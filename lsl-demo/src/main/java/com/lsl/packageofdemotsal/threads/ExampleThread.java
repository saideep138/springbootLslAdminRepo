package com.lsl.packageofdemotsal.threads;

import java.util.concurrent.Callable;

public class ExampleThread implements Runnable, Callable<String>{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Run method executed");
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("call method executed");
		return "message from future task, YES returned";
	}

}
