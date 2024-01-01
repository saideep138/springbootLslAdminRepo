package com.lsl.packageofdemotsal.collections.concurrency.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentListExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.
		CopyOnWriteArrayList<String> mp = null;
		
		mp.get(0);
		mp.add(null);
		
		//2.
		List<String> aL = new ArrayList<>();
		List<String> synchAL = Collections.synchronizedList(aL);
		 
		synchronized (synchAL) {
		           Iterator i = synchAL.iterator(); // Must be in synchronized block
		           while (i.hasNext())
		               i.next();
		       }
		
	}
	
	public static void mained(String[] args) {
		// TODO Auto-generated method stub
		//1.
		CopyOnWriteArraySet<String> mp = null;
		
		mp.add(null);
		
		//2.
		Set<String> aL = new HashSet<>();
		Set<String> synchAL = Collections.synchronizedSet(aL);
		synchAL.add(null);
		
		 
		synchronized (synchAL) {
		           Iterator i = synchAL.iterator(); // Must be in synchronized block
		           while (i.hasNext())
		               i.next();
		       }
		
	}
}





