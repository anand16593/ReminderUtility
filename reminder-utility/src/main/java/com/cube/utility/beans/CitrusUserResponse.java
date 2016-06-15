package com.cube.utility.beans;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CitrusUserResponse {
	
	private String responseCode;
	private String responseMessage;
	private ResponseData responseData;
	
	public String getResponseCode() {
		return responseCode;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public ResponseData getResponseData() {
		return responseData;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
