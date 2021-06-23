package com.cg.fms.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.User;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserRepository repository;
	
	Logger logger = LoggerFactory.getLogger(IUserService.class);

	@Override
	public User addUser(User userObj) throws Exception {
		User userData = repository.save(userObj);
		logger.info("Registering new user");
		return userData;
	}

	@Override
	public List<User> viewAll() throws Exception {
		List<User> userList = repository.findAll();
		logger.info("Accessing User Data from database");
		if (userList.isEmpty())
			throw new Exception("User Database Empty");
		else
			return userList;
	}

	@Override
	public User viewById(int userId) throws Exception {
		logger.info("Accessing user data for id: "+userId);
		if (repository.existsByUserId(userId))
			return repository.findByUserId(userId);
		else
			throw new Exception("User not found for id: " + userId);
	}

	@Override
	public void delete(int userId) throws Exception {
		logger.info("Deleting user data for id: "+userId);
		if (repository.existsByUserId(userId))
			repository.deleteById(userId);
		else
			throw new Exception("Cannot delete as, User not found for id: " + userId);

	}

	@Override
	public User updateUser(User user) throws Exception {
		logger.info("Updating user data for id: "+user.getUserId());
		if (repository.existsByUserId(user.getUserId()))
			return repository.save(user);
		else
			throw new Exception("Cannot update as, User not found for id: " + user.getUserId());
	}

	@Override
	public User login(String email, String password, HttpSession session) {
		logger.info("User logging in");
		if (repository.existsByEmailAndPassword(email, password)) {
			User userData = repository.findByEmailAndPassword(email, password);
			session.setAttribute("email", email);
			return userData;
		} else
			throw new Exception("Cannot login, Invalid Credentials");
	}

	@Override
	public void logout(HttpSession session) {
		logger.info("User logging out");
		session.removeAttribute("email");
	}

}
