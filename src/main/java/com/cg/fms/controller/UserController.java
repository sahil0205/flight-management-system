package com.cg.fms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.User;
import com.cg.fms.exceptions.Exception;
import com.cg.fms.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/user")
public class UserController {

	@Autowired
	IUserService service;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/adduser")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		try {
			User userData = service.addUser(user);
			logger.info("New User Registered, Hello "+userData.getUserName());
			return new ResponseEntity<Object>(userData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<Object> viewAllUsers() {
		try {
			List<User> userList = service.viewAll();
			logger.info("Accessed User Database");
			return new ResponseEntity<Object>(userList, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewuserbyid/{userId}")
	public ResponseEntity<Object> viewUserById(@PathVariable int userId) {
		try {
			User userData = service.viewById(userId);
			logger.info("Accessed data for id: "+userId);
			return new ResponseEntity<Object>(userData, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable int userId) {
		try {
			service.delete(userId);
			logger.info("Deleted data for id: "+userId);
			return new ResponseEntity<Object>("User Deleted", HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<Object> updateuser(@Valid @RequestBody User user) {
		try {
			User userData = service.updateUser(user);
			logger.info("Updated data for id: "+user.getUserId());
			return new ResponseEntity<Object>(userData, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
		try {
			User userData = service.login(email, password, session);
			logger.info("Login successful");
			return new ResponseEntity<Object>(userData, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Object> logoutUser(HttpSession session){
		try {
			service.logout(session);
			logger.info("Logged Out successfully");
			return new ResponseEntity<Object>("Logout successfull", HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>("Logout unsuccessfull", HttpStatus.BAD_REQUEST);
		}
	}
}
