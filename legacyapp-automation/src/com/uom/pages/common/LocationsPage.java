/**
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 *																																		   	*
 * 2016-2017 Infosys Limited, Banglore, India. All Rights Reserved																			*
 * Version: 1.0																																*
 * 																																			*
 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
 * and will be prosecuted to the maximum extent possible under the law 																		*
 *																																			*
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 **/
package com.uom.pages.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.uom.pages.iOSPhone.IOSLocationsPage;


import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hamcrest.core.IsInstanceOf;
import org.openqa.selenium.By;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.uom.commonFunctions.FunctionLibrary;
import com.uom.pageFactory.PageFactory;
import com.uom.pages.androidPhone.AndroidLocationsPage;
import com.uom.pages.iOSTablet.IOSTabletLocationsPage;
import com.uom.yaml.ProductDetails;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

import com.framework.frameworkFunctions.*;
import com.framework.configuration.*;
import com.framework.reporting.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.stream.StaxErrorReporter;
import com.thoughtworks.selenium.webdriven.commands.GetText;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;



public class LocationsPage extends LibraryPage {

	static Field[] declaredMemberVariables;
	static{
		declaredMemberVariables = LocationsPage.class.getDeclaredFields();
	}


	public static final String COOLER = "Cooler";
	public static final String FREEZER = "Freezer";
	public static final String DRY = "Dry";

	public static final String NOLOCATION = "No Location";
	
	

	//new objects
	public static final String[] lbl_LocationsPage={"//*[contains(text(),'Locations')]",XPATH,"lbl_LocationsPage"};
	/*public static final String[] lbl_LocationCooler ={"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[1]",XPATH,"lbl_LocationCooler"};
	public static final String[] lbl_LocationFreezer = {"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[2]",XPATH,"lbl_LocationFreezer"};
	public static final String[] lbl_LocationDry ={"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[3]",XPATH,"lbl_LocationDry"};*/
	public static final String[] lbl_DefaultLocation ={"(//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[{dynamic1}]/ancestor::button",XPATH,"lbl_DefaultLocation"};
	//public static final String[] lst_Location={"//*[@id='list-item']//*[contains(text(),'{dynamic1}')]",XPATH,"lst_Location"};
	public static final String[] lst_Location={"//*[@id='list-item']//*[text()='{dynamic1}']/ancestor::button",XPATH,"lst_Location"};
	//public static final String[] lst_Location={"//span[@class='mm-c-simplelist__name' and contains(text(),'{dynamic1}')]]",XPATH,"lst_Location"};
	public static final String[] lst_LocationCount={"list-item",ID,"lst_Location"};
	public static final String[] lst_LocationName={"(//*[@id='list-item']//span[@class='mm-c-simplelist__name'])[{dynamic1}]",XPATH,"lst_LocationName"};
	public static final String[] lst_LocationItemCount={"(//*[@id='list-item']//span[@class='mm-c-simplelist__count'])[{dynamic1}]",XPATH,"lst_LocationName"};

	public static final String[] lbl_AddItemFromInventoryList ={"//*[contains(text(),'{dynamic1}')]",XPATH,"lbl_AddItemFromOrderGuide"};
	//

	//public static final String[] lbl_AddItemFromOrderGuide ={"//*[contains(text(),'Add From Order Guide')]",XPATH,"lbl_AddItemFromOrderGuide"};
	//public static final String[] lbl_AddItemFromNonSysco ={"//*[contains(text(),'Create Non-Sysco Item')]",XPATH,"lbl_AddItemFromNonSysco"};
	//public static final String[] lbl_AddItemFromPrep={"//*[contains(text(),'Create Prep Item')]",XPATH,"lbl_AddItemFromPrep"};
	//public static final String[] lbl_AddItemFromCustomList ={"//*[contains(text(),'Add From Custom List')]",XPATH,"lbl_AddItemFromCustomList"};

	public static final String[] lbl_ProductNames={"//div[contains(@class,'product-list__details')]//h4",XPATH,"lbl_ProductNames"};

	//public static final String[] lbl_Products={"(//div[@class='mm-c-product-list__image ']//a//img)[{dynamic1}]",XPATH,"lbl_Products"};
	public static final String[] lbl_Products={"(//div[@class='mm-c-product-list__details ']//a)[{dynamic1}]",XPATH,"lbl_ProductNames"};
	//public static final String[] lbl_Product={"//div[@class='mm-c-product-list__details ']//h4[contains(text(),'{dynamic1}')]/ancestor::div[2]//a",XPATH,"lbl_Product"};
	public static final String[] lbl_Product={"//div[@class='mm-c-product-list__details ']//h4[contains(text(),'{dynamic1}')]",XPATH,"lbl_Product"};

	//public static final String[] lbl_Products={"(//div[@class='mm-c-product-list__image ']//a//img)[{dynamic1}]",XPATH,"lbl_Products"};
	//public static final String[] lbl_Product={"(//div[@class='mm-c-product-list__details ']//h4[contains(text(),'{dynamic1}')]/ancestor::*)[19]//a",XPATH,"lbl_Product"};
	//public static final String[] lbl_Product={"//div[@class='mm-c-product-list__details ']//h4[contains(text(),'{dynamic1}')]/parent::*/a",XPATH,"lbl_Product"};
	//div[@class='mm-c-product-list__details ']//h4[contains(text(),'Salad Fresh Edamame')]/parent::*/a

	//public static final String[] lbl_Product={"(//div[@class='mm-c-product-list__details ']//h4[contains(text(),'{dynamic1}')]/ancestor::*)[19]//a",XPATH,"lbl_ProductNames"};

	//(//div[@class='mm-c-product-list__details ']//h4[contains(text(),'Milk Almond Vanilla')]/ancestor::*)[19]//a
	public static final String[] lbl_ProducIDs={"//div[contains(@class,'product-list__description')]/h6",XPATH,"lbl_ProducIDs"};
	public static final String[] lbl_LocationTitle={"//*[@class='navbar-brand']",XPATH,"lbl_LocationTitle"};
	//public static final String[] txt_Search={"//*[@placeholder='Search']",XPATH,"txt_Search"};
	public static final String[] txt_Search={"//*[@placeholder='Filter']",XPATH,"txt_Search"};
	public static final String[] txt_SearchInAddItemForm={"//*[@placeholder='Search']",XPATH,"txt_SearchInAddItem"};
	public static final String[] lst_SelectItemFromOrderGuide ={"(//*[@id='mount']//*[@class='item-input checkbox'])[1]",XPATH,"lst_SelectItemFromOrderGuide"};
	public static final String[] lbl_DeleteItemIcon ={"(//*[@class='mm-c-product-list__edit']//*[@class='mm-c-product-list__details-wrapper']//h4)[1]",XPATH,"lbl_DeleteItemIcon"};
	public static final String[] btn_DeleteLocationButton ={"//button[text()='Delete this location']",XPATH,"btn_DeleteItemButton"};
	public static final String[] lst_SelectItemFromSearchResults ={"(//*[@id='mount']//*[@class='item-input checkbox'])[1]",XPATH,"lst_SelectItemFromSearchResults"};

	//public static final String[] lbl_ItemListView={"//*[@class='Grid__innerScrollContainer']",XPATH,"lbl_ItemListView"};
	public static final String[] lbl_ItemListView={"//div[@class='ReactVirtualized__Grid__innerScrollContainer']",XPATH,"lbl_ItemListView"};


	public static final String[] lbl_NoProductsfound={"//*[@class='mm-c-product-list']//p",XPATH,"lbl_NoProductsfound"};

	//use ID if an element is having id attribute
	//public static final String[] txt_LocationName={"//*[@id='name']",XPATH,"txt_LocationName"};
	//public static final String[] lbl_LocationType ={"//*[@id='storage']",XPATH,"lbl_LocationType"};
	//public static final String[] lbl_UOM = {"(//*[@id='uom'])[1]",XPATH,"lbl_UOM"};
	public static final String[] txt_LocationName={"name",ID,"txt_LocationName"};
	public static final String[] lbl_LocationType ={"storage",ID,"lbl_LocationType"};
	public static final String[] lbl_UOMAttribute = {"uom",ID,"lbl_UOMAttribute"};

	//BELOW 3 LOCATORS NEEDS TO BE CONVERTED INTO 1 LOCATOR WITH DYNAMIC TEXT
	public static final String[] lst_LocationTypeCooler ={"//*[@class='radio']//*[@value='C']",XPATH,"lst_LocationTypeCooler"};
	public static final String[] lst_LocationTypeFreezer ={"//*[@class='radio']//*[@value='F']",XPATH,"lst_LocationTypeFreezer"};
	public static final String[] lst_LocationTypeDry ={"//*[@class='radio']//*[@value='D']",XPATH,"lst_LocationTypeDry"};

	//updated one - pls do not change below  2 objects - Periya
	public static final String[] rbtn_LocationType ={"//label[contains(text(),'{dynamic1}')]",XPATH,"rbtn_LocationType"};
	public static final String[] lst_LocationsList={"//*[@id='list-item']//*[text()='{dynamic1}']/ancestor::button",XPATH,"lst_LocationsList"};
	//public static final String[] lst_LocationsList={"//*[text()='{dynamic1}']",XPATH,"lst_LocationsList"};

	public static final String[] lbl_SearchedItem={"(//*[contains(@class,'mm-c-product-list__item mm-c-product__sysco')])[1]",XPATH,"lbl_SearchedItem"};	
	public static final String[] lbl_SearchedItemCustom={"(//*[contains(@class,'mm-c-product-list__item mm-c-product__custom')])[1]",XPATH,"lbl_SearchedItem"};	
	public static final String[] lbl_SelectSearchItem={"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'{dynamic1}')]",XPATH,"lbl_SelectSearchItem"};
	public static final String[] txt_EnterItemQuantity = {"(//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-u-input-highlight mm-c-product-list__qty form-control'])[{dynamic1}]",XPATH,"txt_EnterItemQuantity"};
	public static final String[] lbl_VerifyItemCategory = {"(//*[@class='mm-c-product-list__location']/h6)",XPATH,"lbl_VerifyItemCategory"};

	public static final String[] lbl_VerifyItemOnLocation={"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'{dynamic1}')]",XPATH,""};
	public static final String[] lbl_SyscoBrandedIndicator={"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'{dynamic1}')]/ancestor::div[@class='mm-c-product-list__details-wrapper']//*[@class='mm-o-icon icon-leaf-fill']",XPATH,""};
	public static final String[] lbl_SyscoNonBrandedIndicator={"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'{dynamic1}')]/ancestor::div[@class='mm-c-product-list__details-wrapper']//*[@class='mm-o-icon icon-leaf']",XPATH,""};
	public static final String[] lbl_ItemName={"//*[contains(@class,'mm-c-product-minlist__item')]//*[contains(text(),'{dynamic1}')]/parent::*/parent::*//input",XPATH,"lbl_ItemName"};
	//public static final String[] lbl_ItemName={"(//*[contains(@class,'mm-c-product-minlist__item')]//*[contains(text(),'{dynamic1}')]/ancestor::*)[12]/*[contains(@class,'mm-c-product-list__check-icon')]//*[contains(@class,'item-input checkbox')]//input",XPATH,"lbl_SelectSearchItem"};
	//Converting the below four locators into 1 locator with dynamic text
	//public static final String[] lst_UOMSelectCS = {"(//*[@id='uom']/option[1])[1]",XPATH,""};
	//public static final String[] lst_UOMSelectLB = {"(//*[@id='uom']/option[2])[1]",XPATH,""};
	//public static final String[] lst_UOMSelectEA = {"(//*[@id='uom']/option[3])[1]",XPATH,""};
	//public static final String[] lst_UOMSelectOZ = {"(//*[@id='uom']/option[4])[1]",XPATH,""};
	public static final String[] lst_UOMSelect = {"(//*[@id='uom']/option[{dynamic1}])[1]",XPATH,"lst_UOMSelect"};   // updated the correct xpath here

	public static final String[] lbl_AddItemFrom={"//*[contains(text(),'Add Item From')]",XPATH,"lbl_AddItemForm"};
	public static final String[] lbl_AddOrderGuide={"//*[contains(text(),'Add Order Guid')]",XPATH,"lbl_AddOrderGuide"};
	public static final String[] lbl_AddCustomList={"//*[contains(text(),'Add Custom Li')]",XPATH,"lbl_AddCustomList"};


	public static final String[] lbl_LocationDetailsPage={"//*[text()='Location Details']",XPATH,"lbl_LocationDetails"};
	public static final String[] btn_ViewItemInThisLocation={"view-button",ID,"btn_ViewItemInThisLocation"};
	public static final String[] lbl_AddLocationPage={"//*[text()='Add Location']",XPATH,"lbl_AddLocationPage"};
	public static final String[] lbl_ItemsInLocation={"//div[@class='mm-c-product-list']//div[contains(@class,'mm-c-product-list__item ')]",XPATH,"lbl_ItemsInLocation"};   
	public static final String[] lbl_LocationPage={"//span[@class='navbar-brand']/h3[text()='{dynamic1}']",XPATH,"lbl_LocationPage"};   

	public static final String[] lbl_SelectList={"//*[contains(text(),'Select List')]",XPATH,"lbl_SelectList"};


	public static final String[] lbl_ListName={"//*[contains(text(),'{dynamic1}')]",XPATH,"lbl_SelectList"};


	public static final String[] lbl_LocationDetailsName={"//UIATextField[@name='LOCATION NAME']",XPATH,"lbl_LocationDetailsName"};
	public static final String[] lbl_LocationDetailsType={"//UIATextField[@name='LOCATION TYPE']",XPATH,"lbl_LocationDetailsType"};
	public static final String[] lbl_DeleteConfirmationModalHeader ={"modal-title",ID,"lbl_DeleteConfirmationModaleHeader"};
	public static final String[] lbl_DeleteConfirmationModalBody ={"modal-body",ID,"lbl_DeleteConfirmationModalBody"};

	public static final String[] lbl_UOMAttributeInList = {"(//*[@id='uom'])[{dynamic1}]",XPATH,"lbl_UOMAttributeInList"};
	//arun-1310
	public static final String[] lst_LocationQtyUOM={"//UIAElement[@value='{dynamic1}']",XPATH,"lst_LocationQtyUOM"};	
	public static final String[] btn_NativeList_Done= {"(//UIAButton[@name='Done'])[2]",XPATH,"btn_Done"};
	public static final String[] lst_nativeList= {"//UIAPicker[1]/UIAPickerWheel[1]",XPATH,"lst_nativeList"};
	public static final String[] lbl_UOMAttributeIOS= {"(//select[@id='uom'])[1]",XPATH,"lbl_UOMAttributeIOS"};

	//$x("(//select[@id='uom'])[1]")


	public static final String[] lbl_AddProduct={"//*[contains(text(),'Add Product')]",XPATH,"lbl_AddItemForm"};

	public static final String[] lbl_ProductDescription={"(//div[@class='mm-c-product-list__details ']//h4)[{dynamic1}]",XPATH,"lbl_ProductDescription"};
	public static final String[] img_ProductImage={"(//div[@class='mm-c-product-list__image ']//img)[{dynamic1}]",XPATH,"img_ProductImage"};
	public static final String[] lbl_ProductBrand={"(//div[@class='mm-c-product-list__brand']//h6)[{dynamic1}]",XPATH,"lbl_ProductBrand"};
	public static final String[] lbl_ProductID={"(//div[@class='mm-c-product-list__description']/h6[1])[{dynamic1}]",XPATH,"lbl_ProductID"};
	public static final String[] lbl_ProductPackOrSize={"(//div[contains(@class,'product-list__description')]/h6[2])[{dynamic1}]",XPATH,"lbl_ProductPackOrSize"};
	public static final String[] lbl_ProductCategory={"(//div[contains(@class,'mm-c-product-list__location')]/h6)[{dynamic1}]",XPATH,"lbl_ProductCategory"};
	//native element
	public static final String[] lst_DropdownOption={"//android.widget.CheckedTextView[@text='{dynamic1}']",XPATH,"lst_LocationOptions"};
	public static final String[] lst_DropdownOptions={"//android.widget.CheckedTextView[@index='{dynamic1}']",XPATH,"lst_LocationOptions"};



	public static final String[] lbl_KitchenOnboardingPage={"//div[@class='mm-c-help__content']",XPATH,"lbl_KitchenOnBoardingPage"};

	public static final String[] img_DeleteIcon={"//*[@class='mm-c-product-list__draggable-item']//h4[contains(text(),'{dynamic1}')]/ancestor::*[@class='mm-c-product-list__draggable-item']//div[@class='mm-c-product-list__edit']/div[1]/i",XPATH,"img_DeleteIcon"};

	public static final String[] btn_DeleteProduct ={"//*[@class='mm-u-delete__btn']",XPATH,"btn_DeleteProduct"};

