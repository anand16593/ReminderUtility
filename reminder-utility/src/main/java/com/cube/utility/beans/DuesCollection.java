package com.cube.utility.beans;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "dues")
public class DuesCollection {

	private ObjectId _id;
	private String amount;
	private String paidVia;
	private Double reminderDate;
	private String forwardPhone;
	private String forwardName;
	private ObjectId reminderId;
	private Double paidDate;
	private String status;
	private String transactionId;
	private String orderId;
	private String paymentStatus;
	private String serviceType;
	private String uniqueId;
	private Integer idOrder;
	private Boolean active;
	private Boolean enabled;
	private Double created;
	private String createdISO;
	private ObjectId userId;
	private Double updated;
	private String updatedISO;
	
	public ObjectId get_id() {
		return _id;
	}
	public String getAmount() {
		return amount;
	}
	public String getPaidVia() {
		return paidVia;
	}
	public Double getReminderDate() {
		return reminderDate;
	}
	public String getForwardPhone() {
		return forwardPhone;
	}
	public String getForwardName() {
		return forwardName;
	}
	public ObjectId getReminderId() {
		return reminderId;
	}
	public Double getPaidDate() {
		return paidDate;
	}
	public String getStatus() {
		return status;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public String getOrderId() {
		return orderId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public String getServiceType() {
		return serviceType;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public Integer getIdOrder() {
		return idOrder;
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
	public ObjectId getUserId() {
		return userId;
	}
	public Double getUpdated() {
		return updated;
	}
	public String getUpdatedISO() {
		return updatedISO;
	}
}
