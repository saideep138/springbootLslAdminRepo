package com.lsl.packageoftsaled.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsaled.service.WorkService;

@Service(value="goodWork")
public class WorkServiceImpl implements WorkService {
	
	public String var = null;

	@Override
	public List<HomeResponse> fetchResponse(String id) throws LSLException {
		// TODO Auto-generated method stub
		List<HomeResponse> response = new ArrayList<HomeResponse>();
		for(int i =0;i<3;i++) {
			HomeResponse res = new HomeResponse();
			res.setEmpid(100+i);
			res.setEmpName(i+"ABCD from"+var);
			response.add(res);
		}
		return response;
	}

}
