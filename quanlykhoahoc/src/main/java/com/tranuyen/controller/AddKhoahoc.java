package com.tranuyen.controller;

import java.util.ArrayList;
import java.util.List;
import org.json.*;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.service.ChiTietKhoaHocService;
import com.tranuyen.service.DangkyService;
import com.tranuyen.service.ThongKeService;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Loai;
import com.tranuyen.entity.SinhVien;

@Controller
@RequestMapping("addkhoahoc")
public class AddKhoahoc {
	@Autowired
	DangkyService dk;
	
	@Autowired
	ThongKeService thongke;
	
	@Autowired
	ChiTietKhoaHocService chitiet;
	
	@GetMapping
	public String AddKhoahoc(HttpSession session, ModelMap map) {
		Admin admin = (Admin) session.getAttribute("admin");
		SinhVien sv = (SinhVien) session.getAttribute("sinhvien");
		GiaoVien gv = (GiaoVien) session.getAttribute("giaovien");
		if(admin == null || sv != null || gv != null) {
			return "404";
		}
		map.addAttribute("list", thongke.ListGV());
		return "add-course";
	}
	
	
	
	
	@GetMapping("/checkkhoahoc")
	@ResponseBody
	public String ThemKhoahoc(@RequestParam int loaiId, @RequestParam int idgiaovien, @RequestParam String ten, @RequestParam String thoigian, @RequestParam String chiphi, @RequestParam String img, @RequestParam JSONArray listbaihoc, Model model) {
		model.addAttribute("idgiaovien", idgiaovien);
		model.addAttribute("loaiId", loaiId);
		model.addAttribute("ten", ten);
		model.addAttribute("thoigian", thoigian);
		model.addAttribute("chiphi", chiphi);
		model.addAttribute("lisbaihoc", listbaihoc);
		System.out.println(loaiId);
		System.out.println(idgiaovien);
		System.out.println(listbaihoc);
		GiaoVien gv = new GiaoVien();
		Loai loai  = new Loai();
		gv.setId(idgiaovien);
		loai.setId(loaiId);
		KhoaHoc khoahoc = new KhoaHoc();
		khoahoc.setChiphi(chiphi);
		khoahoc.setImg(img);
		khoahoc.setTen(ten);
		khoahoc.setThoigian(thoigian);
		khoahoc.setLoaiId(loai);
		khoahoc.setIdgiaovien(gv);
		dk.AddKhoahoc(khoahoc);
		
		JSONArray jsonMainArr = listbaihoc; 
		for (int i = 0; i < jsonMainArr.length(); i++) {
		     JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
		     String name = childJSONObject.getString("name");
		     String tgbatdau     = childJSONObject.getString("tgbatdau");
		     String tgketthuc = childJSONObject.getString("tgketthuc");
		     BaiHoc baihoc = new BaiHoc();
		     baihoc.setName(name);
		     baihoc.setTgbatdau(tgbatdau);
		     baihoc.setTgketthuc(tgketthuc);
		     baihoc.setIdkhoahoc(khoahoc);
		     dk.AddBaiHoc(baihoc);
		     System.out.println(baihoc.getTgbatdau());
		}
		
		
		return "ok";
	}
	
	
}
