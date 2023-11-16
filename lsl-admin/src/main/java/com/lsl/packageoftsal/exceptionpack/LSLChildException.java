package com.lsl.packageoftsal.exceptionpack;

public class LSLChildException extends LSLException {
	private String message;
	public LSLChildException(int errorCode, String errorDescription, String message) {
		super(errorCode, errorDescription);
		// TODO Auto-generated constructor stub
	}
}
