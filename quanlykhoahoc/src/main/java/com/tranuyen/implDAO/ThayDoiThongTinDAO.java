package com.tranuyen.implDAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.tranuyen.DAO.ThayDoiThongTin;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;
import com.tranuyen.entity.SinhVien;

@Repository
@Transactional

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ThayDoiThongTinDAO implements ThayDoiThongTin{
	@Autowired
	SessionFactory sessionfactory;
	
	public boolean SetGV(GiaoVien gv) {
		Session session = sessionfactory.getCurrentSession();
		if( gv == null) return false;
		try {
			session.update(gv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean SetSV(SinhVien sv) {
		if(sv == null) {
			return false;
		}else {
			Session session = sessionfactory.getCurrentSession();
			session.update(sv);
			return true;
		}
			
			
	}
	
	public boolean SetAD(Admin ad) {
		if(ad == null) {
			return false;
		}else {
			Session session = sessionfactory.getCurrentSession();
			session.update(ad);
			return true;
		}
			
			
	}
	
	public boolean SetKhoaHoc(KhoaHoc khoahoc) {
		if(khoahoc == null) {
			return false;
		}else {
			Session session = sessionfactory.getCurrentSession();
			session.update(khoahoc);
			return true;
		}
	}
	
	public boolean SetBaiHoc(BaiHoc baihoc) {
		if(baihoc == null) {
			return false;
		}else {
			Session session = sessionfactory.getCurrentSession();
			session.update(baihoc);
			return true;
		}
	}
	
	public boolean DeleteBaihoc(BaiHoc baihoc) {
		if(baihoc == null) {
			return false;
		}else {
			Session session = sessionfactory.getCurrentSession();
			session.delete(baihoc);
			return true;
		}
	}
	
	public boolean DeleteKhoaHoc(KhoaHoc khoahoc) {
		if(khoahoc == null) {
			return false;
		}else {
			Session session = sessionfactory.getCurrentSession();
			session.delete(khoahoc);
			return true;
		}
	}
	
	public boolean DeleteKH_HV(Khoahoc_Hocvien kh_hv) {
		if(kh_hv == null) {
			return false;
		}else {
			Session session = sessionfactory.getCurrentSession();
			session.delete(kh_hv);
			return true;
		}
	}
}
