package com.ns.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String passion;
	
	@Column
	private String weddingDate;
	
	@Column
	private Long mobNo;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	public String getPassion() {
		return passion;
	}

	public void setPassion(String passion) {
		this.passion = passion;
	}

	public String getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(String weddingDate) {
		this.weddingDate = weddingDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, Long mobNo, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobNo = mobNo;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobNo() {
		return mobNo;
	}

	public void setMobNo(Long mobNo) {
		this.mobNo = mobNo;
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
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobNo=" + mobNo + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	

}
