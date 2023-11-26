package com.lsl.packageoftsaled.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripResponse {
	@JsonProperty("customer Id")
	private Long customerId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date travelDate;
	
	@JsonProperty("flight ID")
	private Long flightID;
	
	@JsonProperty
	private Long payId;
	
	@JsonProperty("tripId")
	private Long tripId;
	
	public TripResponse(Long tripId,Long customerId, Date travelDate, Long flightID, Long payId) {
		super();
		this.customerId = customerId;
		this.travelDate = travelDate;
		this.flightID = flightID;
		this.payId = payId;
		this.tripId = tripId;
	}
	@Override
	public String toString() {
		return "TripResponse [customerId=" + customerId + ", travelDate=" + travelDate + ", flightID=" + flightID
				+ ", payId=" + payId + ", tripId=" + tripId + "]";
	}
	
	
}
