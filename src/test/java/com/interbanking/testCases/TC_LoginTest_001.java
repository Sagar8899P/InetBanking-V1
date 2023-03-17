package com.interbanking.testCases;


import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.inetbanking.pageObjects.LoginPage;
import com.jcraft.jsch.Logger;

public class TC_LoginTest_001 extends BaseClass {


	@Test
	public void loginTest( )  {

		driver.get(baseURL);
		LoginPage LP= new LoginPage(driver);
		
		LP.setUsername(userName);
		logger.info("UserName is entered");
		LP.setPassword(password);
		logger.info("UserName is entered");
		LP.clickSubmit();

		String Exp_title = "GTPL Bank Manager HomePage";
		String Act_title = driver.getTitle();

		System.out.println(Act_title);


		assertEquals(Act_title, Exp_title);
		logger.info("Test is passed");


	}

}








