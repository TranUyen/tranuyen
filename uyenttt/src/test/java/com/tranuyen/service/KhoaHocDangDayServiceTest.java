package com.tranuyen.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;

@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
@RunWith(MockitoJUnitRunner.class)
public class KhoaHocDangDayServiceTest {
	
	@Mock
	KhoaHocDangDayService kh;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	
	public void testKhoaHocDangDay() {
		GiaoVien giaovien = new GiaoVien();
		giaovien.setId(1);
		
		
		KhoaHoc hoc = new KhoaHoc();
		hoc.setId(1);
		hoc.setTen("abc");
		hoc.setGiaovien(giaovien);
		hoc.setChiphi("100");
		
		List<KhoaHoc> list = new ArrayList<KhoaHoc>();
		list.add(hoc);
		
		when(kh.KhoaHocDangDay(1)).thenReturn(list);
		
		
		assertEquals(1,kh.KhoaHocDangDay(1).size());
	}
	
	@Test
	public void testNUll() {
		GiaoVien giaovien = new GiaoVien();
		giaovien.setId(1);
		List<KhoaHoc> list = null;
		when(kh.KhoaHocDangDay(1)).thenReturn(list);
		
		assertNull(kh.KhoaHocDangDay(1));
		
	}

}
