package com.lsl.packageoftsal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.TripEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.TripRepository;
import com.lsl.packageoftsal.service.PaymentService;
import com.lsl.packageoftsal.service.TripService;
import com.lsl.packageoftsaled.pojo.TripRequest;
import com.lsl.packageoftsaled.pojo.TripResponse;


@Primary
@Service
@Order(1)
public class TripServiceImpl implements TripService {
	

	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	PaymentService paymentService;
	
	// OR
	/*
	PaymentService varPaymentServiceFromXmlBean;

	public void setVarPaymentServiceFromXmlBean(PaymentService varPaymentServiceFromXmlBean) {
		this.varPaymentServiceFromXmlBean = varPaymentServiceFromXmlBean;
	}
	*/
	

	@Transactional(rollbackForClassName="LSLException")
	@Override
	public TripResponse createTrip(TripRequest request) throws LSLException {
		
		Long payid = paymentService.makePayment(request);
		//varPaymentServiceFromXmlBean.makePayment(request);
		
		if(request.getAmount()<600) {
			throw new LSLException(301,"Payment must be more than 600");
		}
		
		TripEntity tripEntity = new TripEntity(request.getCustomerId(), 
				request.getTravelDate(), request.getFlightID(), payid);
				
		
		tripEntity = tripRepository.save(tripEntity);
		
		
		
		TripResponse response = new TripResponse(tripEntity.getTripid(), request.getCustomerId(), 
				request.getTravelDate(), request.getFlightID(), payid) ;
		
		String k = response.toString()+" \n"+tripEntity.toString();
		
		System.out.println(k);
		
		return response;

	}

}
/*
	private Long customerId;
	private Date TravelDate;
	private Long flightID;
	private Long amount;
*/