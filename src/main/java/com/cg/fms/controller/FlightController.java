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

import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.Exception;
import com.cg.fms.service.IFlightService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/flight")
public class FlightController {
	
	@Autowired
	IFlightService service;
	
	Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	@PostMapping("/addflight")
	public ResponseEntity<Object> addFlight(@Valid @RequestBody Flight flight){
		try {
			Flight flightData = service.addFlight(flight);
			logger.info("Added new flight to Flight Database");
			return new ResponseEntity<Object>(flightData, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<Object> viewAll(){
		try {
			List<Flight> flightData = service.viewAll();
			logger.info("Accessed data from flight database");
			return new ResponseEntity<Object>(flightData, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("viewbyid/{id}")
	public ResponseEntity<Object> viewById(@RequestParam int id){
		try {
			Flight flightData = service.viewById(id);
			logger.info("Accessed Flight data for flight number: "+id);
			return new ResponseEntity<Object>(flightData, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@RequestParam int id){
		try {
			service.delete(id);
			logger.info("Flight Data deleted");
			return new ResponseEntity<Object>("Flight data deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@Valid @RequestBody Flight flight){
		try {
			Flight flightData = service.update(flight);
			logger.info("Flight data updated for flight number: "+flight.getFlightNumber());
			return new ResponseEntity<Object>(flightData, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
