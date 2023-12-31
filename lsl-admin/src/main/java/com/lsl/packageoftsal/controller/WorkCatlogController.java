package com.lsl.packageoftsal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsl.packageoftsal.exceptionpack.LSLChildException;
import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsaled.service.WorkService;

import fom.lvl.FomSample;

@Controller
@RequestMapping("/work")
public class WorkCatlogController {

	
	FomSample fomSample;
	
	@Qualifier(value="badWork")
	@Autowired
	WorkService workService;
	
	@ResponseBody
	@RequestMapping(value="/fetch", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<HomeResponse> fetchDetails(@RequestHeader String header
//			,
//			HttpRequest req,
//			HttpResponse res
			) throws LSLChildException {
		List<HomeResponse> response=null;
		try {
			response = workService.fetchResponse(header);
		} catch (LSLException e) {
			// TODO Auto-generated catch block
		}
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
