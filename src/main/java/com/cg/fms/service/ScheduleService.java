package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Schedule;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class ScheduleService implements IScheduleService {

	@Autowired
	IScheduleRepository repository;

	@Override
	public Schedule addSchedule(Schedule schedule) throws Exception {
		return repository.save(schedule);
	}

	@Override
	public List<Schedule> viewAll() throws Exception {
		List<Schedule> list = repository.findAll();
		if (list.isEmpty())
			throw new Exception("No Schedules found");
		else
			return list;
	}

	@Override
	public Schedule viewById(int id) throws Exception {
		if (repository.existsById(id))
			return repository.findById(id).get();
		else
			throw new Exception("No Schedules found");
	}

	@Override
	public void delete(int id) throws Exception {
		if (repository.existsById(id))
			repository.deleteById(id);
		else
			throw new Exception("No Schedules found");

	}

	@Override
	public Schedule update(Schedule schedule) throws Exception {
		if (repository.existsById(schedule.getId()))
			return repository.save(schedule);
		else
			throw new Exception("No Schedules found");
	}

}
