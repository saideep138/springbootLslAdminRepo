package com.lsl.packageoftsal.service;


import java.util.List;

import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;

public interface CustomerRetriveService {
	List<CustomerInfoEntity> fetchResponse(String id) throws LSLException;

	Object addDetails(HomeRequestBody request) throws LSLException, RestClientException, JsonProcessingException;
	boolean externaladdDetails(HomeRequestBody request) throws LSLException;
	
	boolean deleteDetails(HomeRequestBody request) throws LSLException;
}
