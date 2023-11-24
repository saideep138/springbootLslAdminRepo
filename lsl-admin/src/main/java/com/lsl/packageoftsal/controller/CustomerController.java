package com.lsl.packageoftsal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsal.service.CustomerPageService;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	@Qualifier("customerServiceBean")
	CustomerPageService customerPageService;
	
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

			customerPageService.addDetails(request);
			hres.addHeader("KeyGivenInJavaCode", "ValueGivenInJavaCode");
			
			List<String> resString = new ArrayList<>();
					
			resString.add("paramkeynameInPostMan="+hreq.getParameter("paramkeynameInPostMan"));
			
			resString.add(" header="+headerVar) ;
			
			
			
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
