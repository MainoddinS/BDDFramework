package stepDefinitions;

import java.util.Map;

import Pages.RegistrationPage;
import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	RegistrationPage objRegPage =new RegistrationPage(BaseClass.getDriver()); 
	
	
	@Given("the user navigates to registration page")
	public void the_user_navigates_to_registration_page() throws InterruptedException {
		
	    objRegPage.clickHomeLoginButton();
	    objRegPage.clickMainRegisterButton();
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) throws InterruptedException {
	    Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
	    
	    objRegPage.enterFirstName(dataMap.get("firstname"));
	    objRegPage.enterLastName(dataMap.get("lastname"));
	    objRegPage.enterUserName(dataMap.get("username"));
	    objRegPage.enterPassword(dataMap.get("password"));
	    objRegPage.enterConfPassword(dataMap.get("confpassword"));
	}

	@When("user selects the gender")
	public void user_selects_the_gender() throws InterruptedException {
		objRegPage.clickRadioButton();
	}

	@When("user clicks on register button")
	public void user_clicks_on_register_button() {
		objRegPage.clickSubmitRegisterButton();
	}

	@Then("user gets registered")
	public void user_gets_registered() throws InterruptedException {
		objRegPage.checkLoginWindowDisplayedOnReg();
	}
}
