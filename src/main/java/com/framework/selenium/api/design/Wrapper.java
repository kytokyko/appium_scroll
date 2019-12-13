package com.framework.selenium.api.design;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

public interface Wrapper {
	
	/**
	 * This method will launch the Chrome browser and 
	 * maximise the browser and set the wait for 30 seconds 
	 * and load the url
	 * @param url - This will load the specified url  
	 * @author Sarath - TestLeaf
	 * @return 
	 * @throws MalformedURLException 
	 */	
	public boolean startApp(String appPackage, String appActivity, String deviceName);
	
	/**
	 * This method will launch the Any browser and 
	 * maximise the browser and set the wait for 30 seconds 
	 * and load the url
	 * @param browser - This will load the specified browser
	 * @param url - This will load the specified url  
	 * @author Sarath - TestLeaf
	 * @throws MalformedURLException 
	 */
	
	public WebElement locateElement(String locator, String locValue);
	
	public boolean click(WebElement ele);
	
	public void scroll();
	
	public boolean eleIsDisplayed(String ele);
	
	public WebElement locateElementByXpath(String ele);
	
	public boolean scroll_point_input(String ele);

	
	

	
}
