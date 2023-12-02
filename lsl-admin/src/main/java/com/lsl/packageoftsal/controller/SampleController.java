package com.lsl.packageoftsal.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class SampleController {
	
	@Value("${spring.datasource.url}")
	String userBucketPath;
	
	public String show() {
		System.out.print("="+userBucketPath);
		return userBucketPath;
	}
}
