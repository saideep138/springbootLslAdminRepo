package com.lsl.packageoftsal.service;


import java.util.List;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;

public interface HomePageService {
	List<CustomerInfoEntity> fetchResponse(String id) throws LSLException;

	boolean addDetails(HomeRequestBody request) throws LSLException;
	
	boolean deleteDetails(HomeRequestBody request) throws LSLException;
}
