package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Passenger;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class PassengerService implements IPassengerService{

	@Autowired
	IPassengerRepository repository;
	
	@Override
	public Passenger addPassenger(Passenger passenger) throws Exception {
		return repository.save(passenger);
	}

	@Override
	public List<Passenger> viewAll() throws Exception {
		List<Passenger> list = repository.findAll();
		if(list.isEmpty())
			throw new Exception("No Passengers Found");
		else
			return list;
	}

	@Override
	public Passenger viewById(int prn) throws Exception {
		if(repository.existsById(prn))
			return repository.findById(prn).get();
		else
			throw new Exception("No Passenger Found for PRN: "+prn);
	}

	@Override
	public void delete(int prn) throws Exception {
		if(repository.existsById(prn))
			repository.deleteById(prn);
		else
			throw new Exception("No Passenger Found for PRN: "+prn);
	}

	@Override
	public Passenger update(Passenger passenger) throws Exception {
		if(repository.existsById(passenger.getPrn()))
			return repository.save(passenger);
		else
			throw new Exception("No Passenger Found for PRN: "+passenger.getPrn());
	}

}
