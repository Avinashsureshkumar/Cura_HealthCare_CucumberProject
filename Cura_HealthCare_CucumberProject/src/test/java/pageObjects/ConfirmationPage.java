package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage{

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Appointment Confirmation']")
     WebElement confmsf;
	@FindBy(xpath="//p[@id='comment']")
    WebElement concomment;
	@FindBy(xpath="//p[@id='visit_date']")
    WebElement condate;
	
	public String confmsg() {
		return confmsf.getText();
	}
	
	public String concomment() {
		return concomment.getText();
	}
	
	public String condate() {
		return condate.getText();
	}
}
