package com.tranuyen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.service.ThongKeService;

@Controller
@RequestMapping("course")
public class Thongke {
	
	@Autowired
	private ThongKeService thongke;
	
	@GetMapping()
	public String ThongkeAll(ModelMap map) {
		
		map.addAttribute("listkhoahoc", thongke.ListAll());
		return "course";
	}
	
	@GetMapping("/{id}")
	public String ThongkeSeminar(@PathVariable String id, ModelMap map) {
		map.addAttribute("listkhoahoc", thongke.ListSeminar(Integer.parseInt(id)));
		return "course";
	}
		
}
	
	
	

	
	
	

