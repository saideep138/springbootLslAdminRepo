package com.lsl.packageoftsal.serviceImpl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lsl.packageoftsal.exceptionpack.LSLException;
import com.lsl.packageoftsal.hiberanatepack.entities.TripEntity;
import com.lsl.packageoftsal.hiberanatepack.repositoeries.TripRepository;
import com.lsl.packageoftsal.service.PaymentService;
import com.lsl.packageoftsal.service.SampleService;
import com.lsl.packageoftsal.service.TripService;
import com.lsl.packageoftsaled.beanspackage.GenerateBeans;
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
	
	@Autowired//to use Autowire when checking this ensure @Component/Service is removed for PaymentService
	PaymentService paymentServiceFromXmlBean;
	

	@Transactional(rollbackForClassName="LSLException")
	@Override
	public TripResponse createTrip(TripRequest request) throws LSLException {
		
		Long payid ;
		
		//payid = paymentService.makePayment(request);
		payid = paymentServiceFromXmlBean.makePayment(request);
		
		
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
		
		learn();
		
		return response;

	}
	
	public void learn() {
		BeanFactory beanFactory = new AnnotationConfigApplicationContext(GenerateBeans.class);
		SampleService sampleServiceAppContextBean1 = beanFactory.getBean("sampleServiceAppContextBean",SampleService.class);
	
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beanconfigfold/beanConfig.xml"});
		SampleService sampleServiceAppContextBean2 = context.getBean("sampleServiceFromXmlBean",SampleService.class);
		
	}
	
	public void init() throws Exception
    {
        System.out.println(
            "Bean HelloWorld has been "
            + "instantiated and I'm "
            + "the init() method");
    }
 
    // This method executes
    // when the spring container
    // is closed
    public void destroy() throws Exception
    {
        System.out.println(
            "Container has been closed "
            + "and I'm the destroy() method");
    }

}
/*
	private Long customerId;
	private Date TravelDate;
	private Long flightID;
	private Long amount;
*/