package com.tranuyen.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.implDAO.*;

@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
@RunWith(MockitoJUnitRunner.class)
public class ThongKeServiceTest {

	@Mock
	ThongKeService tk;
	
	/*@Mock
	ThongkeDAO tkd;*/
	
	List<KhoaHoc> list = new ArrayList<KhoaHoc>();
	@Before
	public void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);
		KhoaHoc kh1 = new KhoaHoc();
		kh1.setId(1);
		kh1.setTen("abc");
		list.add(kh1);
		 
		KhoaHoc kh2 = new KhoaHoc();
		kh2.setId(2);
		kh2.setTen("xyz");
		list.add(kh2);
		
	}

	@Test
	public void testListAllInt() {
		when(tk.ListAll()).thenReturn(list);
		
		//List<KhoaHoc> listkh = tk.ListAll();
		assertEquals(2, tk.ListAll().size());		
	}

}
