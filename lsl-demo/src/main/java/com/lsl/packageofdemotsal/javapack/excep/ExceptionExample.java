package com.lsl.packageofdemotsal.javapack.excep;

public class ExceptionExample {  
public static void main(String args[])  
{  
    try  
    {  
    	int b = 0;
        int a = 1/0;  
        System.out.println("a = "+a);  
    }
    catch(ArithmeticException ex){System.out.println("hi "+ex);}
    catch(Exception e){System.out.println("hello"+e);}  
      
}  
}  