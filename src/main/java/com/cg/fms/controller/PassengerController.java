package com.cg.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Passenger;
import com.cg.fms.service.IPassengerService;

import com.cg.fms.exceptions.Exception;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/passenger")
public class PassengerController {

	@Autowired
	IPassengerService service;

	@PostMapping("/addpass")
	ResponseEntity<Object> addPass(@Valid @RequestBody Passenger passenger) {
		try {
			Passenger data = service.addPassenger(passenger);
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/viewall")
	ResponseEntity<Object> viewAllPass() {
		try {
			List<Passenger> data = service.viewAll();
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/viewbyid/{id}")
	ResponseEntity<Object> viewbyId(@RequestParam int id) {
		try {
			Passenger data = service.viewById(id);
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Object> delete(@RequestParam int id) {
		try {
			service.delete(id);
			return new ResponseEntity<Object>("Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update")
	ResponseEntity<Object> update(@Valid @RequestBody Passenger passenger) {
		try {
			Passenger data = service.update(passenger);
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
