package com.inetbankng.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtpin;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtphonenum;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() 
	{
		lnkAddNewCustomer.click();
	}
		
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custgender(String cgender)
	{
		rdGender.click();
	}
	
	public void custdob(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void cusstate(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void custpin(String cpin)
	{
		txtpin.sendKeys(String.valueOf(cpin));
	}
	
	public void custphone(String cphone)
	{
		txtphonenum.sendKeys(cphone);
	}
	
	public void custemail(String cemail)
	{
		txtemail.sendKeys(cemail);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	
	
	
	
	
}
