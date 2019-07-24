package com.tranuyen.controller;

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
import com.tranuyen.service.ThayDoiThongTinService;
import com.tranuyen.service.ThongKeService;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;

@Controller
@RequestMapping("khoahocadmin/{id}")
public class ThongkeAdmin {
	
	@Autowired
	ThongKeService thongke;
	
	@Autowired
	ChiTietKhoaHocService chitietkhoahoc;
	
	@Autowired
	ThayDoiThongTinService thaydoi;
	
	@GetMapping
	public String ThongkeSeminar(@PathVariable String id,HttpSession session, ModelMap map) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin == null) {
			return "404";
		}
		map.addAttribute("listkhoahoc", thongke.ListAll((Integer.parseInt(id))));
		map.addAttribute("id", id);
		return "tableskhoahoc";
	}
	
	@GetMapping("/xoakhoahoc")
	@ResponseBody
	public String DeleteKhoahoc(int idkhoahoc) {
		KhoaHoc khoahoc = chitietkhoahoc.Khoahoc(idkhoahoc);
		List<BaiHoc> listbaihoc = chitietkhoahoc.ListBaiHoc(idkhoahoc);
		List<Khoahoc_Hocvien> listkh_hv = chitietkhoahoc.ListKH_HV(idkhoahoc);
				for(int i = 0; i < listkh_hv.size(); i ++) {
					thaydoi.DeleteKH_HV(listkh_hv.get(i));
				}
			
			for(int i = 0 ; i < listbaihoc.size(); i++) {
				thaydoi.DeleteBaihoc(listbaihoc.get(i));
			}

			thaydoi.DeleteKhoaHoc(khoahoc);
			return "ok";
	}
	
}
