package com.lsl.packageofdemotsal;

public class EnumExample {
	
	
	public static void main(String[] args) throws Exception{
		
		OrderStatus v2 = OrderStatus.valueOf("DEVLIVERED");
		System.out.println(v2.name()+"\n\n");
		
		v2.setMessage("Delivery complete");
		
		for(OrderStatus os : OrderStatus.values()) {
			System.out.print(os.name()+","+os.ordinal()+",");
			System.out.println(os.code+","+os.getMessage()+",");
			
		}
	}
}
