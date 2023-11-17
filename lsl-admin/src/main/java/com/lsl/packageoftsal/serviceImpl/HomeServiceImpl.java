package com.lsl.packageoftsal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.CustomerInfoRespository;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsal.service.HomePageService;

@Service
public class HomeServiceImpl implements HomePageService {
	
	@Autowired
	CustomerInfoRespository customerInfoRespository;

	@Override
	public List<CustomerInfoEntity> fetchResponse(String id) throws LSLException {
		return (List<CustomerInfoEntity>)
					customerInfoRespository.findAll();		
	}
	
	public List<HomeResponse> fetchResponse2(String id) throws LSLException {
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
