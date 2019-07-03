package com.tranuyen.inteface;

import com.tranuyen.entity.SinhVien;

public interface  DangKy {
	public boolean Dangky(SinhVien sinhvien);
	public boolean CheckEmailSV(String email);
	public boolean CheckEmailAD(String email);
	public boolean CheckEmailGV(String email);
}
