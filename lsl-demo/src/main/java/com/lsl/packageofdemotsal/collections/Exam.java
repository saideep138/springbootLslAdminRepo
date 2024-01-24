package com.lsl.packageofdemotsal.collections;

import java.util.Arrays;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		class Interval{
			int start;
			int end;
			Interval(int s,int e){
				start = s;
				end=e;
			}
		}
		
		int n=4;
		
		Interval[] intervals = new Interval[n];

		intervals[0] = new Interval(1,3);
		intervals[1] = new Interval(2,6);
		intervals[2] = new Interval(8,10);
		intervals[3] = new Interval(15,18);
		
		Arrays.sort(intervals,(a,b)-> a.start-b.start);
		
		Interval pre = intervals[0];

		
		/*
		 * 
1 3

2 6 //3>2 merge, 1.5<2 print _ 1.5

8 10

15 18
		 */
//		System.out.println(n);
		
		for(int i = 1; i<n ;i++) {
			System.out.println(i);
			Interval currentInterval = intervals[i];
			
			System.out.println("    "+currentInterval.start+","+currentInterval.end);
			
			if(pre.end>=currentInterval.start) {//3>=2
				if(pre.end < currentInterval.end)
					pre.end = currentInterval.end;
			}
			else {
				System.out.println("ans"+pre.start+","+pre.end);
				if(i<n) {
					pre = intervals[i];
				}
			}
			
		}
		
		System.out.println(":::::"+pre.start+","+pre.end);
	}

}

/*
 * 1 1.5
 * 2 6 = 1 6
 *  * */
