package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	@Given("User is on OrangeHRM Login Page")
	public void user_is_on_orange_hrm_login_page() {
		
	    driver=new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    
	}

	
	@When("User enters valid credentials \\(Username : {string}, Password : {string})")
	public void user_enters_valid_credentials_username_password(String uname, String pass) {
	   
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @placeholder='Username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @placeholder='Password']")).sendKeys(pass);
	}

	
	@When("the user clicks on Login button")
	public void the_user_clicks_on_login_button() {
	   
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	
	@Then("User should redirect to Home Page")
	public void user_should_redirect_to_home_page() {
	 
		boolean DashBoard =driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']")).isDisplayed();
		Assert.assertEquals(DashBoard, true);
	}
}
