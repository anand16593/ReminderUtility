package com.cube.utility.beans;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ResponseData {
	
	private ProfilebyEmail profileByEmail;

	public ProfilebyEmail getProfileByEmail() {
		return profileByEmail;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
