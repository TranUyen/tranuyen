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
@Table(name = "sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String hoten;
	private String diachi;
	private String sdt;
	private String email;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Roles roles;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private Set<Khoahoc_Hocvien> khoahochocvien = new HashSet<Khoahoc_Hocvien>();
	
	public SinhVien() {
		
	}
	
	@ManyToMany
	@JoinTable(name = "diemdanh", joinColumns = @JoinColumn(name = "idhocvien",referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "idbaihoc",referencedColumnName = "id"))
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	


}
