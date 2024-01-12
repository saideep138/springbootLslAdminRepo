package com.lsl.packageoftsal.controller.Conceptual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.CustomerInfoRespository;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/paginationConcepts")
@EnableTransactionManagement
public class PaginationConceptsController {

	@Autowired
	CustomerInfoRespository customerInfoRespository;
	

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * 1.Pagination
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value="/fetch", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> fetch(
			@RequestHeader(name="headParam") String headerVar,
			@RequestBody HomeRequestBody request,
			HttpServletRequest hreq,
			HttpServletResponse hres) throws LSLException, Exception {
		
		LslResponse response = null;
		
		
		

		return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	}
}
