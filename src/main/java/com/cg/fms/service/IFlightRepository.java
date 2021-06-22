package com.cg.fms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer>{

}
