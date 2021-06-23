package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.ScheduledFlight;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class ScheduledFlightService implements IScheduledFlightService {

	@Autowired
	IScheduledFlightRepository repository;
	
	Logger logger = LoggerFactory.getLogger(ScheduledFlightService.class);

	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) throws Exception {
		logger.info("Adding new Scheduled Flight to database");
		return repository.save(scheduledFlight);
	}

	@Override
	public List<ScheduledFlight> viewAll() throws Exception {
		logger.info("Accessing Scheduled Flight data from database");
		List<ScheduledFlight> list = repository.findAll();
		if (list.isEmpty())
			throw new Exception("No Scheduled Flights available");
		else
			return list;
	}

	@Override
	public ScheduledFlight viewById(int id) throws Exception {
		if (repository.existsById(id))
			return repository.findById(id).get();
		else
			throw new Exception("No Scheduled Flight for given id: " + id);
	}

	@Override
	public void delete(int id) throws Exception {
		if (repository.existsById(id))
			repository.deleteById(id);
		else
			throw new Exception("Cannot delete, as no Scheduled Flight available for given id: " + id);
	}

	@Override
	public ScheduledFlight update(ScheduledFlight scheduledFlight) throws Exception {
		if (repository.existsById(scheduledFlight.getId()))
			return repository.save(scheduledFlight);
		else
			throw new Exception("Cannot update, as no Scheduled Flight available for given id: " + scheduledFlight.getId());
	}

}