	public static final String[] lbl_LocationValue={"(//*[contains(@class,'product-details__locations')]//*[contains(@class,'product-details__location disabled')]/span)[{dynamic1}]",XPATH,"lbl_LocationValue"};
	public static final String[] lbl_ExpenseCategoryValue={"//*[@id='expense-view']//*[contains(@class,'product-details__expense')]",XPATH,"lbl_ExpenseCategoryValue"};
	
	public static final String[] lbl_ExpenseCategory={"//h4[contains(text(),'{dynamic1}')]/ancestor::div[@class='mm-c-product-list__details ']//div[@class='mm-c-product-list__location']/h6",XPATH,"lbl_ExpenseCategory"};
	public static final String[] lbl_ProductNameByIndex={"(//div[contains(@class,'product-list__details')]//h4)[{dynamic1}]",XPATH,"lbl_ProductNames"};
	public static final String[] lbl_ProductExpenseCategory={"//h4[contains(text(),'{dynamic1}')]/ancestor::div[@class='mm-c-product-list__details ']//div[@class='mm-c-product-list__location']/h6[contains(text(),'dynamic2')]",XPATH,"lbl_ExpenseCategory"};
	public static final String[] lbl_Location={"(//*[contains(@class,'product-details__locations')]//*[contains(@class,'product-details__location disabled')]/span)",XPATH,"lbl_Location"};
	//h4[contains(text(),'Clam Stuffed Premium')]/ancestor::div[@class='mm-c-product-list__details ']//div[@class='mm-c-product-list__location']/h6

	public static final String[] btn_AllLocationsInList ={"//div[@class='mm-u-list__item']/button",XPATH,"btn_AllLocationsInList"};
	public static final String[] btn_FirstLocationInList ={"(//div[@class='mm-u-list__item']/button)[1]",XPATH,"btn_FirstLocationInList"}; // do not change



	public static final String[] lbl_CategoryProductDetailsPage ={"//span[@class='mm-c-product-details__expense']",XPATH,"lbl_CategoryProductDetailsPage"};
	public static final String[] lbl_PrdtNamesInNoLocations={"//div[@class='mm-c-product-list__details ']//h4",XPATH,"lbl_PrdtNamesInNoLocations"};


	public static final String[] txt_Quantity={"//*[contains(@class,'mm-c-product-list__item mm-c-product__sysco ')][{dynamic1}]//input",XPATH,"txt_Quantity"};

	public static final String[] lst_uom={"//*[contains(@class,'mm-c-product-list__item mm-c-product__sysco ')][{dynamic1}]//*[@class='mm-u-product-uom-wrapper form-group']//select",XPATH,"lbl_uom"};


	public static final String[] lbl_ProductIDNumber={"(//div[@class='mm-c-product-list__description']/h6[1])[{dynamic1}]",XPATH,"lbl_ProductIDNumber"};  // do not remove - no duplicate. added for specific purpose, only id number
	public static final String[] btn_FilterButton= {"//button[@id='filter-button']",XPATH,"btn_FilterButton"};
	public static final String[] txt_ItemQuantity= {"//input[@type='number']",XPATH,"txt_EnterItemQuantity"};
	
	public static final String[] lbl_InventoryListSelectedLineItem= {"(//div[@class='ReactVirtualized__Grid__innerScrollContainer']//div[contains(@class,'mm-c-product-list__item mm-c-product__sysco ')])[{dynamic1}]",XPATH,"lbl_InventoryListSelectedLineItem"};
	
	public static final String[] lbl_EditItemListPage= {"//div[@class='mm-c-product-list mm-c-product-list__draggable']",XPATH,"lbl_EditItemListPage"};
	public static final String[] lbl_EditItems= {"//li[@class='mm-c-product-list__draggable-item']",XPATH,"lbl_EditItems"};
	public static final String[] btn_RearrageIconForItem= {"(//li[@class='mm-c-product-list__draggable-item'])[{dynamic1}]//*[@class='mm-o-icon icon-menu']",XPATH,"btn_RearrageIconForItem"};
	public static final String[] btn_DeleteIconForItem= {"(//li[@class='mm-c-product-list__draggable-item'])[{dynamic1}]//*[@class='mm-c-product-list__delete-icon ']",XPATH,"btn_DeleteIconForItem"};
	
	public static final String[] lbl_DeleteConfirmationPopUp={"//div[@class='modal-content']",XPATH,"lbl_DeleteConfirmationPopUp"};
	
	public static final String[] img_ProductImagesInListPage={"//div[@class='mm-c-product-list__image ']//img",XPATH,"img_ProductImagesInListPage"};
	public static final String[] img_IndivialProductImageInListPage={"(//div[@class='mm-c-product-list__image ']//img)[{dynamic1}]",XPATH,"img_IndivialProductImageInListPage"};
	public static final String[] lbl_LineItemsInList= {"//div[@class='ReactVirtualized__Grid__innerScrollContainer']//div[contains(@class,'mm-c-product-list__item mm-c-product__sysco ')]",XPATH,"lbl_InventoryListSelectedLineItem"};
	
	/* Functions on the Page are defined below */

	
	public static Map< Object, String> productMap = new HashMap<Object, String>();
	
	public static final String[] lbl_ProductNameWithIndex={"(//div[@class='mm-c-product-list__details ']//a)[{dynamic1}]/h4",XPATH,"lbl_ProductNameWithIndex"};
	


	public static final String[] lbl_ProductFromListWithIndex={"(//div[@class='mm-c-product-minlist mm-c-product__sysco'])[{dynamic1}]//label",XPATH,"lbl_ProductFromListWithIndex"};

	public static final String[] lbl_ProductFromListItemNameWithIndex={"(//div[@class='mm-c-product-minlist mm-c-product__sysco'])[{dynamic1}]//div[@class='mm-c-product-minlist__item ']/h4",XPATH,"lbl_ProductFromListWithIndex"};
	public static final String[] lbl_ProductFromListItemIdWithIndex={"(//div[@class='mm-c-product-minlist mm-c-product__sysco'])[{dynamic1}]//div[@class='mm-c-product-minlist__details']/h6[1]",XPATH,"lbl_ProductFromListItemIdWithIndex"};


	/* Functions on the Page are defined below */





	/**
	 * @Function verifyLocationsInNoLocations
	 * @Description To verify whether products in NO LOCATIONS is having empty locations
	 * @author Arun Mathai
	 * @date 05-10-2016
	 */
	public void verifyLocationsInNoLocations()
	{
		switchToWebContext();
		int itemCount=getElementCount(lbl_ProductNames);
		boolean isTrue=true;
		System.out.println(""+itemCount);
		for (int i=1;i<=itemCount;i++) {
			switchToWebContext();
			clickElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
			if(!getElementText(replaceDynamicText(lbl_LocationValue, "1")).equals("")){
				System.out.println("Element Text "+getElementText(replaceDynamicText(lbl_LocationValue, "1")));
				isTrue=false;
			}					
			PageFactory pf =new PageFactory();
			pf.generic().tapClose();

		}
		if(isTrue){
			FrameworkReporter.pass("All products are having empty Locations and hence NO LOCATIONS is having the expected Products");
		}
		else{
			FrameworkReporter.fail("Some Products is having Locations and it should not be in NO LOCATIONS");
		}


	}





	/**
	 * @Function verifyItemsInNoLocations
	 * @Description To verify that the product name which is having location is not present in the NO Location
	 * @params-check the corresponding productname whether present in NO LOCATIONS
	 * @author Arun Mathai
	 * @date 05-10-2016
	 */
	public void verifyItemsInNoLocations(String PrdtName)
	{
		switchToWebContext();
		boolean flag=false;

		int count=getDriver().findElements(getLocatorsType(lbl_PrdtNamesInNoLocations)).size();	
		List<WebElement>webElementList= getDriver().findElements(getLocatorsType(lbl_PrdtNamesInNoLocations));
		for(int i=0;i<count;i++)
		{
			String customLoc=webElementList.get(i).getText();
			System.out.println("custom loc"+customLoc);
			if(customLoc.equals(PrdtName))
			{
				flag=true;
				break;
			}
		}

		if(flag==false)
		{
			FrameworkReporter.pass(PrdtName +" is not present in the NO Location list as it is already having a Location");
		}
		else
		{
			FrameworkReporter.fail(PrdtName+ " is present in the NO Location List which is not expected");

		}
	}


	/**
	 * @Function verifyCategoryInProductCardDetails
	 * @Description To verify Category of items in the product card
	 * @author Arun Mathai
	 * @date 05-10-2016
	 */
	public void verifyCategoryInProductCardDetails(String CategoryName){
		switchToWebContext();
		int itemCount=getElementCount(lbl_ProductNames);
		boolean isTrue=true;
		System.out.println(""+itemCount);
		for (int i=1;i<=itemCount;i++) {
			switchToWebContext();
			clickElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
			if(!getElementText(lbl_CategoryProductDetailsPage).equals(CategoryName)){
				isTrue=false;
			}					
			PageFactory pf =new PageFactory();
			pf.generic().tapClose();

		}
		if(isTrue==true){
			FrameworkReporter.pass("Category Name "+ CategoryName+"is expected for the product");
		}
		else{
			FrameworkReporter.fail("Could not find "+ CategoryName+"for the product");
		}
	}

	/**
	 * @Function verifyLocationsListedInAssignProductsPage
	 * @Description Verify Locations listed in the assign products page
	 * @param strLocationsName - string of Locations name 
	 * @author Arun Mathai
	 * @date 05-10-2016
	 */
	public void verifyItemsAssignedInLocationsPage(String strProductName)
	{
		switchToWebContext();
		boolean flag=false;

		String[] strPrdtName1; 

		int count=getDriver().findElements(getLocatorsType(lbl_ProductNames)).size();	
		List<WebElement>webElementList= getDriver().findElements(getLocatorsType(lbl_ProductNames));
		for(int i=0;i<count;i++)
		{
			String prdt=webElementList.get(i).getText();
			if(prdt.equals(strProductName))
			{
				flag=true;
				break;
			}
		}

		if(flag==true)
		{
			FrameworkReporter.pass("Verified the product"+strProductName+" in the location");
		}
		else
		{
			FrameworkReporter.fail("Colud not find the product"+strProductName+" in the location");

		}


	}


	/**
	 * @Function verifyAllItemsInLocationsPage
	 * @Description Verify Locations listed in the assign products page
	 * @param strProductName - string array of  Product name 
	 * @author Asha
	 * @date 07-10-2016
	 */
	public void verifyAllItemsInLocationsPage(String strProductName)
	{
		switchToWebContext();	

		String[] strPrdtName1 = strProductName.split("/"); 

		int count=getDriver().findElements(getLocatorsType(lbl_ProductNames)).size();	
		List<WebElement>webElementList= getDriver().findElements(getLocatorsType(lbl_ProductNames));
		for(int i=0;i<count;i++)
		{
			String prdt=webElementList.get(i).getText();
			if(prdt.contains(strPrdtName1[i]))
			{				
				FrameworkReporter.pass("Verified the product"+strPrdtName1[i]+" in the location");
			}
			else
			{
				FrameworkReporter.fail("Could not find the product"+strPrdtName1[i]+" in the location");

			}
		}
	}
	
	
	

	/**
	 * @Function verifyLocationsPage
	 * @Description To verify whether locations page is displayed or not 
	 * @author Sujina_S
	 * @date 22-09-2016
	 */
	public void verifyLocationsPage(){
		switchToWebContext();

		if(isElementPresentAfterWait(lbl_LocationsPage,10)){
			FrameworkReporter.pass("Locations page is displayed");
		}
		else{
			FrameworkReporter.fail("Locations page is not displayed");
		}

	}



	/**
	 * @Function verifyLocationPage
	 * @Description To verify corresponding location page is displayed or not 
	 * @author Periyasamy_Nainar
	 * @date 22-09-2016
	 */
	public void verifyLocationPage(String strLocationName){
		switchToWebContext();
		if(isElementPresentAfterWait(replaceDynamicText(lbl_LocationPage, strLocationName),10)){
			FrameworkReporter.pass("Locations page "+ strLocationName + "  is displayed");
		}
		else{
			FrameworkReporter.fail("Locations page "+ strLocationName + "  is not displayed");
		}

	}


	/**
	 * @Function verifyOrderOfLocations
	 * @Description To verify whether locations are displayed on order: Cooler,Freezer and Dry
	 * @param cooler - Default location Cooler,freezer - Default location freezer,dry - Default location dry
	 * @author Sujina_S
	 * @date 22-09-2016
	 */

	public void verifyOrderOfDefaultLocations(String ...str){
		switchToWebContext();
		/*// this function working fine, pls dont update this
		if ((getElementText(replaceDynamicText(lbl_DefaultLocation, "1")).contains(COOLER)) && 
				((getElementText(replaceDynamicText(lbl_DefaultLocation, "2")).toString()).contains(FREEZER)) && 
				((getElementText(replaceDynamicText(lbl_DefaultLocation, "3")).toString()).contains(DRY))){

			FrameworkReporter.pass("Order of Default Locations verified");

		} else {
			FrameworkReporter.fail("Order of Default Locations not displayed as expected");

		}*/

		
		if(str.length!=0){   // Applicable for only no location 
			if ((getElementText(replaceDynamicText(lbl_DefaultLocation, "4")).contains(str[0]))) {
				FrameworkReporter.pass("No Location is dispalyed as the last location in location list page");
			}else{
				FrameworkReporter.fail("No Location is not dispalyed as the last location in location list page");
			}
		}



	}
	
	
	/**
	 * @Function verifyDefaultLocations
	 * @Description To verify the default locations  displayed on Locations page
	 * @param cooler - Default location Cooler,freezer - Default location freezer,dry - Default location dry
	 * @author Sujina_S
	 * @date 22-09-2016
	 */

	public void verifyDefaultLocations(){
		/*
		switchToWebContext();
		//comment: the default location should be in the order of Cooler-Freezer-Dry.. please dont update this function
		if ((getElementText(replaceDynamicText(lbl_DefaultLocation, "1")).toString()).contains(COOLER)){
			FrameworkReporter.pass("Cooler displayed on default location list");
		}
		else{
			FrameworkReporter.fail("Cooler not displayed on default location list");

		}
		if ((getElementText(replaceDynamicText(lbl_DefaultLocation, "2")).toString()).contains(FREEZER)){

			FrameworkReporter.pass("Freezer displayed on default location list");
		}
		else{
			FrameworkReporter.fail("Freezer not displayed on default location list");
		}

		if ((getElementText(replaceDynamicText(lbl_DefaultLocation, "3")).toString()).contains(DRY)){

			FrameworkReporter.pass("Dry displayed on default location list");
		}
		else{
			FrameworkReporter.fail("Dry not displayed on default location list");
		}*/

	}
	
	
	/**
	 * @Function tapLocation
	 * @Description Select location from the locations list
	 * @param locationName - Location name 
	 * @author Sujina_S
	 * @date 22-09-2016
	 */

	public void tapLocation(String locationName){
		switchToWebContext();
		clickElement(replaceDynamicText(lst_Location, locationName));
		FrameworkReporter.info("Tapped on location "+locationName);
	}





	/**
	 * @Function getItemCountInLocation
	 * @Description get Item count from location in locations page
	 * @param locationName - Location name 
	 * @author Periyasamy Nainar
	 * @date 28-09-2016
	 */

	public void getItemCountInLocation(String locationName){
		switchToWebContext();
		if(lst_Location[0].contains("{dynamic1}")){		
			mapObj.put("ItemCountIn"+locationName.replace(" ", ""),getElementText(replaceDynamicText(lst_Location, locationName)).replace(locationName, "").replace("(", "").replace(")", "").trim().replace("\n", "").replace(" ", ""));			
		}

	}


	/**
	 * @Function verifyItemCountAfterDeleteLoc
	 * @Description verify Items count in No locations after deleting location from manage location
	 * @param locationName - Location name 
	 * @author Periyasamy Nainar
	 * @date 28-09-2016
	 * @dependency getItemCountInLocation
	 */

	public void  verifyItemCountAfterDeleteLoc(String locationName1, String strDeletedLocation,String ...strLocationCount){		
		switchToWebContext();
		if(lst_Location[0].contains("{dynamic1}")){		
			String strNoLocCount = getElementText(replaceDynamicText(lst_Location, locationName1)).replace(locationName1, "").replace("(", "").replace(")", "").trim().replace("\n", "").replace(" ", "");
			String strOldNoLocCount = mapObj.get("ItemCountIn"+locationName1.replace(" ", "")).toString().replace(" ", "").trim();
			String strDeletedLocCount = "";

			if(strLocationCount.length==0){
				strDeletedLocCount = mapObj.get("ItemCountIn"+strDeletedLocation.replace(" ", "")).toString().replace(" ", "").trim();
			}else{
				strDeletedLocCount = strLocationCount[0];
			}


			if(Integer.parseInt(strNoLocCount) == Integer.parseInt(strOldNoLocCount)+ Integer.parseInt(strDeletedLocCount)){
				FrameworkReporter.pass("All items from deleted location "+ strDeletedLocation+ " is moved to "+ locationName1+ " as the count "+ strNoLocCount +" is changed correctly");
			}else{
				FrameworkReporter.pass("All items from deleted location "+ strDeletedLocation+ " is not moved to "+ locationName1+ " as the count is not changed correctly");
			}

		}

	}
	/**
	 * @Function verifyLocationsWithCount
	 * @Description To verify Item count is dispalyed against each location
	 * @param icount - number of locations (ex. 3 if u have to verify cooler, freezer and dry) and strCountVal - locations name with count
	 * @author Periyasamy nainar
	 * @date 27-09-2016
	 */

