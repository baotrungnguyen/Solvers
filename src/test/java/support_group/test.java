package support_group;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import automationCore.DriverFactory;

public class test extends DriverFactory {
	@Test
	public void test() throws Exception{
		WebDriver driver = getDriver();
		driver.get("https://www.google.com");
		WebElementSuport.openBrowserFullScreen(driver);
		WebElementSuport.forWaitURL(driver, "https://www.guru99.com/", 5);
	}
	
	
}
