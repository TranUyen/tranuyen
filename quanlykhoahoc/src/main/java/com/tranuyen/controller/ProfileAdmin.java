package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranuyen.entity.Admin;

@Controller
@RequestMapping("profile-admin")
public class ProfileAdmin {

	@GetMapping
	public String ProfileAdmin(HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin == null) {
			return "404";
		}
		return "profileadmin";
	}
}
