package com.lsl.packageofdemotsal.collections.concurrency.map;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentLinkedQueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
		
		q.add(null);
		
		LinkedBlockingQueue<String> q2 = new LinkedBlockingQueue<String>();
		
		q2.add(null);

		//{@code false}
		// false
	}

}
