package com.lsl.packageofdemotsal.corejava;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectExample {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		//1 register driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// OR alternate for step-1
		Driver myDriver = null;//new oracle.jdbc.driver.OracleDriver();
		   DriverManager.registerDriver( myDriver );
		   
		//2  connect to db
		   String URL = "jdbc:oracle:thin:@amrood:1521:EMP";
		   String USER = "username";
		   String PASS = "password";
		   Connection conn = DriverManager.getConnection(URL, USER, PASS);
		   
		
		//3
		   		//3A
				   Statement stmt = null;
				   try {
					   String SQL = "select * from Employees";
					   
				      stmt = conn.createStatement( );
				      ResultSet rs = stmt.executeQuery(SQL);
				      
				      while(rs.next())  {
				    	  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				    	  
				    	  }
				      rs.close();
				      
				   }
				   catch (SQLException e) {
				      
				   }
				   finally {
				      stmt.close();
				   }
		   
				//3B
				   PreparedStatement pstmt = null;
				   try {
					   String SQL = "Update Employees SET name = ? WHERE id = ?";
					   pstmt = conn.prepareStatement(SQL);
					   
					   pstmt.setString(1, "RAM");
					   pstmt.setInt(2, 4);
					   
					   pstmt.execute();
					  
					}
					catch (SQLException e) {
					  
					}
					finally {
						pstmt.close();
					}
		   
		   
			  //3C
				   CallableStatement cstmt = null;
				   try {
				      String SQL = "{call getEmpName (?, ?)}";
				      cstmt = conn.prepareCall (SQL);
				      
				      
				      /*
				       GFG is csmt here
				      //Use GFG.setter() methods to pass IN parameters
 
								//Use GFG.registerOutParameter() method to register OUT parameters
								 
								//Executing the CallableStatement
								 GFG.execute();
								 
								//Use GFG.getter() methods to retrieve the result 
				      */
				      
				   }
				   catch (SQLException e) {
				      
				   }
				   finally {
				      cstmt.close();
				   }
		   
		   
				   
		
				   
				   
		//
		   conn.close();
		
	}

}
