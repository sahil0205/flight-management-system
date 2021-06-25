package com.cg.fms.controller;

import java.util.List;

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

import com.cg.fms.entities.Passenger;
import com.cg.fms.service.IPassengerService;

import com.cg.fms.exceptions.Exception;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/passenger")
public class PassengerController {

	@Autowired
	IPassengerService service;
	
	Logger logger = LoggerFactory.getLogger(PassengerController.class);

	@PostMapping("/addpass")
	ResponseEntity<Object> addPass(@Valid @RequestBody Passenger passenger) {
		try {
			Passenger data = service.addPassenger(passenger);
			logger.info("Added new passesnger");
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/viewall")
	ResponseEntity<Object> viewAllPass() {
		try {
			List<Passenger> data = service.viewAll();
			logger.info("Accessed Passenger data from database");
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/viewbyid/{id}")
	ResponseEntity<Object> viewbyId(@PathVariable int id) {
		try {
			Passenger data = service.viewById(id);
			logger.info("Accessed passenger details for PRN: "+id);
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Object> delete(@PathVariable int id) {
		try {
			service.delete(id);
			logger.info("Deleted passenger details for PRN: "+id);
			return new ResponseEntity<Object>("Deleted", HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update")
	ResponseEntity<Object> update(@Valid @RequestBody Passenger passenger) {
		try {
			Passenger data = service.update(passenger);
			logger.info("Updated passenger details for PRN: "+passenger.getPrn());
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
