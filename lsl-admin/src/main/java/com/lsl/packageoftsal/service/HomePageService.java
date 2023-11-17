package com.lsl.packageoftsal.service;


import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;

import java.util.List;

import com.lsl.packageoftsal.exceptionpack.LSLException;

public interface HomePageService {
	List<CustomerInfoEntity> fetchResponse(String id) throws LSLException;
}
