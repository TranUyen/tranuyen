package com.tranuyen.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.DAO.ThongKe;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.implDAO.ThongkeDAO;

@Service
public class ThongKeService implements ThongKe{
	@Autowired
	private ThongkeDAO thongkedao;
	
	public List<KhoaHoc> ListAll(int loaiId) {
		return thongkedao.ListAll(loaiId);
	}
	
	public List<KhoaHoc> ListAll(int loaiId, int offset, int maxResults) {
		return thongkedao.ListAll(loaiId, offset, maxResults);
	}
	
	public List<KhoaHoc> ListAll() {
		List<KhoaHoc> list = thongkedao.ListAll();
		return list;
	}
	
	
	public List<GiaoVien> ListGV() {
		return thongkedao.ListGV();
	}
	
	public List<SinhVien> ListSV() {
		return thongkedao.ListSV();
	}
	
	public GiaoVien GV(int id) {
		return thongkedao.GV(id);
	}
	
	public boolean UpdateGV(GiaoVien gv) {
		return thongkedao.UpdateGV(gv);
	}
	
	public SinhVien SV(int id) {
		return thongkedao.SV(id);
	}
	
	public boolean UpdateSV(SinhVien sv) {
		return thongkedao.UpdateSV(sv);
	}
}
