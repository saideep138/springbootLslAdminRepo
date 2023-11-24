package com.lsl.packageoftsal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan(basePackages={"com.lsl.packageoftsal","com.lsl.packageoftsaled"})

//@SpringBootApplication(scanBasePackages={"com.lsl.packageoftsal","com.lsl.packageoftsaled.serviceImpl"})
public class LslAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(LslAdminApplication.class, args);
		System.out.print("Inside Main mathod");
	}

}