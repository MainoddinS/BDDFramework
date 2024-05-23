package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import util.DataReader;

public class LoginWithExcelTestData {
	WebDriver driver;
	List<HashMap<String, String>> datamap;
	
	@Given("User navigates to OrangeHRM Login Page")
	public void user_navigates_to_orange_hrm_login_page() {
		driver=new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	}

	@Then("User should be redirected to Home Page by passing username and password with excel row {string}")
	public void user_should_be_redirected_to_home_page_by_passing_username_and_password_with_excel_row(String rows) {
		datamap = DataReader.data(System.getProperty("user.dir")+"\\testData\\OrangeHRMData.xlsx","Sheet1");
		int index = Integer.parseInt(rows)-1;
		String username = datamap.get(index).get("username");
		String password = datamap.get(index).get("password");
		
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @placeholder='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @placeholder='password']")).sendKeys(password);
	
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
}
