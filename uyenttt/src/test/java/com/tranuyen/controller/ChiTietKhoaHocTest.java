package com.tranuyen.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.service.ChiTietKhoaHocService;

@RunWith(MockitoJUnitRunner.class)
public class ChiTietKhoaHocTest {
	
	@InjectMocks
	ChiTietKhoaHoc chitiet;
	
	@Mock
	ChiTietKhoaHocService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(chitiet).build();
	}

	@Test
	public void testChiTietKhoaHoc() throws Exception {
		MockHttpSession session = new MockHttpSession();
		Admin admin = new Admin();
		admin.setId(1);
		admin.setName("123");
		session.setAttribute("admin", admin);
		ArrayList<BaiHoc> listbaihoc = new ArrayList<BaiHoc>();
		BaiHoc baihoc = new BaiHoc();
		baihoc.setId(1);
		baihoc.setName("abc");
		listbaihoc.add(baihoc);
		
		KhoaHoc khoahoc = new KhoaHoc();
		khoahoc.setId(1);
		khoahoc.setTen("xyz");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/course-detail/{id}",1).session(session);
		when(service.ListBaiHoc(1)).thenReturn(listbaihoc);
		when(service.Khoahoc(1)).thenReturn(khoahoc);
		
		mockMvc.perform(builder).andExpect(status().isOk()).andExpect(view().name("course-detail"))
				.andExpect(model().attribute("listbaihoc", listbaihoc))
				.andExpect(model().attribute("khoahoc", khoahoc))
				.andDo(print());
		
	}
	
	@Test
	public void testChiTietKhoaHocAdminNUll() throws Exception {
		MockHttpSession session = new MockHttpSession();
		Admin admin = null;
		session.setAttribute("admin", admin);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/course-detail/{id}",1).session(session);
		
		mockMvc.perform(builder).andExpect(status().isOk()).andExpect(view().name("404"))
				.andDo(print());
		
	}
	

}
