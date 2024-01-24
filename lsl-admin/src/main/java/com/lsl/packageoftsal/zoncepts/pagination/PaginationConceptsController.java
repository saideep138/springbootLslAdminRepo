package com.lsl.packageoftsal.zoncepts.pagination;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.CustomerInfoRespository;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/paginationConcepts")
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
			@RequestHeader(name="headParam") 
			String headerVar,
			@RequestBody 
			HomeRequestBody request,
			@RequestParam("requestParamJsonVar")
			String requestParamVar,
			String requestParam,//@RequestParam("requestParam") is not need as json and java has same name for varible
			HttpServletRequest hreq,
			HttpServletResponse hres) throws LSLException, Exception {
		
		LslResponse response = null;
		
		
		
		
		
        response = new LslResponse(solveA(), 200);
        
		

		return new ResponseEntity<LslResponse>(response, HttpStatus.OK);
	}
	
	
	Object solveA() {
		// First page with 5 items
        Pageable pageble = PageRequest.of(
            0, 5, Sort.by("customerName").ascending());
        Page<CustomerInfoEntity> page = customerInfoRespository.findAll(pageble);
        
        return page.getContent();
	}
	
	Object solveB() {
		// Just sort by column

        List<CustomerInfoEntity> list = customerInfoRespository.findAll(Sort.by("mobileNo"));
        
        return list;
	}
}
