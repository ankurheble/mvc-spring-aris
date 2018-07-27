package com.arisglobal.regulatory.team1.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.arisglobal.regulatory.team1.entity.Product;
import com.arisglobal.regulatory.team1.entity.ProductFamily;
import com.arisglobal.regulatory.team1.entity.Substance;
import com.arisglobal.regulatory.team1.entity.UserDetails;
import com.arisglobal.regulatory.team1.entity.common.GenericEntity;
import com.arisglobal.regulatory.team1.service.GenericService;

/**
 * Copyright  1995-2014 ArisGlobal, LLC.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of ArisGlobal, Inc. ("Confidential Information").
 * Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
 * Created On  : 26-Oct-2015
 * Description : This class acts as a Controller for handling all the requests.
 */
@Controller
public class ViewController {

	private static final String DELETE_INFO_MESSAGE = "Record deleted Successfully.";
	private static final String SAVE_INFO_MESSAGE = "Record saved Successfully.";
	private static final String SELECT_RECORD_MESSAGE = "Please Select a Record to Delete.";
	private static final String GENERAL_SAVE_ERROR_INFO_MESSAGE = "Error occured while saving the data.Please try again later.";
	private static final String GENERAL_DELETE_ERROR_INFO_MESSAGE = "Error occured while deleting the data.Please try again later.";
	private static final String DELETE_REFERENCE_MESSAGE = "Record cannot be deleted as it is referred in other part of application.";
	private static final String GENERAL_EXPORT_ERROR = "Please create product before generating XML.";
	private GenericService genericService;  
	
	/**
	 * This is a request handler method for adding Product Family entities.
	 * @param request - HttpServletRequest object
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/addProductFamily")
	public ModelAndView addProductFamily(HttpServletRequest request) {
		ProductFamily productFamily = new ProductFamily();
		productFamily.setProductFamilyId("PF-" + genericService.getNextValueFromSequence("PRODUCT_FAMILY_SEQ"));
		productFamily.setActive("Yes");
		return new ModelAndView("resources/pages/productfamily/product_family_form_view.jsp","productFamily", productFamily);
	}
	
	/**
	 * This is a request handler method for saving Product Family entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/saveProductFamily")
	public ModelAndView saveProductFamily(HttpServletRequest request) {
		ProductFamily productFamily;
		String recordId = request.getParameter("recordId");
		if(recordId!=null && recordId.length()>0){
			productFamily =(ProductFamily) genericService.find(Long.parseLong(recordId), ProductFamily.class);	
		}else{
			productFamily = new ProductFamily();
		}

		productFamily.setProductFamilyId(request.getParameter("productFamilyId"));
		productFamily.setProductFamilyName(request.getParameter("productFamilyName"));
		productFamily.setRemarks(request.getParameter("remarks"));
		productFamily.setActive(request.getParameter("active"));
		String message = "";
		try{
			productFamily=(ProductFamily) genericService.save(productFamily);
			message = SAVE_INFO_MESSAGE;			
		}catch(Exception e){
			String error = e.toString();
			if(error.indexOf("PRD_FAMILY_UK_PRD_FAMILY_NAME")>=0){
				message = "Product Family Name Should be unique.";
			}else if(error.indexOf("PRD_FAMILY_UK_PRD_FAMILY_UID")>=0){
				message ="Product Family Id Should be unique.";
			}else{
				message =GENERAL_SAVE_ERROR_INFO_MESSAGE ;
			}
		}
		ModelAndView modelAndView =new ModelAndView("resources/pages/productfamily/product_family_form_view.jsp","productFamily", productFamily);
		modelAndView.addObject("message", message); // adding one more object to display
		return modelAndView;
	}

	/**
	 * This is a request handler method for listing Product Family entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/listProductFamily")
	public ModelAndView listProductFamily(HttpServletRequest request) {
		return new ModelAndView("resources/pages/productfamily/product_family_list_view.jsp","productFamilyList", genericService.getAllRecords("ProductFamily", GenericEntity.class));
	}

	/**
	 * This is a request handler method for editing Product Family entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView 
	 */
	@RequestMapping(value = "/editProductFamily")
	public ModelAndView editProductFamily(HttpServletRequest request) {
		return new ModelAndView("resources/pages/productfamily/product_family_form_view.jsp","productFamily", (ProductFamily) genericService.find(Long.parseLong(request.getParameter("recordId")), ProductFamily.class));
	}

