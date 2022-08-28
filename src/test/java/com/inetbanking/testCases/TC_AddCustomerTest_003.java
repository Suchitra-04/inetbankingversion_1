package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbankng.pageObjects.AddCustomerPage;
import com.inetbankng.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		logger.info("Entered page");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details........");
		
		addcust.custName("Suchitra");
		addcust.custgender("female");
		addcust.custdob("06", "04", "1987");
		Thread.sleep(3000);
		addcust.custaddress("MPL");
		addcust.custcity("AP");
		addcust.cusstate("India");
		addcust.custpin("517325");
		addcust.custphone("1232355496");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemail(email);
		addcust.clickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test is failed");
		}
		
		
	}
		

	
	

}
