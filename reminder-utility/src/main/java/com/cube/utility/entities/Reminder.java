package com.cube.utility.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rc_reminder")
public class Reminder implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="consumer_id")
	private Consumer consumer;

	private String active;

	private String enabled;

	private String circleCode;

	private String operator;

	private String code;

	private String optionOneCode;

	private String optionTwoCode;

	private String serviceType;

	private String title;

	private String category;

	private String type;

	private String repeatValue;

	private Integer remindOn;
	
	private String serviceData;

	private String plan;

	private String payment;

	private String appCode;

	
	public Reminder() {
	}
	
	public Reminder(Consumer consumer,Date created, String active, String enabled,
			String circleCode, String operator, String code,
			String optionOneCode, String optionTwoCode, String serviceType,
			String title, String category, String type, String repeatValue,
			Integer remindOn, String plan, String payment, String appCode,
			String serviceData) {
		this.created = created;
		this.active = active;
		this.enabled = enabled;
		this.circleCode = circleCode;
		this.operator = operator;
		this.code = code;
		this.optionOneCode = optionOneCode;
		this.optionTwoCode = optionTwoCode;
		this.serviceType = serviceType;
		this.title = title;
		this.category = category;
		this.type = type;
		this.repeatValue = repeatValue;
		this.remindOn = remindOn;
		this.plan = plan;
		this.payment = payment;
		this.appCode = appCode;
		this.serviceData=serviceData;
		this.consumer=consumer;
	}

	public Integer getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public String getActive() {
		return active;
	}

	public String getEnabled() {
		return enabled;
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

	public String getRepeatValue() {
		return repeatValue;
	}

	public Integer getRemindOn() {
		return remindOn;
	}

	public String getServiceData() {
		return serviceData;
	}

	public String getPlan() {
		return plan;
	}

	public String getPayment() {
		return payment;
	}

	public String getAppCode() {
		return appCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Consumer getConsumer() {
		return consumer;
	}
	
	
}
