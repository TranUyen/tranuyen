package com.tranuyen.implDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.tranuyen.DAO.ChiTietKhoaHocInf;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS )

public class ChitietKhoahocDAO implements ChiTietKhoaHocInf{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public KhoaHoc Khoahoc(int id_khoahoc) {
		Session session = sessionfactory.getCurrentSession();
		KhoaHoc khoaHoc = new KhoaHoc();
		String hql = "FROM KhoaHoc WHERE id = " + id_khoahoc;
		try {
			khoaHoc = (KhoaHoc) session.createQuery(hql).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return khoaHoc;
		
	}
	
	public List<Khoahoc_Hocvien> ListKH_HV(int id){
		 Session session = sessionfactory.getCurrentSession();
		 ArrayList<Khoahoc_Hocvien> list = null;
			try {
				list = (ArrayList<Khoahoc_Hocvien>) session.createQuery("from Khoahoc_Hocvien s WHERE s.idkhoahoc = " + id).getResultList();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	 }
	
	
	
}
