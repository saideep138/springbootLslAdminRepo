package com.lsl.packageofdemotsal.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> mp = new HashMap<String,String>();
		
		mp.put(null, null);
//		mp.remove(null);
	}
	
	public static void main2(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentHashMap<String,String> mp = new ConcurrentHashMap<String,String>();
		
		mp.put(null, null);
		mp.get(null);
//		mp.remove(null);
	}
	public static void main3(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String,String> mp = new LinkedHashMap<String,String>();
		
		mp.put(null, null);
//		mp.remove
//		mp.remove(null);
	}
}
