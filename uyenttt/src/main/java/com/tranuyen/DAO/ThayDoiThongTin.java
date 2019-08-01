package com.tranuyen.DAO;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;
import com.tranuyen.entity.SinhVien;

public interface ThayDoiThongTin {
	public boolean SetSV(SinhVien sv);
	public boolean SetGV(GiaoVien gv);
	public boolean SetAD(Admin ad);
	public boolean SetKhoaHoc(KhoaHoc khoahoc);
	public boolean SetBaiHoc(BaiHoc baihoc);
	public boolean DeleteKhoaHoc(KhoaHoc khoahoc);
	public boolean DeleteBaihoc(BaiHoc baihoc);
	public boolean DeleteKH_HV(Khoahoc_Hocvien kh_hv);
}
