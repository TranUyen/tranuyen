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

import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.inteface.ThongKe;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ThongkeDAO implements ThongKe{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<KhoaHoc> ListSeminar(int loaiId) {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<KhoaHoc> list = null;
		try {
			list = (ArrayList<KhoaHoc>) session.createQuery("from KhoaHoc s WHERE s.loaiId = " + loaiId).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<KhoaHoc> ListAll() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<KhoaHoc> list = null;
		try {
			list = (ArrayList<KhoaHoc>) session.createQuery("from KhoaHoc").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
