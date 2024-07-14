package stepDefination;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashBoard;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Tc_001_ValidLogin {

	HomePage hp;
	LoginPage lp;
	DashBoard db;
	
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() {
	    hp = new HomePage(BaseClass.getDriver());
	    BaseClass.getLogger().info("Clicking on make Appointment link");
	    hp.clickmakeapointment();
	    
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
	    lp = new LoginPage(BaseClass.getDriver());
	    BaseClass.getLogger().info("Entering username");
	    lp.txtusername(string);
	    BaseClass.getLogger().info("Entering Password");
	    lp.txtpassword(string2);
	    
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
	    lp.btlogin();
	}

	@Then("the user should be redirected to the Appointments Page")
	public void the_user_should_be_redirected_to_the_appointments_page() {
		db = new DashBoard(BaseClass.getDriver());
		BaseClass.getLogger().info("Validating");
	    String dburl = db.DashBoardURL();
	    Assert.assertEquals(dburl, "https://katalon-demo-cura.herokuapp.com/#appointment");
	}

}
