package com.lsl.packageoftsal.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.FlightEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.FlightRepository;
import com.lsl.packageoftsal.mybatis.mapper.FlightMapper;
import com.lsl.packageoftsal.mybatis.model.FlightModel;
import com.lsl.packageoftsaled.pojo.LslResponse;

@Controller
@RequestMapping("/hiberFlight")
public class FlightHiberController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	FlightMapper flightMapper;

	@ResponseBody
	@RequestMapping(value="/add", 
			method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<LslResponse> addFlight(
			@RequestBody FlightModel request
			) throws LSLException{
//		ResponseEntity<LslResponse> response = null;
		
//		flightXmlMapper.inserted(request);
//		response = new ResponseEntity<LslResponse>(new LslResponse(flightMapper.insert(request),200),null,HttpStatus.OK);
		
		FlightEntity entity = new FlightEntity(request.getFlightName(), request.getCapacity());
		FlightEntity row = flightRepository.save(entity);
		
		
		LslResponse response = new LslResponse(row,200);
		return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/update", 
			method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<LslResponse> updateFlight(
			@RequestBody FlightModel request
			) throws LSLException{
		
		Optional<FlightEntity> optEntity = flightRepository.findById(request.getFlightId());
		FlightEntity entity = optEntity.get();
		
		entity.setCapacity(request.getCapacity());
		entity.setFlightName(request.getFlightName());
		
		log.info("The "+entity.toString());
		
		FlightEntity row = flightRepository.save(entity);
		
		log.info(""+entity.toString());
		
		
		LslResponse response = new LslResponse(row,200);
		return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
		
	}
	
}
