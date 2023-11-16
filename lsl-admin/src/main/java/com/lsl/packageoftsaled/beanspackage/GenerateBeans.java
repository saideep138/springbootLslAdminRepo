package com.lsl.packageoftsaled.beanspackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lsl.packageoftsaled.service.WorkService;
import com.lsl.packageoftsaled.serviceImpl.WorkServiceImpl;

@Configuration
public class GenerateBeans {
	
	@Bean(name="badWork")
	protected WorkService generate() {
		WorkServiceImpl bean = new WorkServiceImpl();
		bean.var = "by Bad work";
		return bean;
	}

}
