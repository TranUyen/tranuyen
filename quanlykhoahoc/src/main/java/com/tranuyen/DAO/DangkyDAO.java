package com.tranuyen.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.inteface.DangKy;

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
	
	
}
