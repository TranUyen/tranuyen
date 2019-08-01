package com.tranuyen.controller;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.service.ThongKeService;

@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
@RunWith(MockitoJUnitRunner.class)
public class ThongkeTest {
	
	@InjectMocks
	private Thongke tk;
	
	@Mock
	private ThongKeService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders
				.standaloneSetup(tk)
				.build();
	}

	@Test
	public void testThongkeAll() throws Exception {
		ArrayList<KhoaHoc> listkhoahoc = new ArrayList<KhoaHoc>();
		KhoaHoc kh = new KhoaHoc();
		kh.setId(1);
		kh.setTen("abc");
		listkhoahoc.add(kh);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/course/{id}/phantrang",1)
																	  .param("start", "0");
																	  
		when(service.ListAll(1, 0, 6)).thenReturn(listkhoahoc);
		
		mockMvc.perform(builder).andExpect(status().isOk())
				.andDo(print());
		
		
	}

	@Test
	public void testThongkeSeminar() throws Exception {
		ArrayList<KhoaHoc> listkhoahoc = new ArrayList<KhoaHoc>();
		KhoaHoc kh = new KhoaHoc();
		kh.setId(1);
		kh.setTen("abc");
		listkhoahoc.add(kh);
		int count = 1;
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/course/{id}",1);
		
		when(service.ListAll(1)).thenReturn(listkhoahoc);
		when(service.ListAll(1, 0, 6)).thenReturn(listkhoahoc);
		
		mockMvc.perform(builder).andExpect(status().isOk()).andExpect(model().attribute("listkhoahoc", listkhoahoc))
				.andExpect(model().attribute("id", "1"))
				.andExpect(model().attribute("count", count))
				.andExpect(view().name("course"))
				.andDo(print());
	
	}

}
