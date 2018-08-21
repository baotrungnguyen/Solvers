package support_group;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {

	public static Long WAIT_TIMEOUT_IN_SECONDS=30L;
//	public static final Logger logger = LogManager.getLogger("WebUltils");
	public WebUtils() {
		// Ultility class
	}
	
	public static WebDriverWait getDefaultWait(WebDriver driver) {
		return new WebDriverWait(driver, WAIT_TIMEOUT_IN_SECONDS);
	}
	
/*	Updates the default wait time out seconds with the user provider value.
	
	@param timeout
		the time out in seconds
*/		
	
	public static void setDefaultTimeout(Long timeout) {
		WAIT_TIMEOUT_IN_SECONDS=timeout;
	}

/*	Refresh current page.
	
	@param driver
	@param wait
	@param by
*/	
	
	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
/*	Clicks the web element using driver and locator
	
	@param driver
	@para wait
	@param by
*/	
	
	public static void click(WebDriver driver, WebDriverWait wait, By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	
/*	Clicks the web element using dreiver adn locator
	
	@param driver
	@param by
*/	
	
	public static void click(WebDriver driver, By by) {
		
		click(driver, getDefaultWait(driver), by);
		
	} 
	
/*	Click the web element inside a sub DOM using driver, wait, parent and locator
	
	@param driver
	@param wait
	@param parent
	@param by
*/	
	
	public static void click(WebDriver driver, WebDriverWait wait, WebElement parent, By by) {
		
		wait.until(ExpectedConditions.elementToBeClickable(parent)).click();
		
	}
	
	
	
	
	
	
}
