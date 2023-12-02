package com.lsl.packageofdemotsal.javapack;

public class BlockInitParent {
	// Instance Initialization Block - 1

    {

        System.out.println("parent IIB1 block");

    }
 
    static {

        System.out.println("parent IIB1 static block");

    }

    // Instance Initialization Block - 2

    {

        System.out.println("parent IIB2 block");

    }
 

    // Constructor of class GfG

    BlockInitParent() { System.out.println("Constructor Called"); }
 

    // Instance Initialization Block - 3

    {

        System.out.println("parent IIB3 block");

    }
    
    static {

        System.out.println("parent IIB2 static block");

    }
 

    // main function

    public static void main(String[] args)

    {

    	BlockInitParent a = new BlockInitParent();
    	a.solve(0);;

    }
    
    private void solve(int k) {
    	System.out.println("solve(k) method in parent");
    }
    
    void show(int k) {
    	System.out.println("show--(k) method in parent");
    }
    
    void show2(int k) {
    	System.out.println("show--(k) method in parent");
    }
}
