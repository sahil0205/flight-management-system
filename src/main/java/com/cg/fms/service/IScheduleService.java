package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.Airport;
import com.cg.fms.entities.Schedule;
import com.cg.fms.exceptions.Exception;

public interface IScheduleService {
	public Schedule addSchedule(Schedule schedule) throws Exception;

	public List<Schedule> viewAll() throws Exception;

	public Schedule viewById(int id) throws Exception;

	public void delete(int id) throws Exception;

	public Schedule update(Schedule schedule) throws Exception;
	
	public List<Schedule> viewBySourceAndDestination(int source, int destination) throws Exception;
}
