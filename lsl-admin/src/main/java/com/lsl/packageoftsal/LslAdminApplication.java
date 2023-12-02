package com.lsl.packageoftsal;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.JpaSort.Path;

import com.lsl.packageoftsal.controller.SampleController;

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
