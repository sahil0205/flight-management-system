package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.Booking;
import com.cg.fms.exceptions.Exception;

public interface IBookingService {

	public Booking addBooking(Booking booking) throws Exception;

	public List<Booking> viewAll() throws Exception;

	public Booking viewById(int bookingId) throws Exception;

	public void delete(int bookingId) throws Exception;

	public Booking update(Booking booking) throws Exception;
}
