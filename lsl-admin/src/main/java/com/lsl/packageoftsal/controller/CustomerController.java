package com.lsl.packageoftsal.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsal.serviceImpl.CustomerServiceImpl;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/customer")
@EnableTransactionManagement
public class CustomerController {
	
	@Autowired
	@Qualifier("customerServiceBean")
	CustomerServiceImpl customerPageService;
	
	
	@ResponseBody
	@RequestMapping(value="/addWithTransaction", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> addDetail(@RequestHeader(name="headParam") String headerVar,
			@RequestBody HomeRequestBody request,
			HttpServletRequest hreq,
			HttpServletResponse hres) throws LSLException, Exception {
		LslResponse response = null;
		Logger log = LoggerFactory.getLogger(this.getClass());

			try {
			Long Cusid = customerPageService.addDetailWithTransaction(request);
			hres.addHeader("KeyGivenInJavaCode", "ValueGivenInJavaCode");
			
			List<String> resString = new ArrayList<>();
					
			resString.add("paramkeynameInPostMan="+hreq.getParameter("paramkeynameInPostMan"));
			
			resString.add(" header="+headerVar) ;
			
			resString.add("Your Customer id is " + Cusid);
			
			response = new LslResponse(resString,200);
			}catch(LSLException e) {
				log.info("Caught with exception");
				response = e.getLslResponse();
			}
			
			return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * The Below code is for Base API and Above code is for Experimental.
	 * */
	
	@ResponseBody
	@RequestMapping(value="/fetch", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerInfoEntity> fetchDetails(@RequestHeader String header) throws LSLException {
//		List<CustomerInfoEntity> t = 
				return customerPageService.fetchResponse(header);
//		LslResponse response = new LslResponse(t,200);
//		return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> addDetails(@RequestHeader(name="headParam") String headerVar,
			@RequestBody HomeRequestBody request,
			HttpServletRequest hreq,
			HttpServletResponse hres) throws LSLException {

			Long Cusid = customerPageService.addDetails(request);
			hres.addHeader("KeyGivenInJavaCode", "ValueGivenInJavaCode");
			
			List<String> resString = new ArrayList<>();
					
			resString.add("paramkeynameInPostMan="+hreq.getParameter("paramkeynameInPostMan"));
			
			resString.add(" header="+headerVar) ;
			
			resString.add("Your Customer id is " + Cusid);
			
			LslResponse response = new LslResponse(resString,200);
			
			return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> deleteDetails(@RequestHeader String header,
			@RequestBody HomeRequestBody request,
			HttpServletRequest hreq,
			HttpServletResponse hres) throws LSLException {
		
			customerPageService.addDetails(request);
			hres.addHeader("KeyGivenInJavaCode", "ValueGivenInJavaCode");
			LslResponse response = new LslResponse("param"+hreq.getParameter("paramkeynameInPostMan"),200);
			
			return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	
	}

	
	@ResponseBody
	@RequestMapping(value="/externaladd", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> externalAddDetails(@RequestHeader String header,
			@RequestBody HomeRequestBody request,
			HttpServletRequest hreq,
			HttpServletResponse hres) throws LSLException {
		
			customerPageService.externaladdDetails(request);
			
			hres.addHeader("KeyGivenInJavaCode", "ValueGivenInJavaCode");
			LslResponse response = new LslResponse("param"+hreq.getParameter("paramkeynameInPostMan"),200);
			
			return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/health", method=RequestMethod.GET)
	public HomeResponse healthCheck(@RequestHeader String header) {
		HomeResponse res = new HomeResponse();
		res.setEmpid(123);
		res.setEmpName("ABCD"+header);
		return res;
	}
}
