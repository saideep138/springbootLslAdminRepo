package com.lsl.packageofdemotsal.threads;

public class ThreadNormal {
	public static void main(String[] args) throws InterruptedException{
//		System.out.println("=========main2 ========");
//		ThreadNormal  tn = new ThreadNormal();
		
		PrintNum pn = new PrintNum();
		
		for(int v = 1 ; v<=3 ; v++) {
			SampleThread s1 = new SampleThread(v,3, pn);
			s1.start();
		}

//		SampleThread s1 = new SampleThread(1,3, pn);
//		SampleThread s2 = new SampleThread(2,3, pn);
//		SampleThread s3 = new SampleThread(3,3, pn);
//		s1.start();
//		s2.start();
//		s3.start();
		
		
	}
	
	static class SampleThread extends Thread{
		
		int i,add;
		PrintNum pn ;
		
		SampleThread(int iv,int adder,PrintNum pn ){
			super("Thread-"+iv);
			i = iv;
			add=adder;
			this.pn = pn; 
			System.out.println("Created Thread-"+i);
		}

		@Override
		public void run() {
			for(; i<= 10 ; i+=add) {
				try {
					
//					System.out.println("               run()>"+Thread.currentThread().getName()+ " : "+i);
					pn.print(i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	static class PrintNum{
		volatile int pre=0;
		void print(int i) throws InterruptedException {
			
                synchronized (this)
                {
                	while(this.pre!=i-1) {
//                		System.out.println("pre="+pre+" waiting..."+Thread.currentThread().getName());
        				wait(1000);
                	}
        			
                	
                	System.out.println(Thread.currentThread().getName()+ " : "+i);
        			pre=i;
        			
        			notifyAll();
                }
		}
	}
}

