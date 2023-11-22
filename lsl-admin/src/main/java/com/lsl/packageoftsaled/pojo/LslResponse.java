package com.lsl.packageoftsaled.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LslResponse {
	@JsonProperty("response")
	Object response;
	
	@JsonProperty("code")
	int code;
	
	public LslResponse(Object response, int code) {
		super();
		this.response = response;
		this.code = code;
	}
}
