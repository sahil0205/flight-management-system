package com.cg.fms.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cg.fms.entities.User;
import com.cg.fms.exceptions.Exception;

public interface IUserService {
	public User addUser(User userObj) throws Exception;

	public List<User> viewAll() throws Exception;

	public User viewById(int userId) throws Exception;

	public void delete(int userId) throws Exception;

	public User updateUser(User user) throws Exception;
	
	public User login(String email, String password, HttpSession session);
	
	public void logout(HttpSession session);
}
