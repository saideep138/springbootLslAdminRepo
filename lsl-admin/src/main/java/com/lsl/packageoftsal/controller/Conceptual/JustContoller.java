package com.lsl.packageoftsal.controller.Conceptual;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/justController")
public class JustContoller {
	
	@RequestMapping(value="/justMethod", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> justMethod(
			@RequestHeader String headVar,
			@RequestParam String paramVar,
			@RequestBody HomeRequestBody request,
			HttpServletRequest req,
			HttpServletResponse res
			){
		File f = new File("");
		
		
		return new ResponseEntity<LslResponse>(null,null,HttpStatus.OK);
	}

}
