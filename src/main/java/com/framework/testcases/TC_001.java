package com.framework.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.pages.AppHomePage;
import com.framework.testng.api.base.Annotations;

public class TC_001 extends Annotations{
	@BeforeTest
	public void setData() {
		testcaseName = "TC_001_DropDown";
		testcaseDec = "dropdown";
		author = "Venkatesh";
		category = "smoke";
	}
	
	
	
	@Test(priority=0)
	public void click() throws InterruptedException
	{
		new AppHomePage().click_login();
	}

}
