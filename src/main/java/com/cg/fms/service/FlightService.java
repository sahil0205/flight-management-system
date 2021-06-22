package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class FlightService implements IFlightService{

	@Autowired
	IFlightRepository repository;
	@Override
	public Flight addFlight(Flight flight) throws Exception {
		return repository.save(flight);
	}

	@Override
	public List<Flight> viewAll() throws Exception {
		List<Flight> flightList = repository.findAll();
		if(flightList.isEmpty())
			throw new Exception("No Flights found");
		else
			return flightList;
	}

	@Override
	public Flight viewById(int flightNumber) throws Exception {
		if(repository.existsById(flightNumber))
			return repository.findById(flightNumber).get();
		else
			throw new Exception("No Flight found for flight number: "+flightNumber);
	}

	@Override
	public void delete(int flightNumber) throws Exception {
		if(repository.existsById(flightNumber))
			repository.deleteById(flightNumber);
		else
			throw new Exception("No Flight found for flight number: "+flightNumber);
	}

	@Override
	public Flight update(Flight flight) throws Exception {
		if(repository.existsById(flight.getFlightNumber()))
			return repository.save(flight);
		else
			throw new Exception("No Flight found for flight number: "+flight.getFlightNumber());
	}

}
