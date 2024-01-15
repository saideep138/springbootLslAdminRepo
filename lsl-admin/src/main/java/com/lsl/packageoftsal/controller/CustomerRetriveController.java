package com.lsl.packageoftsal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.service.CustomerRetriveService;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/customerRetrive")
public class CustomerRetriveController {
	
	@Autowired
	CustomerRetriveService customerRetriveService;
	
	@ResponseBody
	@RequestMapping(value="/fetch/{id}", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerInfoEntity> fetchDetails(@PathVariable(value="id") String idVar) throws LSLException {
		
		return customerRetriveService.fetchResponse(idVar);
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> addDetails(@RequestHeader(name="headParam") String headerVar,
			@RequestBody HomeRequestBody request,
			HttpServletRequest hreq,
			HttpServletResponse hres) throws LSLException, RestClientException, JsonProcessingException {

			Object restResponse = customerRetriveService.addDetails(request);
			hres.addHeader("KeyGivenInJavaCode", "ValueGivenInJavaCode");
			
			
			
			LslResponse response = new LslResponse(restResponse,200);
			
			return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	}
}