	public void verifyLocationsWithCount(String iCount, String...strCountVal){
		switchToWebContext();
		Boolean boolFound = false; 
		int iLocCount = getElementCount(lst_LocationCount);
		for(int i=1; i <= iLocCount; i++){
			String strActualText = getElementText(replaceDynamicText(lbl_DefaultLocation, Integer.toString(i))).toString().replace("\n", "").replace(" ", "");
			for(int j=0; j< strCountVal.length; j++){
				if(strActualText.equalsIgnoreCase(strCountVal[j].replace("\r", "").replace("\n", "").replace(" ", ""))){
					boolFound = true;
					break;
				}
			}
			
			if(boolFound){
				FrameworkReporter.pass("Location '"+ strActualText + "' is displayed with correct item count");
			}else{
				FrameworkReporter.fail("Location '"+ strActualText + "' is not displayed with correct item count");
			}		
			
		}
		
		if(!(iCount.isEmpty())){
			if(Integer.parseInt(iCount) == iLocCount){
				FrameworkReporter.pass("Number of locations displayed in location page are correct as expected. count:" + iCount);
			}else{
				FrameworkReporter.fail("Number of locations displayed in location page are not correct as expected. count:" + iCount+ " Actual: "+ iLocCount);
			}
			
		}
		
	}



