
package com.tranuyen.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private Set<Khoahoc_Hocvien> khoahochocvien = new HashSet<Khoahoc_Hocvien>();
	
	public KhoaHoc() {
		// TODO Auto-generated constructor stub
	}

	public KhoaHoc(int id, String ten, String thoigian, String chiphi, String email, GiaoVien giaovien, Loai loai) {
		
		this.id = id;
		this.ten = ten;
		this.thoigian = thoigian;
		this.chiphi = chiphi;
		this.idgiaovien = giaovien;
		this.loaiId = loai;
	}
	/*@ManyToMany
	@JoinTable(name = "khoahoc_hocvien", joinColumns = @JoinColumn(name = "idkhoahoc",referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "idhocvien",referencedColumnName = "id"))
	public int getId() {
		return id;
	}*/

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

	public Loai getLoai() {
		return loaiId;
	}

	public void setLoai(Loai loai) {
		this.loaiId = loai;
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
	
}
