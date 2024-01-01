package com.lsl.packageofdemotsal.threads;

import java.lang.Thread.State;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadSample {
	
	ThreadSample(){
		System.out.print("In constructor ThreadSample");
	}
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		
		main2();
		
	}

	
	public static void main1() throws ExecutionException, InterruptedException {
		
		System.out.println("using implementation of Runnable class");
		
		ExampleThread eth = new ExampleThread();
		
		Thread th = new Thread(eth);
		th.start();
		
		while(th.getState()!=State.TERMINATED) {
			th.sleep(2);
			System.out.println("			while loop");
		}
		System.out.println("			outside loop \n = th thread state = "+th.getState());
		
		
		//th.start(); gives Illegal exception state exeption
		if(th == Thread.currentThread()) {
			System.out.println("	Same th thread ");
		}
		else {
			System.out.println(""+Thread.currentThread());
		}
	}
	
	public static void main2() throws ExecutionException, InterruptedException {
		System.out.println("=========main2 ========");
		Callable<String> callThread = new ExampleThread();
		
		
		int a = 1;

		
		
		if(a==1){
			
			FutureTask<String> futuretask = new FutureTask<String>(callThread);
			Thread th = new Thread(futuretask);
			
			th.start();
			System.out.println(futuretask.get());
		}
		else if(a==2){
			
			ExecutorService executorService = Executors.newCachedThreadPool();
			Future<String> future = executorService.submit(callThread);
			
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		
		
		
	}
}
