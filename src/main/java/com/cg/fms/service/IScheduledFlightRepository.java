package com.cg.fms.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.ScheduledFlight;

@Repository
public interface IScheduledFlightRepository extends JpaRepository<ScheduledFlight, Integer> {
}
