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

import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.Exception;
import com.cg.fms.service.IAirportService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fms/airport")
public class AirportController {
	
	@Autowired
	IAirportService service;
	
	@PostMapping("/addairport")
	public ResponseEntity<Object> addAirport(@Valid @RequestBody Airport airport ) {
		try {
			Airport airportData = service.addAirport(airport);
			return new ResponseEntity<Object>(airportData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<Object> viewAllAirport() {
		try {
			List<Airport> airportList = service.viewAll();
			return new ResponseEntity<Object>(airportList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<Object> viewById(@RequestParam int id ) {
		try {
			Airport airportData = service.viewById(id);
			return new ResponseEntity<Object>(airportData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@RequestParam int id ) {
		try {
			service.delete(id);
			return new ResponseEntity<Object>("Airport Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@Valid @RequestBody Airport airport ) {
		try {
			Airport airportData = service.update(airport);
			return new ResponseEntity<Object>(airportData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
