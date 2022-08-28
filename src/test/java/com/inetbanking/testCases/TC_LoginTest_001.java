package com.inetbanking.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbankng.pageObjects.LoginPage;

 
public class TC_LoginTest_001 extends BaseClass 
{
	
	@Test
	public void loginTest() throws IOException 
	{
		
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");
		lp.setPassword(password);
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Test is failed");
		}
		
	}
	
	
	

}
