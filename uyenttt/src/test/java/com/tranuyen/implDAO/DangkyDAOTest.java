package com.tranuyen.implDAO;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.KhoaHoc;

@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
@RunWith(MockitoJUnitRunner.class)
public class DangkyDAOTest {
	
	@Mock
	DangkyDAO dk;
	
	Admin ad;
	
	@Before
	public void setUp() throws Exception {
		ad = new Admin();
		ad.setId(1);
		ad.setName("abc");
		ad.setPassword("123");
		ad.setEmail("123@xyz");
		
		when(dk.CheckEmailAD(ad.getEmail())).thenReturn(false);
		when(dk.CheckEmailGV(ad.getEmail())).thenReturn(false);
		when(dk.CheckEmailSV(ad.getEmail())).thenReturn(false);
		dk.AddAdmin(ad);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddAdmin() {
		
		//dk.AddAdmin(new Admin());
//		when(dk.CheckEmailAD(ad.getEmail())).thenReturn(false);
//		when(dk.CheckEmailGV(ad.getEmail())).thenReturn(false);
//		when(dk.CheckEmailSV(ad.getEmail())).thenReturn(false);
		
		////when(dk.AddAdmin(ad)).thenReturn(true);
		
		
		ArrayList<Admin> admins = dk.listAddAdmins();
		assertEquals(1, admins.size());
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testListAddmins() {
		Admin ad = new Admin();
		ad.setId(1);
		ad.setName("abc");
		ad.setPassword("123");
		ad.setEmail("123@xyz");
		
		ArrayList<Admin> admins = new ArrayList<Admin>();
		admins.add(ad);
		
		when(dk.listAddAdmins()).thenReturn(admins);
		
		assertEquals(1, dk.listAddAdmins().size());
		
	}
	
	@Test
	public void testAddKhoahoc() {
		KhoaHoc khoahoc = new KhoaHoc();
		khoahoc.setId(1);
		khoahoc.setTen("abc");
		
		dk.AddKhoahoc(khoahoc);
		assertEquals(1, dk.listAddAdmins().size());
	}
}
