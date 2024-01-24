package com.lsl.zpackageoftsal.zconcepts.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;
import com.lsl.packageoftsaled.pojo.LslResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/jpaConceptsController")
public class JpaConceptsController {
	
	@Autowired
	StudentRespository studentRespository;
	
	@RequestMapping(value="/jpatable", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LslResponse> solve(
			@RequestBody HomeRequestBody request,
//			@RequestParam String param,
//			@RequestHeader String head,
			HttpServletRequest rq,
			HttpServletResponse rs
			){
		
		LslResponse response ;
		
		String head ="";
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.add(head+"key", "val"+head);
		
		List<Student> ls = (List<Student>) studentRespository.findAll();
		List<String> ls1 = new ArrayList<String>();
		
		for(Student s : ls)
		ls1.add(s.studentname);

		List<Student> ls2 = new ArrayList<Student>();
		
		for(Student s : ls)
		ls2.add(s);
		
		response = new LslResponse(ls2,200);
		
		
		return new ResponseEntity<LslResponse>(response, httpHeaders, HttpStatus.OK);
	}
	
}
