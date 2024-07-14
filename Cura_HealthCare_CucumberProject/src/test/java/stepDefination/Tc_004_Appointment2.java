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

public class Tc_004_Appointment2 {
	HomePage hp;
	DashBoard db;
	LoginPage lp;
	ConfirmationPage cp;

	@Given("The user is on login page username {string} and password {string}")
	public void the_user_is_on_login_page_username_and_password_this_is_not_a_password(String string ,String string2) {
	    hp = new HomePage(BaseClass.getDriver());
	    hp.clickmakeapointment();

	    lp = new LoginPage(BaseClass.getDriver());
	    BaseClass.getLogger().info("Entering username");
	    lp.txtusername(string);
	    BaseClass.getLogger().info("Entering Password");
	    lp.txtpassword(string2);
	    lp.btlogin();
    }

	@When("The user fills all the fields")
	public void the_user_fills_all_the_fields() {
		BaseClass.getLogger().info("Entering fields");
		    db = new DashBoard(BaseClass.getDriver());
		    db.dropdown().selectByIndex(1);
		    //db.readmission();
		    db.medicaid();
		    db.datebox("10/06/2024");
		    db.commentbox("test2");
		    
	   
	}

	@When("The user clicks on bookappointment link")
	public void the_user_clicks_on_bookappointment_link() {
		BaseClass.getLogger().info("clicking on bookapiontment link");
		 db = new DashBoard(BaseClass.getDriver());
		 db.booklink(); 
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		BaseClass.getLogger().info("validating");
		   cp = new ConfirmationPage(BaseClass.getDriver());
		   String confmsg = cp.confmsg();
		   String confdate = cp.condate();
		   String confcomment = cp.concomment();
		   Assert.assertEquals(confmsg, "Appointment Confirmation");
		   Assert.assertEquals(confdate,"10/06/2024");
		   Assert.assertEquals(confcomment,"test2");
	}

}
