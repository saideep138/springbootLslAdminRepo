package com.lsl.packageofdemotsal.streamspack;

import java.util.Arrays;

public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr= new Integer[100];

		
		//reduce() method usage
		Arrays.stream(arr).reduce((a,b) -> a+b);
		Arrays.stream(arr).reduce(0,(a,b) -> a+b);

	}

}
