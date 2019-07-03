package com.tranuyen.inteface;

import java.util.List;

import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;

public interface KhoaHocdanghocInf {
	public List<Khoahoc_Hocvien> ListDangHoc(int id);
}
