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

@Controller
@RequestMapping("login")
public class Login{
	
	@Autowired
	DangnhapService dn;
	
	
	@GetMapping("/check")
	@ResponseBody
	public String checkLogin(@RequestParam String email, @RequestParam String password,@RequestParam int roleId, HttpSession session, Model model) {
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		
		String pw = dn.Md5(password);
		model.addAttribute("roleId", roleId);
		try {
			if(roleId == 2) {
				if(dn.CheckLogInSV(pw, email)) {
					session.setAttribute("sinhvien", dn.ThongtinSV(email));
					model.addAttribute("sinhvien", dn.ThongtinSV(email));
					System.out.println("sinhvien");
					return "OK";
				}
			}
			if(roleId == 3) {
			 if(dn.CheckLogInGV(pw, email)) {
				session.setAttribute("giaovien", dn.ThongtinGV(email));
				model.addAttribute("giaovien", dn.ThongtinSV(email));
				System.out.println("giaovien");
				return "OK";
			     }
			 }
			if(roleId == 1) {
				 if(dn.CheckLogInAd(pw, email)) {
					session.setAttribute("admin", dn.ThongtinAd(email));
					model.addAttribute("admin", dn.ThongtinAd(email));
					System.out.println("admin");
					return "admin";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("error");
		return "error";
		
	}
	
	
	@GetMapping
	public String homeIndex() {
		return "login";
	}
	
	@GetMapping("/dangky")
	public String Dangky() {
		return "dangky";
	}
	
	
}
