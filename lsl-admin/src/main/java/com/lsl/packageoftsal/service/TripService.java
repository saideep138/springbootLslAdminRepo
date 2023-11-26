package com.lsl.packageoftsal.service;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsaled.pojo.TripRequest;
import com.lsl.packageoftsaled.pojo.TripResponse;

public interface TripService {
	
	public TripResponse createTrip(TripRequest request) throws LSLException;

}
