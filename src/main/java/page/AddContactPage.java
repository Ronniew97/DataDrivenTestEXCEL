package page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.BasePage;

public class AddContactPage extends BasePage {

	WebDriver driver;
	
	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]") WebElement CUSTOMER_BUTTON;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]") WebElement ADD_CUSTOMER_BUTTON;
	@FindBy(how = How.XPATH, using = "//input[@name='account']") WebElement FULL_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']") WebElement COMPANY_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") WebElement PHONE_NUMBER_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='country']") WebElement COUNTRY_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") WebElement ZIP_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@name='group']") WebElement GROUP_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//input[@name='password']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='cpassword']") WebElement CONFIRM_PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']") WebElement SAVE_BUTTON;
	@FindBy(how = How.XPATH, using = "//a[@id='summary']") WebElement SUMMARY_TEXT;
	
	public void goToAddContactPage() {
		explicitWait(driver, 3, CUSTOMER_BUTTON);
		CUSTOMER_BUTTON.click();
		explicitWait(driver, 3, ADD_CUSTOMER_BUTTON);
		ADD_CUSTOMER_BUTTON.click();
	}
	
	public void enterFullName(String name) {
		explicitWait(driver, 5, FULL_NAME_FIELD);
		FULL_NAME_FIELD.sendKeys(name+randomNumber());
	}
	
	public void selectCompany(String company) {
		dropDown(COMPANY_DROPDOWN, company);
	}
	
	public void enterContactInformation(String email, String phone) {
		EMAIL_FIELD.sendKeys(email+randomNumber()+"@email.com");
		PHONE_NUMBER_FIELD.sendKeys(phone+randomNumber());
	}
	
	public void enterLocation(String address, String city, String state, String zip, String country) {
		ADDRESS_FIELD.sendKeys(address);
		CITY_FIELD.sendKeys(city);
		STATE_FIELD.sendKeys(state);
		ZIP_FIELD.sendKeys(zip);
		dropDown(COUNTRY_DROPDOWN, country);
	}
	
	public void selectGroup(String group) {
		explicitWait(driver, 4, GROUP_DROPDOWN);
		dropDown(GROUP_DROPDOWN, group);
	}
	
	public void createPassword(String password, String cpassword) {
		PASSWORD_FIELD.sendKeys(password);
		CONFIRM_PASSWORD_FIELD.sendKeys(cpassword);
	}
	
	public void clickSubmit() {
		SAVE_BUTTON.click();
	}
	
	public void takesScreenShotAtEndOfTest(WebDriver driver) throws IOException {
		explicitWait(driver, 4, SUMMARY_TEXT);
		
		TakesScreenshot ts = (TakesScreenshot)(driver);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("screenshots//contactpage"+System.currentTimeMillis()+".png"));
	}
}
