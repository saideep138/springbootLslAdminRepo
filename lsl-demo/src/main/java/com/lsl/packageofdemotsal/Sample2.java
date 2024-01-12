package com.lsl.packageofdemotsal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Sample2 {
	
	public static void main1(String[] argv) {
		PriorityQueue<Integer> room = new PriorityQueue<Integer>();

		room.add(1);
		room.add(10);
		room.add(5);
		
		Iterator<Integer> itr = room.iterator();
		
		while(itr.hasNext()) {
			int i = itr.next();
			System.out.print(i);
		}
		
	}
	
	public static void main(String[] argv) {
		java.lang.OutOfMemoryError l;
		
//		Arrays.asList(null);
		
		try {
			HashMap<String,String> mp = new HashMap<String,String>();
			
			mp.put(null, null);
			
		}
		catch(Error e) {
			
		}
		System.out.print("done..!");
	}
}

