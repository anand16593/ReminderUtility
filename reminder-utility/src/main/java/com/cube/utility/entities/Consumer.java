/*
 * Copyright (c) 2012 CitrusPay. All Rights Reserved.
 *
 * This software is the proprietary information of CitrusPay.
 * Use is subject to license terms.
 */
package com.cube.utility.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "rc_consumer")
public class Consumer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@NotNull
	private String mobile;
	
	protected Consumer() {
	}

	public Consumer(String email, String mobile, String name) {
		this.email = email;
		this.mobile = mobile;
		this.name = name;
		this.created = new Date();
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

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.lastModified = new Date();
	}
}
