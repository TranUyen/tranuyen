package com.tranuyen.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranuyen.DAO.DangNhap;
import com.tranuyen.entity.Admin;
import com.tranuyen.entity.GiaoVien;
import com.tranuyen.entity.SinhVien;
import com.tranuyen.implDAO.DangNhapDAO;

@Service
public class DangnhapService implements DangNhap {
	
	@Autowired
	DangNhapDAO dao;
	
	
	public boolean CheckLogInSV(String password, String email) {
		return dao.CheckLogInSV(password, email);
	}
	
	public boolean CheckLogInAd(String password, String email) {
		return dao.CheckLogInAd(password, email);
	}
	public boolean CheckLogInGV(String password, String email) {
		return dao.CheckLogInGV(password, email);
	}
	public SinhVien ThongtinSV(String email) {
		return dao.ThongtinSV(email);
	}
	
	public Admin ThongtinAd(String email) {
		return dao.ThongtinAd(email);
	}
	
	public GiaoVien ThongtinGV(String email) {
		
		return dao.ThongtinGV(email);
	}
	 public String Md5(String password) {
		 String result = "";
			MessageDigest digest;
			try {
				digest = MessageDigest.getInstance("MD5");
				digest.update(password.getBytes());
				BigInteger bigInteger = new BigInteger(1,digest.digest());
				result = bigInteger.toString(16);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return result;
	 }
	
	

	
}
