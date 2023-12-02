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
    	a.solve(0);
    	a.show(0);
    	a.show2(0);

    }
    
    //@Override
    private void solve(int k) {
    	System.out.println("solve(k) method in child");
    }
    
    void show2(int k) {
    	System.out.println("show2--(k) method in child");
    }
}
