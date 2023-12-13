package com.lsl.packageofdemotsal.javapack;

public class BlockInitParent {
	
	static String staticVar = "The Parent staticVar";
	String justVar = "The Parent justVar";
	
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

    public BlockInitParent() { System.out.println("Parent Constructor Called"); }
 

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
    	System.out.println("hello main start");
    	BlockInitParent a = new BlockInitParent();
    	a.onlyInParentPrivate(0);;
    	System.out.println("hello main end");

    }
    
    private void onlyInParentPrivate(int k) {
    	System.out.println("onlyInParentPrivate(k) method in parent withsaticVar="+staticVar);
    }
    
    void onlyInParent(int k) {
    	System.out.println("onlyInParent--(k) method in parent with justVar="+justVar);
    }
    
    Object inBothChildAndParent(int k) {
    	System.out.println("inBothChildAndParent--(parent) method covariant Return type in parent with saticVar="+staticVar);
    	return this;
    }
    
    private void inBothChildAndParentPrivate(int k) {
    	System.out.println("inBothChildAndParentPrivate--(parent) method in parent with saticVar="+staticVar);
    }
}
