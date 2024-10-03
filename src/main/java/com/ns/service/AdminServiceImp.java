package com.ns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ns.entities.Admin;
import com.ns.repository.AdminRepository;

@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	private AdminRepository repo;

	@Override
	public Admin getAdminLogin(Long id,String email) {
		
		return repo.findByIdAndEmail(id, email);
	}

}
