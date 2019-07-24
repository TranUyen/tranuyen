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
@RequestMapping("addadmin")
public class AddAdmin {
	
	@Autowired
	DangkyService dk;
	
	@Autowired
	DangnhapService dn;
	
	@GetMapping
	public String AddAdmin(HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		if(admin == null || sv != null || gv != null) {
			return "404";
		}else return "addAdmin";
		
	}
	
	@GetMapping("/checkadmin")
	@ResponseBody
	public String AddAdmin(@RequestParam String email, @RequestParam String password, @RequestParam String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		model.addAttribute("email", email);
		int roleId = 1;
		Roles role = new Roles();
		role.setId(roleId);
		try {
			if(!dk.CheckEmail(email)) {
				return "emailfalse";
			}
		    if(!dk.CheckPassword(password)) {
				return "passwordfalse";
			}
			Admin ad = new Admin();
			ad.setEmail(email);
			ad.setName(name);
			ad.setPassword(dn.Md5(password));
			ad.setRoles(role);
			if(dk.AddAdmin(ad)) {
				return "OK";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
		
	}
	
}
