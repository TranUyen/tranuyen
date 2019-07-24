package com.tranuyen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.DAO.ThayDoiThongTin;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.implDAO.ThayDoiThongTinDAO;

@Service
public class ThayDoiThongTinService implements ThayDoiThongTin{
	@Autowired
	ThayDoiThongTinDAO dao;
	public boolean SetGV(GiaoVien gv) {
		return dao.SetGV(gv);
	}
	
	public boolean SetSV(SinhVien sv) {
		 return dao.SetSV(sv);
	}
	
	public boolean SetAD(Admin ad) {
		return dao.SetAD(ad);
	}
	
	public boolean SetKhoaHoc(KhoaHoc khoahoc) {
		return dao.SetKhoaHoc(khoahoc);
	}
	
	public boolean SetBaiHoc(BaiHoc baihoc) {
		return dao.SetBaiHoc(baihoc);
	}
	
	public boolean DeleteBaihoc(BaiHoc baihoc) {
		return dao.DeleteBaihoc(baihoc);
	}
	
	public boolean DeleteKhoaHoc(KhoaHoc khoahoc) {
		return dao.DeleteKhoaHoc(khoahoc);
	}
	
	public boolean DeleteKH_HV(Khoahoc_Hocvien kh_hv) {
		return dao.DeleteKH_HV(kh_hv);
	}
	public boolean CheckSdt(String sdt) {
		
		for (int i = 0 ; i < sdt.length(); i ++) {
			 if(Character.isDigit(sdt.charAt(i))){
	               
	            }else return false;
		}
		return true;
	}

}
