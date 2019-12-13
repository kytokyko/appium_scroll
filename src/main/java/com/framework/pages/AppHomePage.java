package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.testng.api.base.Annotations;

import io.appium.java_client.pagefactory.AndroidFindBy;



public class AppHomePage extends Annotations{
	
	public AppHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='LOG IN']") WebElement login;
	
	public SampleListPage click_login() throws InterruptedException
	{
		WebElement login = driver.findElementByXPath("//android.widget.TextView[@text='LOG IN']");
		click(login);
		return new SampleListPage();
	}

}
