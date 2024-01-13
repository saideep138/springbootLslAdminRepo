package com.lsl.packageoftsal.controller.Conceptual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;
import com.lsl.packageoftsaled.pojo.TripResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/requestHandle")
public class ARestHandlingConceptController {
	

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	/*
	 * 1.Pagination
	 * 
	 * */
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
		
		
		
		
		ResponseEntity<LslResponse> response = null;
		LslResponse lslResponse = null;
		
		
		
		
		HttpHeaders headerMap = new HttpHeaders();
		headerMap.add("ResponseHeaderKey", "ResponseHeaderValue");
		headerMap.add("headParam", headerVar);
		
		
		try {
			lslResponse = new LslResponse(request, 200);
		}
		catch(Exception e) {
			log.info("Caught with exception");
		}
		
		
		
		
		
		response = new ResponseEntity<LslResponse>(lslResponse,headerMap,HttpStatus.OK);
		
		return response;
	}
}
