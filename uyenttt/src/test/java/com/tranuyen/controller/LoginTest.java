package com.tranuyen.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.service.DangnhapService;

@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
@RunWith(MockitoJUnitRunner.class)
public class LoginTest {
	
	

	@InjectMocks
	private Login login;
	
	@Mock
	private DangnhapService loginservice;
	
	private MockMvc mockMvc;
	private String email;
	private String password;
	private String roleId;
	
	@Before
	public void setUp() throws Exception {
			mockMvc = MockMvcBuilders
	                .standaloneSetup(login)
	                .build();
	}

	@Test
	public void testCheckLoginAdmin() throws Exception {
		Admin admin = new Admin();
		email = "tranvana@gmail.com";
		password = "12345678";
		roleId = "1";
		admin.setEmail(email);
		admin.setPassword(password);
		
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/login/check")
				.param("password",password).param("email", email).param("roleId", roleId);
		when(loginservice.Md5(password)).thenReturn(password);
		when(loginservice.CheckLogInAd(password, email)).thenReturn(true);
		when(loginservice.ThongtinAd(email)).thenReturn(admin);
		
		mockMvc.perform(builder)
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		
	}
	
	@Test
	public void testCheckLoginSV() throws Exception {
		SinhVien sinhvien = new SinhVien();
		email = "tranvana@gmail.com";
		password = "12345678";
		roleId = "2";
		sinhvien.setEmail(email);
		sinhvien.setPassword(password);
		
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/login/check")
				.param("password",password).param("email", email).param("roleId", roleId);
		when(loginservice.Md5(password)).thenReturn(password);
		when(loginservice.CheckLogInSV(password, email)).thenReturn(true);
		when(loginservice.ThongtinSV(email)).thenReturn(sinhvien);
		
		mockMvc.perform(builder)
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		
	}
	
	@Test
	public void testCheckLoginGV() throws Exception {
		GiaoVien giaovien = new GiaoVien();
		email = "tranvana@gmail.com";
		password = "12345678";
		roleId = "3";
		giaovien.setEmail(email);
		giaovien.setPassword(password);
		
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/login/check")
				.param("password",password).param("email", email).param("roleId", roleId);
		when(loginservice.Md5(password)).thenReturn(password);
		when(loginservice.CheckLogInGV(password, email)).thenReturn(true);
		when(loginservice.ThongtinGV(email)).thenReturn(giaovien);
		
		mockMvc.perform(builder).andExpect(status().isOk()).andDo(print());
				
		
		
	}

}
