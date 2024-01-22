package com.lsl.packageofdemotsal.streamspack;

import java.util.Optional;

public class OptionalExample {
	
	static class Box{
		int i = 0;

		public Box(int i) {
			super();
			this.i = i;
		}
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Optional<Box> op1 = Optional.of(new OptionalExample.Box(10));
		Optional<Box> op2 = Optional.empty();
		
		op2.ifPresent( b -> b.i=5);
		
		op1.ifPresentOrElse(b->System.out.print(b.i), ()->System.out.print("hi"));
		
		op1.orElseThrow(() -> new Exception());
		
		
		
	}

}
