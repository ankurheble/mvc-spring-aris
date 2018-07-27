package com.arisglobal.regulatory.team1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * Created On  : 28-Oct-15
 * Description : This is the Entity class for the Product module which derives recordId and active from GenericEntity.
 */
@Entity
@Table(name = "SUBSTANCE")
public class Substance extends GenericEntity  {

	@Column(name = "INGREDIENT_ID")
	private String ingredientId;

	@Column(name = "INGREDIENT_NAME")
	private String ingredientName;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "REFERENCE_SUBSTANCE")
	private Substance referenceSubstance;
	
	@Transient
	private Long referenceSubstanceId;
	
	@Transient
	private String referenceSubstanceName;

	@Column(name = "LANGUAGE")
	private String language;

	@Column(name = "ACTIVE_INGREDIENT")
	private int activeIngredient;

	@Column(name = "ADJUVANT")
	private int adjuvant;

	@Column(name = "MATERIAL")
	private int material;

	@Column(name = "ALT_MATERIAL")
	private int alternateMaterial;

	@Transient
	private int allCheck;

	/**
	 * This is a getter method for retrieving the activeIngredient field.
	 * @return int - activeIngredient
	 */
	public int getActiveIngredient() {
		return activeIngredient;
	}

	/**
	 * This is a setter method for setting the activeIngredient field.
	 * @param int - activeIngredient
	 */
	public void setActiveIngredient(int activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

	/**
	 * This is a getter method for retrieving the adjuvant field.
	 * @return int - adjuvant
	 */
	public int getAdjuvant() {
		return adjuvant;
	}

	/**
	 * This is a setter method for setting the adjuvant field.
	 * @param int - adjuvant
	 */
	public void setAdjuvant(int adjuvant) {
		this.adjuvant = adjuvant;
	}

	/**
	 * This is a getter method for retrieving the material field.
	 * @return int - material
	 */
	public int getMaterial() {
		return material;
	}

	/**
	 * This is a setter method for setting the material field.
	 * @param int - material
	 */
	public void setMaterial(int material) {
		this.material = material;
	}

	/**
	 * This is a getter method for retrieving the alternateMaterial field.
	 * @return int - alternateMaterial
	 */
	public int getAlternateMaterial() {
		return alternateMaterial;
	}

	/**
	 * This is a setter method for setting the alternateMaterial field.
	 * @param int - alternateMaterial
	 */
	public void setAlternateMaterial(int alternateMaterial) {
		this.alternateMaterial = alternateMaterial;
	}

	/**
	 * This is a getter method for retrieving the allCheck field.
	 * @return int - allCheck
	 */
	public int getAllCheck() {
		if(this.activeIngredient==1 && this.adjuvant==1 && this.material==1 && this.alternateMaterial==1){
			return 1;
		}else{
			return 0;
		}
	}

	/**
	 * This is a setter method for setting the allCheck field.
	 * @param int - allCheck
	 */
	public void setAllCheck(int allCheck) {
		this.allCheck = allCheck;
	}

	/**
	 * This is a getter method for retrieving the ingredientId field.
	 * @return String - ingredientId
	 */
	public String getIngredientId() {
		return ingredientId;
	}

	/**
	 * This is a setter method for setting the ingredientId field.
	 * @param String - ingredientId
	 */
	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}

	/**
	 * This is a getter method for retrieving the ingredientName field.
	 * @return String - ingredientName
	 */
	public String getIngredientName() {
		return ingredientName;
	}

	/**
	 * This is a setter method for setting the ingredientName field.
	 * @param String - ingredientName
	 */
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}


	/**
	 * This is a getter method for retrieving the language field.
	 * @return String - language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * This is a setter method for setting the language field.
	 * @param String - language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * This is a getter method for retrieving the referenceSubstance field.
	 * @return Substance - referenceSubstance
	 */
	public Substance getReferenceSubstance() {
		return referenceSubstance;
	}

	/**
	 * This is a setter method for setting the referenceSubstance field.
	 * @param Substance - referenceSubstance
	 */
	public void setReferenceSubstance(Substance referenceSubstance) {
		this.referenceSubstance = referenceSubstance;
	}

	/**
	 * This is a getter method for retrieving the referenceSubstanceId field.
	 * @return Long - referenceSubstanceId
	 */
	public Long getReferenceSubstanceId() {
		if(referenceSubstance!=null){
			return referenceSubstance.getRecordId();
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
		if(referenceSubstance!=null){
			return referenceSubstance.getIngredientName();
		}else{
			return null;
		}
	}

	/**
	 * This is a setter method for setting the referenceSubstanceName field.
	 * @param String - referenceSubstanceName
	 */
	public void setReferenceSubstanceName(String referenceSubstanceName) {
		this.referenceSubstanceName = referenceSubstanceName;
	}
	
}