package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.LoginPage;
import utilities.BrowserFactory;
import utilities.ExcelReader;

public class AddContactTest {

	ExcelReader excel = new ExcelReader("ExcelFile\\TechfiosData.xlsx");
	String username = excel.getCellData("Login", "Username", 2);
	String password = excel.getCellData("Login", "Password", 2);
	String name = excel.getCellData("Customer", "FullName", 2);
	String company = excel.getCellData("Customer", "Company", 2);
	String email = excel.getCellData("Customer", "Email", 2);
	String phone = excel.getCellData("Customer", "Phone", 2);
	String address = excel.getCellData("Customer", "Address", 2);
	String city = excel.getCellData("Customer", "City", 2);
	String state = excel.getCellData("Customer", "State", 2);
	String zip = excel.getCellData("Customer", "Zip", 2);
	String country = excel.getCellData("Customer", "Country", 2);
	String group = excel.getCellData("Customer", "Group", 2);
	String newPassword = excel.getCellData("Customer", "Password", 2);
	String confirmPassword = excel.getCellData("Customer", "ConfirmPassword", 2);
	
	WebDriver driver;
	
	@BeforeMethod
	public void goToContactPage() {
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickLoginButton();
	}
	
	@Test
	public void userShouldBeAbleToCreateAProfileWithValidContactInformation() throws IOException {
		AddContactPage contact = PageFactory.initElements(driver, AddContactPage.class);
		contact.goToAddContactPage();
		contact.enterFullName(name);
		contact.selectCompany(company);
		contact.enterContactInformation(email, phone);
		contact.enterLocation(address, city, state, zip, country);
		contact.selectGroup(group);
		contact.createPassword(newPassword, confirmPassword);
		contact.clickSubmit();
		contact.takesScreenShotAtEndOfTest(driver);
	}
}
