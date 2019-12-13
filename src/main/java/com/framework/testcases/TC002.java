package com.framework.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.Annotations;

public class TC002 extends Annotations {
	@BeforeTest
	public void setData() {
		testcaseName = "TC_002_scroll";
		testcaseDec = "scroll";
		author = "Venkatesh";
		category = "smoke";
	}
	
	@Test(priority=1)
	public void scroll()
	{
		
		
	}
	
	
	

}
