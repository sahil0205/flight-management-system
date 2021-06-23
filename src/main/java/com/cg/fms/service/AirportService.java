package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class AirportService implements IAirportService {

	@Autowired
	IAirportRepository repository;
	
	Logger logger = LoggerFactory.getLogger(AirportService.class);
	
	@Override
	public Airport addAirport(Airport airport) throws Exception {
		logger.info("Adding "+airport.getAirportName()+" to Airport Database");
		return repository.save(airport);
	}

	@Override
	public List<Airport> viewAll() throws Exception {
		List<Airport> airportList = repository.findAll();
		logger.info("Accessing data from Airport Database");
		if(airportList.isEmpty()) {
			throw new Exception("Airport Database Empty");
		}	
		else {
			return airportList;
		}
			
	}

	@Override
	public Airport viewById(int airportId) throws Exception {
		logger.info("Accessing Airport data for id: "+airportId);
		if(repository.existsById(airportId)) {
			return repository.findById(airportId).get();
		}
		else {
			throw new Exception("No airport found for id: "+airportId);
		}
	}

	@Override
	public void delete(int airportId) throws Exception {
		logger.info("Deleting airport data for id: "+airportId);
		if(repository.existsById(airportId))
			repository.deleteById(airportId);
		else
			throw new Exception("Cannot complete deletion, as no airport found for id: "+airportId);
	}

	@Override
	public Airport update(Airport airport) throws Exception {
		logger.info("Updating airport data for id: "+airport.getId());
		if(repository.existsById(airport.getId()))
			return repository.save(airport);
		else
			throw new Exception("Cannot update, as no airport found for id: "+airport.getId());
	}

}
