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
import com.lsl.packageoftsaled.pojo.HomeRequestBody;

@Service
public class HomeServiceImpl implements HomePageService {
	
	@Autowired
	CustomerInfoRespository customerInfoRespository;

	@Override
	public List<CustomerInfoEntity> fetchResponse(String id) throws LSLException {
		return (List<CustomerInfoEntity>)
					customerInfoRespository.findAll();		
	}
	
	@Override
	public boolean addDetails(HomeRequestBody request) throws LSLException{
		CustomerInfoEntity cus = new CustomerInfoEntity(request.getId(), request.getName());
		customerInfoRespository.save(cus);
		return true;
	}
	
	@Override
	public boolean deleteDetails(HomeRequestBody request) throws LSLException{
		customerInfoRespository.deleteById(request.getId());
		return true;
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
