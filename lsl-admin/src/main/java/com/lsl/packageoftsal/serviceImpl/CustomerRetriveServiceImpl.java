package com.lsl.packageoftsal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.CustomerInfoRespository;
import com.lsl.packageoftsal.service.CustomerRetriveService;
import com.lsl.packageoftsaled.pojo.HomeRequestBody;

@Service
public class CustomerRetriveServiceImpl implements CustomerRetriveService {
	
	@Autowired
	CustomerInfoRespository customerInfoRespository;

	@Override
	public List<CustomerInfoEntity> fetchResponse(String id) throws LSLException {
		int idnum = Integer.parseInt(id);
		return (List<CustomerInfoEntity>)
					customerInfoRespository.findById(idnum, idnum+70);		
	}

	@Override
	public boolean addDetails(HomeRequestBody request) throws LSLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean externaladdDetails(HomeRequestBody request) throws LSLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDetails(HomeRequestBody request) throws LSLException {
		// TODO Auto-generated method stub
		return false;
	}

}
