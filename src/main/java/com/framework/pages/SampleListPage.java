package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.framework.testng.api.base.Annotations;

public class SampleListPage extends Annotations {
	
	public SampleListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public SampleListPage scrollToElement()
	
	{
		scrollFromDownToUpinAppUsingPointerInputUntilElementIsVisible("xpath","//android.widget.TextView[@text='Wheel Picker']");
		WebElement wheel_picker = driver.findElementByXPath("//android.widget.TextView[@text='Wheel Picker']");
        //click(wheel_picker);
		
	if(wheel_picker.isDisplayed())
		{
			click(wheel_picker);
		}
		
		return this;

	}

}
