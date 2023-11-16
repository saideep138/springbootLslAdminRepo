package com.lsl.packageoftsal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsal.service.HomePageService;

@Service
public class HomeServiceImpl implements HomePageService {

	@Override
	public List<HomeResponse> fetchResponse(String id) throws LSLException {
		// TODO Auto-generated method stub
		List<HomeResponse> response = new ArrayList<HomeResponse>();
		for(int i =0;i<3;i++) {
			HomeResponse res = new HomeResponse();
			res.setEmpid(100+i);
			res.setEmpName(i+"ABCD");
			response.add(res);
		}
		return response;
	}

}
