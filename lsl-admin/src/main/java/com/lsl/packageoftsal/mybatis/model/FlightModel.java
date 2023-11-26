package com.lsl.packageoftsal.mybatis.model;

public class FlightModel {
	private Long flightID;
	private String flightName;
	private Long capacity;
	public Long getFlightID() {
		return flightID;
	}
	public void setFlightID(Long flightID) {
		this.flightID = flightID;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public Long getCapacity() {
		return capacity;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	
}
