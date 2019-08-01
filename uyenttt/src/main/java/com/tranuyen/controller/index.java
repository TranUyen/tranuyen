package com.tranuyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping(path = {"/","index"})
public class index {
	
	@GetMapping
	public String home() {
		return "index";
	}
	
}
