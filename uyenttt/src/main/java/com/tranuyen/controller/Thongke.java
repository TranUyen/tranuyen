package com.tranuyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tranuyen.service.ThongKeService;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.KhoaHoc;

@Controller
@RequestMapping("course/{id}")
public class Thongke {
	
	@Autowired
	private ThongKeService thongke;
	
	@GetMapping("/phantrang")
	@ResponseBody
	public String ThongkeAll(ModelMap map,int start,@PathVariable String id ) {
		List<KhoaHoc> listkhoahoc = thongke.ListAll(Integer.parseInt(id), start, 6);
		map.addAttribute("listkhoahoc",listkhoahoc);
		String page = "";
		for (KhoaHoc khoaHoc : listkhoahoc) {
			page += "<div class='col-md-6 col-sm-6'>";
			page +=       "<div class='mu-latest-course-single'>";
			page +=         "<figure class='mu-latest-course-img'>";
			page +=           "<a ><img src='"+khoaHoc.getImg()+"' style= 'height: 250px' alt='img'></a>";
			page +=           "<figcaption class='mu-latest-course-imgcaption'>";
			page +=             "<a>"+khoaHoc.getTen() +"</a>";
			page +=             "<span><i class='fa fa-clock-o'></i>"+khoaHoc.getThoigian()+"</span>";
			page +=           "</figcaption>";
			page +=         "</figure>";
			page +=         "<div class='mu-latest-course-single-content'>";
			page +=           "<div class='mu-latest-course-single-contbottom'>";
			page +=             "<a class='mu-course-details' href='/quanlykhoahoc/course-detail/"+khoaHoc.getId()+"'>Details</a>";
			page +=             "<span class='mu-course-price' >"+khoaHoc.getChiphi()+"</span>";
			page +=           "</div>";
			page +=          "</div>";
			page +=        "</div>";
			page +=     "</div>";
		}
		
		return page;
	}
	
	
	@GetMapping
	public String ThongkeSeminar(@PathVariable String id, ModelMap map) {
		List<KhoaHoc> listkhoahoc = thongke.ListAll(Integer.parseInt(id));
		List<KhoaHoc> list = thongke.ListAll(Integer.parseInt(id), 0, 6);
		int count = listkhoahoc.size()/6 + 1;
		System.out.println(count);
		map.addAttribute("listkhoahoc",list );
		map.addAttribute("count",count );
		map.addAttribute("id",id);
		return "course";
	}
		
}
	
	


	

	
	
	

