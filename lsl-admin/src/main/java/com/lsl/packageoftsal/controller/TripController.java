package com.lsl.packageoftsal.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.service.TripService;
import com.lsl.packageoftsaled.pojo.LslResponse;
import com.lsl.packageoftsaled.pojo.TripRequest;
import com.lsl.packageoftsaled.pojo.TripResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/trip")
@RestController
@EnableTransactionManagement
public class TripController {
	
	@Autowired
	TripService tripService;

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value="/create",consumes="application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> createTrip(@RequestHeader String header,
			@RequestBody TripRequest request,
			HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) throws LSLException{
		
		ResponseEntity<LslResponse> response = null;
		LslResponse lslResponse = null;
		
		try {
			TripResponse tresponse = tripService.createTrip(request);

			System.out.println(tresponse);
			lslResponse = new LslResponse(tresponse, 200);
		}
		catch(LSLException e) {
			lslResponse = new LslResponse(e,200);
		}
		
//		LslResponse lslResponse = new LslResponse();
		response = new ResponseEntity<LslResponse>(lslResponse,HttpStatus.OK);
		
		return response;
	}
	
}
