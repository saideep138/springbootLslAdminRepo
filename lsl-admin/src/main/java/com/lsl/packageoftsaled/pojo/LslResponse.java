package com.lsl.packageoftsaled.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LslResponse {
	@JsonProperty("response")
	Object response;
	
	@JsonProperty("Responsecode")
	int code;
	
	public LslResponse() {}
	
	public LslResponse(Object response, int code) {
		super();
		this.response = response;
		this.code = code;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
