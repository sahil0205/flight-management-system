package com.cg.fms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Airport;

@Repository
public interface IAirportRepository extends JpaRepository<Airport, Integer>{
	public Airport findByAirportName(String airportName);
	public Airport findById(int id);
}
