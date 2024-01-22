package com.lsl.packageoftsal.controller.Conceptual.async;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	 	
	@Async
    public void performAsyncNullTask() {
	        // Simulate a time-consuming task
	        try {
	        for(int i = 0 ; i<3 ; i++) {
	            Thread.sleep(5000); // Sleep for 5 seconds
	            System.out.println("processing task!");
	        }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	        System.out.println("Async task completed!");
	}
	
	@Async
    public CompletableFuture<String> performAsyncTask() {
        // Simulate a time-consuming task
        try {
        	for(int i = 0 ; i<3 ; i++){
	            Thread.sleep(5000); // Sleep for 5 seconds
	            System.out.println("processing task!");
	        }
        	System.out.println("Async task completed!");
            return CompletableFuture.completedFuture("Async task completed!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture("Async task failed to complete!");
    }
}
