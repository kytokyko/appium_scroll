package com.selenium.api.base;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.framework.selenium.api.design.Wrapper;
import io.appium.java_client.AppiumDriver;
import utils.Reporter;
import io.appium.java_client.android.AndroidDriver;



public class SeleniumBase extends Reporter implements Wrapper{
	public static AppiumDriver<WebElement> driver;

	@Override
	public boolean startApp(String appPackage, String appActivity, String deviceName) {
		// TODO Auto-generated method stub
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", appPackage);
			dc.setCapability("appActivity", appActivity);
			dc.setCapability("deviceName", deviceName);
			dc.setCapability("automationName", "UiAutomator2");
			dc.setCapability("noReset", true);
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		
	}

	public long takeScreenShot() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			File srcFiler = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFiler, new File("./reports/images/" + number + ".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.err.println("The browser has been closed.");
		} catch (IOException e) {
			System.err.println("The snapshot could not be taken");
		}
		return number;
	}

		
	
	 public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case ("id"):
				return driver.findElementById(locValue);
			case ("linkText"):
				return driver.findElementByLinkText(locValue);
			case ("xpath"):
				return driver.findElementByXPath(locValue);
			case ("name"):
				return driver.findElementByName(locValue);
			case ("className"):
				return driver.findElementByClassName(locValue);
			case ("accessID"):
				driver.findElementByAccessibilityId(locValue);
			}
		}  catch (Exception e) {
		}
		return null;
	}

	public boolean click(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	

	@Override
	public void scroll() {
		Dimension size = driver.manage().window().getSize();
		int x1 = (int) (size.getWidth() * 0.5);
		int y1 = (int) (size.getHeight() * 0.8);
		int x0 = (int) (size.getWidth() * 0.5);
		int y0 = (int) (size.getHeight() * 0.2);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 1);
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
		x1, y1));
		sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
		x0, y0));
		sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
		driver.perform(Arrays.asList(sequence));
		
	}

	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean eleIsDisplayed(String ele) {
		// TODO Auto-generated method stub
		try
		{
		if(locateElementByXpath(ele).isDisplayed())
		return true;
		}catch(Exception ae)

		{
		return false;
		}
		return false;
	}

	@Override
	public WebElement locateElementByXpath(String ele) {
		// TODO Auto-generated method stub
		try {
			return driver.findElementByXPath(ele);
			} catch (Exception e) {
			}
		return null;
	}

	@Override
	public boolean scroll_point_input(WebElement wheelPicker) {
		// TODO Auto-generated method stub
		while(!eleIsDisplayed(wheelPicker)) {
			scroll();
			}
		return true;
	}
}

		

	



