package com.tranuyen.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.DeleteUser;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;
import com.tranuyen.implDAO.DeleteUserDAO;

@Service
public class DeleteUserService implements DeleteUser {
	@Autowired
	DeleteUserDAO dao;
	
	public boolean DeleteGV(int id) {
		return dao.DeleteGV(id);
	}
	
	public ArrayList<KhoaHoc> DeleteKHGV(int id) {
		return dao.DeleteKHGV(id);
	}
	
	public boolean DeleteBaihoc(BaiHoc bh) {
		return dao.DeleteBaihoc(bh);
	}
	
	public boolean DeleteKhoaHoc(KhoaHoc khoahoc) {
		return dao.DeleteKhoaHoc(khoahoc);
	}
	
	public ArrayList<Khoahoc_Hocvien> DeleteKHHV(int id) {
		return dao.DeleteKHHV(id);
	}
	
	public boolean DeleteHocVien(int id) {
		return dao.DeleteHocVien(id);
	}
}
