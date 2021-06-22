package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class AirportService implements IAirportService {

	@Autowired
	IAirportRepository repository;
	
	@Override
	public Airport addAirport(Airport airport) throws Exception {
		return repository.save(airport);
	}

	@Override
	public List<Airport> viewAll() throws Exception {
		List<Airport> airportList = repository.findAll();
		if(airportList.isEmpty())
			throw new Exception("No airports found");
		else
			return airportList;
	}

	@Override
	public Airport viewById(int airportId) throws Exception {
		if(repository.existsById(airportId))
			return repository.findById(airportId).get();
		else
			throw new Exception("No airport found for id: "+airportId);
	}

	@Override
	public void delete(int airportId) throws Exception {
		if(repository.existsById(airportId))
			repository.deleteById(airportId);
		else
			throw new Exception("No airport found for id: "+airportId);
	}

	@Override
	public Airport update(Airport airport) throws Exception {
		if(repository.existsById(airport.getId()))
			return repository.save(airport);
		else
			throw new Exception("No airport found for id: "+airport.getId());
	}

}
