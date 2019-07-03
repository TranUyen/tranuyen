package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.service.DangnhapService;

@Controller
@RequestMapping("login")
public class Login{
	
	@Autowired
	DangnhapService dn;
	
	@GetMapping
	public String DangKy() {
		return "login";
	}
	@PostMapping()
	public String checkLogin(@RequestParam String email, @RequestParam String password, HttpSession session1,HttpSession session2,HttpSession session3, Model model) {
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		
		if(dn.CheckLogInSV(password, email)) {
			session1.setAttribute("sinhvien", dn.ThongtinSV(email));
			SinhVien sv = (SinhVien) session1.getAttribute("sinhvien");
			return "redirect:/";
		}else if(dn.CheckLogInGV(password, email)) {
			session2.setAttribute("giaovien", dn.ThongtinGV(email));
			GiaoVien gv = (GiaoVien) session2.getAttribute("giaovien");
			return "redirect:/";
		}else 
			return "login";
			
		
	}
	
	
	@GetMapping("/")
	public String homeIndex() {
		return "index";
	}
	
	@GetMapping("/dangky")
	public String Dangky() {
		return "dangky";
	}
	
}
