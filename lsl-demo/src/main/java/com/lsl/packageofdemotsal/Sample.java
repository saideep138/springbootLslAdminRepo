package com.lsl.packageofdemotsal;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class Sample {
	
	public static void main(String[] args) throws IOException{
		
		Hashtable<String,Integer> al;
		
		
		StringBuffer sb = new StringBuffer();
		sb.notify();
		
		FileOutputStream file;
		try {
			file = new FileOutputStream("");
			ObjectOutputStream out = new ObjectOutputStream(file);
			
		}
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	 
	        // Reading data using readLine
	        String name = reader.readLine();
		
		
		
		
		
		
		
		
		
	}
}
