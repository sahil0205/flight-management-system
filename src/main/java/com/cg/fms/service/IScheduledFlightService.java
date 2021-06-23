package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.ScheduledFlight;
import com.cg.fms.exceptions.Exception;

public interface IScheduledFlightService {

	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) throws Exception;

	public List<ScheduledFlight> viewAll() throws Exception;

	public ScheduledFlight viewById(int id) throws Exception;

	public void delete(int id) throws Exception;

	public ScheduledFlight update(ScheduledFlight scheduledFlight) throws Exception;
}