	/**
	 * @Function verifyLocationDetailsPage
	 * @Description To verify whether location details page is displayed or not 
	 * @author Periyasamy_Nainar
	 * @date 26-09-2016
	 */
	public void verifyLocationDetailsPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_LocationDetailsPage,10)){
			FrameworkReporter.pass("Location details page is displayed");
		}
		else{
			FrameworkReporter.fail("Location details page is not displayed");
		}

	}

	/**
	 * @Function verifyAddLocationPage
	 * @Description To verify whether Add location page is displayed or not 
	 * @author Periyasamy_Nainar
	 * @date 26-09-2016
	 */
	public void verifyAddLocationPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_AddLocationPage,10)){
			FrameworkReporter.pass("Add Location page is displayed");
		}
		else{
			FrameworkReporter.fail("Add Location page is not displayed");
		}

	}


	/**
	 * @Function tapAddItemFromOrderGuide
	 * @Description To click on Add from Order Guide on 'Add Item From' page
	 * @author Sujina_S
	 * @date 22-09-2016
	 */

	public void tapAddItemFromOrderGuide(){
		switchToWebContext();
		if(isElementPresentAfterWait(replaceDynamicText(lbl_AddItemFromInventoryList,"Add From Order Guide"),10)){
			clickElement(replaceDynamicText(lbl_AddItemFromInventoryList,"Add From Order Guide"));
			FrameworkReporter.pass("Tapped on Add item from Order Guide");		
		}
		else{
			FrameworkReporter.fail("Add item from Order Guide not tapped");
		}


	}

	/**
	 * @Function tapAddItemFromCustomList
	 * @Description To click on Add from Custom List on 'Add Item From' page
	 * @author Sujina_S
	 * @date 22-09-2016
	 */

	public void tapAddItemFromCustomList(){
		switchToWebContext();
		if(isElementPresentAfterWait(replaceDynamicText(lbl_AddItemFromInventoryList,"Add From Custom List"),10)){
			clickElement(replaceDynamicText(lbl_AddItemFromInventoryList,"Add From Custom List"));
			FrameworkReporter.pass("Tapped on Add item from Custom List");		
		}
		else{
			FrameworkReporter.fail("Add item from Custom List not tapped");
		}

	}
	/**
	 * @Function tapCreateNonSyscoItem
	 * @Description To click on  Create Non Sysco Item on 'Add Item From' page
	 * @author Sujina_S
	 * @date 22-09-2016
	 */

	public void tapCreateNonSyscoItem(){
		switchToWebContext();
		if(isElementPresentAfterWait(replaceDynamicText(lbl_AddItemFromInventoryList,"Create Non-Sysco Item"),10)){
			clickElement(replaceDynamicText(lbl_AddItemFromInventoryList,"Create Non-Sysco Item"));
			FrameworkReporter.pass("Tapped on Create Non Sysco Item");

		}
		else{
			FrameworkReporter.fail("Create Non Sysco Item not tapped");


		}


	}
	/**
	 * @Function tapCreatePrepItem
	 * @Description To click on  Create Prep Item on 'Add Item From' page
	 * @author Sujina_S
	 * @date 22-09-2016
	 */

	public void tapCreatePrepItem(){
		switchToWebContext();
		if(isElementPresentAfterWait(replaceDynamicText(lbl_AddItemFromInventoryList,"Create Prep Item"),10)){
			clickElement(replaceDynamicText(lbl_AddItemFromInventoryList,"Create Prep Item"));
			FrameworkReporter.pass("Tapped on Create Prep Item");

		}
		else{
			FrameworkReporter.fail("Create Prep Item not tapped");


		}
	}



	/**
	 * @Function verifyLocationPageDisplayed
	 * @Description To verify displayed location page by comparing with the expected page 
	 * @param strLocation- Location page to be displayed
	 * @author Sujina_S
	 * @date 22-09-2016
	 */

	public void verifyLocationPageDisplayed(String strLocation){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_LocationTitle, 10))
		{

			if(getElementText(lbl_LocationTitle).toLowerCase().contains(strLocation.toLowerCase())){
				FrameworkReporter.pass("Verified expected location page");
				//("PASSED: Expected location page displayed");
			}
			else{
				FrameworkReporter.fail("Expected location page not displayed");
				//("FAILED: Expected location page not displayed");

			}
		}
	}
	/**
	 * @Function searchItem
	 * @Description To search for an item using keyword (brand, description, number or nickname)
	 * @param strKeyword- search keyword
	 * @author Sujina_S
	 * @date 23-09-2016
	 */

	public void  searchItem(String strKeyword){
		switchToWebContext();
		//wait for Element present and click element is already handled in sendText function in framework
		//waitForElementPresent(txt_Search);
		clickElement(txt_Search);
		sendText(txt_Search, strKeyword);
		FrameworkReporter.info("Searched item using keyword "+strKeyword);


	}
	/**
	 * @Function addItemFromOrderGuide
	 * @Description To select item from Order guide products
	 * @author Sujina_S
	 * @date 23-09-2016
	 */

	public void addItemFromOrderGuide(){
		switchToWebContext();
		//wait for Element present is already handled in clickElement function in framework
		//waitForElementPresent(lst_SelectItemFromOrderGuide);
		clickElement(lst_SelectItemFromOrderGuide);
		FrameworkReporter.info("Select item from Order guide products");




	}


	/**
	 * @Function tapDeleteIcon
	 * @Description To click on delete item icon
	 * @author Sujina_S
	 * @date 23-09-2016
	 */

	public void tapDeleteIcon(){
		//	waitForElementPresent(lbl_DeleteItemIcon);
		switchToWebContext();
		clickElement(lbl_DeleteItemIcon);
		FrameworkReporter.info("Clicked on Delete Icon");




	}
	/**
	 * @Function tapDeleteButton
	 * @Description To click on delete item button
	 * @author Sujina_S
	 * @date 23-09-2016
	 */

	public void tapDeleteButton(){
		switchToWebContext();
		//	waitForElementPresent(btn_DeleteItemButton);
		clickElement(btn_DeleteLocationButton);
		FrameworkReporter.info("Clicked on Delete Button");
	}


	/**
	 * @Function addItemFromSearchResults
	 * @Description To select item from Search Results
	 * @author Sujina_S
	 * @date 23-09-2016
	 */

	public void addItemFromSearchResults(){
		//waitForElementPresent(lst_SelectItemFromSearchResults);
		switchToWebContext();
		clickElement(lst_SelectItemFromSearchResults);
		FrameworkReporter.info("Select item from Search Results");
	}


	/**
	 * @Function verifyDeleteConfirmationMessage
	 * @Description Verify confirmation message displayed to delete
	 * @author Periyasamy_Nainar
	 * @param strLocationName - Location name, strLocationCount - Expected count ( not mandatory )
	 * @date 28-09-2016
	 */

	public void verifyDeleteConfirmationMessage(String strLocationName,String ...strLocationCount){ 
		switchToWebContext();
		String strCount ="";
		if(getElementText(lbl_DeleteConfirmationModalHeader).toString().equalsIgnoreCase("Are you sure you want to delete "+strLocationName +" from your list?")){
			FrameworkReporter.pass("Delete confirmation modal header is displayed correctly as"+getElementText(lbl_DeleteConfirmationModalHeader).toString() );
		}else{
			FrameworkReporter.fail("Delete confirmation modal header is not displayed correctly. Actual: "+getElementText(lbl_DeleteConfirmationModalHeader).toString() 
					+ " Expected: "+ "Are you sure you want to delete "+strLocationName +" from your list?" );
		}
		if(strLocationCount.length==0){
			strCount = mapObj.get("ItemCountIn"+strLocationName).toString();
		}else{
			strCount = strLocationCount[0];
		}//Delete message needs to be updated  - Delete confirmation message has been change and item count will not be available in pop up. GOt the confirmation from Felix. So making an update in the as needed. 
	//	if(getElementText(lbl_DeleteConfirmationModalBody).toString().equalsIgnoreCase("By removing this location, you will no longer be able to track "+ strCount +" items in your inventory. Are you sure?")){
		if(getElementText(lbl_DeleteConfirmationModalBody).toString().equalsIgnoreCase("By removing this location, you will no longer be able to see these items in your inventory or food costs. Are you sure?")){
		
			FrameworkReporter.pass("Delete confirmation modal body is displayed correctly as"+getElementText(lbl_DeleteConfirmationModalBody).toString() );
		}else{
			FrameworkReporter.fail("Delete confirmation modal header is not displayed correctly. Actual: "+getElementText(lbl_DeleteConfirmationModalBody).toString() + 
					" Expected: "+ "By removing this location, you will no longer be able to track "+ strCount +" items in your inventory. Are you sure?" );
		}
	}

	/**
	 * @Function enterLocationDetails
	 * @Description To enter location details
	 * @param strLocationName- Location Name,strLocationType- Location Type
	 * @author Sujina_S
	 * @date 23-09-2016
	 */
	public void enterLocationDetails(String strLocationName,String strLocationType){
		switchToWebContext();		
		sendText(txt_LocationName,strLocationName);
		//This function needs to be updated - One locator should be used with dynamic Text
		FrameworkReporter.info("Entered location name");
		System.out.println("");
		/*if(strLocationType.equalsIgnoreCase("Cooler"))
			clickElement(lst_LocationTypeCooler);
		if(strLocationType.equalsIgnoreCase("Freezer"))
			clickElement(lst_LocationTypeFreezer);
		if(strLocationType.equalsIgnoreCase("Dry"))
			clickElement(lst_LocationTypeDry);*/
		clickElement(replaceDynamicText(rbtn_LocationType, strLocationType.toUpperCase()));
		FrameworkReporter.info("Selected location type "+strLocationType);


	}
	/**
	 * @Function verifyLocationInList
	 * @Description To verify Location is displayed in list
	 * @param strLocationName-LocationName
	 * @author Sujina_S
	 * @date 23-09-2016
	 */

	public void verifyLocationInList(String strLocationNames,Boolean boolVal){
		switchToWebContext();
		//if(lst_LocationsList[0].contains("{dynamic}")){
		//lst_LocationsList[0]=lst_LocationsList[0].replace("{dynamic1}",strLocationName); 
		//change in above implementation			
		//waitForElementPresent(lst_LocationsList);

		String[] strLocationName = strLocationNames.split("/");
		for(int i = 0; i<strLocationName.length; i++){	
			if(boolVal){

					if(isElementPresentAfterWait(replaceDynamicText(lst_LocationsList, strLocationName),8)){
						FrameworkReporter.pass("Location " +  strLocationName[i] + " is displayed on location list");}
					 else {
						FrameworkReporter.fail("Location " +  strLocationName[i] + "  is not displayed on location list");
						}	
			}
			else{
				if(!(isElementPresentAfterWait(replaceDynamicText(lst_LocationsList, strLocationName),8))){
					FrameworkReporter.pass("Location " +  strLocationName[i] + "  is not displayed on location list");}
				 else {
					FrameworkReporter.fail("Location " +  strLocationName[i] + "  is displayed on location list");
				 }	

				}
		}		

	}


	/**
	 * @Function verifySearchedItems
	 * @Description To verify searched item list is displayed correctly as per search keyword
	 * @param strKeyword- search keyword
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	public void verifySearchedItems(String strKeyword) throws InterruptedException, IOException {

		switchToWebContext();
		if(getElementText(lbl_SearchedItem).contains(strKeyword)){
			FrameworkReporter.pass("Searched item list is displayed correctly as per search keyword");

		} else {
			FrameworkReporter.fail("Searched item list is not displayed correctly as per search keyword");
		}
	}
	/**
	 * @Function verifySearchedNonSyscoItems
	 * @Description To verify searched non sysco item list is displayed correctly as per search keyword
	 * @param strKeyword- search keyword
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	public void verifySearchedNonSyscoItems(String strKeyword) throws InterruptedException, IOException {

		switchToWebContext(); 
		if(getElementText(lbl_SearchedItemCustom).contains(strKeyword)){
			FrameworkReporter.pass("Searched item list is displayed correctly as per search keyword");

		} else {
			FrameworkReporter.fail("Searched item list is not displayed correctly as per search keyword");
		}


	}
	/**
	 * @Function verifyLocationDetails
	 * @Description To verify location details
	 * @param strLocationName- Location Name,strLocationType- Location Type
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	public void verifyLocationDetails(String strLocationName,String strLocationType){
		switchToNativeContext();

		if(!strLocationName.isEmpty()){
			if(getElementText(getObject(lbl_LocationDetailsName)).toString().equals(strLocationName)){
				FrameworkReporter.pass("Location name is displayed as expected");
				consolePrint("PASSED: Location name is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Location name is not displayed as expected value: "+strLocationName+", displayed as: "+getElementText(getObject(lbl_LocationDetailsName)));
				consolePrint("FAILED: Location name is not displayed as expected value: "+strLocationName+", displayed as: "+getElementText(getObject(lbl_LocationDetailsName)));
			}
		}
		if(!strLocationType.isEmpty()){
			if(getElementText(getObject(lbl_LocationDetailsType)).toString().equals(strLocationType)){
				FrameworkReporter.pass("Location type is displayed as expected");
				consolePrint("PASSED: Location type is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Location type is not displayed as expected value: "+strLocationType+", displayed as: "+getElementText(getObject(lbl_LocationDetailsType)));
				consolePrint("FAILED: Location type is not displayed as expected value: "+strLocationType+", displayed as: "+getElementText(getObject(lbl_LocationDetailsType)));
			}
		}

	}
	/**
	 * @Function selectAnItem
	 * @Description To select an item
	 * @param strItemId - Item identifier
	 * @author Sujina_S
	 * @date 24-09-2016
	 */

	public void selectAnItem(String strItemName,boolean click){
		switchToWebContext();
		//lbl_SelectSearchItem[0]=lbl_SelectSearchItem[0].replace("{dynamic1}",strItemId);
		//changed the implementation		
		List <WebElement>	elements=getDriver().findElements(getLocatorsType(lbl_ProductNames));
		for (WebElement element: elements) {			
			if(element.getText().equalsIgnoreCase(strItemName)){
				moveToElement(replaceDynamicText(lbl_Products,Integer.toString((elements.indexOf(element))+1)));
				if(click == true){
				clickElement(replaceDynamicText(lbl_Products,Integer.toString((elements.indexOf(element))+1)));}
				FrameworkReporter.info("Item : "+strItemName+ "is selected");		
				break;
			}
		}	
	}
	/**
	 * @Function selectAnItemWithIndex
	 * @Description To select an item
	 * @param strItemIndex - Item index in list
	 * @author Gayathri
	 * @date 04-10-2016
	 */

	public void selectAnItemWithIndex(String index,String...strings){
		
		switchToWebContext();

		if(strings.length >0 && strings[0].equalsIgnoreCase("true"))
		{
			String strProductName =getElementText(replaceDynamicText(lbl_Products,index)).split("\n")[0];
			System.out.println(strProductName);
			if(strings.length ==2)
			{
				storeValue("ProductName"+strings[1],strProductName);
			}
			else
			{
				storeValue("ProductName",strProductName);
			}
		}
		
		clickElement(replaceDynamicText(lbl_Products,index));
		FrameworkReporter.info("Item : "+index+ "is selected");		
	}
	/**
	 * @Function enterQuantity
	 * @Description To enter quantity for an item in item list page
	 * @param iQty- item quantity
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	public void enterQuantity(String quantity,String index){
		switchToWebContext();
		//waitForElementPresent(txt_EnterItemQuantity);
		//clickElement(txt_EnterItemQuantity);
		//clear(txt_EnterItemQuantity);
		//wait, click and clear is handled in sendText function in framework
		sendText(replaceDynamicText(txt_EnterItemQuantity, index),quantity);
		FrameworkReporter.info("Entered item quantity");
		storeValue("Item"+index, getElementText(replaceDynamicText(lbl_ProductNameByIndex, index)));
		storeValue("Item"+index+"Qty", quantity);
	}
	/**
	 * @Function verifyQuantity
	 * @Description To verify quantity for an item in item list page
	 * @param iQty- item quantity
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	public void verifyQuantity(String quantity,String index){
		switchToWebContext();
		if(getElementAttributeValue(replaceDynamicText(txt_EnterItemQuantity, index),"value").equals(quantity)){
			FrameworkReporter.pass("Item quantity displayed as expected");

		}
		else{
			FrameworkReporter.fail("Item quantity is not displayed as expected value: "+quantity+", displayed as: "+getElementText(replaceDynamicText(txt_EnterItemQuantity, index)));

		}
	}
	
	/**
	 * @Function verifyQuantityAfterReLogin
	 * @Description To verify quantity for an item in item list page after re login
	 * @param iQty- item quantity
	 * @author Reshma S Farook
	 * @date 27-10-2016
	 */
	public void verifyQuantityAfterReLogin(String quantity,String index){
		switchToWebContext();
		System.out.println("value- "+getElementAttributeValue(replaceDynamicText(txt_EnterItemQuantity, index),"placeholder"));
		if(getElementAttributeValue(replaceDynamicText(txt_EnterItemQuantity, index),"placeholder").equals(quantity)){
			FrameworkReporter.pass("Item quantity displayed as expected");

		}
		else{
			FrameworkReporter.fail("Item quantity is not displayed as expected value: "+quantity+", displayed as: "+getElementText(replaceDynamicText(txt_EnterItemQuantity, index)));

		}
	}

	/**
	 * @Function verifyQuantityAndUOMAttribute
	 * @Description To verify quantity and uom attribute fields are displayed for an item
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	public void verifyQuantityAndUOMAttribute(String index){
		switchToWebContext();
		if(isElementPresent(replaceDynamicText(txt_EnterItemQuantity, index))){
			FrameworkReporter.pass("Item quantity field displayed for item");

		}
		else{
			FrameworkReporter.fail("Item quantity field not displayed for item");

		}
		if(isElementPresent(replaceDynamicText(lbl_UOMAttributeInList,index))){
			FrameworkReporter.pass("Item UOM field displayed for item");

		}
		else{
			FrameworkReporter.fail("Item UOM field not displayed for item");

		}
	}

	/**
	 * @Function verifyItemCategoryOfAllItemsInList
	 * @Description To verify the category of all items in item list page for selected location
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	public void verifyItemCategoryOfAllItemsInList(String categoryType,String... customCategories){
		switchToWebContext();
		String[] categoryNames=null;
		boolean isTrue=true;
		switch (categoryType){
		case "default":
			categoryNames=new String[2];
			categoryNames[0]="Food";
			categoryNames[1]="Non-Food";
			break;
		case "suggested":
			categoryNames=new String[12];
			categoryNames[0]="Dairy";
			categoryNames[1]="Meat";
			categoryNames[2]="Poultry";
			categoryNames[3]="Seafood";
			categoryNames[4]="Produce";
			categoryNames[5]="Canned and Dry";
			categoryNames[6]="Dispenser Beverage";
			categoryNames[7]="Frozen";
			categoryNames[8]="Chemical & Janatorial";
			categoryNames[9]="Paper & Disposable";
			categoryNames[10]="Supplies & Equipment";
			categoryNames[11]="Healthcare & Hospitality";
			break;
		case "custom":
			categoryNames=customCategories;
			break;
		default:
			break;
		}
		List <WebElement> elements=getDriver().findElements(getLocatorsType(lbl_VerifyItemCategory));
		if(!categoryType.equals("no category")){
			for (WebElement element:elements){
				boolean isCategoryFound=false;
				for (int i=0;i<categoryNames.length;i++){
					if(element.getText().equals(categoryNames[i]) || (element.getText().contains(categoryNames[i]) ) ) 
					{
						System.out.println("Category displayed is "+element.getText());
						isCategoryFound=true;
						break;
					}
				}
				if(!isCategoryFound){
					isTrue=false;
				}
			}
			if(isTrue){
				FrameworkReporter.pass("Category of all items in the list is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Category of all items in the list is not displayed as expected");
			}
		}
		else{
			for (WebElement element:elements){
				if(!element.getText().isEmpty()){
					isTrue=false;
				}
			}
			if(isTrue){
				FrameworkReporter.pass("No category is displayed for all items in list");
			}
			else{
				FrameworkReporter.fail("Category is displayed for items in list");
			}
		}
	}
	/**
	 * @Function tapOnUOMAttribute
	 * @Description To change UOM attribute value
	 * @param strUOMAttribute - UOM attribute value
	 * @author Periyasamy Nainar
	 * @date 17-10-2016
	 */

	public void tapOnUOMAttribute(String strIndex){
		switchToWebContext();		
		clickElement(replaceDynamicText(lst_uom, strIndex));		
		FrameworkReporter.info("Tapped on UOM Attibute to change the value on the element at index:  "+strIndex);
	}

	/**
	 * @Function verifyUOMAttribute
	 * @Description To verify UOM attribute value
	 * @param strUOMAttribute - UOM attribute value
	 * @author Sujina_S
	 * @date 24-09-2016
	 */

	public void verifyUOMAttribute(String strUOMAttribute){

		switchToWebContext();
		if(getElementText(lbl_UOMAttribute).contains(strUOMAttribute)){
			FrameworkReporter.pass("UOM displayed as expected");

		}
		else{
			FrameworkReporter.fail("UOM not displayed as expected");

		}


	}

	/**
	 * @Function verifyItemPresentInLocation
	 * @Description To verify item is present on location
	 * @param strItem - item detail
	 * @author Sujina_S
	 * @date 24-09-2016
	 */

	public void verifyItemPresentInLocation(String strItem){
		switchToWebContext();
		//lbl_VerifyItemOnLocation[0]=lbl_VerifyItemOnLocation[0].replace("{dynamic1}",strItem);
		if(isElementPresent(replaceDynamicText(lbl_VerifyItemOnLocation, strItem))){

			FrameworkReporter.pass("Item "+strItem+" present in location");

		}
		else{
			FrameworkReporter.fail("Item "+strItem+" not present in location");
		}



	}
	/**
	 * @Function verifyIndicator
	 * @Description To verify indicator is displayed properly based on the item
	 * @param strIndicatorType -Item brand(Sysco Branded, Sysco Non Branded,Non Sysco) ,strItem- item ID 
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	//Needs to refine this function
	public void verifyIndicator(String strIndicatorType,String strItem){
		switchToWebContext();
		if(strIndicatorType.equalsIgnoreCase("Sysco Branded")){
			lbl_SyscoBrandedIndicator[0]=lbl_SyscoBrandedIndicator[0].replace("{dynamic1}",strItem);
			if(isElementPresent(lbl_SyscoBrandedIndicator)){
				FrameworkReporter.pass("Indicator displayed correctly for Sysco Branded item");

			}
			else{
				FrameworkReporter.fail("Indicator not displayed correctly for Sysco Branded item");

			}
		}
		if(strIndicatorType.equalsIgnoreCase("Sysco Non Branded")){
			lbl_SyscoNonBrandedIndicator[0]=lbl_SyscoNonBrandedIndicator[0].replace("{dynamic1}",strItem);
			if(isElementPresent(lbl_SyscoNonBrandedIndicator)){
				FrameworkReporter.pass("Indicator displayed correctly for Sysco Non Branded item");

			}
			else{
				FrameworkReporter.fail("Indicator not displayed correctly for Sysco Non Branded item");

			}
		}
		if(strIndicatorType.equalsIgnoreCase("Non Sysco")){
			lbl_SyscoBrandedIndicator[0]=lbl_SyscoBrandedIndicator[0].replace("{dynamic1}",strItem);
			lbl_SyscoNonBrandedIndicator[0]=lbl_SyscoNonBrandedIndicator[0].replace("{dynamic1}",strItem);

			if(!(isElementPresent(lbl_SyscoBrandedIndicator)||(isElementPresent(lbl_SyscoNonBrandedIndicator)))){
				FrameworkReporter.fail("Indicator not displayed correctly for Non Sysco item");

			}
			else{
				FrameworkReporter.pass("Indicator displayed correctly for Non Sysco item");

			}
		}
	}




	/**
	 * @Function verifyProductNicknameInItemList
	 * @Description Verify product nickname is displayed in list view
	 * @author Gayathri Anand
	 * @param productId - UPC/ID of item, nickName - Nick name
	 * @date 23-09-2016
	 */

	public void verifyProductNicknameInItemList(String productId,String nickName){
		switchToWebContext();
		List<WebElement> productIDs=getDriver().findElements(getLocatorsType(lbl_ProducIDs));
		List<WebElement> productNames=getDriver().findElements(getLocatorsType(lbl_ProductNames));
		boolean itemFound=false;
		for (WebElement productIdElement: productIDs) {
			if(productIdElement.getText().equals(productId)){
				itemFound=true;
				WebElement productName=productNames.get(productIDs.indexOf(productIdElement));
				if(productName.getText().equals(nickName)){
					FrameworkReporter.pass("Nick name is displayed for the item as expected");

				}
				else{
					FrameworkReporter.fail("Nick name is not displayed for the item, expected: "+nickName+" actual: "+productName.getText());

				}
				break;
			}
		}
		if(!itemFound){
			FrameworkReporter.fail("Item "+productId+" not present in the list");

		}

	}




	/**
	 * @Function verifyItemPresentInLocation
	 * @Description Verify item present or not in a location
	 * @author Gayathri Anand
	 * @param productIdOrName - Item UPC/ID or name, itemDetailType - Item details type of param1(productIdOrName)[UPCID or Product Name], isExpected - boolean value for item expected or not
	 * @date 23-09-2016
	 */

	public void verifyItemPresentInLocation(String productIdOrName,String itemDetailType,boolean isExpected, String...strings){
		//	List<WebElement> elements=getDriver().findElements(getLocatorsType(lbl_ProducIDs));
		switchToWebContext();
		if(strings.length >0 && strings[0].equalsIgnoreCase("true"))
		{
			if(strings.length ==2)
			{
				productIdOrName= retreiveStoredValue("ProductName"+strings[1]).toString();
			}
			else
			{
				productIdOrName= retreiveStoredValue("ProductName").toString();
			}
		}
		List<WebElement> elements=null;
		boolean itemFound=false;
		//System.out.println(productIdOrName);
		switch (itemDetailType){
		case "UPCID":
			elements=getDriver().findElements(getLocatorsType(lbl_ProducIDs));
			break;
		case "Product Name":
			elements=getDriver().findElements(getLocatorsType(lbl_ProductNames));
			break;
		default:
			break;
		}
		//	System.out.println(elements.size());
		if(elements.size()!=0)
		{
			for (WebElement element: elements) {
				if(ConfigFile.getProperty("brand").equalsIgnoreCase("android")){ //Please dont remove it - Parvathy
				System.out.println(element.getText().trim());
				}
				if(element.getText().trim().equalsIgnoreCase(productIdOrName.trim())){
					itemFound=true;
					break;
				}
			}
		}
		if(isExpected){
			if(itemFound){
				FrameworkReporter.pass("Item "+productIdOrName+" present in the location selected");

			}
			else{
				FrameworkReporter.fail("Item "+productIdOrName+" not present in the location selected");
			}
		}		

		else{
			if(!itemFound){
				FrameworkReporter.pass("Item "+productIdOrName+" not present in the location selected");

			}
			else{
				FrameworkReporter.fail("Item "+productIdOrName+" present in the location selected");
			}
		}



	}
	/**
	 * @Function verifyLocationListPage
	 * @Description Verify if the Add Item Form page is displayed
	 * @author Parvathy P
	 * @param 
	 * @date 26-09-2016
	 */

	public void verifyAddItemFormPageDisplayed(){
		waitFor(5);
		switchToWebContext();
		
		if(isElementPresent(lbl_AddItemFrom)){
			FrameworkReporter.pass("Add Item Form Page is displayed");
		}
		else{
			FrameworkReporter.fail("Add Item Form Page is not displayed");
		}
	}



	/**
	 * @Function verifySelectPage
	 * @Description Verify if the Select List page is displayed
	 * @author Parvathy P
	 * @param 
	 * @date 26-09-2016
	 */

	public void verifySelectPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_SelectList,20)){
			FrameworkReporter.pass("Add Select List Page is displayed");
		}
		else{
			FrameworkReporter.fail("Add Select List Page is not displayed");
		}

	}


	/**
	 * @Function tapItemInThisLocation
	 * @Description Tap on View Items on this location
	 * @author Periyasamy_Nainar
	 * @date 26-09-2016
	 */
	public void tapItemInThisLocation()
	{
		switchToWebContext();
		clickElement(btn_ViewItemInThisLocation);
		FrameworkReporter.info("Tapped on View Items on this location");
	}

	/**
	 * @Function getNumberOfItemInThisLocation
	 * @Description get Number of items from the button view items in this location 
	 * @author Periyasamy_Nainar
	 * @date 26-09-2016
	 */
	public void getNumberOfItemInThisLocation()
	{
		switchToWebContext();
		System.out.println(getElementText(btn_ViewItemInThisLocation).toString().split("View")[1].split("item")[0].replace(" ", "").trim());
		int iNumberOfItems = Integer.parseInt(getElementText(btn_ViewItemInThisLocation).toString().split("View")[1].split("item")[0].replace(" ", "").trim());
		FrameworkReporter.info("Tapped on View Items on this location");
		storeValue("iNumberOfItemsInLocation", iNumberOfItems);
	}


	/**
	 * @Function verifyNumberOfItemInThisLocation
	 * @Description verify number of itesm in the button view items in this location is equal to the number of lines items in location page
	 * @author Periyasamy_Nainar
	 * @date 26-09-2016
	 */
	public void verifyNumberOfItemInThisLocation()
	{
		switchToWebContext();
		System.out.println(getElementCount(lbl_ItemsInLocation));
		System.out.println(retreiveStoredValue("iNumberOfItemsInLocation").toString().replace(" ", "").trim());
		if(getElementCount(lbl_ItemsInLocation) == Integer.parseInt(retreiveStoredValue("iNumberOfItemsInLocation").toString())){
			FrameworkReporter.pass("Number of items displayed in view items in this location is equal to the number of line itesm in location page");
		}else{
			FrameworkReporter.fail("Number of items displayed in view items in this location is not equal to the number of line itesm in location page");
		}		
	}



	/**
	 * @Function verifyNumberOfItemInLocation
	 * @Description Verify the count of number of items in a location
	 * @author Reshma S Farook
	 * @param expectedItemCount - Count of items expected per location, Location - desired location
	 * @date 26-09-2016
	 */
	public void verifyNumberOfItemInLocation (String expectedItemCount, String location)
	{
		switchToWebContext();
		String strBtnViewItemInLocText = getElementText(btn_ViewItemInThisLocation).toString();
		String strExpectedValue = "View " +expectedItemCount+ " Item(S) In This Location";
		if (strBtnViewItemInLocText.equalsIgnoreCase("View " +expectedItemCount+ " Item(S) In This Location"))		{
			FrameworkReporter.pass("Total number of items present in the location " +location+ " is correctly populated as "+expectedItemCount );
		}else{
			FrameworkReporter.fail("Total number of items present in the location " +location+ " is not populated as "+expectedItemCount );
		}
	}
	/**
	 * @Function verifyAddOrderGuidePage
	 * @Description Verify if Add Order Guid..  page is displayed
	 * @author Parvathy P
	 * @param 
	 * @date 26-09-2016
	 */

	public void verifyAddOrderGuidePage(){
		switchToWebContext();
		if(isElementPresent(lbl_AddOrderGuide)){
			FrameworkReporter.pass("Add From Order Guide Page is displayed");

		}
		else{
			FrameworkReporter.fail("Add From Order Guide Page is not displayed");
		}
	}
	/**
	 * @Function selectCustomList
	 * @Description Select a custom list
	 * @param strListName
	 * @author Parvathy_P
	 * @date 26-09-2016
	 */

	public LocationsPage selectCustomList(String strListName){
		switchToWebContext();
		clickElement(replaceDynamicText(lbl_ListName, strListName));
		FrameworkReporter.info("Custom List: "+strListName+" is selected");
		return this;
	}
	/**
	 * @Function selectAnItemWithName
	 * @Description To select an item with its name from add products page
	 * @param strItemName - Item name
	 * @author Parvathy
	 * @date 26-09-2016
	 */

	public LocationsPage selectAnItemWithName(String strItemName){
		switchToWebContext();
		if(ConfigFile.getProperty("platformType").equalsIgnoreCase("android")){
			Actions action = new Actions(getDriver());
			WebElement ele = waitForElementPresent(replaceDynamicText(getObject(lbl_ItemName), strItemName));
			action.moveToElement(ele).build().perform();
		}
		clickElement(replaceDynamicText(getObject(lbl_ItemName), strItemName));
		FrameworkReporter.info("Item "+strItemName+" is selected");
		//("Selected item");
		return this;
	}
	/**
	 * @Function verifyLocationListPage
	 * @Description Verify if Add Order Guid..  page is displayed
	 * @author Parvathy P
	 * @param 
	 * @date 26-09-2016
	 */
	public void verifyAddCustomListPage(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_AddCustomList,20)){
			FrameworkReporter.pass("Add Custom List Page is displayed");
		}
		else{
			FrameworkReporter.fail("Add Custom List Pageis not displayed");
		}
	}

	/**
	 * @Function verifyItemCategoryInItemList
	 * @Description To verify the category of an item in item list page for selected location
	 * @author Gayathri Anand
	 * @date 26-09-2016
	 */
	public LocationsPage verifyItemCategoryInItemList(String productName,String categoryName){
		switchToWebContext();
		searchItem(productName);
		if(getElementText(lbl_VerifyItemCategory).equals(categoryName)){
			FrameworkReporter.pass("Category of item is displayed as expected: "+ categoryName);
		}
		else{
			FrameworkReporter.fail("Category of item is not displayed as expected value: "+categoryName+" actual value: "+getElementText(lbl_VerifyItemCategory));
		}
		return this;

	}

	/**
	 * @Function verifyAddProductPageDisplayed
	 * @Description To verify if the Add Product page is displayed
	 * @author Parvathy P
	 * @param 
	 * @date 27-09-2016
	 */

	public void verifyAddProductPageDisplayed(){
		switchToWebContext();
		if(isElementPresentAfterWait(lbl_AddProduct,10)){
			FrameworkReporter.pass("Add Product Page is displayed");
		}
		else{
			FrameworkReporter.fail("Add Product Page is not displayed");
		}
	}

	/**
	 * @Function verifyNonSyscoItemTextColorSameAsSyscoItem
	 * @Description To verify thatption To verify that non sysco item text color is same as sysco item
	 * @author Gayathri Anand
	 * @date 27-09-2016
	 */

	public void verifyNonSyscoItemTextColorSameAsSyscoItem(String nonSyscoItem, String syscoItem){
		switchToWebContext();
		String nsColor,syscoColor;

		moveToElement(replaceDynamicText(lbl_SelectSearchItem, syscoItem));
		syscoColor = getElementCSSValue(replaceDynamicText(lbl_SelectSearchItem, syscoItem), "color");
		swipeScreenInVertical(8,3);
		switchToWebContext();
		moveToElement(replaceDynamicText(lbl_SelectSearchItem, nonSyscoItem));
		nsColor = getElementCSSValue(replaceDynamicText(lbl_SelectSearchItem, nonSyscoItem), "color");
		
		System.out.println("syscoItem" +syscoColor);
		System.out.println("nonSyscoItem" +nsColor);
		if(nsColor.equalsIgnoreCase(syscoColor)){
			FrameworkReporter.pass("Non sysco item text color is same as sysco item");
		}
		else
		{
			FrameworkReporter.fail("Non sysco item text color is not same as sysco item");
		}
		/*if(getElementCSSValue(replaceDynamicText(lbl_SelectSearchItem, nonSyscoItem), "color").equals(getElementCSSValue(replaceDynamicText(lbl_SelectSearchItem, syscoItem), "color"))){
			FrameworkReporter.pass("Non sysco item text color is same as sysco item");
		}
		else{
			FrameworkReporter.fail("Non sysco item text color is not same as sysco item");
		}*/
	}
	/**
	 * @Function verifyTogglingOfUOMAttributeFromItemList
	 * @Description To verify the toggling of UOM attribute from item list
	 * @author Gayathri Anand
	 * @date 27-09-2016
	 */

	public void verifyTogglingOfUOMAttributeFromItemList(String itemIndex){

		//	switchToNativeContext();
		//clickElement(replaceDynamicText(getObject(lst_LocationQtyUOM),itemIndex));	
		//	clickElement(replaceDynamicText(lbl_UOMAttributeInList, itemIndex));
		//	FrameworkReporter.info("Tapped on UOM Attribute to change the value for location : "+ strLocationType);;		

		//	switchToNativeContext();

		String[] uomAttributes={"CS","EA","LB","OZ"};
		switchToWebContext();
		String strBrand = ConfigFile.getProperty("brand");
		if((strBrand.equalsIgnoreCase("android") || (strBrand.equalsIgnoreCase("ipad")))){
			//	clickElement(replaceDynamicText(getObject(lst_NativeAndroidIpadList),strName)); 
			for (int i=0;i<uomAttributes.length;i++){
				clickElement(replaceDynamicText(lbl_UOMAttributeInList, itemIndex));
				switchToNativeContext();
			//	String selectedAttribute= getSelectedOptionTextInDropDown(lst_DropdownOptions,uomAttributes.length);
			//	clickElement(replaceDynamicText(lst_DropdownOption, uomAttributes[i]));
				
				//************************
				PageFactory pf =new PageFactory();
				pf.generic().selectValueFromDropdown(uomAttributes[i], uomAttributes[i] + "selected");
				//************************
				
				FrameworkReporter.info("Selected attribute "+uomAttributes[i]);
				switchToWebContext();
				Select select =new Select(waitForElementPresent(replaceDynamicText(lbl_UOMAttributeInList, itemIndex)));
				String strCurrentUOM =(select.getFirstSelectedOption().getText());
				if(strCurrentUOM.equals(uomAttributes[i])){
					FrameworkReporter.pass("Selected UOM atribute is displayed");
				}
				else{
					FrameworkReporter.fail("Selected UOM atribute is not displayed");
				}
			}
		}
		else
		{
		/*
			switchToWebContext();
			//clickElement(lbl_UOMAttributeIOS);
			GenericPage gp=new GenericPage();
			for (int i=0;i<uomAttributes.length;i++)
			{
				clickElement(getObject(replaceDynamicText(lbl_UOMAttributeInList,itemIndex)));
				gp.verifyValueInDropdown(uomAttributes[i], "uom", true);
				gp.selectValueFromDropdown(uomAttributes[i], uomAttributes[i]+" is selected");		
				gp.tapDone();
			}
			//		clickElement(replaceDynamicText(getObject(lbl_UOMAttributeInList),itemIndex));	

			//sendText(getObject(lst_nativeList), strName);

			//		
			//	FrameworkReporter.pass(strMessage);
*/

			//clickElement(getObject(btn_NativeList_Done));
		}





		//Android

		/*		
			String[] uomAttributes={"CS","EA","LB","OZ"};
		switchToWebContext();
		for (int i=0;i<uomAttributes.length;i++){
			clickElement(replaceDynamicText(lbl_UOMAttributeInList, itemIndex));
			switchToNativeContext();
			String selectedAttribute= getSelectedOptionTextInDropDown(lst_DropdownOptions,uomAttributes.length);
			clickElement(replaceDynamicText(lst_DropdownOption, uomAttributes[i]));
			FrameworkReporter.info("Selected attribute "+uomAttributes[i]);
			switchToWebContext();
			Select select =new Select(waitForElementPresent(replaceDynamicText(lbl_UOMAttributeInList, itemIndex)));
			String strCurrentUOM =(select.getFirstSelectedOption().getText());
			if(strCurrentUOM.equals(uomAttributes[i])){
				FrameworkReporter.pass("Selected UOM atribute is displayed");
			}
			else{
				FrameworkReporter.fail("Selected UOM atribute is not displayed");

			}
		}
		 */
	}

	/**
	 * @Function clearQuantity
	 * @Description To clear quantity for an item in item list page
	 * @param iQty- item quantity
	 * @author Gayathri
	 * @date 24-09-2016
	 */
	public void clearQuantity(String index){
		switchToWebContext();
		clear(replaceDynamicText(txt_EnterItemQuantity, index));
		FrameworkReporter.info("Cleared item quantity");

	}
	/**
	 * @Function verifyItemCountIsDisplayedForAllLocations
	 * @Description To verify item count is displayed in paranthesis for all locations
	 * @author Gayathri
	 * @date 28-09-2016
	 */
	public void verifyItemCountIsDisplayedForAllLocations(){
		switchToWebContext();
		int locationCount=getElementCount(lst_LocationCount);
		for (int i=1;i<=locationCount;i++){
			if(isElementPresent(replaceDynamicText(lst_LocationItemCount, Integer.toString(i)))){
				FrameworkReporter.pass("Item count is displayed for location "+getElementText((replaceDynamicText(lst_LocationName, Integer.toString(i)))));
			}
			else{
				FrameworkReporter.fail("Item count is not displayed for location "+getElementText((replaceDynamicText(lst_LocationName, Integer.toString(i)))));
			}
		}


	}


	/**
	 * @Function verifyItemListViewIsDisplayed
	 * @Description To verify item list view is displayed
	 * @author Gayathri
	 * @date 28-09-2016
	 */
	public void verifyItemListViewIsDisplayed(){
		switchToWebContext();	
		String brand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
	//	if(!brand.equals("iphone")){	
			if(isElementPresent(lbl_ItemListView)){
				FrameworkReporter.pass("Item list view is displayed");
			}
			else{
				FrameworkReporter.fail("Item list view is not displayed");
			}
	/*	}else{
			if(isElementPresent(btn_FilterButton)){

				FrameworkReporter.pass("Item list view is displayed");
			}
			else{
				FrameworkReporter.fail("Item list view is not displayed");
			}
		}*/

	}


	/**
	 * @Function verifyNoItemsInLocation
	 * @Description To verify no items present in a location
	 * @author Gayathri
	 * @date 28-09-2016
	 */
	public void verifyNoItemsInLocation(){
		switchToWebContext();	
		if(getElementText(lbl_NoProductsfound).equals("No Products Found")){
			FrameworkReporter.pass("No items present in the location");
		}
		else{
			FrameworkReporter.fail("No items present in the location");
		}


	}



	/**
	 * @Function verifyKitchenOnboardingPage
	 * @Description To verify whether on boarding page is displayed after deleting all locations from manage locations page
	 * @author Periyasamy_Nainar
	 * @date 28-09-2016
	 */
	public void verifyKitchenOnboardingPage(){
		switchToWebContext();
		System.out.println(getElementText(lbl_KitchenOnboardingPage).toString());
		if(getElementText(lbl_KitchenOnboardingPage).toString().equalsIgnoreCase("Visualize how your kitchen is organized. Sysco Mobile Inventory should match your kitchen setup and flow.")){
			FrameworkReporter.pass("Visualize kitchen page is displayed as onboarding page after deleting all locations from manage locations page");
		}else{
			FrameworkReporter.fail("Visualize kitchen page is not displayed as onboarding page after deleting all locations from manage locations page");
		}



	}




	/** @Function selectAnItemFromProductList
	 * @Description To select an item fromproduct list
	 * @param strItemId - Item Name
	 * @author Parvathy P
	 * @date 28-09-2016
	 */

	public void selectAnItemFromProductList(String strItemName){
		switchToWebContext();

		
			moveToElement(replaceDynamicText(getObject(lbl_Product),strItemName));
			//Actions action = new Actions(getDriver());
			//action.moveToElement(waitForElementPresent(replaceDynamicText(lbl_Product,strItemName))).build().perform();;
			clickElement(replaceDynamicText(getObject(lbl_Product),strItemName));
			FrameworkReporter.info("Item : "+strItemName+ "is selected");
		
		
		
	}

	/** @Function swipeScreen
	 * @Description to swipe screen to direct to next page
	 * @author Periyasamy_Nainar
	 * @date 29-09-2016
	 */

	public void swipeScreen(){	
		swipeScreenInVertical(2,8);
	}

	/** @Function verifyProductCardDetailsInList
	 * @Description Verify product card details in list
	 * @author Gayathri Anand
	 * @date 29-09-2016
	 */

	public void verifyProductCardDetailsInList(boolean categoryPresent){
		//product description
		switchToWebContext();	
		if(isElementPresentAfterWait(replaceDynamicText(lbl_ProductDescription, "1"),10)){
			FrameworkReporter.pass("Product description is displayed in product card list");
		}
		else{
			FrameworkReporter.fail("Product description is not displayed in product card list");
		}
		//product image
		if(isElementPresentAfterWait(replaceDynamicText(img_ProductImage, "1"),10)){
			FrameworkReporter.pass("Product image is displayed in product card list");
		}
		else{
			FrameworkReporter.fail("Product image is not displayed in product card list");
		}
		//brand name
		if(isElementPresentAfterWait(replaceDynamicText(lbl_ProductBrand, "1"),10)){
			FrameworkReporter.pass("Product brand is displayed in product card list");
		}
		else{
			FrameworkReporter.fail("Product brand is not displayed in product card list");
		}
		//UPC/ID
		if(isElementPresentAfterWait(replaceDynamicText(lbl_ProductID, "1"),10)){
			FrameworkReporter.pass("Product UPC is displayed in product card list");
		}
		else{
			FrameworkReporter.fail("Product UPC is not displayed in product card list");
		}	
		//Pack/Size
		if(isElementPresentAfterWait(replaceDynamicText(lbl_ProductPackOrSize, "1"),10)){
			FrameworkReporter.pass("Product Pack/Size is displayed in product card list");
		}
		else{
			FrameworkReporter.fail("Product Pack/Size is not displayed in product card list");
		}
		if(categoryPresent){
			//category type
			if(isElementPresentAfterWait(replaceDynamicText(lbl_ProductCategory, "1"),10)){
				FrameworkReporter.pass("Product category is displayed in product card list");
			}
			else{
				FrameworkReporter.fail("Product category is not displayed in product card list");
			}	
		}
	}

	/**
	 * @Function selectCustomList
	 * @Description Select a custom list
	 * @param strListName
	 * @author Parvathy_P
	 * @date 26-09-2016
	 */

	public void deleteItem(String itemName){
		switchToWebContext();
		//tap on delete icon
		clickElement(replaceDynamicText(img_DeleteIcon,itemName));
		consolePrint(replaceDynamicText(img_DeleteIcon,itemName)[0]);
		//tap on the delete button
		clickElement(btn_DeleteProduct);
		FrameworkReporter.info("Item "+itemName+" is deleted." );

	}
	/**
	 * @Function verifyLocationOfAllItemsInList
	 * @Description To verify location of all items in a list
	 * @author Gayathri
	 * @date 29-09-2016
	 */
	public void verifyLocationOfAllItemsInList(String locationName){
		switchToWebContext();
		int itemCount=getElementCount(lbl_ProductNames);
		boolean isTrue=true;
		for (int i=1;i<=itemCount;i++) {
			switchToWebContext();			
				if(i>4){
					moveToElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
				}
					clickElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
					int locationCount=getElementCount(lbl_Location);
					boolean isLoc=false;
					for(int j=1;j<=locationCount;j++){
					if(getElementText(replaceDynamicText(lbl_LocationValue,Integer.toString(j))).trim().equalsIgnoreCase(locationName.trim())){
						isLoc=true;
						break;
					}
					}
					if(!isLoc){
						isTrue=false;
						break;
					}
					PageFactory pf =new PageFactory();
					pf.generic().tapClose();
					
				}
			if(isTrue){
				FrameworkReporter.pass("Location of all items in the list is displayed as "+locationName);
			}
			else{
				FrameworkReporter.fail("Location of all items in the list is not displayed as "+locationName);
			}
	}
	/**
	 * @Function verifyExpenseCategory
	 * @Description To verify location of all items in a list
	 * @author Parvathy
	 * @date 03-10-2016
	 */
	public void verifyExpenseCategory(String itemName,String expenseCategory,boolean isPresent){
		switchToWebContext();
		String expCategoryTxt = getElementText(replaceDynamicText(lbl_ExpenseCategory,itemName));
	/*	if(!(getElementText(replaceDynamicText(lbl_ExpenseCategory,itemName)).isEmpty())){
			expCategoryTxt = getElementText(replaceDynamicText(lbl_ExpenseCategory,itemName));
		}else{
			expCategoryTxt = "";
		}*/
		String expCat = expCategoryTxt.split("/")[0];
		if(isPresent)
		{
			if(expCat.trim().equalsIgnoreCase(expenseCategory.trim()))
			{

				FrameworkReporter.pass("Expense Category of the item "+itemName+" displayed as expected");
			}
			else{
				FrameworkReporter.fail("Expense Category of the item "+itemName+" not displayed as expected");

			}
		}
		else
		{
			if(expCat.trim().equalsIgnoreCase(expenseCategory.trim()))
			{
				FrameworkReporter.fail("Expense Category :"+expenseCategory+" is displayed for the item "+itemName);					
			}
			else{

				FrameworkReporter.pass("Expense Category :"+expenseCategory+" not displayed for the item "+itemName);				}

		}
	}


	
		
		/**
		 * @Function verifyAllItemsInLocation
		 * @Description  get All items from specific location and store it in array list
		 * @author Periyasamy Nainar
		 * @date 04-10-2016
		 */
		public void verifyAllItemsInLocation(){
			switchToWebContext();			
			List<WebElement> list = getElements(lbl_ProducIDs);
			ArrayList<String> listStoredItemIDs = (ArrayList<String>)mapObj.get("lstProductIds");
			
			int i = 0;
			for(WebElement ele: list){
				String strActual = ele.getText().toString();
						if(listStoredItemIDs.get(i).equalsIgnoreCase(strActual)){
							i++;
							FrameworkReporter.pass("Proudct ID '" +  strActual+ "' is displayed in item list page");
						}else{
							FrameworkReporter.fail("Proudct ID '" +  strActual+ "' is not displayed in item list page");
						}
			}			
						
}
		
		
		

		

	/**
	 * @Function getAllItemsFromLocation
	 * @Description  get All items from specific location and store it in array list
	 * @author Periyasamy Nainar
	 * @date 04-10-2016
	 */
	public void getAllItemsFromLocation(){
		switchToWebContext();			
		List<WebElement> list = getElements(lbl_ProducIDs);
		ArrayList<String> listIDs = new ArrayList<String>();

		for(WebElement ele: list){
			listIDs.add(ele.getText().toString());		
		}			
		mapObj.put("lstProductIds", listIDs);						

	}




	/**
	 * @Function verifyCategoryOfAllItemsInListFromProductCard
	 * @Description To verify category of all items in a list from product card
	 * @author Gayathri
	 * @date 04-10-2016
	 */
	public void verifyCategoryOfAllItemsInListFromProductCard(String categoryType,String...customCategories ){
		switchToWebContext();
		String[] categoryNames=null;
		boolean isTrue=true;
		int itemCount=getElementCount(lbl_ProductNames);
		switch (categoryType){
		case "default":
			categoryNames=new String[2];
			categoryNames[0]="Food";
			categoryNames[1]="Non-Food";
			break;
		case "suggested":
			categoryNames=new String[12];
			categoryNames[0]="Dairy";
			categoryNames[1]="Meat";
			categoryNames[2]="Poultry";
			categoryNames[3]="Seafood";
			categoryNames[4]="Produce";
			categoryNames[5]="Canned and Dry";
			categoryNames[6]="Dispenser Beverage";
			categoryNames[7]="Frozen";
			categoryNames[8]="Chemical & Janatorial";
			categoryNames[9]="Paper & Disposable";
			categoryNames[10]="Supplies & Equipment";
			categoryNames[11]="Healthcare & Hospitality";
			break;
		case "custom":
			categoryNames=customCategories;
			break;
		default:
			break;
		}
		if(!categoryType.equals("no category")){
			for (int i=1;i<=itemCount;i++) {
				switchToWebContext();
				boolean isCategoryFound=false;
				Actions builder=new Actions(getDriver());
				builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_Products,Integer.toString(i)))).build().perform();
				clickElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
				for (int j=0;j<categoryNames.length;j++){
					if(getElementText(lbl_ExpenseCategoryValue).equals(categoryNames[j])){
						isCategoryFound=true;
						break;
					}						
				}
				if(!isCategoryFound){
					isTrue=false;
				}
				PageFactory pf =new PageFactory();
				pf.generic().tapClose();
			}
			if(isTrue){
				FrameworkReporter.pass("Category of all items in the list is displayed as expected in product card");
			}
			else{
				FrameworkReporter.fail("Category of all items in the list is not displayed as expected in product card");
			}
		}
		else{
			for (int i=1;i<=itemCount;i++) {
				switchToWebContext();
				clickElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
				if(!getElementText(lbl_ExpenseCategoryValue).isEmpty()){
					isTrue=false;
				}
				PageFactory pf =new PageFactory();
				pf.generic().tapClose();
			}
			if(isTrue){
				FrameworkReporter.pass("No category is displayed for all items in product card");
			}
			else{
				FrameworkReporter.fail("Category is displayed for items in product card");
			}
		}
	}

	/**
	 * @Function tapAddItemForm
	 * @Description  tap on Add Item Form label
	 * @authorParvathy
	 * @date 04-10-2016
	 */
	public void tapAddItemForm(){
		switchToWebContext();			
		clickElement(lbl_AddItemFrom);		

	}
	/**
	 * @Function verifyItemCategoryAfterEditOfAllItemsInListAfterUpdate
	 * @Description To verify the category of all items in item list page for selected location after updating the category name
	 * @author Sujina_S
	 * @date 24-09-2016
	 */
	public void verifyItemCategoryAfterEditOfAllItemsInListAfterUpdate(String categoryType,String[] categoryNamesBefore, String[] categoryNamesAfter,String...customCategories){
		switchToWebContext();
		String[] categoryNames=null;
		boolean isTrue=true;
		switch (categoryType){
		case "default":
			categoryNames=new String[2];
			categoryNames[0]="Food";
			categoryNames[1]="Non-Food";
			break;
		case "suggested":
			categoryNames=new String[12];
			categoryNames[0]="Dairy";
			categoryNames[1]="Meat";
			categoryNames[2]="Poultry";
			categoryNames[3]="Seafood";
			categoryNames[4]="Produce";
			categoryNames[5]="Canned and Dry";
			categoryNames[6]="Dispenser Beverage";
			categoryNames[7]="Frozen";
			categoryNames[8]="Chemical & Janatorial";
			categoryNames[9]="Paper & Disposable";
			categoryNames[10]="Supplies & Equipment";
			categoryNames[11]="Healthcare & Hospitality";
			break;
		case "custom":
			categoryNames=customCategories;
			break;
		default:
			break;
		}
		for(int i=0;i<categoryNamesBefore.length;i++){
			for(int j=0;j<categoryNames.length;j++){
				if(categoryNames[j].equals(categoryNamesBefore[i])){
					categoryNames[j]=categoryNamesAfter[i];
					break;
				}
			}
		}
		List <WebElement> elements=getDriver().findElements(getLocatorsType(lbl_VerifyItemCategory));
		if(!categoryType.equals("no category")){
			for (WebElement element:elements){
				boolean isCategoryFound=false;
				for (int i=0;i<categoryNames.length;i++){
					if(element.getText().contains(categoryNames[i])){
						isCategoryFound=true;
						storeValue(categoryNames[i]+"items", getElementText(replaceDynamicText(lbl_ProductNameByIndex, Integer.toString(elements.indexOf(element)+1))));
						break;
					}
				}
				if(!isCategoryFound){
					isTrue=false;
				}
			}
			if(isTrue){
				FrameworkReporter.pass("Category of all items in the list is displayed as expected");
			}
			else{
				FrameworkReporter.fail("Category of all items in the list is not displayed as expected");
			}
		}

	
	}

	/**
	 * @Function verifyItemCategoryofAllItemsInList
	 * @Description To verify the category of all items in the location
	 * @author Asha
	 * @date 07-10-2016
	 */
	public void verifyItemCategoryofAllItemsInList(String categoryTypes, String... strCatType){
		switchToWebContext();
		boolean isTrue=true;
		PageFactory factoryObj = new PageFactory();
		String[] categoryNames = {};
		ArrayList<String> list = new ArrayList<String>();
		if(strCatType.length==0){
			categoryNames = categoryTypes.split("/");
		}else if(strCatType[0].toString().equalsIgnoreCase("suggested")){
			list=  factoryObj.nonSyscoPrepItem().getSuggestedCategories();
			categoryNames =  new String[list.size()];
			list.toArray(categoryNames);			
		}
		 
		List <WebElement> elements=getDriver().findElements(getLocatorsType(lbl_VerifyItemCategory));
		for (WebElement element:elements){
			boolean isCategoryFound=false;
			for (int i=0;i<categoryNames.length;i++){
				if(element.getText().contains(categoryNames[i])){
					isCategoryFound=true;
					break;
				}
			}
			if(!isCategoryFound){
				isTrue=false;
			}
		}
		if(isTrue){
			FrameworkReporter.pass("Category of all items in the list is displayed as expected");
		}
		else{
			FrameworkReporter.fail("Category of all items in the list is not displayed as expected");
		}
	}


	/*********
	 * Framework function : DO NOT UPDATE/DELETE
	 *********/
	public String[] getObject(String[] parentObject)
	{

		String[] childClassObject =null;
		String brand =ConfigFile.getProperty("brand").toString().toLowerCase().trim();
		switch (brand) {
		case "iphone":				
			//childClassObject= new IOSLocationsPage().findChildObject(parentObject[2]);	
			break;
		case "ipad":	
			childClassObject = new IOSTabletLocationsPage().findChildObject(parentObject[2]);	
			break;
		case "android":
			childClassObject = new AndroidLocationsPage().findChildObject(parentObject[2]);					
			break;
		case "android tablet":
			break;

		case "desktop":
			break;
		default:
			break;
		}

		if(null!=childClassObject){
			return childClassObject;}

		return parentObject;
	}
	/**
	 * @Function verifyCategoryOfAllItemsInListFromProductCardAfterUpdate
	 * @Description To verify category of all items in a list from product card after updating the category name
	 * @author Gayathri
	 * @date 05-10-2016
	 */
	public void verifyCategoryOfAllItemsInListFromProductCardAfterUpdate(String categoryType,String[] categoryNamesBefore, String[] categoryNamesAfter,String...customCategories ){
		switchToWebContext();
		String[] categoryNames=null;
		boolean isTrue=true;
		int itemCount=getElementCount(lbl_ProductNames);
		switch (categoryType){
		case "default":
			categoryNames=new String[2];
			categoryNames[0]="Food";
			categoryNames[1]="Non-Food";
			break;
		case "suggested":
			categoryNames=new String[12];
			categoryNames[0]="Dairy";
			categoryNames[1]="Meat";
			categoryNames[2]="Poultry";
			categoryNames[3]="Seafood";
			categoryNames[4]="Produce";
			categoryNames[5]="Canned and Dry";
			categoryNames[6]="Dispenser Beverage";
			categoryNames[7]="Frozen";
			categoryNames[8]="Chemical & Janatorial";
			categoryNames[9]="Paper & Disposable";
			categoryNames[10]="Supplies & Equipment";
			categoryNames[11]="Healthcare & Hospitality";
			break;
		case "custom":
			categoryNames=customCategories;
			break;
		default:
			break;
		}
		for(int i=0;i<categoryNamesBefore.length;i++){
			for(int j=0;j<categoryNames.length;j++){
				if(categoryNames[j].equals(categoryNamesBefore[i])){
					categoryNames[j]=categoryNamesAfter[i];
					break;
				}
			}
		}
		for (int i=1;i<=itemCount;i++) {
			switchToWebContext();
			boolean isCategoryFound=false;
			Actions builder=new Actions(getDriver());
			builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_Products,Integer.toString(i)))).build().perform();
			clickElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
			for (int j=0;j<categoryNames.length;j++){
				if(getElementText(lbl_ExpenseCategoryValue).equals(categoryNames[j])){
					isCategoryFound=true;
					break;
				}						
			}
			if(!isCategoryFound){
				isTrue=false;
			}
			PageFactory pf =new PageFactory();
			pf.generic().tapClose();
		}
		if(isTrue){
			FrameworkReporter.pass("Category of all items in the list is displayed as expected in product card");
		}
		else{
			FrameworkReporter.fail("Category of all items in the list is not displayed as expected in product card");
		}

	}




	/**
	 * @Function verifyCategoryOfDeletedCategoryItems
	 * @Description To verify no category is displayed for items associated to a deleted category
	 * @author Gayathri
	 * @date 05-10-2016
	 */
	public void verifyCategoryOfDeletedCategoryItems(String categoryName){
		String categoryItem="";
		if(!retreiveStoredValue(categoryName+"items").toString().equalsIgnoreCase("null")){
			categoryItem=retreiveStoredValue(categoryName+"items").toString();

			if(!isElementPresent(replaceDynamicText(lbl_ProductExpenseCategory,categoryItem,categoryName)))
			{

				FrameworkReporter.pass("No category is displayed for item "+categoryItem+" in item list");
			}
			else{
				FrameworkReporter.fail("Category is displayed for item "+categoryItem+" in item list");
			}
			verifyNoCategoryForItemInProductPage(categoryItem);
		}
		else{
			FrameworkReporter.info("No item in the location was having the category "+categoryName);
		}
	}
	/**
	 * @Function verifyNoCategoryForItemInProductPage
	 * @Description To verify no category is selected for an item
	 * @author Gayathri
	 * @date 05-10-2016
	 */
	public void verifyNoCategoryForItemInProductPage(String itemName){
		switchToWebContext();
		clickElement(replaceDynamicText(lbl_Product, itemName));
		if(getElementText(lbl_ExpenseCategoryValue).isEmpty())
		{
			FrameworkReporter.pass("No category is displayed for item "+itemName+" in product card");
		}
		else{
			FrameworkReporter.fail("Category is displayed for item "+itemName+" in product card");

		}
		PageFactory pf=new PageFactory();
		pf.generic().tapClose();
	}

	/**
	 * @Function verifyItemsCountInLocation
	 * @Description To verify all items count in location Page
	 * @author Asha
	 * @date 05-10-2016
	 */
	public void verifyItemsCountInLocation(String itemsCount){
		switchToWebContext();
		int itemCountAct=getElementCount(lbl_ProductNames);
		String count = Integer.toString(itemCountAct);

		if(count.contains(itemsCount)){
			FrameworkReporter.pass("All items Count in Location is correct as expected as "+itemsCount);
		}
		else{
			FrameworkReporter.fail("All items Count in Location is not correct as expected as "+itemsCount);
		}


	}


	/**
	 * @Function verifyLocationInListMultipleLocation
	 * @Description Verify whether assigned locations from Setup Inventory has successfully been created in Track Inventory
	 * @param strAssignLocation - Location assigned for desired items from setup inventory
	 * @author Reshma S Farook
	 * @date 06-10-2016
	 */
	public void verifyLocationInListMultipleLocation (String strAssignLocation)
	{
		for(int i = 0; i<strAssignLocation.split("/").length; i++) 
		{
			System.out.println(strAssignLocation.split("/")[i].toString());
			verifyLocationInList(strAssignLocation.split("/")[i].toString(),true);
		}
	}

	/**
	 * @Function verifyWhetherItemInLocation
	 * @Description Verify whether the item is present in location when the user many items are mapped to single location
	 * @param strLocationName - string of Locations name ,strProductDetails - UPCID or ProductName of the product,strVerificationBy - Is the verification done by UPCID/ProductName,isExpected - verification whether product is expected in the location given
	 * @author Reshma S Farook
	 * @date 06-10-2016
	 */
	public void verifyWhetherItemInLocation(String strLocationName,String strProductDetails, String strVerificationBy,boolean isExpected)
	{
		switchToWebContext();
		int itemCount=getElementCount(lbl_ProductNames);	
		System.out.println("No of items in the given location " +strLocationName+ " is " +itemCount);
		if(strProductDetails.contains("/"))
		{
			for( int i=0; i<strProductDetails.split("/").length;i++)	   {	
				System.out.println("Searching given location "+strLocationName+ " for product with " +strVerificationBy+ " " +strProductDetails.split("/")[i]);
				verifyItemPresentInLocation(strProductDetails.split("/")[i], strVerificationBy,isExpected);
			}
		}
		else
		{
			System.out.println("Searching given location "+strLocationName+ " for product with " +strVerificationBy+ " " +strProductDetails);
			verifyItemPresentInLocation(strProductDetails, strVerificationBy,isExpected);
		}
	}
	/**
	 * @Function verifyIfProductCardDetailsAreDisplayedFortheItemSelected
	 * @Description To verify If Product Card Details Are Displayed For the Item Selected
	 * @author Reshma
	 * @date 06-10-2016
	 */
	public void verifyIfProductCardDetailsAreDisplayedFortheItemSelected(){
		switchToWebContext();
		int itemCount=getElementCount(lbl_ProductNames);
		boolean isTrue=true;
		Actions builder=new Actions(getDriver());	        
		for (int i=1;i<=itemCount;i++) {				
			switchToWebContext();
			if(i>4){
				builder.moveToElement(waitForElementPresent(replaceDynamicText(lbl_Products, Integer.toString(i)))).build().perform();
			}					
			verifyProductCardDetailsInList(true);
			clickElement(replaceDynamicText(lbl_Products,Integer.toString(i)));
			/*if(!getElementText(replaceDynamicText(lbl_LocationValue, "1")).equals(locationName)){
						isTrue=false;
					}*/
			PageFactory pf =new PageFactory();
			pf.generic().tapClose();
		}
		/*if(isTrue){
					FrameworkReporter.pass("Location of all items in the list is displayed as "+locationName);
				}
				else{
					FrameworkReporter.fail("Location of all items in the list is not displayed as "+locationName);
				}*/
	}
	/**
	 * @Function verifyQuantityIsEmpty
	 * @Description To verify quantity quantity is empty
	 * @param strQty - quantity value
	 * @author Gayathri
	 * @date 27-09-2016
	 */
	public void verifyQuantityIsEmpty(String index){
		switchToWebContext();
		if(getElementAttributeValue(replaceDynamicText(txt_EnterItemQuantity, index),"value").isEmpty()){
			FrameworkReporter.pass("Quantity displayed as expected");

		}
		else{
			FrameworkReporter.fail("Quantity not displayed as expected");

		}


	}


	/**
	 * @Function verifyAssignedItemsInLocation
	 * @Description To verify only items assigned during setup inventory are present in a location
	 * @author Gayathri
	 * @date 13-10-2016
	 */
	public void verifyAssignedItemsInLocation(String strLocationName){
		switchToWebContext();
		waitForPageLoadAndroid(5);
		int locationLastIndex=Integer.parseInt(retreiveStoredValue(strLocationName+"_index").toString());
		String itemName="";
		if(locationLastIndex==getElementCount(lbl_ItemsInLocation)){
			FrameworkReporter.pass("Item count is same as expected.");
		}
		else{
			FrameworkReporter.fail("Item count is not same as expected. Expected:"+locationLastIndex+", Actual:"+getElementCount(lbl_ItemsInLocation));
		}
		for(int i=1;i<=locationLastIndex;i++){
			itemName=retreiveStoredValue(strLocationName+"_item"+i).toString();
			verifyItemPresentInLocation(itemName);
		}
	}

	/**
	 * @Function enterQuantityAndVerifyForTheItem
	 * @Description To enter the quantity and verifying the quantity updated for the item displayed for all items and uncounted item filters
	 * @param strLocationName,strQunatity,strIndex
	 * @author Sampada
	 * @date 12-10-2016
	 */
	public void enterQuantityAndVerifyForTheItem(String strLocationName,String strQunatity,String[] strArrIndex,boolean hasItemVerify){
		switchToWebContext();	
		String strFilterText=getElementText(btn_FilterButton);
		int iLoopCount=0;
		if(hasItemVerify){	
			if(getElements(txt_ItemQuantity).size()!=0){
				consolePrint("PASSED: User is able to view the items in the :" + strLocationName+" under the filter "+strFilterText);	
				if(strQunatity!=null || strArrIndex!=null){
					if(strArrIndex[0].equalsIgnoreCase("All")){
						iLoopCount=getElements(txt_ItemQuantity).size();
					}
					else{
						if(getElements(txt_ItemQuantity).size()<=strArrIndex.length){
							iLoopCount=getElements(txt_ItemQuantity).size();
						}else{
							iLoopCount=strArrIndex.length;
						}
					}
					for (int iCount = 0; iCount < iLoopCount; iCount++) {
						if(!strArrIndex[0].equalsIgnoreCase("All")){
							waitFor(1);
							sendText(replaceDynamicText(getObject(txt_EnterItemQuantity), strArrIndex[iCount]), strQunatity);
						}else{
							waitFor(1);
							if(ConfigFile.getProperty("brand").equalsIgnoreCase("Android")){
								Actions action = new Actions(getDriver());
								action.moveToElement(waitForElementPresent(replaceDynamicText(getObject(txt_EnterItemQuantity), ""+iCount+1))).build().perform();
							}
							sendText(replaceDynamicText(getObject(txt_EnterItemQuantity), ""+iCount+1), strQunatity);
						}
						FrameworkReporter.info("Entered qunatity for the item in the location :" + strLocationName);
						String strQunatityValue="";
						if(!strArrIndex[0].equalsIgnoreCase("All")){
							strQunatityValue=getElementAttributeValue(replaceDynamicText(getObject(txt_EnterItemQuantity), strArrIndex[iCount]),"value");
						}else{
							strQunatityValue=getElementAttributeValue(replaceDynamicText(getObject(txt_EnterItemQuantity), ""+iCount+1),"value");
						}
						if (strQunatityValue.trim().equals(strQunatity)) {
							FrameworkReporter.pass("Item quantity displayed as expected :" + strQunatity);

						} else {
							FrameworkReporter.fail("Item quantity is not displayed as expected value: " + strQunatity+ ", displayed as: " + getElementText(replaceDynamicText(getObject(txt_EnterItemQuantity), strArrIndex[iCount])));

						}
					}
				}
			}

			else{
				consolePrint("Fail: Items are not available in the location :"+strLocationName +" under the filter "+strFilterText);
				FrameworkReporter.fail("Items are no available for the location :"+strLocationName+" , Hence quantity can not be entered");

			}
		}else{
			if(getElements(txt_ItemQuantity).size()==0){
				consolePrint("PASSED: User is not able to view the items in the :" + strLocationName+" under the filter "+strFilterText+" as expected");	
			}else{
				consolePrint("PASSED: User is  able to view the items in the :" + strLocationName+" under the filter "+strFilterText);
			}
		}
	}

	/**
	 * @Function clickOnFilterForAllItemAndUncounted
	 * @Description click on all item and uncounted filter
	 * @param 
	 * @author Sampada
	 * @date 12-10-2016
	 */
	public void clickOnFilterForAllItemAndUncounted(){
		switchToWebContext();
		String strFilterText=getElementText(btn_FilterButton);
		if(isElementPresentAfterWait(btn_FilterButton,20)){
			clickElement(btn_FilterButton);
			FrameworkReporter.pass("Clicked on filter type :"+strFilterText);
		}else{
			FrameworkReporter.fail("Filter type is not clicked");
		}

		}
		
		/**
		 * @Function getAllProductsFromInventoryList
		 * @Description To get all products from inventory list for validation, validating both id & product name
		 * @param strLocationName - location name 
		 * @author Periyasamy nainar
		 * @date 11-10-2016
		 */
		public void getAllProductsFromInventoryList(String strLocationName){
			
			String strKey,  strValue;
			switchToWebContext();
			List<WebElement> elements = getElements(lbl_ProductNames);
			int i=1;
			for(WebElement ele: elements){				
				strKey = waitForElementPresent(replaceDynamicText(lbl_ProductIDNumber, Integer.toString(i))).getText();				
				strValue =ele.getText().toString();
				System.out.println("Key: " + strKey + "Value: " + strValue);
				productMap.put(strLocationName+strKey, strValue);
				i++;
			}
			storeValue("itemCountIn"+strLocationName, elements.size());
		}
		
			
			/**
			 * @Function verifyProductsFromInventoryList
			 * @Description verify all the products are displayed as expected in inventory list page, validating both id & name
			 * @param  strOldLocName - old location name,  strLocationName - updated location name
			 * @author Periyasamy nainar
			 * @date 11-10-2016
			 */
			public void verifyProductsFromInventoryList(String strOldLocName, String strLocationName){
				
				switchToWebContext();
				Boolean boolVal = false;
				List<WebElement> elements = getElements(lbl_ProductNames);
				System.out.println("");
				int i=1;
				System.out.println(elements.size());
				System.out.println(Integer.parseInt(retreiveStoredValue("itemCountIn"+strOldLocName).toString()));
				if(elements.size() == Integer.parseInt(retreiveStoredValue("itemCountIn"+strOldLocName).toString())){
					FrameworkReporter.pass("Same number of items are displayed in inventory list page before and after editing location");
				}else{
					FrameworkReporter.fail("Same number of items are not displayed in inventory list page before and after editing location");
				}
				
				
				
				
				for(WebElement ele: elements){		
					for(Map.Entry<Object, String> obj: productMap.entrySet())
					{
						if(productMap.get(obj.getKey()).toString().equalsIgnoreCase(ele.getText())){
							boolVal = true;
							break;
						}
					}
					if(boolVal){
						FrameworkReporter.pass("Product '"+ ele.getText() + "' is displayed in invetory list before" +strOldLocName+ " and after " + strLocationName+ " updating location");
					}else{
						FrameworkReporter.fail("Product '"+ ele.getText() + "' is not displayed in invetory list before" +strOldLocName+ " and after " + strLocationName+ " updating location");
					}
					
				}
				

		}
		
			
			
			
			/** @Function verifyLocationNameInInventoryList
			 * @Description To verify location name is displayede in inventory page with item details if an item is present in multiple location
			 * @param strProductName - product name to check , strLocationName - LocationName to be verified
			 * @author Periyasamy Nainar
			 * @date 11-10-2016
			 */

			public void verifyLocationNameInInventoryList(String strProductName, String strLocationName){
				switchToWebContext();
				consolePrint(getElementText(replaceDynamicText(lbl_ExpenseCategory,strProductName)));
				if(getElementText(replaceDynamicText(lbl_ExpenseCategory,strProductName)).trim().contains(strLocationName.trim()))
				{
					
					FrameworkReporter.pass("Another location" + strLocationName+ " of the item "+strProductName+" displayed as expected");
				}
				else{
					FrameworkReporter.fail("Another location "+ strLocationName + " of the item " + strProductName+" not displayed as expected");
					
				}
				
			}
			

			/** @Function verifyAssignedProductsInInventoryList
			 * @Description To verify location name is displayede in inventory page with item details if an item is present in multiple location
			 * @param  strLocationName - LocationName to be verified
			 * @author Periyasamy Nainar
			 * @date 13-10-2016
			 */

			public void verifyAssignedProductsInInventoryList(String strLocationName){
				switchToWebContext();			
			
								
				int itemCount=0;		
				
				List<WebElement> elements = getElements(lbl_ProductNames);
				for(WebElement ele: elements){
					Boolean boolVal = false;
					String strActualText = ele.getText().toLowerCase();
					for(Map.Entry<String, String> obj: locItemMap.entrySet())
					{
						if(obj.getKey().toLowerCase().contains(strLocationName.toLowerCase())){
							consolePrint("key:  "+ obj.getKey()+ " Value: "+ obj.getValue());
							consolePrint(obj.getValue().toLowerCase()+ " "+ strActualText);
							if(obj.getValue().toLowerCase().contains(strActualText)){
								boolVal = true;
								itemCount++;
								break;							
						}
					}
											
					}
					if(boolVal){
						FrameworkReporter.pass("Product '"+ ele.getText() + "' is displayed in invetory list for the location "+ strLocationName);
					}else{
						FrameworkReporter.fail("Product '"+ ele.getText() + "' is not displayed in invetory list for the location "+ strLocationName);
						}
				}
				consolePrint("itemCount: " + itemCount + " elements.size(): "+ elements.size());
				if(itemCount == elements.size()){					
					FrameworkReporter.pass("Item count in inventory list page and assign products page is correct");
				}else{
					FrameworkReporter.fail("Item count in inventory list page and assign products page is not correct");
				}

		}
			
			
			
		/**
		 * @Function verifyQuantityAndUOMAttribute
		 * @Description To verify quantity and uom attribute fields are displayed for an item
		 * @author Parvathy
		 * @date 13-10-2016
		 */
	
		public void verifyQuantityAndUOMAttributeWithItemName(String strName,String quantity, String uom,String...strings){
			switchToWebContext();
			if(strings.length >0 && strings[0].equalsIgnoreCase("true"))
			{
				if(strings.length ==2)
				{
					strName= retreiveStoredValue("ProductName"+strings[1]).toString();
				}
				else
				{
					strName= retreiveStoredValue("ProductName").toString();
				}
			}
			int itemposition =1;
			if(strName.length()<=3){
				itemposition = Integer.parseInt(strName);    // adding this line of code to send index value in strName parameter 
			}else{
			//get the location with item name
					List<WebElement> elms = getElements(lbl_ProductNames);
					for(WebElement elm: elms)
					{
						if(elm.getText().trim().equalsIgnoreCase(strName.trim()))
						{
							break;
						}
						itemposition++;
					}
			}
			consolePrint(itemposition+"   ddd" );
			if(itemposition<0)
			{
				FrameworkReporter.fail("Item :"+strName+" not presnet in the list");
			}
			else
			{
				//Quantity verification
				consolePrint("inside " );
				if(! (quantity.trim().equalsIgnoreCase("null") || (quantity.isEmpty())))
				{
					if(!getElementAttributeValue(replaceDynamicText(txt_EnterItemQuantity, Integer.toString(itemposition)),"placeholder").isEmpty())
						{consolePrint("act: "+getElementAttributeValue(replaceDynamicText(txt_EnterItemQuantity, Integer.toString(itemposition)),"placeholder"));
						consolePrint("exp: "+quantity.trim());
							if(getElementAttributeValue(replaceDynamicText(txt_EnterItemQuantity, Integer.toString(itemposition)),"placeholder").trim().equalsIgnoreCase(quantity.trim()))
								{
									FrameworkReporter.pass("Quantity displayed as expected for "+strName);
								}
							else
							{
								FrameworkReporter.fail("Quantity not displayed correctly for "+strName);
							}
						}
						else
						{
							FrameworkReporter.fail("Quantity not displayed correctly for "+strName);
						}
				}
				else
				{
					if(getElementAttributeValue(replaceDynamicText(txt_EnterItemQuantity, Integer.toString(itemposition)),"value").isEmpty())
					{
						FrameworkReporter.pass("Quantity displayed as expected for "+strName);
						
					}
					else
					{
						FrameworkReporter.fail("Quantity not displayed correctly for "+strName);
					}
				}
				
				//UOM Verification
				//Select sel1 = new Select(getDriver().findElement(By.xpath("//*[contains(@class,'mm-c-product-list__item mm-c-product__sysco ')][4]//*[@class='mm-u-product-uom-wrapper form-group']//select")));
				Select sel = new Select(waitForElementPresent(replaceDynamicText(lst_uom,Integer.toString(itemposition))));
				String strUOM =	sel.getFirstSelectedOption().getText();	
				consolePrint(strUOM+"  ");
				if(strUOM.trim().equalsIgnoreCase(uom.trim()))
				{
					FrameworkReporter.pass("UOM displayed as expected for "+strName);
				}
				else
				{
					FrameworkReporter.fail("UOM not displayed correctly for "+strName);
				}
			}
		}
		
		
		/** @Function verifyCategoryOfAssignedProductsInInventoryList
		 * @Description To verify category name displayed in inventory page with item details if an item is present in multiple location
		 * @param strLocationName - LocationName to be verified
		 * @author Periyasamy Nainar
		 * @date 14-10-2016
		 */

		public void verifyCategoryOfAssignedProductsInInventoryList(String strLocationName){
			switchToWebContext();			
		
							
	
			
			List<WebElement> elements = getElements(lbl_ProductNames);
			for(WebElement ele: elements){
//				Boolean boolVal = false;
				String strActualText = ele.getText();				
				
				for(Map.Entry<String, String> obj: locItemMap.entrySet())
				{					
					if(obj.getKey().equalsIgnoreCase(ele.getText())){						
						consolePrint("key:  "+ obj.getKey()+ " Value: "+ obj.getValue());
						consolePrint(obj.getValue().toLowerCase()+ " "+ strActualText);
						//strCat = getElementText(lbl_ProductCategory);
						if(obj.getValue().equalsIgnoreCase("nocategory")){
							verifyExpenseCategory(strActualText, obj.getValue(), false); 
						}else{
							verifyExpenseCategory(strActualText, obj.getValue(), true);   // using existing function
						}
							break;
						/*if(obj.getValue().equalsIgnoreCase(strCat)){
							boolVal = true;							
							break;	
						}*/
					}
				}						
					
					/*if(boolVal){
						FrameworkReporter.pass("Product '"+ ele.getText() + "' is displayed with correct category '"+ strCat +"in invetory list for the location "+ strLocationName);
					}else{
						FrameworkReporter.fail("Product '"+ ele.getText() + "' is not displayed with correct category '"+ strCat +"in invetory list for the location "+ strLocationName);
						}*/
										
				}
				
			}

		/**
		 * @Function verifyDefaultLocationsAnyOrder
		 * @Description To verify the default locations  displayed on Locations page when they are displayed in any order
		 * @param cooler - Default location Cooler,freezer - Default location freezer,dry - Default location dry
		 * @author Reshma S Farook
		 * @date 14-10-2016
		 */
		public void verifyDefaultLocationsAnyOrder(){
		
			switchToWebContext();
			String strDefaultLocation1=getElementText(replaceDynamicText(lbl_DefaultLocation,"1")).toString();
			String strDefaultLocation2=getElementText(replaceDynamicText(lbl_DefaultLocation,"2")).toString();
			String strDefaultLocation3=getElementText(replaceDynamicText(lbl_DefaultLocation,"3")).toString();
			System.out.println(getElementText(replaceDynamicText(lbl_DefaultLocation,"1")).toString());
			System.out.println(getElementText(replaceDynamicText(lbl_DefaultLocation,"2")).toString());
			System.out.println(getElementText(replaceDynamicText(lbl_DefaultLocation,"3")).toString());
			
			if(strDefaultLocation1.contains(COOLER) || strDefaultLocation1.contains(DRY) || strDefaultLocation1.contains(FREEZER))
			{
				FrameworkReporter.pass(strDefaultLocation1+ " is displayed on default location list");
			}
			else 
			{
				FrameworkReporter.fail(strDefaultLocation1+ " is not displayed on default location list");
			}
			if(strDefaultLocation2.contains(COOLER) || strDefaultLocation2.contains(DRY) || strDefaultLocation2.contains(FREEZER))
			{
				FrameworkReporter.pass(strDefaultLocation2+ " is displayed on default location list");
			}
			else 
			{
				FrameworkReporter.fail(strDefaultLocation2+ " is not displayed on default location list");
			}
			if(strDefaultLocation3.contains(COOLER) || strDefaultLocation3.contains(DRY) || strDefaultLocation3.contains(FREEZER))
			{
				FrameworkReporter.pass(strDefaultLocation3+ " is displayed on default location list");
			}
			else 
			{
				FrameworkReporter.fail(strDefaultLocation3+ " is not displayed on default location list");
			}
		}
	

		/**
		 * @Function verifyDeletedProductsInNoLocationList
		 * @Description verify all the products deleted from any location is moved to no locations list except the product which is present in multiple location 
		 * @param  strOldLocName - old location name,  strLocationName - updated location name
		 * @author Periyasamy nainar
		 * @date 15-10-2016
		 */
		public void verifyDeletedProductsInNoLocationList(String strOldLocName, String strLocationName, String ...strProdInMultiLoc) {
			
			switchToWebContext();
			Boolean boolVal = false;
			List<WebElement> elements = getElements(lbl_ProductNames);
			System.out.println("");
			int iDeletedItemCount = 1;
			
			if(strProdInMultiLoc.length!=0){			
			String[] strProductInMultiLoc= strProdInMultiLoc;					
				//verify if an item present in multiple location, it should be deleted while deleting the location
				for(WebElement ele: elements){		
					for(int j=0; j< strProductInMultiLoc.length; j++){
						if(strProductInMultiLoc[j].toLowerCase().contains(ele.getText().toLowerCase())){
							FrameworkReporter.fail("Item present in mutli location is moved to no location while deleting 1 location: "+ strProductInMultiLoc[j]);
						} 
					}
				}
			}
				
				for(Map.Entry<Object, String> obj: productMap.entrySet())
				{
					if(obj.getKey().toString().contains(strOldLocName)){
						for(WebElement ele: elements){	
							if(ele.getText().equalsIgnoreCase(obj.getValue().toString())){
								boolVal = true;
								iDeletedItemCount++;
								break;
							}
						}
						if(boolVal){
							FrameworkReporter.pass("Product '"+ obj.getValue().toString() + "' is moved from deleted location " +strOldLocName+ " to " + strLocationName);
						}else{
							FrameworkReporter.fail("Product '"+ obj.getValue().toString() + "' is not moved from deleted location " +strOldLocName+ " to " + strLocationName);
						}
					}
				}
				
				if(iDeletedItemCount==1){
					FrameworkReporter.fail("Items are not moved from old location to no location after deleting the location");
				}
						

		}

		
		
		
		
		/**
		 * @Function verifyNumberOfLocation
		 * @Description To verify the number oflocation displayed in locations page
		 * @author Periyasamy Nainar
		 * @param  strCount - Number of locations
		 * @date 21-10-2016
		 */
		public void verifyNumberOfLocation(String strCount){
			switchToWebContext();		
					
			if(getElementCount(lst_LocationCount) == Integer.parseInt(strCount)){			
					FrameworkReporter.pass("Number of locations are dispalyed correctly as expected in suppliers page. count: "+ strCount);
				}
				else{
					FrameworkReporter.fail("Number of locations are not displayed correctly as expected in suppliers page. count: "+ strCount);
				}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		/**
		 * @Function tapOnLocationHeader
		 * @Description Tap on location header to reflect the background color selection for an item in inventory list page
		 * @author Periyasamy_Nainar
		 * @date 17-10-2016
		 */
		public void tapOnLocationHeader(String strLocationName){
			switchToWebContext();
			clickElement(replaceDynamicText(lbl_LocationPage, strLocationName));
			FrameworkReporter.info("Tapped on location header" + strLocationName );
		}
		
		
		
		
		/**
		 * @Function verifyItemBackGroundHighlightColor
		 * @Description verify item is highlighted and background color is displayed in inventory list once the user enter a quantity
		 * @param  strOldLocName - old location name,  strLocationName - updated location name
		 * @author Periyasamy nainar
		 * @date 17-10-2016
		 */
		public void verifyItemBackGroundHighlightColor(String strIndexVal, boolean isSelected, String strProductName ) {
			
			switchToWebContext();
			WebElement ele = null;
			String strIndex = "";
			int i=0;
			if(strProductName.isEmpty()){
				strIndex = strIndexVal;
			}else{
			//	List<WebElement> elements= getElements(lbl_LineItemsInList);
				List<WebElement> elements= getElements(lbl_LineItemsInList);
				int iCount = elements.size();
						
				for (WebElement element: elements) {
					i++;
					System.out.println(elements.size());
					System.out.println(element.getText());
					if(element.getText().contains(strProductName)){
						break;
					}
				}
				strIndex = Integer.toString(i);
			}
			System.out.println("test");
			if(isSelected){				
				//verifyBackGroundColor(replaceDynamicText(lbl_InventoryListSelectedLineItem,strIndex), "F4FAFF");
				verifyBackGroundColor(replaceDynamicText(lbl_InventoryListSelectedLineItem,strIndex), "E2F2FA");
				if(getElementAttributeValue(replaceDynamicText(lbl_InventoryListSelectedLineItem,strIndex), "class").toString().equalsIgnoreCase("mm-c-product-list__item mm-c-product__sysco mm-c-product-list__tracked-change")){
					FrameworkReporter.pass("Item is highlighted with blue color background after entering the quantity in position: " + strIndex);
				}else{
					FrameworkReporter.fail("Item is not highlighted with blue color background after entering the quantity in position: " + strIndex);
				}
				
			}else{
				verifyBackGroundColor(replaceDynamicText(lbl_InventoryListSelectedLineItem,strIndex), "000");
				consolePrint("mm-c-product-list__item mm-c-product__sysco");
				consolePrint(getElementAttributeValue(replaceDynamicText(lbl_InventoryListSelectedLineItem,strIndex), "class").toString().replace(" ", ""));
				if(getElementAttributeValue(replaceDynamicText(lbl_InventoryListSelectedLineItem,strIndex), "class").toString().replace(" ", "").trim().equalsIgnoreCase("mm-c-product-list__item mm-c-product__sysco".replace(" ", ""))){
					FrameworkReporter.pass("Item is not highlighted with blue color background without entering the quantity in position: " + strIndex);
				}else{
					FrameworkReporter.fail("Item is  highlighted with blue color background without entering the quantity in position: " + strIndex);
				}
			}
			
			
				
		}
		
		
		/**
		 * @Function verifySearchIcon
		 * @Description verify search icon in item list page
		 * @author Periyasamy nainar
		 * @date 18-10-2016
		 */

		public void  verifySearchIconInItemList(){
			switchToWebContext();
			if(isElementPresentAfterWait(txt_Search, 5)){
				FrameworkReporter.pass("Search icon is displayed in item list page view");
			}else{
				FrameworkReporter.pass("Search icon is not displayed in item list page view");
			}


		}
		
		/**
		 * @Function verifyEditItemListDeleteRearrangeIcon
		 * @Description verify Edit item list page with delete and rearrange icons
		 * @author Periyasamy nainar
		 * @date 18-10-2016
		 */

		public void  verifyEditItemListDeleteRearrangeIcon(){
			switchToWebContext();
			if(isElementPresentAfterWait(lbl_EditItemListPage, 5)){
				FrameworkReporter.pass("Edit inventory item list page is displayed");
			}else{
				FrameworkReporter.pass("Edit inventory item list page is not displayed");
			}
			
			int iNumberOfItems = getElementCount(lbl_EditItems);
			
			for(int i=1; i<=iNumberOfItems; i++){
				
				if(isElementPresentAfterWait(replaceDynamicText(btn_RearrageIconForItem,Integer.toString(i)), 5)){
					FrameworkReporter.pass("Rearrange icon is displayed for "+ i+ "st line item in edit item list page");
				}else{
					FrameworkReporter.fail("Rearrange icon is not displayed for "+ i+ "st line item in edit item list page");
				}
				
				
				if(isElementPresentAfterWait(replaceDynamicText(btn_DeleteIconForItem,Integer.toString(i)), 5)){
					FrameworkReporter.pass("Delete icon is displayed for "+ i+ "st line item in edit item list page");
				}else{
					FrameworkReporter.fail("Delete icon is not displayed for "+ i+ "st line item in edit item list page");
				}			

			}
		
		}
		
		
		/**
		 * @Function verifyDeleteConfirmationPopUp
		 * @Description verify delete confirmation pop up is displayed or not
		 * @author Periyasamy nainar
		 * @date 18-10-2016
		 */

		public void  verifyDeleteConfirmationPopUp(){
			switchToWebContext();
			if(isElementPresentAfterWait(lbl_DeleteConfirmationPopUp, 5)){
				FrameworkReporter.pass("Delete confirmation pop up is displayed");
			}else{
				FrameworkReporter.pass("Delete confirmation pop up is not displayed");
			}


		}
		
		
	
		
		/**
		 * @Function verifyProductImageInListView
		 * @Description verify product image in item list page
		 * @author Periyasamy nainar
		 * @date 18-10-2016
		 */

		public void  verifyProductImageInListView(String strItemID){			
		
			switchToWebContext();
			int iCount = getElementCount(img_ProductImagesInListPage);		
			Boolean boolVal = false;
		
			for(int i=1; i <= iCount; i++){			
			
				if(getElementText(replaceDynamicText(lbl_ProductID, Integer.toString(i))).contains(strItemID)){   // item id verification
					boolVal = true;
					String strActualText = getElementAttributeValue(replaceDynamicText(img_IndivialProductImageInListPage,Integer.toString(i)),"src");
					if(strActualText.contains("http://sysco-cdn.madmobile.com/?width=100") && strActualText.contains(strItemID) && strActualText.contains("Fweb") && strActualText.contains(".png")){
						FrameworkReporter.pass("image is displayed in list view for an item with ID " + strItemID);
						break;   // validation for 1 item at a time
					}else{
						FrameworkReporter.fail("image is not displayed in list view for an item with ID " + strItemID);
					}					
					
				}					
			}
			
			if(!boolVal){
				FrameworkReporter.fail("Item is not displayed in inventory item list page with item id: "+ strItemID);
			}
		
		}
		
		
		

		/**
		 * @Function getItemPrice
		 * @Description get price of item
		 * @param 
		 * @author Gayathri
		 * @throws FileNotFoundException 
		 * @date 17-10-2016
		 */
		public void getItemPrice(String index) throws FileNotFoundException{
			switchToWebContext();
			String itemName=retreiveStoredValue("Item"+index).toString();
			String itemPrice=ProductDetails.getPrice(itemName);
			storeValue("Item"+index+"Price", itemPrice);
			}
		
		/**
		 * @Function getInventoryValue
		 * @Description get Current Inventory value
		 * @param 
		 * @author Gayathri
		 * @date 17-10-2016
		 */
		public void getInventoryValue(String numberOFItems,String categoryType){
			String foodCategories="";
			switch (categoryType){
			case "default":
				foodCategories="Food";
			break;
			case "suggested":
				foodCategories="Healthcare & Hospitality/Dairy/Meat/Poultry/Seafood/Frozen/Canned and Dry/Produce";
			break;
			case "custom":
			foodCategories=retreiveStoredValue("FoodCategories").toString();
			break;
			}
			int itemNum=Integer.parseInt(numberOFItems);
			String itemName="";
			String itemCategory="";
			double itemQty=0;
			double itemPrice=0;
			double inventoryValue=0;
			DecimalFormat df=new DecimalFormat("0.00");
			for (int i=1;i<=itemNum;i++){
				itemName=retreiveStoredValue("Item"+i).toString();
				itemCategory=getElementText(replaceDynamicText(lbl_ExpenseCategory, itemName)).split("/")[0];
				for(int j=0;j<foodCategories.split("/").length;j++){
					if(itemCategory.equalsIgnoreCase(foodCategories.split("/")[j])){
						itemQty=Double.parseDouble(retreiveStoredValue("Item"+i+"Qty").toString());
						itemPrice=Double.parseDouble(retreiveStoredValue("Item"+i+"Price").toString().replace("$", ""));
						inventoryValue=inventoryValue+(itemQty*itemPrice);
						break;
					}
				}
			}
			storeValue("InventoryValue", df.format(inventoryValue));
			storeValue("FoodCategories",foodCategories);
			}
			
		
		
		
		
		/**
		 * @Function searchItemInAddItemForm
		 * @Description To search for an item using keyword (brand, description, number or nickname) from Add Item Form Page
		 * @param strKeyword- search keyword
		 * @author Parvathy
		 * @date 19-10-2016
		 */

		public void  searchItemInAddItemForm(String strKeyword){
			switchToWebContext();
			//wait for Element present and click element is already handled in sendText function in framework
			//waitForElementPresent(txt_Search);
			clickElement(txt_SearchInAddItemForm);
			sendText(txt_SearchInAddItemForm, strKeyword);
			FrameworkReporter.info("Searched item using keyword "+strKeyword);


		}
		
		/**
		* @Function verifyCakeDescOfItemSelectedFromAddCustomList
		* @Description To verify whether the name of an item is displayed correctly and to click an item with its name from add products page
		* @param strItemName - Item name
		* @author Reshma
		* @date 26-09-2016
		*/

		public LocationsPage verifyCakeDescOfItemSelectedFromAddCustomList(String strItemName){
		switchToWebContext();
		boolean itemFound = false;
		String strActualCakeDesc = null;
		if(ConfigFile.getProperty("platformType").equalsIgnoreCase("android")){
		Actions action = new Actions(getDriver());
		WebElement ele = waitForElementPresent(replaceDynamicText(getObject(lbl_ItemName), strItemName));
		//action.moveToElement(ele).build().perform();
		if(ConfigFile.getProperty("brand").equalsIgnoreCase("android"))
		{		
			if(ele == null){
				FrameworkReporter.fail("Item "+strItemName+" is not present in the location selected with the required cake desc");
			}
			else if(ele.getText().trim().equalsIgnoreCase(strItemName)){
				System.out.println("inside if");
		}
		itemFound=true; 
		} 
		} 
		if(itemFound){
			FrameworkReporter.pass("Item "+strItemName+" present in the location selected");
			selectAnItemWithName(strItemName);		
		} 
		return this; 
		}		
	
		/**
		* @Function verifyDuplicationLoc
		* @Description To verify whether the user was able to add an item more than once in the same location.
		* @param strLocationName - Location name,strItemName - Item name
		* @author Reshma
		* @date 26-09-2016
		*/
		public void verifyDuplicationLoc (String strLocationName, String strItemName){
			int iLocCnt = 0;
			int locationCount=getElementCount(lbl_Location);				
			List<WebElement> elements = getElements(lbl_Location);			
			for(WebElement ele: elements){
				if(ele.getText().equalsIgnoreCase(strLocationName.trim())){
					iLocCnt++;
				}				
				if(iLocCnt>1){
					FrameworkReporter.fail("Item " +strItemName+ " is added more than once in the same location " +strLocationName);
				}
			}
			if(iLocCnt==1){
				FrameworkReporter.pass("Item " +strItemName+ " is added only once in the location " +strLocationName+ " Works as expected");
			}		
		}				
		
	
		
		
		/**
		 * @Function selectAnItemWithIndexFromList
		 * @Description To select an item from list
		 * @param strItemIndex - Item index in list
		 * @author Parvathy
		 * @date 04-11-2016
		 */

		public void selectAnItemWithIndexFromList(String index,String...strings){
			
			switchToWebContext();
			String productVal="";
			if(strings.length >0 && strings[0].equalsIgnoreCase("true"))
			{
				String strProductName =getElementText(replaceDynamicText(lbl_ProductFromListItemNameWithIndex,index)).trim();
				String strProductId=getElementText(replaceDynamicText(lbl_ProductFromListItemIdWithIndex, index)).trim();
				if(strings.length >1 && strings[1].equalsIgnoreCase("upcid")){
					productVal=strProductId;
				}
				else{
					productVal=strProductName;
				}
				System.out.println(productVal);
				if(strings.length ==3)
				{
					storeValue("ProductName"+strings[2],productVal);
				}
				else
				{
					storeValue("ProductName",productVal);
				}
			}
			
			clickElement(replaceDynamicText(lbl_ProductFromListWithIndex,index));
			FrameworkReporter.info("Item : "+index+ "is selected");		
		}
		
	}


			


