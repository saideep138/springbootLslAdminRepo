package com.lsl.packageofdemotsal.javapack;

public class BlockInitInterfaceImpl implements BlockInitInterface {
	// Instance Initialization Block - 1
	static String staticVar = "The Child staticVar";
	String justVar = " child justVar";
    {

        System.out.println("IIB1 block - interface");

    }
 
    static {

        System.out.println("IIB1 static block");

    }

    // Instance Initialization Block - 2

    {

        System.out.println("IIB2 block");

    }
 

    // Constructor of class GfG

    BlockInitInterfaceImpl() { System.out.println("Child Constructor Called"); }
    BlockInitInterfaceImpl(String a){System.out.println("Child Constructor Called with "+a);}
 

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
    	BlockInitInterfaceImpl.inBothChildAndParentStatic(0);
    	
    	//Object related
    	BlockInitInterfaceImpl a = new BlockInitInterfaceImpl("The ChildObject");
    	
    	System.out.println(" ============ Now call methods : only in any one of child or parent ============= ");
    	a.onlyInParent(0);
    	a.onlyInChild(0);
    	
    	//
//    	a.onlyInParentStatic(99);
    	BlockInitInterface.onlyInParentStatic(99);
    	
    	a.onlyInChildPrivate(0);
//    	a.onlyInParentPrivate(0);
    	
    	System.out.println(" ============ Now call methods : Both in child and parent ============= ");
    	
    	a.inBothChildAndParent(0);
    	a.inBothChildAndParentPrivate(0);
    	a.inBothChildAndParentStatic(0);
    	
    	System.out.println("In main, justVar=" + a.justVar );
    	
    	
    	System.out.println("====================================================================" );

    	System.out.println("=============== Object Creation with Parent Varible =================" );

    	BlockInitInterface b = new BlockInitInterfaceImpl("A    param");
    	b.onlyInParent(0);
//    	b.onlyInChild(0);
//    	b.onlyInChildPrivate(0);
    	((BlockInitInterfaceImpl) b).onlyInChild(0);
    	((BlockInitInterfaceImpl) b).onlyInChildPrivate(0);
    	
    	b.inBothChildAndParent(0);
//    	b.inBothChildAndParentPrivate(0);
    	
//    	b.inBothChildAndParentStatic(0);
    	((BlockInitInterfaceImpl) b).inBothChildAndParentStatic(0);
    	
    	
    	
    	System.out.println("In main, justVar=" + b.justVar );

    }
    
    private void onlyInChildPrivate(int k) {
    	System.out.println("onlyInChildPrivate(k) method in child withsaticVar="+staticVar);
    }
    
    void onlyInChild(int k) {
    	{
    		System.out.println("			Outside the onlyInChild block - start");
    		{
        		System.out.println("			Inside the onlyInChild block");
    		}
    		System.out.println("			Outside the onlyInChild block - end");
    	}
    	System.out.println("onlyInChild--(k) method  with justVar="+justVar);
    }
    
    public BlockInitInterfaceImpl inBothChildAndParent(int k) {
    	System.out.println("inBothChildAndParent--(child) method, covariant Return type  with saticVar="+staticVar);
    	return this;
    }
    
    private void inBothChildAndParentPrivate(int k) {
    	System.out.println("inBothChildAndParentPrivate--(child) method with saticVar="+staticVar);
    }
    
    static void inBothChildAndParentStatic(int k) {
    	System.out.println("inBothChildAndParentStatic--(child) method with saticVar="+staticVar);
    }
    
}
