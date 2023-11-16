package com.lsl.packageoftsal.exceptionpack;

public class LSLException extends Throwable {
	private int errorCode;
	private String errorDescription;
	public LSLException(int errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
}
