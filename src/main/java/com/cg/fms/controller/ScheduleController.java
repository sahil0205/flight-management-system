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

import com.cg.fms.entities.Schedule;
import com.cg.fms.exceptions.Exception;
import com.cg.fms.service.IScheduleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/schedule")
public class ScheduleController {
	
	@Autowired
	IScheduleService service;
	
	@PostMapping("/addschedule")
	public ResponseEntity<Object> addSchedule(@Valid @RequestBody Schedule schedule){
		try {
			Schedule obj = service.addSchedule(schedule);
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
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<Object> viewById(@RequestParam int id){
		try {
			Schedule obj = service.viewById(id);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@RequestParam int id){
		try {
			service.delete(id);
			return new ResponseEntity<Object>("Deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@Valid @RequestBody Schedule schedule){
		try {
			Schedule obj = service.addSchedule(schedule);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
	}
}
