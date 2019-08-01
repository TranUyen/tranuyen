package com.tranuyen.DAO;

import java.util.List;

import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.SinhVien;

public interface ThongKe {
	public List<KhoaHoc> ListAll(int loaiId);
	public List<KhoaHoc> ListAll(int loaiId, int offset, int maxResults); 
	public List<KhoaHoc> ListAll();
	public List<SinhVien> ListSV();
	public List<GiaoVien> ListGV();
	public GiaoVien GV(int id);
	public SinhVien SV(int id);
	public boolean UpdateGV(GiaoVien gv);
	public boolean UpdateSV(SinhVien sv);
		
}
