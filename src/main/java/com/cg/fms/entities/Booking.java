package com.cg.fms.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "booking_table")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Booking_Id")
	private int bookingId;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private User userId;
	@FutureOrPresent(message = "Booking Date should be a present date or a future date")
	@Column(name = "Booking_Date")
	private LocalDate bookingDate;
	@OneToMany(cascade = CascadeType.MERGE, targetEntity = Passenger.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "Booking_Id", referencedColumnName = "Booking_Id")
	private List<Passenger> passengerList;
	@NotNull
	@Min(value = 1, message = "Cost should not be empty")
	@Column(name = "Cost")
	private double cost;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Flight flight;
	@NotNull
	@Min(value = 1, message = "Enter no of passengers")
	@Column(name = "No_of_Passengers")
	private int noOfPassengers;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public Booking() {
		super();
	}

	public Booking(User userId,
			@FutureOrPresent(message = "Booking Date should be a present date or a future date") LocalDate bookingDate,
			List<Passenger> passengerList, @NotNull(message = "Cost should not be empty") double cost, Flight flight,
			@NotNull(message = "Enter no of passengers") int noOfPassengers) {
		super();
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.cost = cost;
		this.flight = flight;
		this.noOfPassengers = noOfPassengers;
	}

	public Booking(int bookingId, User userId,
			@FutureOrPresent(message = "Booking Date should be a present date or a future date") LocalDate bookingDate,
			List<Passenger> passengerList, @NotNull(message = "Cost should not be empty") double cost, Flight flight,
			@NotNull(message = "Enter no of passengers") int noOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.cost = cost;
		this.flight = flight;
		this.noOfPassengers = noOfPassengers;
	}
}
