package com.tranuyen.implDAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.tranuyen.DAO.DangKy;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.SinhVien;

@Repository
@Transactional

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DangkyDAO implements DangKy{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean Dangky(SinhVien sinhvien) {
		Session session = this.sessionFactory.getCurrentSession();
		if( !CheckEmailAD(sinhvien.getEmail()) && !CheckEmailGV(sinhvien.getEmail()) && !CheckEmailSV(sinhvien.getEmail())) {
			session.save(sinhvien);
			return true; 
		}else
			return false;
		
	}
	public boolean AddGiaoVien(GiaoVien gv) {
		Session session = sessionFactory.getCurrentSession();
		if(!CheckEmailAD(gv.getEmail()) && !CheckEmailGV(gv.getEmail()) && !CheckEmailSV(gv.getEmail())) {
			session.save(gv);
			return true;
		}else {
			return false;
		}
		
	}
	public boolean AddAdmin(Admin ad) {
		Session session = sessionFactory.getCurrentSession();
		if(!CheckEmailAD(ad.getEmail()) && !CheckEmailGV(ad.getEmail()) && !CheckEmailSV(ad.getEmail())) {
			session.save(ad);
			return true;
		}else {
			return false;
		}
		
	}
	public boolean AddKhoahoc(KhoaHoc khoahoc) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(khoahoc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean AddBaiHoc(BaiHoc baihoc) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(baihoc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
		
	public boolean CheckEmailSV(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from SinhVien s WHERE s.email = '"+ email + "'";
		try {
			SinhVien sv = (SinhVien) session.createQuery(hql).getSingleResult();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean CheckEmailAD(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Admin s WHERE s.email = '"+ email + "'";
		try {
			Admin ad = (Admin) session.createQuery(hql).getSingleResult();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}
	public boolean CheckEmailGV(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from GiaoVien s WHERE s.email = '"+ email + "'";
		try {
			GiaoVien sv = (GiaoVien) session.createQuery(hql).getSingleResult();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public int CheckGV(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from GiaoVien s WHERE s.hoten = '"+ name + "'";
		try {
			GiaoVien gv = (GiaoVien) session.createQuery(hql).getSingleResult();
			return gv.getId();
			} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public ArrayList<Admin> listAddAdmins() {
		Session session = sessionFactory.getCurrentSession();
		try {
			ArrayList<Admin> admins = (ArrayList<Admin>) session.createQuery("form Admin").getResultList();
			return admins;
			} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<KhoaHoc> ListKhoahoc() {
		Session session = sessionFactory.getCurrentSession();
		try {
			ArrayList<KhoaHoc> khoahocs = (ArrayList<KhoaHoc>) session.createQuery("form KhoaHoc").getResultList();
			return khoahocs;
			} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
