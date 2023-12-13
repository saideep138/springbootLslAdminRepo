package com.lsl.packageofdemotsal.threads;

import java.util.concurrent.ExecutionException;

import com.lsl.packageofdemotsal.javapack.BlockInitParent;

public class SynchExample {
	
	Object lock = new BlockInitParent();
	static Object statlock = new BlockInitParent();
	
	SynchExample(){
		
	}
	
	void objectSynchMethod() {
		
		//
		synchronized(this) {
			//
		}
		
		//
		synchronized(lock) {
			//
		}
		
	}
	
	void classSynchMethodA() {
		//
		synchronized(SynchExample.class) {
			//
		}
		
		//
		synchronized(statlock) {
			//
		}
		
		//
		synchronized(BlockInitParent.class) {
			//
		}
	}
	
	void classSynchMethodB() {
		//
		synchronized(BlockInitParent.class) {
			//
		}
		
		//
		synchronized(statlock) {
			//
		}
		
		//
		synchronized(SynchExample.class) {
			//
		}
	}
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SynchExample v = new SynchExample();
		
	}
}
