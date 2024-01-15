package com.lsl.packageoftsal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages={"com.lsl.packageoftsal","com.lsl.packageoftsaled.serviceImpl"})

@EnableAutoConfiguration
@ComponentScan(basePackages={"com.lsl.packageoftsal","com.lsl.packageoftsaled"})

@MapperScan({"com.lsl.packageoftsal.mybatis.xmlmapper","com.lsl.packageoftsal.mybatis.mapper"})
public class LslAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(LslAdminApplication.class, args);
		
		System.out.print("Inside Main mathod");
		
	}

}
