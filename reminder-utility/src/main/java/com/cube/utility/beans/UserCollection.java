package com.cube.utility.beans;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Document(collection = "users")
@JsonIgnoreType
public class UserCollection {
	
    private ObjectId _id;

	private String email;

	private String [] uniqIds;
	
	private String active;
	
	private Boolean enabled;
	
	private Double random;
	
	private Double created;
	
	private String createdISO;
	
	private Double updated;
	
	private String updatedISO;
	
	private String cube_uuid;
	
	public UserCollection() {
	}

	public ObjectId get_id() {
		return _id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getUniqIds() {
		return uniqIds;
	}

	public void setUniqIds(String[] uniqIds) {
		this.uniqIds = uniqIds;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Double getRandom() {
		return random;
	}

	public void setRandom(Double random) {
		this.random = random;
	}

	public Double getCreated() {
		return created;
	}

	public void setCreated(Double created) {
		this.created = created;
	}


	public String getCreatedISO() {
		return createdISO;
	}


	public void setCreatedISO(String createdISO) {
		this.createdISO = createdISO;
	}


	public Double getUpdated() {
		return updated;
	}


	public void setUpdated(Double updated) {
		this.updated = updated;
	}


	public String getUpdatedISO() {
		return updatedISO;
	}


	public void setUpdatedISO(String updatedISO) {
		this.updatedISO = updatedISO;
	}

	public String getCube_uuid() {
		return cube_uuid;
	}

	public void setCube_uuid(String cube_uuid) {
		this.cube_uuid = cube_uuid;
	}
	
	
}