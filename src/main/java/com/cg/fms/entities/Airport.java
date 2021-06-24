package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "airport_table")
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	@Size(min = 1, message = "Airport Code should not be empty")
	@Column(name = "Code")
	private String airportCode;
	@NotNull
	@Size(min = 1, message = "Airport Name should not be empty")
	@Column(name = "Name")
	private String airportName;
	@NotNull
	@Size(min = 1, message = "Airport Location should not be empty")
	@Column(name = "Location")
	private String airportLocation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	public Airport() {
		super();
	}
	public Airport(@NotNull(message = "Airport Code should not be empty") String airportCode,
			@NotNull(message = "Airport Name should not be empty") String airportName,
			@NotNull(message = "Airport Location should not be empty") String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	public Airport(int id, @NotNull(message = "Airport Code should not be empty") String airportCode,
			@NotNull(message = "Airport Name should not be empty") String airportName,
			@NotNull(message = "Airport Location should not be empty") String airportLocation) {
		super();
		this.id = id;
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
}
