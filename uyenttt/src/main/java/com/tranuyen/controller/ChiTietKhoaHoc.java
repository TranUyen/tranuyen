package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.service.ChiTietKhoaHocService;

@Controller
@RequestMapping("course-detail")
public class ChiTietKhoaHoc {
	@Autowired
	ChiTietKhoaHocService chitietkhoahoc;
	
	@GetMapping("/{id}")
	public String ChiTietKhoaHoc(@PathVariable String id, ModelMap map, HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		if(admin == null || sv != null || gv != null) {
			return "404";
		}
		map.addAttribute("listbaihoc", chitietkhoahoc.ListBaiHoc(Integer.parseInt(id)));
		map.addAttribute("khoahoc", chitietkhoahoc.Khoahoc(Integer.parseInt(id)));
		return "course-detail";
	}
}
