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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.Exception;
import com.cg.fms.service.IAirportService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/airport")
public class AirportController {
	
	@Autowired
	IAirportService service;
	
	Logger logger = LoggerFactory.getLogger(AirportController.class);
	
	@PostMapping("/addairport")
	public ResponseEntity<Object> addAirport(@Valid @RequestBody Airport airport ) {
		try {
			Airport airportData = service.addAirport(airport);
			logger.info("Added "+airport.getAirportName()+" to Airport database");
			return new ResponseEntity<Object>(airportData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<Object> viewAllAirport() {
		try {
			List<Airport> airportList = service.viewAll();
			logger.info("Accessed data from Airport Database");
			return new ResponseEntity<Object>(airportList, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<Object> viewById(@RequestParam int id ) {
		try {
			Airport airportData = service.viewById(id);
			logger.info("Accessed Airport data for id: "+id);
			return new ResponseEntity<Object>(airportData, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@RequestParam int id ) {
		try {
			service.delete(id);
			logger.info("Airport data deleted");
			return new ResponseEntity<Object>("Airport data deleted", HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@Valid @RequestBody Airport airport ) {
		try {
			Airport airportData = service.update(airport);
			logger.info("Data updated for "+airport.getAirportName());
			return new ResponseEntity<Object>(airportData, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
