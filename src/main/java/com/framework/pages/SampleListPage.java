package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.framework.testng.api.base.Annotations;

public class SampleListPage extends Annotations {
	
	public SampleListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void scrollToElement()
	{
		WebElement wheelPicker = driver.findElementByXPath("//android.widget.TextView[@text='Wheel Picker']");
		scroll_point_input(wheelPicker);

	}

}
