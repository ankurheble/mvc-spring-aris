package com.arisglobal.regulatory.team1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.arisglobal.regulatory.team1.entity.common.GenericEntity;

/**
 * Copyright  1995-2014 PharmApps, LLC.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
 * Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
 * Created On  : 03-Nov-2015
 * Description : This is the Entity class for the Product module which derives recordId and active from GenericEntity.
 */
@Entity
@Table(name = "PRODUCT")
public class Product extends GenericEntity{


	@Column(name = "PRODUCT_ID")
	private String productId;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "REMARKS")
	private String remarks;
	@Column(name = "ADMINISTRABLE_DOSE_FORM")
	private String administrableDoseForm;

	@OneToOne
	@JoinColumn(name = "PRODUCT_FAMILY")
	private ProductFamily productFamily;

	@Transient
	private Long referenceProductFamilyId;

	@Transient
	private String referenceProductFamilyName;

	@OneToOne
	@JoinColumn(name = "MAIN_INGREDIENT")
	private Substance mainIngredient;

	@Transient
	private Long referenceSubstanceId;

	@Transient
	private String referenceSubstanceName;

	/**
	 * This is a getter method for retrieving the referenceProductFamilyId field.
	 * @return Long - referenceProductFamilyId
	 */
	public Long getReferenceProductFamilyId() {
		if(productFamily!=null){
			return productFamily.getRecordId();
		}else{
			return null;
		}
	}
	
	/**
	 * This is a setter method for setting the referenceProductFamilyId field.
	 * @param Long - referenceProductFamilyId
	 */
	public void setReferenceProductFamilyId(Long referenceProductFamilyId) {
		this.referenceProductFamilyId = referenceProductFamilyId;
	}
	
	/**
	 * This is a getter method for retrieving the referenceProductFamilyName field.
	 * @return String - referenceProductFamilyName
	 */
	public String getReferenceProductFamilyName() {
		if(productFamily!=null){
			return productFamily.getProductFamilyName();
		}else{
			return "";
		}
	}
	
	/**
	 * This is a setter method for setting the referenceProductFamilyName field.
	 * @param String - referenceProductFamilyName
	 */
	public void setReferenceProductFamilyName(String referenceProductFamilyName) {
		this.referenceProductFamilyName = referenceProductFamilyName;
	}
	
	/**
	 * This is a setter method for setting the productFamily field.
	 * @param ProductFamily - productFamily
	 */
	public void setProductFamily(ProductFamily productFamily) {
		this.productFamily = productFamily;
	}

	/**
	 * This is a getter method for retrieving the referenceSubstanceId field.
	 * @return Long - referenceSubstanceId
	 */
	public Long getReferenceSubstanceId() {
		if(mainIngredient!=null){
			return mainIngredient.getRecordId();
		}else{
			return null;
		}
	}
	
	/**
	 * This is a setter method for setting the referenceSubstanceId field.
	 * @param Long - referenceSubstanceId
	 */
	public void setReferenceSubstanceId(Long referenceSubstanceId) {
		this.referenceSubstanceId = referenceSubstanceId;
	}
	
	/**
	 * This is a getter method for retrieving the referenceSubstanceName field.
	 * @return String - referenceSubstanceName
	 */
	public String getReferenceSubstanceName() {
		if(mainIngredient!=null){
			return mainIngredient.getIngredientName();
		}else{
			return "";
		}
	}
	
	/**
	 * This is a setter method for setting the referenceSubstanceName field.
	 * @param String - referenceSubstanceName
	 */
	public void setReferenceSubstanceName(String referenceSubstanceName) {
		this.referenceSubstanceName = referenceSubstanceName;
	}
	
	/**
	 * This is a getter method for retrieving the administrableDoseForm field.
	 * @return String - administrableDoseForm
	 */
	public String getAdministrableDoseForm() {
		return administrableDoseForm;
	}
	
	/**
	 * This is a setter method for setting the administrableDoseForm field.
	 * @param String - administrableDoseForm
	 */
	public void setAdministrableDoseForm(String administrableDoseForm) {
		this.administrableDoseForm = administrableDoseForm;
	}
	
	/**
	 * This is a getter method for retrieving the mainIngredient field.
	 * @return Substance - mainIngredient
	 */
	public Substance getMainIngredient() {
		return mainIngredient;
	}
	
	/**
	 * This is a setter method for setting the mainIngredient field.
	 * @param Substance - mainIngredient
	 */
	public void setMainIngredient(Substance mainIngredient) {
		this.mainIngredient = mainIngredient;
	}
	
	/**
	 * This is a getter method for retrieving the productId field.
	 * @return String - productId
	 */
	public String getProductId() {
		return productId;
	}
	
	/**
	 * This is a setter method for setting the productId field.
	 * @param String - productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	/**
	 * This is a getter method for retrieving the productName field.
	 * @return String - productName
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * This is a setter method for setting the productName field.
	 * @param String - productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * This is a getter method for retrieving the description field.
	 * @return String - description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * This is a setter method for setting the description field.
	 * @param String - description
	 */
	public void setDescription(String description) {
		this.description = description;
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
