package com.tranuyen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Khoahoc_Hocvien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "idkhoahoc")
	private KhoaHoc idkhoahoc;
	
	@ManyToOne
	@JoinColumn(name = "idhocvien")
	private SinhVien idhocvien;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public KhoaHoc getIdkhoahoc() {
		return idkhoahoc;
	}
	public void setIdkhoahoc(KhoaHoc idkhoahoc) {
		this.idkhoahoc = idkhoahoc;
	}
	public SinhVien getIdhocvien() {
		return idhocvien;
	}
	public void setIdhocvien(SinhVien idhocvien) {
		this.idhocvien = idhocvien;
	}
	
}
