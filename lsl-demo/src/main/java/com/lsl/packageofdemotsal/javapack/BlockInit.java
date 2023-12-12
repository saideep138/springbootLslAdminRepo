package com.lsl.packageofdemotsal.javapack;

public class BlockInit extends BlockInitParent {
	// Instance Initialization Block - 1

	int justVar = 10999;
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

    BlockInit() { System.out.println("Child Constructor Called"); }
    BlockInit(String a){System.out.println("Child Constructor Called with "+a);}
 

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

    	BlockInit a = new BlockInit("The ChildObject");
    	a.onlyInParent(0);
    	a.onlyInChild(0);
    	
    	a.onlyInChildPrivate(0);
//    	a.onlyInParentPrivate(0);
    	
    	a.inBothChildAndParent(0);
    	a.inBothChildAndParentPrivate(0);
    	
    	System.out.println("In main, justVar=" + a.justVar );
    	
    	
    	System.out.println("====================================================================" );

    	BlockInitParent b = new BlockInit("A    param");
    	//b.solve(0);
    	b.onlyInParent(0);
//    	b.onlyInChild(0);
//    	b.onlyInChildPrivate(0);
    	
    	b.inBothChildAndParent(0);
//    	b.inBothChildAndParentPrivate(0);
    	
    	
    	
    	System.out.println("In main, justVar=" + b.justVar );

    }
    
    private void onlyInChildPrivate(int k) {
    	System.out.println("onlyInChildPrivate(k) method in parent withsaticVar="+staticVar);
    }
    
    void onlyInChild(int k) {
    	System.out.println("onlyInChild--(k) method in parent with justVar="+justVar);
    }
    
    void inBothChildAndParent(int k) {
    	System.out.println("inBothChildAndParent--(child) method  with saticVar="+staticVar);
    }
    
    private void inBothChildAndParentPrivate(int k) {
    	System.out.println("inBothChildAndParentPrivate--(child) method in parent with saticVar="+staticVar);
    }
    
    
}
