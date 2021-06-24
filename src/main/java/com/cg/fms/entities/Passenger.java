package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "passenger_table")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRN")
	private int prn;
	@NotNull
	@Size(min = 1, message = "Name should not be empty")
	@Column(name = "Name")
	private String passengerName;
	@NotNull
	@Min(value = 1, message = "Age cannot be empty")
	@Column(name = "Age")
	private int age;
	@NotNull
	@Min(value = 1, message = "UIN cannot be empty")
	@Column(name = "UIN")
	private int uin;
	private boolean luggage;
	public int getPrn() {
		return prn;
	}
	public void setPrn(int prn) {
		this.prn = prn;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getUin() {
		return uin;
	}
	public void setUin(int uin) {
		this.uin = uin;
	}
	public boolean isLuggage() {
		return luggage;
	}
	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}
	public Passenger() {
		super();
	}
	public Passenger(@NotNull(message = "Name should not be empty") String passengerName,
			@NotNull(message = "Age cannot be empty") int age, @NotNull(message = "UIN cannot be empty") int uin,
			boolean luggage) {
		super();
		this.passengerName = passengerName;
		this.age = age;
		this.uin = uin;
		this.luggage = luggage;
	}

	public Passenger(int prn, @NotNull(message = "Name should not be empty") String passengerName,
			@NotNull(message = "Age cannot be empty") int age, @NotNull(message = "UIN cannot be empty") int uin,
			boolean luggage) {
		super();
		this.prn = prn;
		this.passengerName = passengerName;
		this.age = age;
		this.uin = uin;
		this.luggage = luggage;
	}
}
