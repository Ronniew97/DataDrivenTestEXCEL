package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@name='login']") WebElement LOGIN_BUTTON;
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]") WebElement DASHBOARD_HEADER;

	public void enterUserName(String username) {
		USERNAME_FIELD.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}
	
	public void clickLoginButton() {
		LOGIN_BUTTON.click();
		explicitWait(driver, 4, DASHBOARD_HEADER);
	}
	
	public void verifyHomePage() {
		if(DASHBOARD_HEADER.isDisplayed()) {
		} else {
			System.out.println("Dashboard page not displayed");
		}
	}
}
