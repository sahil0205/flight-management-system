package com.cg.fms.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.User;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserRepository repository;

	@Override
	public User addUser(User userObj) throws Exception {
		User userData = repository.save(userObj);
		return userData;
	}

	@Override
	public List<User> viewAll() throws Exception {
		List<User> userList = repository.findAll();
		if (userList.isEmpty())
			throw new Exception("No users found");
		else
			return userList;
	}

	@Override
	public User viewById(int userId) throws Exception {
		if (repository.existsByUserId(userId))
			return repository.findByUserId(userId);
		else
			throw new Exception("User not found for id: " + userId);
	}

	@Override
	public void delete(int userId) throws Exception {
		if (repository.existsByUserId(userId))
			repository.deleteById(userId);
		else
			throw new Exception("User not found for id: " + userId);

	}

	@Override
	public User updateUser(User user) throws Exception {
		if (repository.existsByUserId(user.getUserId()))
			return repository.save(user);
		else
			throw new Exception("User not found for id: " + user.getUserId());
	}

	@Override
	public User login(String email, String password, HttpSession session) {
		if (repository.existsByEmailAndPassword(email, password)) {
			User userData = repository.findByEmailAndPassword(email, password);
			session.setAttribute("email", email);
			return userData;
		} else
			throw new Exception("Invalid Credentials");
	}

	@Override
	public void logout(HttpSession session) {
		session.removeAttribute("email");
	}

}
