package runner;

import org.testng.annotations.BeforeTest;

import com.framework.testng.api.base.Annotations;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/features/Login.Feature",
				 glue={"com/leafBot"}, 
				 monochrome=true)

public class LoginUsingCucumber extends AbstractTestNGCucumberTests {
	
	/*@BeforeTest
	public void setData() {
		testcaseName = "001 - Login";
		testcaseDec = "Login to the application";
		author = "Sethu";
		category = "smoke";*/
	//} 

}




