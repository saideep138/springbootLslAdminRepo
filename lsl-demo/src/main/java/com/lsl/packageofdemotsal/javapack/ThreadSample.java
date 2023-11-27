package com.lsl.packageofdemotsal.javapack;

import java.lang.Thread.State;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadSample {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExampleThread eth = new ExampleThread();
		
		Thread th = new Thread(eth);
		th.start();
		
		while(th.getState()!=State.TERMINATED) {
			System.out.print("while loop");
		}
		System.out.println("outside loop \n ========");
		
		main2();
//		th.start();
	}
	
	public static void main2() throws ExecutionException, InterruptedException {
		System.out.println("=========main2 ========");
		Callable<String> eth = new ExampleThread();
		
		
		int a = 2;

		
		
		if(a==2){
			FutureTask futuretask = new FutureTask(eth);
			Thread th = new Thread(futuretask);
			th.start();
						System.out.println(futuretask.get());
					
		}
		else {
			ExecutorService executorService = Executors.newCachedThreadPool();
			Future<String> future = executorService.submit(eth);
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		
		
		
	}
}
