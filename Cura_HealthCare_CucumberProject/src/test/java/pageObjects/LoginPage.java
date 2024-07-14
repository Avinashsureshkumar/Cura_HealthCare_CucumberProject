package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='txt-username']")
    WebElement username;
	@FindBy(xpath="//input[@id='txt-password']")
	WebElement password;
	@FindBy(xpath="//button[@id='btn-login']")
	WebElement loginbt;
	@FindBy(xpath="//p[@class='lead text-danger']")
	WebElement loginerror;
	
	public void txtusername(String user) {
		username.sendKeys(user);
	}
	public void txtpassword(String pass) {
		password.sendKeys(pass);
	}
	public void btlogin() {
		loginbt.click();
	}
	
	public String login_error() {
		return loginerror.getText();
	}
	
}
