package com.arisglobal.regulatory.team1.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.arisglobal.regulatory.team1.entity.common.GenericEntity;

/**
 * Copyright  1995-2014 PharmApps, LLC.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
 * Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
 * Created On  : 09-Nov-2015
 * Description : This is the Entity class for the UserDetails module which derives recordId from GenericEntity.
 */
@Entity
@Table(name="BOOT_CAMP_TEAM1_USERS")
public class UserDetails extends GenericEntity{
	
	private String username;
	private String password;
	
	/**
	 * This is a getter method for retrieving the username field.
	 * @return String - username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * This is a setter method for setting the username field.
	 * @param String - username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * This is a getter method for retrieving the password field.
	 * @return String - password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * This is a setter method for setting the password field.
	 * @param String - password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
