package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tranuyen.entity.SinhVien;
import com.tranuyen.service.KhoahocdanghocService;

@Controller
@RequestMapping("course2")
@SessionAttributes({"sinhvien"})
public class Khoahocdanghoc {
	@Autowired
	KhoahocdanghocService khdanghoc;
	
	@GetMapping()
	public String KhoaHocdanghoc(ModelMap map,HttpSession session) {
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		map.addAttribute("listkhoahoc", khdanghoc.KhoaHocDangHoc(sv.getId()));
		System.out.println(khdanghoc.KhoaHocDangHoc(sv.getId()).size());
		return "course";
	}
	
}
