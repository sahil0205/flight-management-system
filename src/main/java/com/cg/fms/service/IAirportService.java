package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.Exception;

public interface IAirportService {
	public Airport addAirport(Airport airport) throws Exception;
	
	public List<Airport> viewAll() throws Exception;
	
	public Airport viewById(int airportId) throws Exception;
	
	public void delete(int airportId) throws Exception;
	
	public Airport update(Airport airport) throws Exception;
}
