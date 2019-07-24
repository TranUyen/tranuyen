package com.tranuyen.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranuyen.service.KhoaHocDangDayService;
import com.tranuyen.entity.GiaoVien;

@Controller
@RequestMapping("course3")
public class KhoaHocDangDay {
	@Autowired
	KhoaHocDangDayService khdangday;
	
	@GetMapping
	public String KhoaHocDangDay(HttpSession session, ModelMap map) {
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		if(gv == null) {
			return "404";
		}
		map.addAttribute("listkhoahoc", khdangday.KhoaHocDangDay(gv.getId()));
		return "course";
	}
}
