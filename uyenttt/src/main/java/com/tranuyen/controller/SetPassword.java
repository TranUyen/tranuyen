package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.service.DangnhapService;
import com.tranuyen.service.ThayDoiThongTinService;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("set-password")
public class SetPassword {
	@Autowired
	ThayDoiThongTinService thaydoi;
	
	@Autowired
	DangnhapService dn;
	
	@GetMapping
	public String Setpassword(HttpSession session) {
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		Admin ad = (Admin) session.getAttribute("admin");
		if( (sv == null && gv == null ) || ad != null) {
			return "404";
		}
		return "set-password";
	}
	
	@GetMapping("/checkpassword")
	@ResponseBody
	public String CheckPassword(@RequestParam String passwordcu, @RequestParam String passwordmoi1, @RequestParam String passwordmoi2, HttpSession session, Model model ) {
		model.addAttribute("passwordcu", passwordcu);
		model.addAttribute("passwordmoi1", passwordmoi1);
		model.addAttribute("passwordmoi2", passwordmoi2);
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		try {
			if( sv == null && gv == null ) {
				return "error1";
			}
			if(sv != null) {
				if(!sv.getPassword().equals(dn.Md5(passwordcu))) {
					return "error2";
				}else if(passwordmoi1.length() < 8) {
						return "error3";
				}else if(!passwordmoi2.equals(passwordmoi1)) {
					return "error4";
				}else {
					sv.setPassword(dn.Md5(passwordmoi1));
					thaydoi.SetSV(sv);
					return "ok";
				}
			}
			if(gv != null) {
				if(!gv.getPassword().equals(passwordcu)) {
					return "error2";
				}else if(passwordmoi1.length() < 8) {
						return "error3";
				}else if(!passwordmoi2.equals(passwordmoi1)) {
					return "error4";
				}else {
					gv.setPassword(passwordmoi1);
					thaydoi.SetGV(gv);
					return "ok";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error"; 
		
			
		
		
	}
		
	
}
