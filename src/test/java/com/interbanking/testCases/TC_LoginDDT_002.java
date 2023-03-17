package com.interbanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLutils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_LoginDDT_002 extends BaseClass  {


	@Test(dataProvider="LoginData")
	public void LoginDDT(String usr, String pwd) {
		

		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(usr);
		lp.setPassword(pwd);
		lp.clickSubmit();
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}


	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}


	@DataProvider(name="LoginData")
	 Object [ ][ ] getData( ) throws IOException{
		String path   = "R:\\JAVA\\Workspace\\InerBanking2\\src\\test\\java\\com\\interbanking\\testData\\Book6.xlsx";

		XLutils xlutils = new XLutils(path);
		
		int rownum = xlutils.getRowCount( "Sheet1");
		int colcount = xlutils.getCellCount("Sheet1", 1);

		String logindata [ ][ ] = new String[rownum][colcount];

		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=xlutils.getCellData("Sheet1" , i  ,  j);
			}
		}
		return logindata;
	}

}