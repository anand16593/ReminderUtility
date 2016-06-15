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
@Table(name="rc_dues")
public class Dues implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	
	private String amount;
	private String paidVia;
	private Date reminderDate;
	private String forwardPhone;
	private String forwardName;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="reminder_id")
	private Reminder reminder;
	private Date paidDate;
	private String status;
	private String transactionId;
	private String orderId;
	private String paymentStatus;
	private String serviceType;
	private String uniqueId;
	private Integer idOrder;
	private Integer active;
	private Integer enabled;
	
	public Dues() {
	}
	
	public Dues(Reminder reminder,Date created, Date lastModified, String amount, String paidVia,
			Date reminderDate, String forwardPhone, String forwardName,
			Date paidDate, String status, String transactionId,
			String orderId, String paymentStatus, String serviceType,
			String uniqueId, Integer idOrder, Integer active, Integer enabled) {
		
		this.reminder=reminder;
		this.created = created;
		this.lastModified = lastModified;
		this.amount = amount;
		this.paidVia = paidVia;
		this.reminderDate = reminderDate;
		this.forwardPhone = forwardPhone;
		this.forwardName = forwardName;
		this.paidDate = paidDate;
		this.status = status;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.paymentStatus = paymentStatus;
		this.serviceType = serviceType;
		this.uniqueId = uniqueId;
		this.idOrder = idOrder;
		this.active = active;
		this.enabled = enabled;
	}


	public Reminder getReminder() {
		return reminder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getAmount() {
		return amount;
	}

	public String getPaidVia() {
		return paidVia;
	}

	public Date getReminderDate() {
		return reminderDate;
	}

	public String getForwardPhone() {
		return forwardPhone;
	}

	public String getForwardName() {
		return forwardName;
	}

	public Date getPaidDate() {
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

	public Integer getActive() {
		return active;
	}

	public Integer getEnabled() {
		return enabled;
	}
}
