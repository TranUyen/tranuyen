package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("profile")
public class Profile {
	
	@GetMapping
	public String Profile(HttpSession session) {
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		if(gv == null && sv == null) {
			return "404";
		}
		
		return "profile";
	}
}
