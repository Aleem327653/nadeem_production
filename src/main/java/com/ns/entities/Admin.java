package com.ns.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@Column
	private Long id;
	
	@Column
	private String adminName;
	
	@Column
	private String studioName;
	
	@Column
	private String email;
	
	@Column
	private String studioAddress;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long id, String adminName, String studioName, String email, String studioAddress) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.studioName = studioName;
		this.email = email;
		this.studioAddress = studioAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getStudioName() {
		return studioName;
	}

	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudioAddress() {
		return studioAddress;
	}

	public void setStudioAddress(String studioAddress) {
		this.studioAddress = studioAddress;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", studioName=" + studioName + ", email=" + email
				+ ", studioAddress=" + studioAddress + "]";
	}
	
	
	

}
