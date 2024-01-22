package com.lsl.packageofdemotsal.zz.advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVExample {
	public static void main(String[] args) {
		String line = "";
		String splitBy = ",";
		try {
//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\saide\\Documents\\delLater\\names.csv"));

			br.readLine();
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] employee = line.split(splitBy); // use comma as separator
				System.out.println("studentId=" + employee[0] + ", student Name=" + employee[1] + ", DOB=" + employee[2]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}