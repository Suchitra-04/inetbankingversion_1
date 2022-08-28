package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.utilities.XLUtils;
import com.inetbankng.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();// CLOSE ALERT
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login is failed");;
		}
		else 
		{
			Assert.assertTrue(true);
			logger.info("login is passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent() // USER DEFINED METHOD CREAETED TO CHECK WETHER ALERT IS PRESENT OR NOT
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		
		catch(Exception e) {
			return false;
		}
		
	}
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1",i, j);//1 0
			}
		}
		
	return logindata;
		
		
	}
	
	
	
	
}
