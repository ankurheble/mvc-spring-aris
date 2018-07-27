package com.arisglobal.regulatory.team1.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.arisglobal.regulatory.team1.dao.GenericDao;
import com.arisglobal.regulatory.team1.entity.UserDetails;
import com.arisglobal.regulatory.team1.entity.common.GenericEntity;

/**
 * Copyright  1995-2014 PharmApps, LLC.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
 * Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
 * Created On  : 27-Oct-2015
 * Description : This class acts as a Generic Dao Implementation to help manage entities that extend GenericEntity.
 */
public class GenericDaoImpl implements GenericDao {
    @PersistenceContext
    private EntityManager em;

    /**
	 * This method retrieves all records of an entity from the database.
	 * @return List - List of generic entities.
	 */
    public List<GenericEntity> getAllRecords(String entityName, Class entityClass) {
		TypedQuery<GenericEntity> typedQueryToRetrieveAllRecords =  em.createQuery("SELECT P FROM "+entityName+" P", entityClass); 
		return typedQueryToRetrieveAllRecords.getResultList();
	}

	/**
	 * This method saves a genericEntity into database.
	 * @param GenericEntity - genericEntity
	 * @return GenericEntity - genericEntity
	 */
	@Transactional
	public GenericEntity save(GenericEntity genericEntity) {
		return em.merge(genericEntity);		
	}

	/**
	 * This method finds and returns a genericEntity record based on recordId.
	 * @param Long - id
	 * @param Class - entityClass
	 * @return GenericEntity - genericEntity
	 */

	public GenericEntity find(Long id, Class entityClass) throws IllegalArgumentException {
		return (GenericEntity) em.find(entityClass, id);
	}

	/**
	 * This method deletes an entity from the database.
	 * @param Long - id
	 * @param Class - entityClass
	 */
	
	@Transactional
	public void delete(Long id, Class entityClass) {
		em.remove(em.find(entityClass, id));
	}
	
	/**
	 * This method deletes an entity from the database.
	 * @param Long - id
	 * @param Class - entityClass
	 */
	
	@Transactional
	public void deleteList(String[] recordIds, Class entityClass) {
		for (String recordId : recordIds) {
			em.remove(em.find(entityClass, Long.parseLong(recordId)));
		}	
	}

	/**
	 * This method retrieves records based on a search key.
	 * @param String - entityName
	 * @param String - entityField
	 * @param String - key
	 * @param Class - entityClass
	 * @return List - List of Records that satisfy the search criteria
	 */
	
	public List<GenericEntity> getRecords(String entityName,List<String> fieldList, String key,
			Class<GenericEntity> entityClass) {
		String whereClass = null;
		for(String field : fieldList ){
			if(whereClass == null){
				whereClass = "P."+field+" LIKE '"+key+"%'";
			}else{
				whereClass += " OR P."+field+" LIKE '"+key+"%'";
			}
		}

		TypedQuery<GenericEntity> typedQueryToRetrieveAllRecords =  em.createQuery("SELECT P FROM "+entityName+" P WHERE " + whereClass, entityClass); 
		return typedQueryToRetrieveAllRecords.getResultList();
	}

	/**
	 * This method returns the count of rows of the total entity records in database.
	 * @return String - entityName
	 * @return int - rows
	 */
	
	public int rowCount(String entityName) {
		Query query = em.createNativeQuery("select count(*) noOfRecords from "+entityName+"");
		List c =   query.getResultList();
		BigDecimal bd = (BigDecimal) c.get(0);
		int count = bd.intValueExact();
		return count;
	}

	/**
	 * This method returns next value in a particular database sequence.
	 * @param String - seqName.
	 * @return BigDecimal - Next value from sequence.
	 */
	
	public BigDecimal getNextValueFromSequence(String seqName) {
		Query query = em.createNativeQuery("select "+ seqName + ".nextval from dual");
		return (BigDecimal) query.getResultList().get(0);
	}

	/** 
	 * This method authenticates a valid user by checking his credentials in database.
	 * @param String - username.
	 * @param String - password.
	 * @return UserDetails - valid user.
	 */
	
	public UserDetails authenticateUser(String username, String password) {
		TypedQuery<GenericEntity> authenticationQuery = em.createQuery("select f from UserDetails f where f.username='"+username+"' and f.password='"+password+"'", GenericEntity.class);
		List<GenericEntity> result = authenticationQuery.getResultList();
		UserDetails userDetails=null;
		if(!result.isEmpty()){
		userDetails =(UserDetails)result.get(0);
		}
		return userDetails;
	}
}