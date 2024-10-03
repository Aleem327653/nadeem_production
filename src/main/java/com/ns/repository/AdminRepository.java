package com.ns.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ns.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{
	public Admin findByIdAndEmail(Long id,String email);

}
