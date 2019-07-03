package com.tranuyen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.DAO.DangkyDAO;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.inteface.DangKy;

@Service
public class DangkyService implements DangKy {
	@Autowired
	private DangkyDAO dangkydao;
	
	
	public boolean Dangky(SinhVien sinhvien) {
		 return dangkydao.Dangky(sinhvien);
	}
	

	public boolean CheckEmailAD(String email) {
		return dangkydao.CheckEmailAD(email);
	}
	
	
	public boolean CheckEmailGV(String email) {
		return dangkydao.CheckEmailGV(email);
	}
	
	
	public boolean CheckEmailSV(String email) {
		return dangkydao.CheckEmailSV(email);
	}
	
	
}
