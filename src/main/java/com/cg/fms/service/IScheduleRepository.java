package com.cg.fms.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Airport;
import com.cg.fms.entities.Schedule;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer>{
	public List<Schedule> findBySourceAndDestination(Airport source, Airport destination);
}
