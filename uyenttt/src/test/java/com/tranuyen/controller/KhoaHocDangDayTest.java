package com.tranuyen.controller;


import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.service.KhoaHocDangDayService;


@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
@RunWith(MockitoJUnitRunner.class)
public class KhoaHocDangDayTest {

	@InjectMocks
	private KhoaHocDangDay kh;
	
	@Mock
	private KhoaHocDangDayService service;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders
                .standaloneSetup(kh)
                .build();
	}

	@Test
	public void test() throws Exception {
		// khởi tạo session
		MockHttpSession session = new MockHttpSession();
		GiaoVien giaovien = new GiaoVien();
		giaovien.setId(1);
		session.setAttribute("giaovien", giaovien);
		
		//khởi tạo dữ liệu
		List<KhoaHoc> listkhoahoc = new ArrayList<KhoaHoc>();
		KhoaHoc kh1 = new KhoaHoc();
		kh1.setId(1);
	
		KhoaHoc kh2 = new KhoaHoc();
		kh2.setId(2);
		listkhoahoc.add(kh1);
		listkhoahoc.add(kh2);
		
		 MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/course3").session(session);
		when(service.KhoaHocDangDay(giaovien.getId())).thenReturn(listkhoahoc);
		mockMvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(view().name("course"))
				.andExpect(model().attribute("listkhoahoc", listkhoahoc));
		
	}
	
	@Test
	public void testNUll() throws Exception {
		MockHttpSession session = new MockHttpSession();
		GiaoVien giaovien = null;
		session.setAttribute("giaovien", giaovien);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/course3").session(session);
		
		mockMvc.perform(builder)
			.andExpect(status().isOk())
			.andExpect(view().name("404"));
	}
	

}
