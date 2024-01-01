package com.lsl.packageofdemotsal.threads;

//Java program to explain the 
//concept of joining a thread. 
import java.io.*; 

//Creating thread by creating the 
//objects of that class 


class ThreadJoinExample 
{ 
	public static void main (String[] args) throws InterruptedException 
	{ 

		// creating two threads 
//		ThreadJoining t0 = new ThreadJoining();t0.stop();
		ThreadJoining t1 = new ThreadJoining(1); 
		ThreadJoining t2 = new ThreadJoining(2); 
		ThreadJoining t3 = new ThreadJoining(3); 

		t1.setName("one");
		t2.setName("two");
		t3.setName("three");
		
		// thread t1 starts 
		t1.start(); 
		t2.start(); 
		t3.start(); 
		
		print("start join");
		
		t1.join(); 
		print("t1 - t2 join");
		print(Thread.currentThread().getName());
		
		t2.join(); 
		print("t2 - t3 join");
		
		t3.join(); 
		print("After t3 join");
	}
	
	static void print(String s) {
		System.out.println(s);
	}
} 
class ThreadJoining extends Thread 
{ 
	int k;
	
	ThreadJoining(int v){
		k=v+2;
	}
	
	@Override
	public void run() 
	{ 
		System.out.println("Started :"+Thread.currentThread().getName());
		for (int i = 0; i < k; i++) 
		{ 
			try
			{ 
				Thread.sleep(2000); 
				System.out.println("i="+i+", Current Thread: "
						+ Thread.currentThread().getName()); 
			} 

			catch(Exception ex) 
			{ 
				System.out.println("Exception has" + 
								" been caught" + ex); 
			} 
			//System.out.println(i); 
		} 
		System.out.println("Completed :"+Thread.currentThread().getName()); 
	} 
} 