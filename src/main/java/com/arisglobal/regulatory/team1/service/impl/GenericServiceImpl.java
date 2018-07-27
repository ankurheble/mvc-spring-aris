package com.arisglobal.regulatory.team1.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.arisglobal.regulatory.team1.dao.GenericDao;
import com.arisglobal.regulatory.team1.entity.UserDetails;
import com.arisglobal.regulatory.team1.entity.common.GenericEntity;
import com.arisglobal.regulatory.team1.service.GenericService;

/**
 * Copyright  1995-2014 PharmApps, LLC.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
 * Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
 * Created On  : 27-Oct-2015
 * Description : This class acts as a Generic Service Implementation to help manage entities that extend GenericEntity.
 */
public class GenericServiceImpl implements GenericService {

	private GenericDao genericDao;	
	
	/**
	 * This is a getter method for retrieving the genericDao field.
	 * @return GenericDao - genericDao
	 */
	public GenericDao getGenericDao() {
		return genericDao;
	}

	/**
	 * This is a setter method for setting the genericDao field.
	 * @param GenericDao - genericDao
	 */
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	/**
	 * This overridden method saves a genericEntity into database.
	 * @param GenericEntity - genericEntity
	 * @return GenericEntity - genericEntity
	 */
	
	public GenericEntity save(GenericEntity genericEntity) {
		return genericDao.save(genericEntity);
	}

	/**
	 * This overridden method retrieves all records of an entity from the database.
	 * @return List - List of generic entities.
	 */
	
	public List<GenericEntity> getAllRecords(String entityName, Class entityClass) {
		return genericDao.getAllRecords(entityName, entityClass);
	}

	/**
	 * This overridden method finds and returns a genericEntity record based on recordId.
	 * @param Long - id
	 * @param Class - entityClass
	 * @return GenericEntity - genericEntity
	 */

	public GenericEntity find(Long id, Class entityClass) {
		return genericDao.find(id, entityClass);
	}

	/**
	 * This overridden method deletes an entity from the database.
	 * @param Long - id
	 * @param Class - entityClass
	 */

	public void delete(Long id, Class entityClass) {
		genericDao.delete(id, entityClass);		
	}
	
	/**
	 * This overridden method deletes an entity from the database.
	 * @param Long - id
	 * @param Class - entityClass
	 */

	public void deleteList(String[] recordIds, Class entityClass) {
		genericDao.deleteList(recordIds, entityClass);		
	}

	/**
	 * This overridden method retrieves records based on a search key.
	 * @param String - entityName
	 * @param String - entityField
	 * @param String - key
	 * @param Class - entityClass
	 * @return List - List of Records that satisfy the search criteria
	 */
	
	public List<GenericEntity> getRecords(String entityName,
			List<String> fieldList, String key, Class<GenericEntity> entityClass) {
		return genericDao.getRecords(entityName, fieldList, key, entityClass);
	}

	/**
	 * This overridden method returns the count of rows of the total entity records in database.
	 * @return String - entityName
	 * @return int - rows
	 */
	
	public int rowCount(String entityName) {
		return genericDao.rowCount(entityName);
	}

	/**
	 * This overridden method returns next value in a particular database sequence.
	 * @param String - seqName.
	 * @return BigDecimal - Next value from sequence.
	 */
	
	public BigDecimal getNextValueFromSequence(String seqName) {
		return genericDao.getNextValueFromSequence(seqName);
	}

	/**
	 * This  overridden method authenticates a valid user by checking his credentials in database.
	 * @param String - username.
	 * @param String - password.
	 * @return UserDetails - valid user.
	 */
	
	public UserDetails authenticateUser(String username, String password) {
		return genericDao.authenticateUser(username, password);
	}
}

