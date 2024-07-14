package stepDefination;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.DashBoard;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Tc_006_Logout {

	HomePage hp;
	LoginPage lp;
	DashBoard db;
	@Given("The user is logged in username {string} password {string}")
	public void the_user_is_logged_in(String string,String string2) {
		BaseClass.getLogger().info("clicking on book Appointment link");
		hp = new HomePage(BaseClass.getDriver());
	    hp.clickmakeapointment();
	    lp = new LoginPage(BaseClass.getDriver());
	    lp.txtusername(string);
	    BaseClass.getLogger().info("Entering username");
	    lp.txtpassword(string2);
	    BaseClass.getLogger().info("Entering Password");
	    lp.btlogin();
	    BaseClass.getLogger().info("clicking login");
	}

	@Then("The user should Successfully Logout")
	public void the_user_should_successfully_logout() {
	    db = new DashBoard(BaseClass.getDriver());
	    BaseClass.getLogger().info("clicking menu");
	    db.menu();
	    BaseClass.getLogger().info("logout successfull");
	    db.logout();
	    
	}

}
