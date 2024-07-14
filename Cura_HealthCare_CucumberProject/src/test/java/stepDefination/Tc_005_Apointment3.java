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

public class Tc_005_Apointment3 {
	HomePage hp;
	DashBoard db;
	LoginPage lp;
	ConfirmationPage cp;

	@Given("The user is into login page username {string} password {string}")
	public void the_user_is_into_login_page(String string , String string2) {
		 hp = new HomePage(BaseClass.getDriver());
		    hp.clickmakeapointment();
		    lp = new LoginPage(BaseClass.getDriver());
		    BaseClass.getLogger().info("Entering username");
		    lp.txtusername(string);
		    BaseClass.getLogger().info("Entering Password");
		    lp.txtpassword(string2);
		    
	}

	@When("Clicks on Bookapointment link")
	public void clicks_on_bookapointment_link() {
		BaseClass.getLogger().info("clicking on book apointment link");
		lp = new LoginPage(BaseClass.getDriver());
	    lp.btlogin();
	}

	@When("The user filled all the details and clicks confirmation")
	public void the_user_filled_all_the_details_and_clicks_confirmation() {
		BaseClass.getLogger().info("Entering fields");
		    db = new DashBoard(BaseClass.getDriver());
		    db.dropdown().selectByIndex(2);
		    db.readmission();
		    db.nonerd();
		    db.datebox("09/09/2024");
		    db.commentbox("test3");
		    db.booklink();
	}
	@Then("validate the outcomes")
	public void validate_the_outcomes() {
		BaseClass.getLogger().info("validatng");
		   cp = new ConfirmationPage(BaseClass.getDriver());
		   String confmsg = cp.confmsg();
		   String confdate = cp.condate();
		   String confcomment = cp.concomment();
		   Assert.assertEquals(confmsg, "Appointment Confirmation");
		   Assert.assertEquals(confdate,"09/09/2024");
		   Assert.assertEquals(confcomment,"test3");

}}
