package com.tranuyen.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.tranuyen.DAO.KhoaHocdanghocInf;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;

@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
@RunWith(MockitoJUnitRunner.class)
public class KhoahocdanghocServiceTest {

	@Mock
	KhoahocdanghocService kh;
	
	@Mock
	KhoaHocdanghocInf hkdao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testKhoaHocDangHoc() {
		ArrayList<Khoahoc_Hocvien> list = new ArrayList<Khoahoc_Hocvien>() ;
		list.add(new Khoahoc_Hocvien());
		when(hkdao.ListDangHoc(1)).thenReturn(list);
		int i = kh.KhoaHocDangHoc(1).size();
		assertEquals(0, i);
	}

}
