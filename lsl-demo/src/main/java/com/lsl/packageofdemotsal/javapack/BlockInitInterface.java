package com.lsl.packageofdemotsal.javapack;

public interface BlockInitInterface {

	String justVar = "justVar-in BlockInitInterface";
	String staticVar = "staticVar-in BlockInitInterface";
	
	default int onlyInParent(int v){
		System.out.println("onlyInParent--(parent) method with saticVar="+staticVar+justVar);
		return 0;
	}
	
	static int onlyInParentStatic(int v) {
		System.out.println("onlyInParentStatic--(parent) method with saticVar="+staticVar);
		return 0;
	}
	
	default Object inBothChildAndParent(int v) {
		System.out.println("inBothChildAndParent--(parent) method with saticVar="+staticVar+justVar);
		return this;
	}
	
	static void inBothChildAndParentStatic(int v) {
    	System.out.println("inBothChildAndParentStatic--(parent) method with saticVar="+staticVar);
	}
	
	private void inBothChildAndParentPrivate(int v) {
		System.out.println("inBothChildAndParentPrivate--(parent) method with saticVar="+staticVar+justVar);
	}
	
}
