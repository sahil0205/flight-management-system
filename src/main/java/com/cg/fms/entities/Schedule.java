package com.cg.fms.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "schedule_table")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Source_ID")
	private Airport source;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Destination_ID")
	private Airport destination;
	@FutureOrPresent(message = "Arrival Date should be present or future")
	private LocalDateTime arrival;
	@FutureOrPresent(message = "Departure Date should be present or future")
	private LocalDateTime departure;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Flight_ID")
	private Flight flight;
	@NotNull
	@Min(value = 1, message = "Cost cannot be empty")
	@Column(name = "Cost_per_person")
	private int cost;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Airport getSource() {
		return source;
	}

	public void setSource(Airport source) {
		this.source = source;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Schedule() {
		super();
	}

	public Schedule(Airport source, Airport destination,
			@FutureOrPresent(message = "Arrival Date should be present or future") LocalDateTime arrival,
			@FutureOrPresent(message = "Departure Date should be present or future") LocalDateTime departure,
			Flight flight, @NotNull @Min(value = 1, message = "Cost cannot be empty") int cost) {
		super();
		this.source = source;
		this.destination = destination;
		this.arrival = arrival;
		this.departure = departure;
		this.flight = flight;
		this.cost = cost;
	}

	public Schedule(int id, Airport source, Airport destination,
			@FutureOrPresent(message = "Arrival Date should be present or future") LocalDateTime arrival,
			@FutureOrPresent(message = "Departure Date should be present or future") LocalDateTime departure,
			Flight flight, @NotNull @Min(value = 1, message = "Cost cannot be empty") int cost) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.arrival = arrival;
		this.departure = departure;
		this.flight = flight;
		this.cost = cost;
	}

	
}
