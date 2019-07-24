package com.tranuyen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.service.DangkyService;
import com.tranuyen.service.DangnhapService;
import com.tranuyen.service.DeleteUserService;
import com.tranuyen.service.ThayDoiThongTinService;
import com.tranuyen.service.ThongKeService;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("listhocvien")
public class ListHocVien {
	@Autowired
	ThongKeService thongke;
	
	@Autowired
	DangkyService dk;
	
	@Autowired
	DangnhapService dn;
	
	@Autowired
	DeleteUserService delete;
	
	@Autowired
	ThayDoiThongTinService thaydoi;
	
	@GetMapping
	public String ListHocVien(ModelMap map,HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		if(admin == null || sv != null || gv != null) {
			return "404";
		}
		int loaiId = 2;
		map.addAttribute("list", thongke.ListSV());
		map.addAttribute("loaiId", loaiId);
		return "tables";
	}
	
	@GetMapping("/set-user/{id}")
	public String SetSV(@PathVariable int id, ModelMap map) {
		int loaiId = 2;
		SinhVien user = thongke.SV(id);
		map.addAttribute("user",user);
		map.addAttribute("loaiId", loaiId);
		return "set-user";
	}
	
	@GetMapping("/set-user/{id}/check")
	@ResponseBody
	public String UpdateGV(@PathVariable int id, ModelMap map, String hoten, String email, String diachi, String sdt, String password) {
		map.addAttribute("id", id);
		SinhVien user = thongke.SV(id);
		try {
			if(!dk.CheckEmail(email)) {
				return "error1";
			}
			
			if(!dk.CheckPassword(password)) {
				return "error2";
			}
			
			if(!dk.CheckSdt(sdt)) {
				return "error3";
			}
			user.setEmail(email);
			user.setDiachi(diachi);
			user.setHoten(hoten);
			user.setPassword(dn.Md5(password));
			user.setSdt(sdt);
			System.out.println(user);
			thongke.UpdateSV(user);
			return "ok";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
		
	}
	
	@GetMapping("/xoahv")
	@ResponseBody
	public String DeleteGV(int id) {
		try {
			ArrayList<Khoahoc_Hocvien> listkhhv = delete.DeleteKHHV(id);
			for(int i = 0; i < listkhhv.size(); i++) {
				thaydoi.DeleteKH_HV(listkhhv.get(i));
			}
			delete.DeleteHocVien(id);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
		
	}
	
}
