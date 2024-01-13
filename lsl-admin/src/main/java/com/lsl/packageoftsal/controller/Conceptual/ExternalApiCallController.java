package com.lsl.packageoftsal.controller.Conceptual;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/externalApiCall")
public class ExternalApiCallController {

	@ResponseBody
	@RequestMapping(value="/fetch", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> fetch(
			
			@RequestHeader(name="headParam") 
			String headerVar,
			
			@RequestBody 
			HomeRequestBody request,
			
			@RequestParam("requestParamJsonVar")
			String requestParamVar,
			
			String requestParam,//@RequestParam("requestParam") is not need as json and java has same name for varible
			
			HttpServletRequest hreq,
			
			HttpServletResponse hres
			)
			throws LSLException, Exception {
		
		
		
		//1. Response related stuff in-it
		ResponseEntity<LslResponse> response = null;
		LslResponse lslResponse = null;
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("ResponseHeaderKey", "ResponseHeaderValue");
		httpHeaders.add("Resent-headParam", headerVar);
		httpHeaders.add("Resent-requestParamJsonVar", requestParamVar);
		
		
		
		
		
		//2. Core Logic
		try {
			
			//A.url
			String url = "http://localhost:8080/v01/requestHandle/fetch";
			
//			String url = "http://localhost:8080/v01/requestHandle/fetch/{account}";
//			Map<String, String> uriParams = new HashMap<String, String>();
//		    uriParams.put("account", "my_account");
			
			
			UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
		                .queryParam("requestParamJsonVar", "ValueOfTheRequestParamJsonVar")
		                .queryParam("requestParam", "ValueOfTheRequestParam")
		                .queryParam("paramkeynameInPostMan", "paramValueInPostMan").build();
			 
			String finalUrl = builder.toString();
				
				
			//B.HttpEntity
			HttpHeaders restHttpHeaders = new HttpHeaders();
			restHttpHeaders.setContentType(MediaType.APPLICATION_JSON);
			restHttpHeaders.add("headParam", "HeaderValue");
			
			ObjectMapper ob = new ObjectMapper();
	        String jsonString = ob.writeValueAsString(request);
			
			HttpEntity<String> httpEntity = new HttpEntity<String>(jsonString, restHttpHeaders);
			
			
			//C.RestCall
			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<String> restResponse 
									= restTemplate.exchange(
										finalUrl, 
										HttpMethod.POST, 
										httpEntity, 
										String.class);
			
//			ResponseEntity<String> restResponse = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class, uriParams);

			
			
			//D.Process response
	        if (restResponse.getStatusCode() == HttpStatus.OK) {
	            
	        	lslResponse = ob.readValue(restResponse.getBody(),LslResponse.class);
	            	//jsonObject.read.readFor(restResponse.getBody());
	        	System.out.println(lslResponse);
//	        	
//	        	lslResponse = (LslResponse) lslResponse.getResponse();
	        }
		}
		catch(Exception e) {
			System.out.println();
		}
		
		
		
		
		
		response = new ResponseEntity<LslResponse>(lslResponse,httpHeaders,HttpStatus.OK);
		
		return response;
	}
}
