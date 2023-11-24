package com.lsl.packageoftsal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.service.CustomerRetriveService;

@RestController
@RequestMapping("/customerRetrive")
public class CustomerRetriveController {
	
	@Autowired
	CustomerRetriveService customerRetriveService;
	
	@ResponseBody
	@RequestMapping(value="/fetch/{id}", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerInfoEntity> fetchDetails(@PathVariable String id) throws LSLException {
		
		return customerRetriveService.fetchResponse(id);
	}
	
}
