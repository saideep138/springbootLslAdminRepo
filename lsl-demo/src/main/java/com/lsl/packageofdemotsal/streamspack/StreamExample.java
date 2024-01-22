package com.lsl.packageofdemotsal.streamspack;

import java.util.Arrays;

public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr= new Integer[2];

		arr[0] = 99;
		arr[1] = 8;
		
		//reduce() method usage
		int v = Arrays.stream(arr).reduce((a,b) -> a+b).get();
//		v = Arrays.stream(arr).reduce(0,(a,b) -> a+b);
		
		
		
		System.out.print(v);

	}

}
