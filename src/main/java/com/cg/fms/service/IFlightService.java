package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.Exception;

public interface IFlightService {
	public Flight addFlight(Flight flight) throws Exception;

	public List<Flight> viewAll() throws Exception;

	public Flight viewById(int flightNumber) throws Exception;

	public void delete(int flightNumber) throws Exception;

	public Flight update(Flight flight) throws Exception;
}
