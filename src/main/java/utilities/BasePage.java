package utilities;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void explicitWait(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void dropDown(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public int randomNumber() {
		Random random = new Random();
		int randNum = random.nextInt(999);
		return randNum;
	}
}
