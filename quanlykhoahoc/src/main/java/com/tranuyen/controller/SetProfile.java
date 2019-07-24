package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.service.ThayDoiThongTinService;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("set-profile")
public class SetProfile {

	@Autowired
	ThayDoiThongTinService thaydoi;
	
	@GetMapping
	public String Setprofile() {
		return "set-profile";
	}
	
	@GetMapping("/checkprofile")
	@ResponseBody
	public String CheckProfile(@RequestParam String hoten, @RequestParam String sdt, @RequestParam String diachi, HttpSession session, Model model) {
		model.addAttribute("hoten", hoten);
		model.addAttribute("diachi", diachi);
		model.addAttribute("sdt", sdt);
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		System.out.println(sv.getHoten());
		if(sv != null) {
			if(!sdt.isEmpty()) {
				if(thaydoi.CheckSdt(sdt)) {
					sv.setSdt(sdt);
				}else {
					return "error1";
				}
			}
			if(!diachi.isEmpty() ) {
				sv.setDiachi(diachi);
			}
			if(!hoten.isEmpty()) {
				sv.setHoten(hoten);
			}
			thaydoi.SetSV(sv);
			return "ok";
		}
		
		if(gv != null) {
			if(!sdt.isEmpty()) {
				if(thaydoi.CheckSdt(sdt)) {
					gv.setSdt(sdt);
				}else {
					return "error1";
				}
			}
			if(!diachi.isEmpty()) {
				gv.setDiachi(diachi);
			}
			if(!hoten.isEmpty()) {
				gv.setHoten(hoten);
			}
			thaydoi.SetGV(gv);
			return "ok";
		}
		return "error";
		
	}
	
}
