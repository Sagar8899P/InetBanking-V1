package com.interbanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		
		Thread.sleep(3000);
		
		
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		addcust.custName("subani");
		logger.info("Customer name is entered");
		Thread.sleep(3000);
		addcust.custgeneder("male");
		logger.info("Customer gender is entered");
		Thread.sleep(3000);
		addcust.custdob("20", "09", "1998");
		logger.info("Customer date of birth is entered");
		Thread.sleep(3000);
		addcust.custaddress("3/348/2, tapovanam");
		logger.info("customer address is entered");
		Thread.sleep(3000);
		addcust.custcity("Anantapur");
		Thread.sleep(3000);
		logger.info("Customer city is entered");
		addcust.custstate("Andhra");
		Thread.sleep(3000);
		logger.info("customer stste is entered");
		addcust.custpinno("560068");
		Thread.sleep(3000);
		logger.info("customer pincode is entered");
		addcust.custtelephoneno("888369870");
		Thread.sleep(3000);
		logger.info("customer phone number is entered");
		String email = radomstring()+"@gmail.com";
		addcust.custemailno(email);
		Thread.sleep(3000);
		logger.info("UserName is entered");
		
		addcust.submit();
		logger.info("Customer email is entered");
		
		
	}
	
public String radomstring() {
	
	String generatedstring = RandomStringUtils.randomAlphabetic(8);
	return generatedstring;
	
	
}
}
