package com.lsl.packageoftsal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.PaymentEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.PaymentRepository;
import com.lsl.packageoftsaled.pojo.TripRequest;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository; 
	
	public Long makePayment(TripRequest tripRequest) throws LSLException {
		
		if(tripRequest.getAmount()<500) {
			throw new LSLException(301,"Payment must be more than 500");
		}
		
		PaymentEntity p = paymentRepository.save(new PaymentEntity(tripRequest.getAmount(),tripRequest.getPayType()));
		
		return p.getPayid();
	}
}
