package com.event.business.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.event.business.model.RetreiveBusinessDetails;

@Repository
public class DynamoDBRepository {
	
	@Autowired
	private DynamoDBMapper mapper;
	
	public void insertIntoDB(RetreiveBusinessDetails object) {
		mapper.save(object);
		
	}
	
	public void updateIntoDB(RetreiveBusinessDetails e, String primaryKeyValue) {
		mapper.save(e, getBuildExpression("businessId", primaryKeyValue));
	}
	
	
	public DynamoDBMapper getMapper() {
		return mapper;
	}

	public void setMapper(DynamoDBMapper mapper) {
		this.mapper = mapper;
	}
	
	public DynamoDBSaveExpression getBuildExpression(String pk, String pkValue){
    	DynamoDBSaveExpression expression = new DynamoDBSaveExpression();
    	Map<String, ExpectedAttributeValue> expectedValue=new HashMap<>();
    	expectedValue.put(pk, new ExpectedAttributeValue(new AttributeValue(pkValue)).withComparisonOperator(ComparisonOperator.EQ));
    	expression.setExpected(expectedValue);   
    	return expression;
    }
}
