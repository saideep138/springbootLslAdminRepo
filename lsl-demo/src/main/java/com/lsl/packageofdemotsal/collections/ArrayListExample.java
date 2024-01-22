package com.lsl.packageofdemotsal.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListExample {
	
	public static void main(String[] args) throws Exception{
		ArrayList<Integer> al = new ArrayList<>(23);
		
		List<Integer> s = al.stream().collect(Collectors.toList());
		
		
		al.add(4);al.add(24);al.add(47);al.add(14);
		al.add(78);al.add(43);al.add(34);
		
		for(int i : al) {System.out.print(i+",");}
		
		System.out.println();
		
		Collections.sort(al,(a, b) -> a-b);
		
		
		
		for(int i : al) {System.out.print(i+",");}
		
	}
}
