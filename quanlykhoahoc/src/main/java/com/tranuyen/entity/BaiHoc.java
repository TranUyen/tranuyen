package com.tranuyen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "baihoc")
public class BaiHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String tgbatdau;
	private String tgketthuc;
	
	@ManyToOne
	@JoinColumn(name = "idkhoahoc")
	private KhoaHoc idkhoahoc;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTgbatdau() {
		return tgbatdau;
	}

	public void setTgbatdau(String tgbatdau) {
		this.tgbatdau = tgbatdau;
	}

	public String getTgketthuc() {
		return tgketthuc;
	}

	public void setTgketthuc(String tgketthuc) {
		this.tgketthuc = tgketthuc;
	}



	public KhoaHoc getIdkhoahoc() {
		return idkhoahoc;
	}



	public void setIdkhoahoc(KhoaHoc idkhoahoc) {
		this.idkhoahoc = idkhoahoc;
	}

	
	
}
