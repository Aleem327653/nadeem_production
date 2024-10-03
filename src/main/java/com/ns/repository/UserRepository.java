package com.ns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ns.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	public User findByEmailAndPassword(String email,String password);
	

}
