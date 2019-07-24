
package com.tranuyen.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String ten;
	private String thoigian;
	private String chiphi;
	private String img;
	
	@ManyToOne
	@JoinColumn(name = "idgiaovien")
	private GiaoVien idgiaovien;
	
	@ManyToOne
	@JoinColumn( name = "loaiId")
	private Loai loaiId;
	
	@OneToMany(mappedBy = "idkhoahoc", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<BaiHoc> listbaihoc;
	
	@OneToMany(mappedBy = "idkhoahoc", cascade = CascadeType.ALL)
	private List<Khoahoc_Hocvien> khoahochocvien ;
	
	
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

	public String getChiphi() {
		return chiphi;
	}

	public void setChiphi(String chiphi) {
		this.chiphi = chiphi;
	}

	public GiaoVien getGiaovien() {
		return idgiaovien;
	}

	public void setGiaovien(GiaoVien giaovien) {
		this.idgiaovien = giaovien;
	}

	public GiaoVien getIdgiaovien() {
		return idgiaovien;
	}
	
	public String getImg() {
		return img;
	}
	public void setIdgiaovien(GiaoVien idgiaovien) {
		this.idgiaovien = idgiaovien;
	}
	
	public void setImg(String img) {
		this.img = img;
	}


	public Loai getLoaiId() {
		return loaiId;
	}


	public void setLoaiId(Loai loaiId) {
		this.loaiId = loaiId;
	}


	
	public void setListbaihoc(List<BaiHoc> listbaihoc) {
		this.listbaihoc = listbaihoc;
	}
	public List<BaiHoc> getListbaihoc() {
		return listbaihoc;
	}

	public void setKhoahochocvien(List<Khoahoc_Hocvien> khoahochocvien) {
		this.khoahochocvien = khoahochocvien;
	}
	
	public List<Khoahoc_Hocvien> getKhoahochocvien() {
		return khoahochocvien;
	}


	public int getId() {
		return id;
	}
	
}
