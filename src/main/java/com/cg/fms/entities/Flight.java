package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flight_table")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Flight_Number")
	private int flightNumber;
	@NotNull(message = "Carrier Name should not be empty")
	@Column(name = "Carrier")
	private String carrierName;
	@NotNull(message = "Flight Model should not be empty")
	@Column(name = "Model")
	private String flightModel;
	@NotNull(message = "Please fill the capacity")
	@Column(name = "Capacity")
	private int seatCapacity;
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public Flight() {
		super();
	}
	public Flight(@NotNull(message = "Carrier Name should not be empty") String carrierName,
			@NotNull(message = "Flight Model should not be empty") String flightModel,
			@NotNull(message = "Please fill the capacity") int seatCapacity) {
		super();
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}

	public Flight(int flightNumber, @NotNull(message = "Carrier Name should not be empty") String carrierName,
			@NotNull(message = "Flight Model should not be empty") String flightModel,
			@NotNull(message = "Please fill the capacity") int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}
}
