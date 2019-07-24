package com.tranuyen.implDAO;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.DeleteUser;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;
import com.tranuyen.entity.SinhVien;

@Transactional
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DeleteUserDAO implements DeleteUser{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean DeleteGV(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			 GiaoVien gv = (GiaoVien) session.createQuery("from GiaoVien Where id =" + id).getSingleResult();
			 session.delete(gv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<KhoaHoc> DeleteKHGV(int id) {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<KhoaHoc> listkhoahoc = new ArrayList<KhoaHoc>();
		try {
			listkhoahoc = (ArrayList<KhoaHoc>) session.createQuery("from KhoaHoc WHERE idgiaovien =" + id).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return listkhoahoc;
	}
	
	public boolean DeleteKhoaHoc(KhoaHoc khoahoc) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(khoahoc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean DeleteBaihoc(BaiHoc bh) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(bh);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Khoahoc_Hocvien> DeleteKHHV(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Khoahoc_Hocvien where idhocvien = "+id;
		ArrayList<Khoahoc_Hocvien> list_khhv = null;
		try {
			list_khhv = (ArrayList<Khoahoc_Hocvien>) session.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_khhv;
	}
	
	public boolean DeleteHocVien(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			 SinhVien sv = (SinhVien) session.createQuery("from SinhVien Where id =" + id).getSingleResult();
			 session.delete(sv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
