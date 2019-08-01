package com.tranuyen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Loai;
import com.tranuyen.service.ChiTietKhoaHocService;
import com.tranuyen.service.DangkyService;
import com.tranuyen.service.ThayDoiThongTinService;
import com.tranuyen.service.ThongKeService;

@Controller
@RequestMapping("set-khoahoc")
public class SetKhoahoc {
	
	@Autowired
	ThongKeService thongke;
	
	@Autowired
	ChiTietKhoaHocService chitietkhoahoc;
	
	@Autowired
	ThayDoiThongTinService thaydoi;
	
	@Autowired
	DangkyService dk;
	
	public List<BaiHoc> listbh;
	public KhoaHoc khoahoc;
	@GetMapping("/{id}")
	public String SetKhoaHoc(@PathVariable String id,HttpSession session, ModelMap map) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin == null) {
			return "404";
		}
		listbh = chitietkhoahoc.ListBaiHoc(Integer.parseInt(id));
		khoahoc = chitietkhoahoc.Khoahoc(Integer.parseInt(id));
		map.addAttribute("listbaihoc", listbh);
		map.addAttribute("khoahoc", khoahoc);
		map.addAttribute("list", thongke.ListGV());
		
		return "set-khoahoc";
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
		khoahoc.setChiphi(chiphi);
		khoahoc.setImg(img);
		khoahoc.setTen(ten);
		khoahoc.setThoigian(thoigian);
		khoahoc.setLoaiId(loai);
		khoahoc.setIdgiaovien(gv);
		thaydoi.SetKhoaHoc(khoahoc);
		
		
		JSONArray jsonMainArr = listbaihoc; 
		for (int i = 0; i < jsonMainArr.length(); i++) {
			
		     JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
		     String name = childJSONObject.getString("name");
		     String tgbatdau = childJSONObject.getString("tgbatdau");
		     String tgketthuc = childJSONObject.getString("tgketthuc");
		     if(i < listbh.size()) {
		    	 
				     listbh.get(i).setName(name);
				     listbh.get(i).setTgbatdau(tgbatdau);
				     listbh.get(i).setTgketthuc(tgketthuc);
				     listbh.get(i).setIdkhoahoc(khoahoc);
					 thaydoi.SetBaiHoc(listbh.get(i));
		     }else {
		    	 BaiHoc baihoc = new BaiHoc();
		    	 baihoc.setName(name);
		    	 baihoc.setTgbatdau(tgbatdau);
		    	 baihoc.setTgketthuc(tgketthuc);
		    	 baihoc.setIdkhoahoc(khoahoc);
		    	 dk.AddBaiHoc(baihoc);
		     }
			     
			
		}
		
		
		return "ok";
	}
	
	
}
