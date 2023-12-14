package com.lsl.packageoftsal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.CustomerInfoRespository;
import com.lsl.packageoftsal.service.CustomerRetriveService;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

@Service
public class CustomerRetriveServiceImpl implements CustomerRetriveService {
	
	@Autowired
	CustomerInfoRespository customerInfoRespository;

	@Override
	public List<CustomerInfoEntity> fetchResponse(String id) throws LSLException {
		int idnum = Integer.parseInt(id);
		return (List<CustomerInfoEntity>)
					customerInfoRespository.findById(idnum, idnum+70);		
	}

	@Override
	public Object addDetails(HomeRequestBody request) throws LSLException, RestClientException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/customer/add";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("headParam", "The RestExchange headParam");

        
        ObjectMapper ob = new ObjectMapper();
        String jsonString = ob.writeValueAsString(request);
        
        HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);
		
        ResponseEntity<String> restResponse = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        LslResponse jsonObject = null;
        if (restResponse.getStatusCode() == HttpStatus.OK) {
            
        	jsonObject = ob.readValue(restResponse.getBody(),LslResponse.class);
            	//jsonObject.read.readFor(restResponse.getBody());
        	
            
        }
        //LslResponse lslResponse = (LslResponse) restResponse.getBody();
        
        //System.out.print(lslResponse.getResponse());
        
		return jsonObject.getResponse();
	}

	@Override
	public boolean externaladdDetails(HomeRequestBody request) throws LSLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDetails(HomeRequestBody request) throws LSLException {
		// TODO Auto-generated method stub
		return false;
	}

}
