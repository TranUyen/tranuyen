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

import com.tranuyen.DAO.KhoaHocDangDayInf;
import com.tranuyen.entity.KhoaHoc;
@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class KhoaHocDangDayDAO implements KhoaHocDangDayInf {
	@Autowired
	SessionFactory sessionfactory;
	
	public List<KhoaHoc> KhoaHocDangDay(int id_giaovien) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "FROM KhoaHoc WHERE idgiaovien = " + id_giaovien;
		ArrayList<KhoaHoc> list = null;
		try {
			list = (ArrayList<KhoaHoc>)session.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
