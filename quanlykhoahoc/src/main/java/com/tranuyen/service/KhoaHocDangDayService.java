package com.tranuyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.DAO.KhoaHocDangDayInf;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.implDAO.KhoaHocDangDayDAO;

@Service
public class KhoaHocDangDayService implements KhoaHocDangDayInf {
	
	@Autowired
	KhoaHocDangDayDAO dao;
	public List<KhoaHoc> KhoaHocDangDay(int id_giaovien) {
		return dao.KhoaHocDangDay(id_giaovien);
	}
	
}
