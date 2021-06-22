package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.Passenger;
import com.cg.fms.exceptions.Exception;

public interface IPassengerService {
	public Passenger addPassenger(Passenger passenger) throws Exception;

	public List<Passenger> viewAll() throws Exception;

	public Passenger viewById(int prn) throws Exception;

	public void delete(int prn) throws Exception;

	public Passenger update(Passenger passenger) throws Exception;
}
