package com.lsl.packageoftsaled.pojo;

public class LslResponse {
	Object response;
	int code;
	public LslResponse(Object response, int code) {
		super();
		this.response = response;
		this.code = code;
	}
}
