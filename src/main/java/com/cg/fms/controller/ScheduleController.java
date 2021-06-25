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

import com.cg.fms.entities.Airport;
import com.cg.fms.entities.Schedule;
import com.cg.fms.exceptions.Exception;
import com.cg.fms.service.IScheduleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/schedule")
public class ScheduleController {
	
	@Autowired
	IScheduleService service;
	
	Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	@PostMapping("/addschedule")
	public ResponseEntity<Object> addSchedule(@Valid @RequestBody Schedule schedule){
		try {
			Schedule obj = service.addSchedule(schedule);
			logger.info("Added new schedule to the database");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<Object> viewAll(){
		try {
			List<Schedule> obj = service.viewAll();
			logger.info("Accessed data from Schedule Table");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<Object> viewById(@PathVariable int id){
		try {
			Schedule obj = service.viewById(id);
			logger.info("Accessed schedule data for id: "+id);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		try {
			service.delete(id);
			logger.info("Deleted schedule for id: "+id);
			return new ResponseEntity<Object>("Deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@Valid @RequestBody Schedule schedule){
		try {
			Schedule obj = service.update(schedule);
			logger.info("Updated schedule for id: "+schedule.getId());
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/viewbysrcanddest")
	public ResponseEntity<Object> viewBySrcAndDest(@RequestParam String source, @RequestParam String destination){
		try {
			List<Schedule> list = service.viewBySourceAndDestination(source, destination);
			logger.info("Accessed schedule data between "+source+" and "+destination);
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
}
