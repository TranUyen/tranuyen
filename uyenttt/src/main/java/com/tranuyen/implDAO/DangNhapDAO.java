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

import com.tranuyen.DAO.DangNhap;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;

@Repository
@Transactional

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DangNhapDAO implements DangNhap{
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public boolean CheckLogInSV(String password, String email) {
		Session session = sessionFactory.getCurrentSession();
		SinhVien sv = new SinhVien();
		String hql = "FROM SinhVien s WHERE s.email='" + email + "' AND s.password ='" + password +"'";
			try {
		    	 sv = (SinhVien) session.createQuery(hql).getSingleResult();
		    	 return true;
		
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	
	public boolean CheckLogInGV(String password, String email) {
		Session session = sessionFactory.getCurrentSession();
		GiaoVien gv = new GiaoVien();
		String hql = "FROM GiaoVien s WHERE s.email='" + email + "' AND s.password ='" + password +"'";
			try {
		    	 gv = (GiaoVien) session.createQuery(hql).getSingleResult();
		    	 return true;
		
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	
	public boolean CheckLogInAd(String password, String email) {
		Session session = sessionFactory.getCurrentSession();
		Admin ad = new Admin();
		String hql = "FROM Admin s WHERE s.email='" + email + "' AND s.password ='" + password +"'";
			try {
		    	 ad = (Admin) session.createQuery(hql).getSingleResult();
		    	 return true;
		
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	
	public SinhVien ThongtinSV(String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql = " from SinhVien s WhERE s.email='" + email + "'";
		SinhVien sv = new SinhVien();
		try {
	    	 sv = (SinhVien) session.createQuery(hql).getSingleResult();
	    	 return sv;
	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public GiaoVien ThongtinGV(String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql = " from GiaoVien s WhERE s.email='" + email + "'";
		GiaoVien gv = new GiaoVien();
		try {
	    	 gv = (GiaoVien) session.createQuery(hql).getSingleResult();
	    	 return gv;
	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Admin ThongtinAd(String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql = " from Admin s WhERE s.email='" + email + "'";
		Admin ad = new Admin();
		try {
	    	 ad = (Admin) session.createQuery(hql).getSingleResult();
	    	 return ad;
	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
		
}
