package com.lsl.packageoftsal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsal.service.HomePageService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	HomePageService homePageService;
	
	@ResponseBody
	@RequestMapping(value="/fetch", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<HomeResponse> fetchDetails(@RequestHeader String header) throws LSLException {
		List<HomeResponse> response = homePageService.fetchResponse(header);
		return response;
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
