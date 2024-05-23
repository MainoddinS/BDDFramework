package stepDefinitions;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
 WebDriver driver;
 Properties p;

    @Before
    public void setup() throws IOException {
    	driver= BaseClass.initBrowser();
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("URL"));
    	driver.manage().window().maximize();
    }
    
    @After
    public void tearDown(Scenario scenario) {
    	//driver.quit();
    }
    
	@AfterStep
	public void addSecreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot sc = (TakesScreenshot)driver;
			byte [] screenshot =sc.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
}
