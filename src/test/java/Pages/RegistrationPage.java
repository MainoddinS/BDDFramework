package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;

public class RegistrationPage {

	 private WebDriver driver;

	 
	// 1. By Locators: OR
	private By btnLoginHome = By.xpath("//span[text()=' Login ']");
	private By btnMainRegister = By.xpath("//span[text()='Register']");
	private By regFirstName = By.xpath("//input[@formcontrolname='firstname']");
	private By regLastName = By.xpath("//input[@formcontrolname='lastname']");
	private By regUserName = By.xpath("//input[@formcontrolname='username']");
	private By regPass = By.xpath("//input[@formcontrolname='password']");
	private By regConfPass = By.xpath("//input[@formcontrolname='confirmPassword']");
	private By radioMale=By.xpath("//label[text()=' Male ']");
	private By btnSubmitRegister = By.xpath("//span[text()='Register']");
	
	private By msgNewUserLoginWindow= By.xpath("//span[text()='New User? ']");

	
	// 2. Constructor of the page class:
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public void clickHomeLoginButton() throws InterruptedException {
		Thread.sleep(3000);
		 driver.findElement(btnLoginHome).click();
	}
	
	public void clickMainRegisterButton() {
		 driver.findElement(btnMainRegister).click();
	}

	public void enterFirstName(String fName) throws InterruptedException {Thread.sleep(3000);
		driver.findElement(regFirstName).sendKeys(fName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(regLastName).sendKeys(lastName);
	}
	
	public void enterUserName(String userName) {
		driver.findElement(regUserName).sendKeys(userName);
	}

	public void enterPassword(String pwd) {
		driver.findElement(regPass).sendKeys(pwd);
	}
	
	public void enterConfPassword(String pwd) throws InterruptedException {Thread.sleep(3000);
		driver.findElement(regConfPass).sendKeys(pwd);
	}

	public void clickRadioButton() throws InterruptedException {Thread.sleep(3000);
		 driver.findElement(radioMale).click();
	}
	
	public void clickSubmitRegisterButton() {
		 driver.findElement(btnSubmitRegister).click();
	}
	
	public void checkLoginWindowDisplayedOnReg() throws InterruptedException {Thread.sleep(3000);
		 driver.findElement(msgNewUserLoginWindow).isDisplayed();
	}

}

