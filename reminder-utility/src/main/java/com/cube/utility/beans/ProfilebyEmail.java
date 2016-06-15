package com.cube.utility.beans;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ProfilebyEmail {
	
	private String email;
	private Integer emailVerified;
	private Long emailVerifiedDate;
	private String mobile;
	private Integer mobileVerified;
	private String firstName;
	private String lastName;
	
	public Integer getEmailVerified() {
		return emailVerified;
	}
	
	public Long getEmailVerifiedDate() {
		return emailVerifiedDate;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public Integer getMobileVerified() {
		return mobileVerified;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Boolean IsEmailVerified()
	{
		return emailVerified==1?true:false;
	}
	
	public Boolean isMobileVerified()
	{
		return mobileVerified==1?true:false;
	}

	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
