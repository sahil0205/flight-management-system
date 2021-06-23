package com.cg.fms.entities;

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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "scheduled_flight_table")
public class ScheduledFlight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Flight")
	private Flight flight;
	@NotNull(message = "Enter available seats")
	@Column(name = "Available_Seats")
	private int availabeSeats;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Schedule")
	private Schedule schedule;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailabeSeats() {
		return availabeSeats;
	}

	public void setAvailabeSeats(int availabeSeats) {
		this.availabeSeats = availabeSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public ScheduledFlight() {
		super();
	}

	public ScheduledFlight(Flight flight, @NotNull(message = "Enter available seats") int availabeSeats,
			Schedule schedule) {
		super();
		this.flight = flight;
		this.availabeSeats = availabeSeats;
		this.schedule = schedule;
	}

	public ScheduledFlight(int id, Flight flight, @NotNull(message = "Enter available seats") int availabeSeats,
			Schedule schedule) {
		super();
		this.id = id;
		this.flight = flight;
		this.availabeSeats = availabeSeats;
		this.schedule = schedule;
	}
}
