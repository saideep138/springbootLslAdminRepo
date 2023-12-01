package com.lsl.packageofdemotsal;

import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

public class ClassExample {
	
	
	
	
	FileOutputStream l;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		LinkedHashMap<Integer,Integer> ll = new LinkedHashMap<>();
		ll.getOrDefault(0, 0);
		System.out.println("HI");
		
		Class c = Class.forName("com.lsl.packageofdemotsal.ThreadSample");
		c.newInstance();
		
		
//		Class[] t = { com.lsl.packageofdemotsal.ThreadSampled.class };  
//		Constructor con = c.getConstructor();
//		
//		
//		ThreadSampled obj = new ThreadSampled("Hello main");
//
//		Object[] objct = { obj};  
//		con.newInstance(objct);
		

		Constructor[] cons = c.getConstructors();
		
		
		//Class.forName(null, false, null);
		
		
	}

}
