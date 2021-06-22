package com.cg.fms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Passenger;

@Repository
public interface IPassengerRepository extends JpaRepository<Passenger, Integer>{

}
