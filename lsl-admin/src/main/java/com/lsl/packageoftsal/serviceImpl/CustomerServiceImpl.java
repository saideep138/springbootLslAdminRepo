package com.lsl.packageoftsal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.CustomerInfoRespository;
import com.lsl.packageoftsal.model.response.HomeResponse;
import com.lsl.packageoftsal.service.CustomerPageService;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;

//@Scope(value="prototype") // for prototype will created only when asked for this bean

@Service(value="customerServiceBean")
public class CustomerServiceImpl implements CustomerPageService {
	
	@Autowired
	CustomerInfoRespository customerInfoRespository;
	

	@Transactional(rollbackForClassName="LSLException")
	public Long addDetailWithTransaction(HomeRequestBody request) throws LSLException, Exception{
		CustomerInfoEntity cus = new CustomerInfoEntity(request.getName(),
				request.getAge(),request.getGender(),request.getMobileNo());
		customerInfoRespository.save(cus);
		if(cus.getCustomerName().startsWith("del"))
			throw new LSLException(301,"Customer Name is started with del");;
		if(cus.getCustomerName().startsWith("detl"))
			throw new Exception("Customer Name is started with dell");;
	
		return cus.getId();
	}
	
	public List<CustomerInfoEntity> fetchResponseWithTransaction(String id) throws LSLException {
		return (List<CustomerInfoEntity>)
					customerInfoRespository.findAll();		
	}
	
	
	/*
	 * The Below code is for Base API and Above code is for Experimental.
	 * */

	@Override
	public List<CustomerInfoEntity> fetchResponse(String id) throws LSLException {
		return (List<CustomerInfoEntity>)
					customerInfoRespository.findAll();		
	}
	
	@Override
	public Long addDetails(HomeRequestBody request) throws LSLException{
		CustomerInfoEntity cus = new CustomerInfoEntity(request.getName(),
				request.getAge(),request.getGender(),request.getMobileNo());
		customerInfoRespository.saveAndFlush(cus);//This will link the Object in java to Table Row
		cus.setCustomerName(cus.getCustomerName()+"okok");
		customerInfoRespository.save(cus);//This will still point to same row in DB.
		return cus.getId();
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

	@Override
	public boolean externaladdDetails(HomeRequestBody request) throws LSLException {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		
		String url = "localhost:8080/home/add";
		
		//rt.exchange(url,  HttpMethod.POST, null, null);
		return false;
	}

}
