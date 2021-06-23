package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Passenger;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class PassengerService implements IPassengerService{

	@Autowired
	IPassengerRepository repository;
	
	Logger logger = LoggerFactory.getLogger(PassengerService.class);
	
	@Override
	public Passenger addPassenger(Passenger passenger) throws Exception {
		logger.info("Adding new passenger details in database");
		return repository.save(passenger);
	}

	@Override
	public List<Passenger> viewAll() throws Exception {
		List<Passenger> list = repository.findAll();
		logger.info("Accessing Passeneger database");
		if(list.isEmpty())
			throw new Exception("Passenger database empty");
		else
			return list;
	}

	@Override
	public Passenger viewById(int prn) throws Exception {
		logger.info("Accessing passenger details for PRN: "+prn);
		if(repository.existsById(prn))
			return repository.findById(prn).get();
		else
			throw new Exception("No Passenger Found for PRN: "+prn);
	}

	@Override
	public void delete(int prn) throws Exception {
		logger.info("Deleting passenger details for PRN: "+prn);
		if(repository.existsById(prn))
			repository.deleteById(prn);
		else
			throw new Exception("Cannot delete passenger, as no passenger found for PRN: "+prn);
	}

	@Override
	public Passenger update(Passenger passenger) throws Exception {
		logger.info("Updating passenger details for PRN: "+passenger.getPrn());
		if(repository.existsById(passenger.getPrn()))
			return repository.save(passenger);
		else
			throw new Exception("Cannot update passenger, as no passenger found for PRN: "+passenger.getPrn());
	}

}
