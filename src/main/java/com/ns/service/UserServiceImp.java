package com.ns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ns.entities.User;
import com.ns.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository repo;

	@Override
	public boolean insertUser(User user) {
		try {
			repo.save(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User getLogin(String email, String password) {
		try {
			User user=repo.findByEmailAndPassword(email, password);
			return user;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<User> getAllData() {
		List<User> users=repo.findAll();
		return users;
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			repo.delete(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
