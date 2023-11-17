package com.lsl.packageoftsal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsal.service.HomePageService;
import com.lsl.packageoftsaled.pojo.LslResponse;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	HomePageService homePageService;
	
	@ResponseBody
	@RequestMapping(value="/fetch", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerInfoEntity> fetchDetails(@RequestHeader String header) throws LSLException {
//		List<CustomerInfoEntity> t = 
				return homePageService.fetchResponse(header);
//		LslResponse response = new LslResponse(t,200);
//		return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
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
