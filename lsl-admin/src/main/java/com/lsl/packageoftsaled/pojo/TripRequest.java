package com.lsl.packageoftsaled.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TripRequest {
	private Long customerId;
	@JsonFormat(pattern="yyyy-MM-DD")
	private Date TravelDate;
	private Long flightID;
	private Long amount;
	private String payType;
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
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	

}