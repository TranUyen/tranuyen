package com.tranuyen.entity;

import java.util.ArrayList;

public interface DeleteUser {
	public boolean DeleteGV(int id);
	public ArrayList<KhoaHoc> DeleteKHGV(int id);
	public boolean DeleteKhoaHoc(KhoaHoc khoahoc);
	public boolean DeleteBaihoc(BaiHoc bh);
	public ArrayList<Khoahoc_Hocvien> DeleteKHHV(int id);
	public boolean DeleteHocVien(int id);
}
