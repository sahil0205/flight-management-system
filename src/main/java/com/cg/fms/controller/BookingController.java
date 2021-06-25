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

import com.cg.fms.entities.Booking;
import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.Exception;
import com.cg.fms.service.IBookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/booking")
public class BookingController {
	
	@Autowired
	IBookingService service;
	
	Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@PostMapping("/addbooking")
	public ResponseEntity<Object> addFlight(@Valid @RequestBody Booking booking){
		try {
			Booking bookingData = service.addBooking(booking);
			logger.info("New booking added for: "+booking.getUserId().getUserName());
			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<Object> viewAll(){
		try {
			List<Booking> bookingData = service.viewAll();
			logger.info("Accessed data from Booking Database");
			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<Object> viewById(@PathVariable int id){
		try {
			Booking bookingData = service.viewById(id);
			logger.info("Accessed Booking data for id: "+id);
			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		try {
			 service.delete(id);
			 logger.info("Deleted Booking data");
			return new ResponseEntity<Object>("Deleted Booking data", HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@Valid @RequestBody Booking booking){
		try {
			Booking bookingData = service.update(booking);
			logger.info("Updated Booking Data for: "+booking.getUserId().getUserName());
			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
