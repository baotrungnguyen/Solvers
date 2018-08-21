package support_group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationCore.DriverFactory;

public class UltisPrivate extends DriverFactory{
	private WebDriver driver;
	private WebDriverWait wait;
	public UltisPrivate() throws Exception {
		
		
		
	}
	public void verifyByID(String id) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	public void verifyByXpath(WebElement element, String xpath) {
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void verifyByClass(WebElement element, String classname) {
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classname)));
	}
	
	public void verifyByLinkText(WebElement element, String linktext) {
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linktext)));
	}

	public void verifyByName(String name) {
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}
	
	public void verifyByCssSelector(WebElement element, String selector) {
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
	}
	
	public void verifyByTagName(WebElement element, String tagname) {
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagname)));
	}
	
}

