package com.cube.utility.enums;

public enum ColleactionEnum {
	
	USERS("users"),REMINDERS("reminders"),DUES("dues");
	
	private String displayLabel;

	private ColleactionEnum(String displayLabel) {
		this.displayLabel = displayLabel;
	}

	public String getDisplayLabel() {
		return this.displayLabel;
	}

}
