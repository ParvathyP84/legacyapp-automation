package com.uom.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DataRead.Excel;
import com.framework.Starter;
import com.framework.configuration.ConfigFile;
import com.framework.utils.RetryAnalyzer;
import com.framework.utils.UOMTestNGListener;
import com.uom.excelSheetObject.CloseInventoryObject;
import com.uom.excelSheetObject.ExpenseCategoriesObject;
import com.uom.pageFactory.PageFactory;


@Listeners(value = UOMTestNGListener.class)
public class CloseInventory extends PageFactory{
	

	public static String[][] completeArray = null;	
   	Starter starter = new Starter();   	
   	
   	
    @BeforeClass(alwaysRun=true)
   	public void getData() throws Exception
   	{		
   		String strDataFilePath;
   		Excel newExcel =new Excel();
   	if(!ConfigFile.getProperty("platformType").toString().equalsIgnoreCase("ios"))
   	{
   		completeArray=newExcel.read("test-data/TestData.xls","CloseInventory");
   	}
   	else{
   		completeArray=newExcel.read("test-data/TestData.xls","CloseInventory_IOS");
   	}
   	}
    
    @BeforeMethod(alwaysRun=true)
    public void initiate() throws Exception
    {
    	
    	  	startup();
    }
    
    @AfterMethod
	public void clean()
	{
    	cleanUp();
	}
    
    @DataProvider(name = "DP1",parallel =true)
    public Object[][] getData(Method method) throws Exception{
	 	Excel newExcel =new Excel();
	 	CloseInventoryObject sheetObj = new CloseInventoryObject();
	 	 System.out.println(method.getName());
	     String[][] MethodArray=newExcel.getMethodData(completeArray, method.getName());
	     Object[][] retObjArr= sheetObj.getTestData(MethodArray);
	     return(retObjArr);
    }
    
    /******************************************************************************************
	  * Name : SyscoAppTest
	  * 
	  *  
	  ******************************************************************************************/
  @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider="DP1",groups={"CloseInventory","CloseInventoryIOS1"}, description = "Validate the Close Inventory if all the items in an inventory are  assigned to Location and Category for Default location and default category")
	 public void INV_CI_001_Close_Inventory_All_Items_Assigned_Default_Loc_Default_Cat(CloseInventoryObject data) throws Exception {	
  	  	Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("sqnorm11");
		driver.findElement(By.id("password")).sendKeys("welcome1");
		driver.findElement(By.xpath("//button[@class='login']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//ul[@class='header-nav']//a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='order-guide']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='app-back-button']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@data-event='create-order']//i[@class='icon']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[contains(text(),'My Custom Lists')]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[@class='name' and contains(text(),'List4')]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='app-back-button']")).click();
		Thread.sleep(7000);
		//a[contains(text(),'My Custom Lists')]		
		driver.findElement(By.xpath("//ul[@class='header-nav']//a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@class='secondary-nav']//a[@class='logout']")).click();
		driver.quit();
		
	  }

}
