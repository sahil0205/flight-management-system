package com.cg.fms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer>{

}