	/**
	 * This is a request handler method for deleting  list of Product Family entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/deleteProductFamilyList")
	public ModelAndView deleteProductFamily(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("listProductFamily.html","message", DELETE_INFO_MESSAGE);
		String deleteList[] = request.getParameterValues("selectedProductFamily");
		if (deleteList != null && deleteList.length>0) {
			try {
				genericService.deleteList(deleteList, ProductFamily.class);
				modelAndView.addObject("message", DELETE_INFO_MESSAGE);
			} catch (Exception e) {
				String error=e.getMessage();
				if(error.indexOf("PRD_FK_PRD_FAMILY")>0)
				{
					modelAndView.addObject("message",DELETE_REFERENCE_MESSAGE);
				}
				else{
					modelAndView.addObject("message",GENERAL_DELETE_ERROR_INFO_MESSAGE);	
				}
			}
		} else {
			modelAndView.addObject("message", SELECT_RECORD_MESSAGE);
		}
		return modelAndView;
	}
	
		
	/**
	 * This is a request handler method for listing Product Family entities as a lookup.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/listProductFamilyLookUp")
	public ModelAndView listProductFamilyLookUp(HttpServletRequest request) {
		return new ModelAndView("resources/pages/productfamily/product_family_lookup.jsp","productFamilyList", genericService.getAllRecords("ProductFamily", GenericEntity.class));
	}

	/**
	 * This is a request handler method for searching Product Family entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/searchProductFamilyRecord")
	public ModelAndView searchProductFamilyRecord(HttpServletRequest request) {
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("productFamilyId");
		fieldList.add("productFamilyName");
		ModelAndView modelAndView =new ModelAndView("resources/pages/productfamily/product_family_list_view.jsp","productFamilyList", genericService.getRecords("ProductFamily", fieldList, request.getParameter("searchKey"), GenericEntity.class));
		modelAndView.addObject("message", "");
		return modelAndView; 
	}
	
	/**
	 * This is a request handler method for adding Substance entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/addSubstance")
	public ModelAndView addSubstance(HttpServletRequest request) {
		Substance substance = new Substance();
		substance.setIngredientId("SUB-" + genericService.getNextValueFromSequence("SUBSTANCE_SEQ"));
		substance.setActive("Yes");
		return new ModelAndView("resources/pages/substance/substance_form_view.jsp","substance", substance);
	}

	/**
	 * This is a request handler method for saving Substance entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/saveSubstance")
	public ModelAndView saveSubstance(HttpServletRequest request) {
		Substance substance= null;
		String recordId = request.getParameter("recordId");
		String categoryList[] = request.getParameterValues("substanceCategory");
		if(recordId!=null && recordId.length()>0){
			substance =(Substance) genericService.find(Long.parseLong(recordId), Substance.class);	
		}else{
			substance = new Substance();
		}

		substance.setIngredientId(request.getParameter("ingredientId"));
		substance.setIngredientName(request.getParameter("ingredientName"));
		substance.setActive(request.getParameter("active"));
		substance.setLanguage(request.getParameter("language"));
		if(categoryList!=null){
			for(String s:categoryList){
				if(s.equals("activeIngredient")){
					substance.setActiveIngredient(1);
				}else if(s.equals("adjuvant")){
					substance.setAdjuvant(1);
				}else if(s.equals("material")){
					substance.setMaterial(1);
				}else if(s.equals("alt_material")){
					substance.setAlternateMaterial(1);
				}
			}
		}
		
		if(request.getParameter("referenceSubstanceId")!=null && !"".equals(request.getParameter("referenceSubstanceId"))){
			substance.setReferenceSubstance((Substance) genericService.find(Long.parseLong(request.getParameter("referenceSubstanceId")), Substance.class));
			}
		ModelAndView modelAndView=null;
		try{
			substance=(Substance) genericService.save(substance);
			modelAndView= new ModelAndView("resources/pages/substance/substance_form_view.jsp","substance", substance);
			modelAndView.addObject("message", SAVE_INFO_MESSAGE);
		}catch(Exception e){
			String error = e.toString();
			modelAndView= new ModelAndView("resources/pages/substance/substance_form_view.jsp","substance", substance);
			if(error.indexOf("SUBSTANCE_UK_INGREDIENT_NAME")>=0){
				modelAndView.addObject("message", "Substance name Should be unique.");
			}else if(error.indexOf("SUBSTANCE_UK_INGREDIENT_ID")>=0){
				modelAndView.addObject("message", "Substance Id Should be unique.");
			}else if(error.indexOf("SUBSTANCE_FK_REF_SUB")>=0){
				modelAndView.addObject("message", "Substance with this Primary key does not exist.");
			}
		}
		return modelAndView;
	}

	/**
	 * This is a request handler method for listing Substance entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/listSubstance")
	public ModelAndView listSubstance(HttpServletRequest request) {
		Substance substance =(Substance) request.getAttribute("substance");
		ModelAndView modelAndView = new ModelAndView("resources/pages/substance/substance_list_view.jsp","substanceList", genericService.getAllRecords("Substance", GenericEntity.class));
		modelAndView.addObject("substance", substance);
		return modelAndView;
	}

	/**
	 * This is a request handler method for deleting list of Substance entities.
	 * @param HttpServletRequest - request     
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/deleteSubstanceList")
	public ModelAndView deleteSubstance(HttpServletRequest request) {
		String deleteList[] = request.getParameterValues("selectedSubstance");
		ModelAndView modelAndView = new ModelAndView("listSubstance.html");
		if (deleteList != null && deleteList.length>0) {
			try{
				genericService.deleteList(deleteList,Substance.class);
				modelAndView.addObject("message", DELETE_INFO_MESSAGE);
			}catch(Exception e){
				String error=e.toString();
				if(error.indexOf("SUBSTANCE_FK_REF_SUB")>=0){
					modelAndView.addObject("message", DELETE_REFERENCE_MESSAGE);	
				}else if(error.indexOf("PRD_FK_MAIN_INGR")>0){
					modelAndView.addObject("message",DELETE_REFERENCE_MESSAGE);
				}else{
					modelAndView.addObject("message", GENERAL_DELETE_ERROR_INFO_MESSAGE);
				}
			}
		}else{
			modelAndView.addObject("message", SELECT_RECORD_MESSAGE);	
		}
		return modelAndView;
	}
	/**
	 * This is a request handler method for editing Substance entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/editSubstance")
	public ModelAndView editSubstance(HttpServletRequest request) {
		return new ModelAndView("resources/pages/substance/substance_form_view.jsp","substance", (Substance) genericService.find(Long.parseLong(request.getParameter("recordId")), Substance.class));
	}

	/**
	 * This is a request handler method for listing Substance entities as a lookup.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/listSubstanceLookUp")
	public ModelAndView listSubstanceLookUp(HttpServletRequest request) {
		return new ModelAndView("resources/pages/substance/substance_reference_lookup.jsp","substanceList", genericService.getAllRecords("Substance", GenericEntity.class));
	}

	/**
	 * This is a request handler method for searching Substance entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/searchSubstanceRecord")
	public ModelAndView searchSubstanceRecord(HttpServletRequest request) {
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("ingredientId");
		fieldList.add("ingredientName");
		fieldList.add("language");
		return new ModelAndView("resources/pages/substance/substance_list_view.jsp","substanceList", genericService.getRecords("Substance",fieldList,request.getParameter("searchKey"), GenericEntity.class));
	}
	
	/**
	 * This is a request handler method for adding Product entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/addProduct")
	public ModelAndView addProduct(HttpServletRequest request) {
		Product product = new Product();
		product.setProductId("PRD-" + genericService.getNextValueFromSequence("PRODUCT_SEQ"));
		product.setActive("Yes");
		return new ModelAndView("resources/pages/product/product_form_view.jsp","product", product);
	}

	/**
	 * This is a request handler method for saving Product entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/saveProduct")
	public ModelAndView saveProduct(HttpServletRequest request) {
		Product product = null;
		String recordId = request.getParameter("recordId");
		if(recordId!=null && recordId.length()>0){
			product =(Product) genericService.find(Long.parseLong(recordId), Product.class);	
		}else{
			product = new Product();
		}

		product.setProductId(request.getParameter("productId"));
		product.setProductName(request.getParameter("productName"));
		product.setRemarks(request.getParameter("remarks"));
		product.setDescription(request.getParameter("description"));
		product.setActive(request.getParameter("active"));
		product.setAdministrableDoseForm(request.getParameter("administrable_dose_form"));
		
		if(request.getParameter("referenceSubstanceId")!=null && !"".equals(request.getParameter("referenceSubstanceId"))){
		product.setMainIngredient((Substance) genericService.find(Long.parseLong(request.getParameter("referenceSubstanceId")), Substance.class));
		}
		
		if(request.getParameter("referenceProductFamilyId")!=null && !"".equals(request.getParameter("referenceProductFamilyId"))){
			product.setProductFamily((ProductFamily) genericService.find(Long.parseLong(request.getParameter("referenceProductFamilyId")), ProductFamily.class));
		}
		
		ModelAndView modelAndView=null;
		try{
			product=(Product) genericService.save(product);
			modelAndView= new ModelAndView("resources/pages/product/product_form_view.jsp","product", product);
			modelAndView.addObject("message", SAVE_INFO_MESSAGE);
		}catch(Exception e){
			String error = e.toString();
			modelAndView= new ModelAndView("resources/pages/product/product_form_view.jsp","product", product);
			if(error.indexOf("PRD_FAMILY_UK_PRD_FAMILY_NAME")>=0){
				modelAndView.addObject("message", "Product name Should be unique.");
			}else if(error.indexOf("PRD_FAMILY_UK_PRD_FAMILY_UID")>=0){
				modelAndView.addObject("message", "Product Id Should be unique.");
			}
		}
		return modelAndView;
	}

	/**
	 * This is a request handler method for listing Product entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/listProduct")
	public ModelAndView listProduct(HttpServletRequest request) {
		return new ModelAndView("resources/pages/product/product_list_view.jsp","productList", genericService.getAllRecords("Product", GenericEntity.class));
	}

	/**
	 * This is a request handler method for deleting list of Product entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/deleteProductList")
	public ModelAndView deleteProduct(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("listProduct.html","message", DELETE_INFO_MESSAGE);
		String deleteList[] = request.getParameterValues("selectedProduct");
		if (deleteList != null && deleteList.length>0)  {
			try {
				genericService.deleteList(deleteList, Product.class);
				modelAndView.addObject("message", DELETE_INFO_MESSAGE);
			} catch (Exception e) {
				modelAndView.addObject("message",GENERAL_DELETE_ERROR_INFO_MESSAGE);
			}
		} else {
			modelAndView.addObject("message", SELECT_RECORD_MESSAGE);
		}
		return modelAndView;
	}

	/**
	 * This is a request handler method for editing Product entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/editProduct")
	public ModelAndView editProduct(HttpServletRequest request) {
		return new ModelAndView("resources/pages/product/product_form_view.jsp","product", (Product) genericService.find(Long.parseLong(request.getParameter("recordId")), Product.class));
	}

	/**
	 * This is a request handler method for searching Product entities.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/searchProductRecord")
	public ModelAndView searchProductRecord(HttpServletRequest request) {
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("productId");
		fieldList.add("productName");
		fieldList.add("administrableDoseForm");
		return new ModelAndView("resources/pages/product/product_list_view.jsp","productList", genericService.getRecords("Product", fieldList, request.getParameter("searchKey"), GenericEntity.class));
	}

	/**
	 * This is a request handler method for deleting Product entity.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/deleteProduct")
	public ModelAndView deleteSingleProduct(HttpServletRequest request) {
		if(null!=request.getParameter("id") && !"".equals(request.getParameter("id"))){
		genericService.delete(Long.parseLong(request.getParameter("id")), Product.class);
		}
		return new ModelAndView("listProduct.html","message", DELETE_INFO_MESSAGE);
	}

	/**
	 * This is a request handler method for deleting Product Family entity.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/deleteProductFamily")
	public ModelAndView deleteSingleProductFamily(HttpServletRequest request) {
		if(null!=request.getParameter("id") && !"".equals(request.getParameter("id"))){
		genericService.delete(Long.parseLong(request.getParameter("id")), ProductFamily.class);
		}
		return new ModelAndView("listProductFamily.html","message", DELETE_INFO_MESSAGE);
	}

	/**
	 * This is a request handler method for deleting Substance entity.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/deleteSubstance")
	public ModelAndView deleteSingleSubstance(HttpServletRequest request) {
		String recordId = request.getParameter("recordId");
		ModelAndView modelAndView = new ModelAndView("listSubstance.html");
		if(null!=recordId && !"".equals(recordId)){
			try {
				genericService.delete(Long.parseLong(recordId), Substance.class);
				modelAndView.addObject("message", DELETE_INFO_MESSAGE);
			} catch (Exception e) {
				String error=e.toString();
				 if(error.indexOf("SUBSTANCE_FK_REF_SUB")>=0){
					modelAndView.addObject("message", DELETE_REFERENCE_MESSAGE);	
				}else{
					modelAndView.addObject("message", GENERAL_DELETE_ERROR_INFO_MESSAGE);
				}
			}
		}

		
		return modelAndView;
	}
	
	/**
	 * This is a request handler method for authenticating valid Users.
	 * @param HttpServletRequest - request
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/authenticateUser")
	public ModelAndView authenticateUser(HttpServletRequest request) {
		UserDetails userDetails = genericService.authenticateUser(request.getParameter("username"), request.getParameter("password"));
		HttpSession session = request.getSession();
		if(userDetails!=null){
			session.setAttribute("username", userDetails.getUsername());
			return new ModelAndView("resources/pages/common/app_index.jsp","userDetails",userDetails);			
		}else if(request.getParameter("logout")!=null){
			if(request.getParameter("logout").equals("Logout")){
			session.invalidate();
			}
			return new ModelAndView("resources/pages/common/log_out.jsp");
		}else{
			return new ModelAndView("resources/pages/common/login.jsp","invalidUser","Please enter valid username and password");
		}
	}
	
	/**
	 * This is a request handler method for exporting Product entities to XML.
	 * @param request - HttpServletRequest object
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/exportProduct")
	public ModelAndView exportProduct(HttpServletRequest request) {
		Long recordId=null;
		if(request.getParameter("recordId")!=null && !"".equals(request.getParameter("recordId"))){
		recordId = Long.parseLong(request.getParameter("recordId"));
		}
		ModelAndView modelAndView =new ModelAndView("resources/pages/product/product_form_view.jsp","message","Exported Successfully");
		Product productObject=null;
		try {
			productObject = (Product) genericService.find(recordId, Product.class);
		}catch(IllegalArgumentException e){
			modelAndView.addObject("message",GENERAL_EXPORT_ERROR);
		}
		
		try{
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			
			Element products = doc.createElement("Products");
			doc.appendChild(products);
			
			Element product = doc.createElement("Product");
			products.appendChild(product);
			
			Element productId = doc.createElement("ProductId");
			product.appendChild(productId);
			productId.setTextContent(productObject.getProductId());
			
			Element productName = doc.createElement("ProductName");
			product.appendChild(productName);
			productName.setTextContent(productObject.getProductName());
			
			Element active= doc.createElement("Active");
			product.appendChild(active);
			active.setTextContent(productObject.getActive());
			
			Element remarks= doc.createElement("Remarks");
			product.appendChild(remarks);
			remarks.setTextContent(productObject.getRemarks());
			
			Element referencedProductFamilyId= doc.createElement("ReferencedProductFamilyId");
			product.appendChild(referencedProductFamilyId);
			referencedProductFamilyId.setTextContent(productObject.getReferenceProductFamilyId().toString());
			
			Element referencedProductFamilyName= doc.createElement("ReferencedProductFamilyName");
			product.appendChild(referencedProductFamilyName);
			referencedProductFamilyName.setTextContent(productObject.getReferenceProductFamilyName());
			
			Element referencedSubstanceId= doc.createElement("ReferencedSubstanceId");
			product.appendChild(referencedSubstanceId);
			referencedSubstanceId.setTextContent(productObject.getReferenceSubstanceId().toString());
			
			Element referencedSubstanceName= doc.createElement("ReferencedSubstanceName");
			product.appendChild(referencedSubstanceName);
			referencedSubstanceName.setTextContent(productObject.getReferenceSubstanceName());
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\product.xml"));
			transformer.transform(source, result);

		}catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (TransformerException tfe) {
			tfe.printStackTrace();
		}catch(Exception e){
			modelAndView.addObject("message",GENERAL_EXPORT_ERROR);
		}
		
		modelAndView.addObject("product", productObject);
		return modelAndView;
	}
	
	/**
	 * This is a request handler method for exporting List of Product entities to XML.
	 * @param request - HttpServletRequest object
	 * @return ModelAndView - modelAndView
	 */
	@RequestMapping(value = "/exportProductList")
	public ModelAndView exportProductList(HttpServletRequest request) {
		List<GenericEntity> productListObject = genericService.getAllRecords("Product", GenericEntity.class);
		ModelAndView modelAndView =new ModelAndView("resources/pages/product/product_list_view.jsp","message","Exported Successfully");
		try{
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			
			Element products = doc.createElement("Products");
			doc.appendChild(products);
			
			for(GenericEntity genericEntity : productListObject){
				
			Product productObject = (Product) genericEntity;
			Element product = doc.createElement("Product");
			products.appendChild(product);
			
			Element productId = doc.createElement("ProductId");
			product.appendChild(productId);
			productId.setTextContent(productObject.getProductId());
			
			Element productName = doc.createElement("ProductName");
			product.appendChild(productName);
			productName.setTextContent(productObject.getProductName());
			
			Element active= doc.createElement("Active");
			product.appendChild(active);
			active.setTextContent(productObject.getActive());
			
			Element remarks= doc.createElement("Remarks");
			product.appendChild(remarks);
			remarks.setTextContent(productObject.getRemarks());
			
			Element description= doc.createElement("Description");
			product.appendChild(description);
			description.setTextContent(productObject.getDescription());
			
			Element referencedProductFamilyId= doc.createElement("ReferencedProductFamilyId");
			product.appendChild(referencedProductFamilyId);
			referencedProductFamilyId.setTextContent(productObject.getReferenceProductFamilyId().toString());
			
			Element referencedProductFamilyName= doc.createElement("ReferencedProductFamilyName");
			product.appendChild(referencedProductFamilyName);
			referencedProductFamilyName.setTextContent(productObject.getReferenceProductFamilyName());
			
			Element referencedSubstanceId= doc.createElement("ReferencedSubstanceId");
			product.appendChild(referencedSubstanceId);
			referencedSubstanceId.setTextContent(productObject.getReferenceSubstanceId().toString());
			
			Element referencedSubstanceName= doc.createElement("ReferencedSubstanceName");
			product.appendChild(referencedSubstanceName);
			referencedSubstanceName.setTextContent(productObject.getReferenceSubstanceName());
			
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\productList.xml"));
			transformer.transform(source, result);

		}catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (TransformerException tfe) {
			tfe.printStackTrace();
		}catch(Exception e){
			modelAndView.addObject("message",GENERAL_EXPORT_ERROR);
		}
		modelAndView.addObject("productList", productListObject);
		return modelAndView;
	}
	
	/**
	 * This is a getter method for retrieving the genericService field.
	 * @return GenericService - genericService
	 */
	public GenericService getGenericService() {
		return genericService;
	}

	/**
	 * This is a setter method for setting the genericService field.
	 * @param GenericService - genericService
	 */
	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

}
