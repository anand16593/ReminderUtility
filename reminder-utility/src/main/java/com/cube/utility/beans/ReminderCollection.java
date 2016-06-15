package com.cube.utility.beans;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reminder")
public class ReminderCollection {

	private ObjectId _id;
	
	private Boolean active;
	
	private Boolean enabled;
	
	private Double created;
	
	private String createdISO;
	
	private String circleCode;
	
	private String operator;
	
	private String code;
	
	private String optionOneCode;
	
	private String optionTwoCode;
	
	private String serviceType;
	
	private String title;
	
	private String category;
	
	private String type;
	
	private String repeat;
	
	private Integer on;
	
	private Boolean plan;
	
	private Boolean payment;
	
	private Double updated;
	
	private String updatedISO;
	
	private ObjectId userId;
	
	private String id;
	
	private String appCode;

	public ObjectId get_id() {
		return _id;
	}

	public Boolean getActive() {
		return active;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public Double getCreated() {
		return created;
	}

	public String getCreatedISO() {
		return createdISO;
	}

	public String getServiceType() {
		return serviceType;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	public String getRepeat() {
		return repeat;
	}

	public Integer getOn() {
		return on;
	}

	public Boolean getPlan() {
		return plan;
	}

	public Boolean getPayment() {
		return payment;
	}

	public Double getUpdated() {
		return updated;
	}

	public String getUpdatedISO() {
		return updatedISO;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public String getId() {
		return id;
	}

	public String getAppCode() {
		return appCode;
	}


	public String getCircleCode() {
		return circleCode;
	}

	public String getOperator() {
		return operator;
	}

	public String getCode() {
		return code;
	}

	public String getOptionOneCode() {
		return optionOneCode;
	}

	public String getOptionTwoCode() {
		return optionTwoCode;
	}
}
