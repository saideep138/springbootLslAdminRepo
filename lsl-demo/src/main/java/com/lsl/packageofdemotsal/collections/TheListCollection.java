package com.lsl.packageofdemotsal.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class TheListCollection {
	
	public static void main(String[] args) throws Exception{
		
		
		
		List<Integer> al = Arrays.asList(12,23,34,45,65,70);
		
		List<Integer> k = al.stream().filter(x->{
			System.out.println(">"+x);
			return x%5==0;
		}).map(x -> {
			System.out.println(">>"+x);
			return x*2;
		}).collect(Collectors.toList());
		
		k.forEach(x->{
			System.out.println(">>>"+x);
			});
		
//		ArrayList<Integer> al = 
		
		System.out.println("ans="+0);
	}
	
	void show() {
		Collections c ;
//		
//		CopyOnWriteArrayList cc;	
//		
//		Collections.SynchronizedMap<> hp;
//		
//		ConcurrentHashMap<> nl;
//		
//		HashMap<> nlp;
//		
//		Hashtable ht;
		
//	cc.listIterator();
	}
}
