package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("indexadmin")
public class IndexAdmin {
	@GetMapping
	public String IndexAdmin(HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin == null ) {
			return "index";
		}
		return "indexadmin";
	}
}
