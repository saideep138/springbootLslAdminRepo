package com.lsl.zpackageoftsal.zconcepts.async;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/async")
public class AsynchExampleController {
	
	@Autowired
	AsyncService asyncService;

	
	@RequestMapping(value="/asyncMethod", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> asyncMethod(
		@RequestBody 
		HomeRequestBody request,

//		@RequestHeader
//		String head,
//		
//		@RequestParam
//		String param,
//		
		HttpServletRequest httReq,
		
		HttpServletResponse httpRes
			){
		
		
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		httpHeader.add("headName", "HeadValue");
		
		CompletableFuture<String> cf = asyncService.performAsyncTask();
		
		LslResponse lslResponse = new LslResponse(cf,200);

		System.out.println("returned ResponseEntity");
		
		return new ResponseEntity<LslResponse>(lslResponse, httpHeader, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/nonasyncMethod", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> nonAsyncMethod(
		@RequestBody 
		HomeRequestBody request,

//		@RequestHeader
//		String head,
//		
//		@RequestParam
//		String param,
//		
		HttpServletRequest httReq,
		
		HttpServletResponse httpRes
			){
		
		
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		httpHeader.add("headName", "HeadValue");
		
		localPerformAsyncNulTask();
		
		LslResponse lslResponse = new LslResponse("response sent",200);

		System.out.println("returned ResponseEntity");
		
		return new ResponseEntity<LslResponse>(lslResponse, httpHeader, HttpStatus.OK);
	}
	
	@Async
    public void localPerformAsyncNulTask() {
        // Simulate a time-consuming task
        try {
        	for(int i =0 ; i<5 ; i++) {
        		Thread.sleep(5000); // Sleep for 5 seconds
        		System.out.println("Processing Local Async task");
        	}
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Local Async task completed!");
    }
	
}
