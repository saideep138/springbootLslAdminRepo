package com.lsl.packageofdemotsal;

public enum OrderStatus {
	
	CREATED(10,"order is created"),
	SHIPPED(15,"shipped order"),
	DEVLIVERED(20,"delivered"),
	COMPLETED(25,"completed");
	
	int code;
	String message;

	OrderStatus(int codeVal, String message) {
		// TODO Auto-generated constructor stub
		code = codeVal;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
