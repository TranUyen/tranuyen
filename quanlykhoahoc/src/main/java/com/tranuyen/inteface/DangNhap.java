package com.tranuyen.inteface;

import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;

public interface DangNhap {
	public boolean CheckLogInSV(String password, String email);
	public boolean CheckLogInGV(String password, String email);
	public boolean CheckLogInAd(String password, String email);
	public SinhVien ThongtinSV(String email);
	public GiaoVien ThongtinGV(String email);
	public Admin ThongtinAd(String email);
}


