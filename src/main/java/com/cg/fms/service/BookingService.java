package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Booking;
import com.cg.fms.exceptions.Exception;

@Service
@Transactional
public class BookingService implements IBookingService {

	@Autowired
	IBookingRepository repository;
	
	Logger logger = LoggerFactory.getLogger(BookingService.class);

	@Override
	public Booking addBooking(Booking booking) throws Exception {
		logger.info("Creating a new booking for: "+booking.getUserId().getUserName());
		return repository.save(booking);
	}

	@Override
	public List<Booking> viewAll() throws Exception {
		List<Booking> list = repository.findAll();
		logger.info("Accessing data from Booking Database");
		if (list.isEmpty())
			throw new Exception("Booking Database is empty");
		else
			return list;
	}

	@Override
	public Booking viewById(int bookingId) throws Exception {
		logger.info("Accessing booking data for id: "+bookingId);
		if (repository.existsById(bookingId))
			return repository.findById(bookingId).get();
		else
			throw new Exception("No Booking data found for id: " + bookingId);
	}

	@Override
	public void delete(int bookingId) throws Exception {
		logger.info("Deleting booking data for id: "+bookingId);
		if (repository.existsById(bookingId))
			repository.deleteById(bookingId);
		else
			throw new Exception("Cannot delete, as no Booking found for id: " + bookingId);
	}

	@Override
	public Booking update(Booking booking) throws Exception {
		logger.info("Deleting booking data for id: "+booking.getBookingId());
		if (repository.existsById(booking.getBookingId()))
			return repository.save(booking);
		else
			throw new Exception("Cannot update, as no Booking found for id: " + booking.getBookingId());
	}

}
