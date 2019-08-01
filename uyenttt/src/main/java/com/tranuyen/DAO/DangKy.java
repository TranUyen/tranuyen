package com.tranuyen.DAO;

import java.util.ArrayList;
import java.util.List;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.BaiHoc;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.SinhVien;

public interface  DangKy {
	public boolean Dangky(SinhVien sinhvien);
	public boolean CheckEmailSV(String email);
	public boolean CheckEmailAD(String email);
	public boolean CheckEmailGV(String email);
	public boolean AddGiaoVien(GiaoVien gv);
	public boolean AddAdmin(Admin ad);
	public int CheckGV(String name);
	public boolean AddBaiHoc(BaiHoc baihoc);
	public boolean AddKhoahoc(KhoaHoc khoahoc);
	public ArrayList<Admin> listAddAdmins();
}
