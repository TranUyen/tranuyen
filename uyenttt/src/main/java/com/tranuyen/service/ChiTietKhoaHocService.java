package com.tranuyen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.DAO.ChiTietKhoaHocInf;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;
import com.tranuyen.implDAO.ChitietKhoahocDAO;

@Service
public class ChiTietKhoaHocService implements ChiTietKhoaHocInf{
	
	@Autowired
	ChitietKhoahocDAO dao;

	public KhoaHoc Khoahoc(int id_khoahoc) {
		return dao.Khoahoc(id_khoahoc);
		
	}
	
	public List<BaiHoc> ListBaiHoc(int id_khoahoc) {
		List<BaiHoc> listbaihoc = dao.Khoahoc(id_khoahoc).getListbaihoc();
		
		return listbaihoc;
	}
	
	public List<Khoahoc_Hocvien> ListKH_HV(int id){
		return dao.ListKH_HV(id);
	}
	
	
}
