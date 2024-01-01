package com.lsl.packageofdemotsal.collections.concurrency.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronisedHashMapExample {
	 public static void main(String[] args) {
			// TODO Auto-generated method stub

		 HashMap<String,String> mp = new HashMap<>();
		 
		 Map<String, String> synchedmp = Collections.synchronizedMap(mp);
		 
		 synchedmp.put(null, null);
		 
		}
}
