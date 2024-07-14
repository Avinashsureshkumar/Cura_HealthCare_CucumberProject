package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = {".//Features/Login.feature"},
        //features = {".//Features/LoginDDT.feature"},
		//features = {".//Features/Appointment3.feature"},
		features = {".//Features/Login.feature",".//Features/LoginDDT.feature",".//Features/Appointment1.feature",".//Features/Appointment2.feature",".//Features/Appointment3.feature",".//Features/Logout.feature"},
        //features = {"@target/rerun.txt"},for running failed test cases
        glue = {"stepDefination","hooks"},
        plugin = {
            "pretty", 
            "html:reports/myreport.html",   
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
            "rerun:target/rerun.txt"
        },
        dryRun = false,   // checks mapping between scenario steps and step definition methods
        monochrome = true,   // to avoid junk characters in output
        publish = true   // to publish report in cucumber server
)

public class TestRunner {

}
