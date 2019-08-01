package com.tranuyen.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.DAO.DangKy;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.implDAO.DangkyDAO;

@Service
public class DangkyService implements DangKy {
	@Autowired
	private DangkyDAO dangkydao;
	
	
	public boolean Dangky(SinhVien sinhvien) {
		 return dangkydao.Dangky(sinhvien);
	}
	
	public boolean AddGiaoVien(GiaoVien gv) {
		return dangkydao.AddGiaoVien(gv);
	}
	
	public boolean AddAdmin(Admin ad) {
		return dangkydao.AddAdmin(ad);
	}
	
	public boolean AddKhoahoc(KhoaHoc kh) {
		return dangkydao.AddKhoahoc(kh);
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
	
	public boolean CheckPassword(String password) {
		if(password.length() < 8 ) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean CheckEmail(String email) {
		int dem = 0;
		for( int i = 0 ; i < email.length(); i++) {
			if(email.charAt(i) == '@') {
				dem = dem +1;
			}
		}
		if(dem == 1) return true;
		else return false;
		
	}
	
	public boolean CheckSdt(String sdt) {
		for (int i = 0 ; i < sdt.length(); i ++) {
			 if(Character.isDigit(sdt.charAt(i))){
	               
	            }else return false;
		}
		return true;
	}
	public int CheckGV(String name) {
		return dangkydao.CheckGV(name);
	}
	
	public boolean AddBaiHoc(BaiHoc baihoc) {
		return dangkydao.AddBaiHoc(baihoc);
	}
	
	public ArrayList<Admin> listAddAdmins() {
		
		return dangkydao.listAddAdmins();
	}
	
}
