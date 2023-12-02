package com.lsl.packageoftsal.exceptionpack;

import com.lsl.packageoftsaled.pojo.LslResponse;

public class LSLException extends Throwable {
	private int errorCode;
	private String errorDescription;
	public LSLException(int errorCode, String errorDescription) {
		super();
		this.setErrorCode(errorCode);
		this.setErrorDescription(errorDescription);
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public LslResponse getLslResponse(){
		return new LslResponse(errorDescription, errorCode);
	}
}
