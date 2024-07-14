package stepDefination;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.ConfirmationPage;
import pageObjects.DashBoard;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Tc_003_Appointment {
HomePage hp;
LoginPage lp;
DashBoard db;
ConfirmationPage cp;
	@Given("The user is successfully logged in with username {string} and password {string}")
public void the_user_is_successfully_logged_in_with_username_and_password(String string, String string2) {
	    hp = new HomePage(BaseClass.getDriver());
	    BaseClass.getLogger().info("Clicking make Appointment link");
	    hp.clickmakeapointment();
	    
	    lp = new LoginPage(BaseClass.getDriver());
	    BaseClass.getLogger().info("Entering username");
	    lp.txtusername(string);
	    BaseClass.getLogger().info("Entering Password");
	    lp.txtpassword(string2);
	    lp.btlogin();
	}

	@When("The user fills all the required fields and checkboxes and clicks on Book Appointment link")
	public void the_user_fills_all_the_required_fields_and_checkboxes_and_clicks_on_book_appointment_link() {
		BaseClass.getLogger().info("Entering fields");
	    db = new DashBoard(BaseClass.getDriver());
	    db.dropdown().selectByIndex(0);
	    db.readmission();
	    db.medicareradio();
	    db.datebox("14/07/2024");
	    db.commentbox("test1");
	    db.booklink();    
	}

	@Then("The user should be redirected to Confirmation page")
	public void the_user_should_be_redirected_to_confirmation_page() {
	   cp = new ConfirmationPage(BaseClass.getDriver());
	   BaseClass.getLogger().info("validating");
	   String confmsg = cp.confmsg();
	   String confdate = cp.condate();
	   String confcomment = cp.concomment();
	   Assert.assertEquals(confmsg, "Appointment Confirmation");
	   Assert.assertEquals(confdate,"14/07/2024");
	   Assert.assertEquals(confcomment,"test1");
	}
}
