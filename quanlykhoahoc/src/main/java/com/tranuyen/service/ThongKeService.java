package com.tranuyen.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.DAO.ThongkeDAO;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.inteface.ThongKe;

@Service
public class ThongKeService implements ThongKe{
	@Autowired
	private ThongkeDAO thongkedao;
	
	public List<KhoaHoc> ListSeminar(int loaiId) {
		List<KhoaHoc> list = thongkedao.ListSeminar(loaiId);
		return list;
	}
	public List<KhoaHoc> ListAll() {
		List<KhoaHoc> list = thongkedao.ListAll();
		return list;
	}
	
	/*public List<KhoaHoc> ListĐTNB(int id) {
		List<KhoaHoc> list = thongkedao.ListĐTNB(2);
		return list;
	}
	
	
	public List<KhoaHoc> ListĐTBN() {
		List<KhoaHoc> list = thongkedao.ListĐTBN(3);
		return list;
	}*/
}
