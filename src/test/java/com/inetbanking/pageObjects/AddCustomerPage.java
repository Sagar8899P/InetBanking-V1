package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver Idriver;

	public AddCustomerPage(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}

	@FindBy(how= How.XPATH, using ="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement LnkAddNewCustomer;

	@FindBy(how= How.XPATH, using ="//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how= How.XPATH, using ="//input[@name='rad1']")
	@CacheLookup
	WebElement rdGeneder;

	@FindBy(how= How.XPATH, using ="//input[@id='dob']")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how= How.XPATH, using ="//tbody/tr[7]/td[2]/textarea[1]")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(how= How.XPATH, using ="//tbody/tr[9]/td[2]/input[1]")
	@CacheLookup
	WebElement txtstate;

	@FindBy(how= How.XPATH, using ="//tbody/tr[8]/td[2]/input[1]")
	@CacheLookup
	WebElement txtcity;

	@FindBy(how= How.XPATH, using ="//tbody/tr[10]/td[2]/input[1]")
	@CacheLookup
	WebElement txtpinno;

	@FindBy(how= How.XPATH, using ="//tbody/tr[11]/td[2]/input[1]")
	@CacheLookup
	WebElement txttelephoneno;

	@FindBy(how= How.XPATH, using ="//tbody/tr[12]/td[2]/input[1]")
	@CacheLookup
	WebElement txtemailid;

	@FindBy(how= How.XPATH, using ="//tbody/tr[13]/td[2]/input[1]")
	@CacheLookup
	WebElement btnsubmit;


	public void clickAddNewCustomer() {
		LnkAddNewCustomer.click();
	}



	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}

	public void custgeneder(String cname) {
		rdGeneder.click();
	}
	public void custdob(String mm,String dd,String yyyy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	public void custpinno(String cpinno) {
		txtpinno.sendKeys(cpinno);
	}
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailno(String cemailno) {
		txtemailid.sendKeys(cemailno);
	}
	
	public void submit() {
		btnsubmit.click();
	}

}
