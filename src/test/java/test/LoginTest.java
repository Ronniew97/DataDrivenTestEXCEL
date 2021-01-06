package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import utilities.BrowserFactory;
import utilities.ExcelReader;

public class LoginTest {

	ExcelReader excel = new ExcelReader("ExcelFile\\TechfiosData.xlsx");
	String username = excel.getCellData("Login", "Username", 2);
	String password = excel.getCellData("Login", "Password", 2);
	
	WebDriver driver;

	@Test
	public void userWithValidCredentialsShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickLoginButton();
		login.verifyHomePage();
	}
}
