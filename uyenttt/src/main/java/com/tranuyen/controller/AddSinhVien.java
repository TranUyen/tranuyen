package com.tranuyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.service.DangkyService;
import com.tranuyen.service.DangnhapService;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.Roles;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("addsinhvien")
public class AddSinhVien {
	@Autowired
	DangkyService dk;
	
	@Autowired
	DangnhapService dn;
	
	@GetMapping
	public String AddSV( HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		if(admin == null || sv != null || gv != null) {
			return "404";
		}
		return "addsinhvien";
	}
	
	@GetMapping("/checksv")
	@ResponseBody
	public String DangKy(@RequestParam String email, @RequestParam String password,@RequestParam String hoten, @RequestParam String diachi, @RequestParam String sdt,  Model model) {
		
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		model.addAttribute("hoten", hoten);
		model.addAttribute("diachi", diachi);
		model.addAttribute("sdt", sdt);
		int roleId = 2;
		Roles role = new Roles();
		role.setId(roleId);
		try {
			if(!dk.CheckEmail(email)) {
				return "emailfalse";
			}
		    if(!dk.CheckPassword(password)) {
				return "passwordfalse";
			}
		    if(!dk.CheckSdt(sdt)) {
		    	return "sdtfalse";
		    }
			SinhVien sinhvien = new SinhVien();
			sinhvien.setEmail(email);
			sinhvien.setPassword(dn.Md5(password));
			sinhvien.setHoten(hoten);
			sinhvien.setDiachi(diachi);
			sinhvien.setRoles(role);
			sinhvien.setSdt(sdt);
			if(dk.Dangky(sinhvien)) {
				return "OK";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
		
	}
	
}
