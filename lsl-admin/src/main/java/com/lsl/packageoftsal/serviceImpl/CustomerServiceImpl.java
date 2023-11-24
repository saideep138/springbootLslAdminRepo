package com.lsl.packageoftsal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
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

	@Override
	public boolean externaladdDetails(HomeRequestBody request) throws LSLException {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		
		String url = "localhost:8080/home/add";
		
		//rt.exchange(url,  HttpMethod.POST, null, null);
		return false;
	}

}
