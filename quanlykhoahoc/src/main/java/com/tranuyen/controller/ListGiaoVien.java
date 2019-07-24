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

import com.tranuyen.service.ChiTietKhoaHocService;
import com.tranuyen.service.DangkyService;
import com.tranuyen.service.DangnhapService;
import com.tranuyen.service.DeleteUserService;
import com.tranuyen.service.ThongKeService;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("listgiaovien")
public class ListGiaoVien {
	@Autowired
	DeleteUserService delete;
	
	@Autowired
	ThongKeService thongke;
	
	@Autowired
	DangkyService dk;
	
	@Autowired
	DangnhapService dn;
	
	@Autowired
	ChiTietKhoaHocService chitietkhoahoc;
	
	@GetMapping
	public String ListGiaoVien(ModelMap map, HttpSession session){
		Admin admin = (Admin) session.getAttribute("admin");
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		if(admin == null || sv != null || gv != null) {
			return "404";
		}
		int loaiId = 3;
		map.addAttribute("list", thongke.ListGV());
		map.addAttribute("loaiId", loaiId);
		return "tables";
	}
	
	@GetMapping("/set-user/{id}")
	public String SetGV(@PathVariable int id, ModelMap map) {
		int loaiId = 3;
		GiaoVien user = thongke.GV(id);
		map.addAttribute("user", user);
		map.addAttribute("loaiId", loaiId);
		return "set-user";
	}
	
	@GetMapping("/set-user/{id}/check")
	@ResponseBody
	public String UpdateGV(@PathVariable int id, ModelMap map, String hoten, String email, String diachi, String sdt, String password) {
		map.addAttribute("id", id);
		System.out.println(hoten);
		System.out.println(email);
		GiaoVien user = thongke.GV(id);
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
			thongke.UpdateGV(user);
			return "ok";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
		
	}
	
	@GetMapping("/xoagv")
	@ResponseBody
	public String DeleteGV(int id) {
		try {
			ArrayList<KhoaHoc> listkh = delete.DeleteKHGV(id);
			for (int j = 0; j < listkh.size(); j++) {
				List<BaiHoc> listbh = chitietkhoahoc.ListBaiHoc(listkh.get(j).getId());
				for(int i = 0; i < listbh.size(); i++) {
					System.out.println(listbh.get(i));
					delete.DeleteBaihoc(listbh.get(i));
				}
				delete.DeleteKhoaHoc(listkh.get(j));
			}
			delete.DeleteGV(id);
			return "ok";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
		
	}
	
}
