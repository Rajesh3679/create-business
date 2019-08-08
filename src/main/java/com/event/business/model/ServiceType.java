package com.event.business.model;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName= "ServiceType")
public class ServiceType implements Serializable {

	private static final long serialVersionUID = 1L;
		
    private String serviceTypeId;
	
	private String key;
	
	private String value;
	
	private String code;

	@DynamoDBHashKey(attributeName = "serviceTypeId")
    @DynamoDBAutoGeneratedKey
	public String getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	@DynamoDBAttribute
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@DynamoDBAttribute
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@DynamoDBAttribute
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}	
		
}
