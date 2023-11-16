package com.lsl.packageoftsaled.service;

import java.util.List;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.model.response.HomeResponse;

public interface WorkService {
	List<HomeResponse> fetchResponse(String id) throws LSLException;
}
