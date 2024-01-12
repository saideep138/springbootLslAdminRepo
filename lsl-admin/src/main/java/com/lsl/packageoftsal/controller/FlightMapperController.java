package com.lsl.packageoftsal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.mybatis.mapper.FlightMapper;
import com.lsl.packageoftsal.mybatis.model.FlightModel;
import com.lsl.packageoftsal.mybatis.xmlmapper.FlightXmlMapper;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/flight")
public class FlightMapperController {
	
	@Autowired
	FlightXmlMapper flightXmlMapper;
	
	@Autowired
	FlightMapper flightMapper;

	@ResponseBody
	@RequestMapping(value="/add", 
			method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<LslResponse> addFlight(
			@RequestHeader(name="headParam") String headerVar,
			@RequestBody FlightModel request,
			HttpServletRequest hreq,
			HttpServletResponse hres
			) throws LSLException{
		ResponseEntity<LslResponse> response = null;
		
//		flightXmlMapper.inserted(request);
		Long k = flightMapper.getSequenceNumber();
		request.setFlightId(k);
		flightMapper.updateSequence(k, k+1);
		response = new ResponseEntity<LslResponse>(new LslResponse(flightMapper.insert(request),200),null,HttpStatus.OK);
		
		
		return response;
	}
	
}
