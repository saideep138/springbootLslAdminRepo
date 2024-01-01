package com.lsl.packageoftsal.hiberanatepack.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tripinfo")
public class TripEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="trip_id")
	private Long tripid;
	
	@Column(name="cusid")
	private Long customerId;
	
	@Column(name="TravelDate")
	private Date TravelDate;
	
	@Column(name="flightID")
	private Long flightID;
	
	@Column(name="payid")
	private Long payid;
	
//	@ManyToOne
//	private CustomerInfoEntity customerInfoEntity;

	public Long getTripid() {
		return tripid;
	}

	public void setTripid(Long tripid) {
		this.tripid = tripid;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getTravelDate() {
		return TravelDate;
	}

	public void setTravelDate(Date travelDate) {
		TravelDate = travelDate;
	}

	public Long getFlightID() {
		return flightID;
	}

	public void setFlightID(Long flightID) {
		this.flightID = flightID;
	}

	public Long getPayid() {
		return payid;
	}

	public void setPayid(Long payid) {
		this.payid = payid;
	}

	public TripEntity(Long customerId, Date travelDate, Long flightID, Long payid) {
		super();
		this.customerId = customerId;
		TravelDate = travelDate;
		this.flightID = flightID;
		this.payid = payid;
	}

	@Override
	public String toString() {
		return "TripEntity [tripid=" + tripid + ", customerId=" + customerId + ", TravelDate=" + TravelDate
				+ ", flightID=" + flightID + ", payid=" + payid + "]";
	}
	
}
