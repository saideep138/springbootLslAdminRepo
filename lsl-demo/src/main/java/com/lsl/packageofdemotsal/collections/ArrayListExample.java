package com.lsl.packageofdemotsal.collections;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListExample {
	
	public static void main(String[] args) throws Exception{
		ArrayList<Integer> al = new ArrayList<>(23);
		
		List<Integer> s = al.stream().collect(Collectors.toList());
		Constructor<ArrayListExample> c;
		//c.newInstance();
	}
}
