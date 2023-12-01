package com.lsl.packageofdemotsal.javapack;

public class BlockInit extends BlockInitParent {
	// Instance Initialization Block - 1

    {

        System.out.println("IIB1 block");

    }
 
    static {

        System.out.println("IIB1 static block");

    }

    // Instance Initialization Block - 2

    {

        System.out.println("IIB2 block");

    }
 

    // Constructor of class GfG

    BlockInit() { System.out.println("Constructor Called"); }
 

    // Instance Initialization Block - 3

    {

        System.out.println("IIB3 block");

    }
    
    static {

        System.out.println("IIB2 static block");

    }
 

    // main function

    public static void main(String[] args)

    {

    	BlockInit a = new BlockInit();

    }
}
