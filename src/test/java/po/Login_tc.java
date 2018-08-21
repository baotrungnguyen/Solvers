package po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.DriverFactory;

public class Login_tc extends DriverFactory{
	public static final Logger logger = LogManager.getLogger("Test Login");
	@Test
	public void validLogin() throws Exception {
		WebDriver driver = getDriver();
		driver.get("http://localhost:3000");
		Thread.sleep(3000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginWith("huyDuong", "123456");
		WebElement message = driver.findElement(By.id("message"));
		String actual_message = message.getText();
		Boolean result = actual_message.equals("Invalid email");
		Assert.assertTrue(result);
		Thread.sleep(3000);
	}
}
