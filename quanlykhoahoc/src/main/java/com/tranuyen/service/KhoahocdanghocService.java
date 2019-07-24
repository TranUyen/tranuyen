package com.tranuyen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.entity.KhoaHoc;
import com.tranuyen.entity.Khoahoc_Hocvien;
import com.tranuyen.implDAO.KhoahocDanghocDAO;

@Service
public class KhoahocdanghocService {
	@Autowired
	private KhoahocDanghocDAO khdao;
	
	public List<KhoaHoc> KhoaHocDangHoc(int id){
		List<Khoahoc_Hocvien> list = khdao.ListDangHoc(id);
		List<KhoaHoc> list1 = new ArrayList<KhoaHoc>();
		for(int i = 0; i < list.size(); i ++) {
			list1.add(list.get(i).getIdkhoahoc());
			
		}
		return list1;
	}
}
