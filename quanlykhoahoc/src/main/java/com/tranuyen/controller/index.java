package com.tranuyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/","index"})
public class index {
	
	@GetMapping
	public String home() {
		return "index";
	}
	
	/*@GetMapping("/dangky")
	public String Dangky() {
		return "dangky";
	}	
	@GetMapping("/course-detail")
	public String chitietkhoahoc() {
		return "course-detail";
	}*/
	
	@GetMapping("/profile")
	public String canhan() {
		return "profile";
	}
	
	
}
