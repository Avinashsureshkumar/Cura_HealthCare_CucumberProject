package stepDefination;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.DashBoard;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataReader;

public class Tc_002_LoginDDT {
	HomePage hp;
	LoginPage lp;
	DashBoard db;
    List<HashMap<String, String>> datamap;
    
    @Given("the user navigates to home page and click on book appointment link")
    public void the_user_navigates_to_home_page_and_click_on_book_appointment_link() {
	    hp = new HomePage(BaseClass.getDriver());
	    hp.clickmakeapointment();  
	    BaseClass.getLogger().info("Tc_002_LoginDDT Clicking on Get Appointment");
	}
    
    @Then("the user should be redirected to the Appointment Page by passing email and password with excel row {string}")
	   public void the_user_user_should_be_redirected_to_the_Appointment_page_by_passing_email_and_password_with_excel_data(String row_index) {
    	try {
	    datamap=DataReader.data(System.getProperty("user.dir")+"\\test-data\\invalid_test_data.xlsx", "Sheet1");
	    
	    int index=Integer.parseInt(row_index)-1;
	    BaseClass.getLogger().info("Capturing usernamefrom excel");
     String username= datamap.get(index).get("Email");
     BaseClass.getLogger().info("Capturing password from excel");
     String password= datamap.get(index).get("Password");
     BaseClass.getLogger().info("Capturing result from excel");
     String exp_result= datamap.get(index).get("Result");
     
     BaseClass.getLogger().info("providing username");
     lp = new LoginPage(BaseClass.getDriver());
     lp.txtusername(username);
     BaseClass.getLogger().info("providing password");
     lp.txtpassword(password);
     lp.btlogin();
    
     db = new DashBoard(BaseClass.getDriver());
     BaseClass.getLogger().info("Validating");
     
     if(exp_result.equalsIgnoreCase("invalid")) {
    	 String errmsg = lp.login_error();
     	if(errmsg.equals("Login failed! Please ensure the username and password are valid.")) {
     		Assert.assertTrue(true);
     	}
     	else {
     		Assert.fail();
     	}
     }
	  if(exp_result.equalsIgnoreCase("Valid")) {
		  String textappointment = db.TextAppointment();
	    if(textappointment.equals("Make Appointment")) {
	    		 db.menu();
	    		 db.logout();
	    		 Assert.assertTrue(true);	 
	    	 }
	    else {
	    	 Assert.fail();
	    	 }
	     }}catch(Exception e) {
	    	 e.printStackTrace();
	    	 Assert.fail();
	    	 
	     }
}
}
