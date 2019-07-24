package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.service.DangnhapService;
import com.tranuyen.service.ThayDoiThongTinService;
import com.tranuyen.entity.Admin;


@Controller
@RequestMapping("set-passwordadmin")
public class SetPasswordAdmin {
	
	@Autowired
	ThayDoiThongTinService thaydoi;
	
	@Autowired
	DangnhapService dn;
	
	@GetMapping
	public String Setpassword(HttpSession session) {
		Admin ad = (Admin) session.getAttribute("admin");
		
		if( ad == null) {
			return "404";
		}
		return "set-passwordadmin";
	}
	
	@GetMapping("/checkpassword")
	@ResponseBody
	public String CheckPassword(@RequestParam String passwordcu, @RequestParam String passwordmoi1, @RequestParam String passwordmoi2, HttpSession session, Model model ) {
		model.addAttribute("passwordcu", passwordcu);
		model.addAttribute("passwordmoi1", passwordmoi1);
		model.addAttribute("passwordmoi2", passwordmoi2);
		Admin ad = (Admin) session.getAttribute("admin");
		try {
			if(!ad.getPassword().equals(dn.Md5(passwordcu))) {
				return "error2";
			}else if(passwordmoi1.length() < 8) {
					return "error3";
			}else if(!passwordmoi2.equals(passwordmoi1)) {
				return "error4";
			}else {
				ad.setPassword(dn.Md5(passwordmoi1));
				thaydoi.SetAD(ad);
				return "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
