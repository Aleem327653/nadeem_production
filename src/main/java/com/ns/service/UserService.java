package com.ns.service;

import java.util.List;

import com.ns.entities.User;

public interface UserService {
	public boolean insertUser(User user);
	public User getLogin(String email,String password);
	public List<User> getAllData();
	public boolean deleteUser(User user);

}
