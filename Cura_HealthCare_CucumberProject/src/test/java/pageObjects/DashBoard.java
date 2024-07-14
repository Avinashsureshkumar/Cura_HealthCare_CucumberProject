package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DashBoard extends BasePage{

	public DashBoard(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='Make Appointment']")
	WebElement Appointmenttext;
	@FindBy(xpath="//a[@id='menu-toggle']")
	WebElement menutoggle;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	@FindBy(xpath="//select[@id='combo_facility']")
	WebElement dropdown;
	@FindBy(xpath="//input[@id='chk_hospotal_readmission']")
	WebElement readmissioncheckbox;
	@FindBy(xpath="//input[@id='radio_program_medicare']")
	WebElement medicarerd;
	@FindBy(xpath="//input[@id='txt_visit_date']")
	WebElement datebox;
	@FindBy(xpath="//textarea[@id='txt_comment']")
	WebElement commentbox;
	@FindBy(xpath="//button[@id='btn-book-appointment']")
	WebElement booklink;
	@FindBy(xpath="//input[@id='radio_program_medicaid']")
	WebElement rdmedicaid;
	@FindBy(xpath="//input[@id='radio_program_none']")
	WebElement rdnone;
	
	public String TextAppointment() {
		return Appointmenttext.getText();
	}
	
	public String DashBoardURL() {
		return driver.getCurrentUrl();
	}
	
	public void menu() {
		menutoggle.click();
	}
	
	public void logout() {
		logout.click();
	}
	
	public Select dropdown() {
		Select sc = new Select(dropdown);
		return sc;
	}
	
	public void readmission() {
		readmissioncheckbox.click();
	}
	
	public void medicareradio() {
		medicarerd.click();
	}
	
	public void datebox(String Date) {
		datebox.sendKeys(Date);
	}
	
	public void commentbox(String comment) {
		commentbox.sendKeys(comment);
	}
	
	public void booklink() {
		booklink.click();
	}
	
	public void medicaid() {
		rdmedicaid.click();
	}
	
	public void nonerd() {
		rdnone.click();
	}

}
