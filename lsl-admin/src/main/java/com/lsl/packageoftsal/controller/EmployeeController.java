package com.lsl.packageoftsal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.mybatis.mapper.EmployeeMapper;
import com.lsl.packageoftsal.mybatis.model.EmployeeModel;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> addDetails(@RequestHeader(name="headParam") String headerVar,
			@RequestBody EmployeeModel request,
			HttpServletRequest hreq,
			HttpServletResponse hres) throws LSLException {
			
			LslResponse response  = null;
		
			try {
				int k = employeeMapper.insert(request);
				logger.info("Inserted provided employee data into employee table");
				response = new LslResponse(k,200);
			}
			catch(Exception e) {
				response = new LslResponse(e,200);
			}
			
			return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	}
}
