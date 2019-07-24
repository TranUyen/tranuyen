package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dang-xuat")
public class DangXuat {
	
	@GetMapping
	public String Dangxuat(HttpSession session) {
		session.removeAttribute("sinhvien");
		session.removeAttribute("giaovien");
		session.removeAttribute("admin");
		return "index";
	}
}
