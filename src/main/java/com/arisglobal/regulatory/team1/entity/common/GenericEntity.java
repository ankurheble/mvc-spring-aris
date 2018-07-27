 package com.arisglobal.regulatory.team1.entity.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
/**
 * Copyright  1995-2014 PharmApps, LLC.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
 * Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
 * Created On  : 21-Oct-2015
 * Description : This class acts as a super entity from which all other entities derive common attributes.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GenericEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "record_id_seq")
	@SequenceGenerator(name = "record_id_seq", allocationSize = 1, initialValue = 1, sequenceName = "RECORD_ID_SEQ")
	@Column(name = "RECORD_ID")
	private Long recordId;
	@Column(name = "ACTIVE")
	protected String active;

	/**
	 * This is a getter method for retrieving the recordId field.
	 * @return Long - recordId
	 */
	public Long getRecordId() {
		return recordId;
	}

	/**
	 * This is a setter method for setting the recordId field.
	 * @param Long - recordId
	 */
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	/**
	 * This is a getter method for retrieving the active field.
	 * @return String - active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * This is a setter method for setting the active field.
	 * @param String - active
	 */
	public void setActive(String active) {
		this.active = active;
	}

}
