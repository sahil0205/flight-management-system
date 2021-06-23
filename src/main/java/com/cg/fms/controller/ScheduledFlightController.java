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

import com.cg.fms.entities.ScheduledFlight;
import com.cg.fms.exceptions.Exception;
import com.cg.fms.service.IScheduledFlightService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/scheduled-flight")
public class ScheduledFlightController {
	
	@Autowired
	IScheduledFlightService service;
	
	Logger logger = LoggerFactory.getLogger(ScheduledFlightController.class);
	
	@PostMapping("/add")
	ResponseEntity<Object> add(@Valid @RequestBody ScheduledFlight scheduledFlight){
		try {
			ScheduledFlight obj = service.addScheduledFlight(scheduledFlight);
			logger.info("Scheduled new flight");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewall")
	ResponseEntity<Object> viewAll(){
		try {
			List<ScheduledFlight> obj = service.viewAll();
			logger.info("Accessing all Scheduled Flights data from database");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewbyid/{id}")
	ResponseEntity<Object> viewById(@RequestParam int id){
		try {
			ScheduledFlight obj = service.viewById(id);
			logger.info("Accessed Scheduled Flight data for id: "+id);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Object> delete(@RequestParam int id){
		try {
			service.delete(id);
			logger.info("Deleted the scheduled flight data for id: "+id);
			return new ResponseEntity<Object>("Deleted the scheduled flight data", HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	ResponseEntity<Object> update(@Valid @RequestBody ScheduledFlight scheduledFlight){
		try {
			ScheduledFlight obj = service.update(scheduledFlight);
			logger.info("Updated the scheduled flight data for id: "+scheduledFlight.getId());
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
