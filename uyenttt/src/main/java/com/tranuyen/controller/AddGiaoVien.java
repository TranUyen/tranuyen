package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.service.DangkyService;
import com.tranuyen.service.DangnhapService;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.Roles;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("addgiaovien")
public class AddGiaoVien {
	
	@Autowired
	DangkyService dk;
	
	@Autowired
	DangnhapService dn;
	
	@GetMapping
	public String AddGiaoVien(HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		if(admin == null || sv !=null || gv != null) {
			return "404";
		}
		return "addgiaovien";
	}
	
	
	@GetMapping("/checkaddgv")
	@ResponseBody
	public String AddGiaoVien(@RequestParam String hoten, @RequestParam String email, @RequestParam String diachi, @RequestParam String sdt,@RequestParam String password, @RequestParam String img, Model model) {
		
		model.addAttribute("email", email);
		model.addAttribute("diachi", diachi);
		model.addAttribute("hoten", hoten);
		model.addAttribute("sdt", sdt);
		model.addAttribute("password", password);
		model.addAttribute("img", img);
		int roleId = 3;
		Roles role = new Roles();
		role.setId(roleId);
		try {
			if(!dk.CheckEmail(email)) {
				return "emailfalse";
			}
		    if(!dk.CheckPassword(password)) {
				return "passwordfalse";
			}
		    if(!dk.CheckSdt(sdt)) {
		    	return "sdtfalse";
		    }
			GiaoVien gv = new GiaoVien();
			gv.setDiachi(diachi);
			gv.setEmail(email);
			gv.setHoten(hoten);
			gv.setRoles(role);
			gv.setSdt(sdt);
			gv.setPassword(dn.Md5(password));
			gv.setImg(img);
			if(dk.AddGiaoVien(gv)) {
				return "OK";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
		
	}
}
