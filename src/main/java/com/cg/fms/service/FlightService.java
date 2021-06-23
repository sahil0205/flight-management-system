package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class FlightService implements IFlightService {

	@Autowired
	IFlightRepository repository;
	
	Logger logger = LoggerFactory.getLogger(FlightService.class);

	@Override
	public Flight addFlight(Flight flight) throws Exception {
		logger.info("Adding new flight data to Flight Database");
		return repository.save(flight);
	}

	@Override
	public List<Flight> viewAll() throws Exception {
		List<Flight> flightList = repository.findAll();
		logger.info("Accessing data from Flight Database");
		if (flightList.isEmpty())
			throw new Exception("Flight Database is empty");
		else
			return flightList;
	}

	@Override
	public Flight viewById(int flightNumber) throws Exception {
		logger.info("Accessing flight data for flight number: "+flightNumber);
		if (repository.existsById(flightNumber))
			return repository.findById(flightNumber).get();
		else
			throw new Exception("No Flight found for flight number: " + flightNumber);
	}

	@Override
	public void delete(int flightNumber) throws Exception {
		logger.info("Deleting flight data for flight number: "+flightNumber);
		if (repository.existsById(flightNumber))
			repository.deleteById(flightNumber);
		else
			throw new Exception("Cannot complete deletion as, no flight found for flight number: " + flightNumber);
	}

	@Override
	public Flight update(Flight flight) throws Exception {
		logger.info("Updating flight data for flight number: "+flight.getFlightNumber());
		if (repository.existsById(flight.getFlightNumber()))
			return repository.save(flight);
		else
			throw new Exception("Cannot update as, no flight found for flight number: " + flight.getFlightNumber());
	}

}
