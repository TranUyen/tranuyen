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

import com.tranuyen.DAO.ThongKe;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.SinhVien;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ThongkeDAO implements ThongKe{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<KhoaHoc> ListAll(int loaiId) {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<KhoaHoc> list = null;
		try {
			if(loaiId == 0) {
				list = (ArrayList<KhoaHoc>)session.createQuery("from KhoaHoc ").list();
			}else {
				list = (ArrayList<KhoaHoc>) session.createQuery("from KhoaHoc s WHERE s.loaiId = " + loaiId).getResultList();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<KhoaHoc> ListAll(int loaiId, int offset, int maxResults) {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<KhoaHoc> list = null;
		try {
				if(loaiId == 0) {
					list = (ArrayList<KhoaHoc>) session.createQuery("from KhoaHoc ").setFirstResult(offset).setMaxResults(maxResults).list();
				}else {
					list = (ArrayList<KhoaHoc>) session.createQuery("from KhoaHoc s WHERE s.loaiId = " + loaiId).setFirstResult(offset).setMaxResults(maxResults).getResultList();
				}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	  public List<KhoaHoc> ListAll() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<KhoaHoc> list = null;
		try {
			list = (ArrayList<KhoaHoc>) session.createQuery("from KhoaHoc ").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<GiaoVien> ListGV() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<GiaoVien> list = null;
		try {
			list = (ArrayList<GiaoVien>) session.createQuery("from GiaoVien").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<SinhVien> ListSV() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<SinhVien> list = null;
		try {
			list = (ArrayList<SinhVien>) session.createQuery("from SinhVien").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public GiaoVien GV(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from GiaoVien where id=" + id;
		GiaoVien gv = null;
		try {
			gv  = (GiaoVien) session.createQuery(hql).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gv;
	}
	
	public boolean UpdateGV(GiaoVien gv) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(gv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public SinhVien SV(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from SinhVien where id=" + id;
		SinhVien sv = null;
		try {
			sv  = (SinhVien) session.createQuery(hql).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sv;
	}
	
	public boolean UpdateSV(SinhVien sv) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(sv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
