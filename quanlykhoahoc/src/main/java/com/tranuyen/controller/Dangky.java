package com.tranuyen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranuyen.entity.Roles;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.service.DangkyService;

@Controller
@RequestMapping("dang-ky")
public class Dangky {
	@Autowired
	private DangkyService dk;
	
	@GetMapping
	public String Dangky() {
		return "dangky";
	}
	
	@PostMapping
	public String DangKy(@RequestParam String email, @RequestParam String password,@RequestParam String hoten, @RequestParam String diachi, @RequestParam String sdt,  Model model) {
		
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		model.addAttribute("hoten", hoten);
		model.addAttribute("diachi", diachi);
		model.addAttribute("sdt", sdt);
		int roleId = 2;
		Roles role = new Roles();
		role.setId(roleId);
		SinhVien sinhvien = new SinhVien();
		sinhvien.setEmail(email);
		sinhvien.setPassword(password);
		sinhvien.setHoten(hoten);
		sinhvien.setDiachi(diachi);
		sinhvien.setRoles(role);
		sinhvien.setSdt(sdt);
		if(dk.Dangky(sinhvien)) {
			return "redirect:/login";
		}else 
			return "dangky";
		}
	
	
	@GetMapping("/")
	public String Login() {
		return "login";
	}
	
	
}
