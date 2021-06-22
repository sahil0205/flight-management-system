package com.cg.fms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Schedule;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer>{
	
}
