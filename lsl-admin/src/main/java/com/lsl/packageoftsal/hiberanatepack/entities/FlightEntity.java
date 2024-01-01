package com.lsl.packageoftsal.hiberanatepack.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="flight")
public class FlightEntity {
	
	@Id
	@GenericGenerator(name="incgenerator" , strategy="increment")
	@GeneratedValue(generator="incgenerator")
	@Column(name = "flightID", unique = true, nullable = false)
//	@Column(name="flightID")
	private Long flightId;
	
	@Column(name="flightName")
	private String flightName;
	
	@Column(name="capacity")
	private long capacity;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public FlightEntity(String flightName, long capacity) {
		super();
		this.flightName = flightName;
		this.capacity = capacity;
	}
	
	public FlightEntity() {
		super();
	}

	@Override
	public String toString() {
		return "FlightEntity [flightId=" + flightId + ", flightName=" + flightName + ", capacity=" + capacity + "]";
	}

}