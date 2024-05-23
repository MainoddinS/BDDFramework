package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions ( 
     //features = {".//FeatureFiles/Login.feature"},
     //features = {".//FeatureFiles/LoginTDDExcel.feature"},
	 features = {".//FeatureFiles/Registration.feature"},
     glue="stepDefinitions",
     plugin= {"pretty", "html:reports/myreport.html"},
    		 // "rerun:target/rerun.txt",
    		  //"com.avenstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
     dryRun=false,
     monochrome=true,
     publish=true
     
     //tags="@sanity"
     //tags="@sanity" and @regression
     //tags="@sanity" and not @regression
     //tags="@sanity" or @regression
     )
public class TestRun {

}
