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

import com.tranuyen.DAO.KhoaHocdanghocInf;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;

@Repository
@Transactional

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class KhoahocDanghocDAO implements KhoaHocdanghocInf {
	@Autowired
    private SessionFactory sessionFactory;
	
	 
	 public List<Khoahoc_Hocvien> ListDangHoc(int id){
		 Session session = sessionFactory.getCurrentSession();
		 ArrayList<Khoahoc_Hocvien> list = null;
			try {
				list = (ArrayList<Khoahoc_Hocvien>) session.createQuery("from Khoahoc_Hocvien s WHERE s.idhocvien = " + id).getResultList();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	 }
}
