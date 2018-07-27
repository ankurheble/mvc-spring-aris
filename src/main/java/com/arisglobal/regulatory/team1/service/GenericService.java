package com.arisglobal.regulatory.team1.service;

import java.math.BigDecimal;
import java.util.List;

import com.arisglobal.regulatory.team1.entity.UserDetails;
import com.arisglobal.regulatory.team1.entity.common.GenericEntity;

/**
 * Copyright  1995-2014 PharmApps, LLC.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
 * Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
 * Created On  : 26-Oct-2015
 * Description : This interface acts as a wrapper for Generic Dao to help manage entities that extend GenericEntity.
 */
public interface GenericService {
	
	/**
	 * This method saves a genericEntity into database.
	 * @param GenericEntity - genericEntity
	 * @return GenericEntity - genericEntity
	 */
	public GenericEntity save(GenericEntity genericEntity);
	
	/**
	 * This method deletes an entity from the database.
	 * @param Long - id
	 * @param Class - entityClass
	 */
	public void delete(Long id, Class entityClass);

	/**
	 * This method deletes an entity from the database.
	 * @param Long - id
	 * @param Class - entityClass
	 */
	public void deleteList(String[] recordIds, Class entityClass);
	/**
	 * This method retrieves all records of an entity from the database.
	 * @return List - List of generic entities.
	 */
	public List<GenericEntity> getAllRecords(String entityName,	Class<GenericEntity> entityClass);
	
	/**
	 * This method retrieves records based on a search key.
	 * @param String - entityName
	 * @param String - entityField
	 * @param String - key
	 * @param Class - entityClass
	 * @return List - List of Records that satisfy the search criteria
	 */
	public List<GenericEntity> getRecords(String entityName,List<String> fieldList,String key,Class<GenericEntity> entityClass);

	/**
	 * This method finds and returns a genericEntity record based on recordId.
	 * @param Long - id
	 * @param Class - entityClass
	 * @return GenericEntity - genericEntity
	 */
	public GenericEntity find(Long id,Class entityClass);
	
	/**
	 * This method returns the count of rows of the total entity records in database.
	 * @return String - entityName
	 * @return int - rows
	 */
	public int rowCount(String entityName);
	
	/**
	 * This method returns next value in a particular database sequence.
	 * @param String - seqName.
	 * @return BigDecimal - Next value from sequence.
	 */
	public BigDecimal getNextValueFromSequence(String seqName);
	
	/**
	 * This method authenticates a valid user by checking his credentials in database.
	 * @param String - username.
	 * @param String - password.
	 * @return UserDetails - valid user.
	 */
	public UserDetails authenticateUser(String username,String password);
}
