package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Airport;
import com.cg.fms.entities.Schedule;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class ScheduleService implements IScheduleService {

	@Autowired
	IScheduleRepository repository;
	
	@Autowired
	IAirportRepository airportRepo;
	
	Logger logger = LoggerFactory.getLogger(ScheduleService.class);

	@Override
	public Schedule addSchedule(Schedule schedule) throws Exception {
		logger.info("Adding new schedule to database");
		return repository.save(schedule);
	}

	@Override
	public List<Schedule> viewAll() throws Exception {
		List<Schedule> list = repository.findAll();
		logger.info("Accessing data from schedule table");
		if (list.isEmpty())
			throw new Exception("Schedule database is empty");
		else
			return list;
	}

	@Override
	public Schedule viewById(int id) throws Exception {
		logger.info("Accessing schedule data for id: "+id);
		if (repository.existsById(id))
			return repository.findById(id).get();
		else
			throw new Exception("No Schedules found for id: "+id);
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("Deleting schedule data for id: "+id);
		if (repository.existsById(id))
			repository.deleteById(id);
		else
			throw new Exception("Cannot delete schedule, as no schedule found for id: "+id);

	}

	@Override
	public Schedule update(Schedule schedule) throws Exception {
		logger.info("Updating schedule for id: "+schedule.getId());
		if (repository.existsById(schedule.getId()))
			return repository.save(schedule);
		else
			throw new Exception("Cannot update schedule, as no schedule found for id: "+schedule.getId());
	}

	@Override
	public List<Schedule> viewBySourceAndDestination(String source, String destination) throws Exception {
		List<Schedule> list = repository.findBySourceAndDestination(airportRepo.findByAirportName(source), airportRepo.findByAirportName(destination));
		if(list.isEmpty())
			throw new Exception("No Schedule found between "+source+" and "+destination);
		else
			return list;
	}

}
