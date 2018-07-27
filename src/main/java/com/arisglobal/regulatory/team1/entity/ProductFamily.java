package com.arisglobal.regulatory.team1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.arisglobal.regulatory.team1.entity.common.GenericEntity;

/**
 * Copyright  1995-2014 PharmApps, LLC.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
 * Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
 * Created On  : 26-Oct-2015
 * Description : This is the Entity class for the Product Family module which derives recordId and active from GenericEntity.
 */
@Entity
@Table(name = "PRODUCT_FAMILY")
public class ProductFamily extends GenericEntity {
	
	@Column(name = "PRODUCT_FAMILY_UID")
	private String productFamilyId;
	@Column(name = "PRODUCT_FAMILY_NAME")
	private String productFamilyName;
	@Column(name = "REMARKS")
	private String remarks;

	/**
	 * This is a getter method for retrieving the productFamilyId field.
	 * @return String - productFamilyId
	 */
	public String getProductFamilyId() {
		return productFamilyId;
	}

	/**
	 * This is a setter method for setting the productFamilyId field.
	 * @param String - productFamilyId
	 */
	public void setProductFamilyId(String productFamilyId) {
		this.productFamilyId = productFamilyId;
	}

	/**
	 * This is a getter method for retrieving the productFamilyName field.
	 * @return String - productFamilyName
	 */
	public String getProductFamilyName() {
		return productFamilyName;
	}

	/**
	 * This is a setter method for setting the productFamilyName field.
	 * @param String - productFamilyName
	 */
	public void setProductFamilyName(String productFamilyName) {
		this.productFamilyName = productFamilyName;
	}

	/**
	 * This is a getter method for retrieving the remarks field.
	 * @return String - remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * This is a setter method for setting the remarks field.
	 * @param String - remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
