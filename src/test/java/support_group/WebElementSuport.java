package support_group;

import java.util.NoSuchElementException;

import org.apache.tools.ant.taskdefs.condition.Equals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementSuport {

/*	Function
	
	Waitting and element
	

	@param element: a element by tester, Using Webelement
	
	*/
	
	public static void waitElememt(WebElement element, WebDriverWait wait) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public static void waitElementBy(By bylocator, WebDriverWait wait ) {
		
		wait.until(ExpectedConditions.elementToBeClickable(bylocator));
		
	}
	
/*	
	Click by text of we element <a>
	
	@param linkText: text of an link or item that tester wanto to click
	
*/	

	public static void clickByLinkText(String linkText, WebDriverWait wait, WebDriver driver) throws Exception {
		
		waitElementBy(By.linkText(linkText), wait);
		driver.findElement(By.linkText(linkText)).click();
		
	}
	
/*	
	Click by text of xpath
	
	@param xpathText: text of xpath link thet tester want to select
	
*/	
	
	public static void ClickByXpath(String xpathGet, WebDriverWait wait, WebDriver driver) throws Exception {
		
		waitElementBy(By.xpath(xpathGet), wait);
		driver.findElement(By.xpath(xpathGet)).click();
		
	}

	
	public static void ClickSupport(WebElement Elm, WebDriverWait wait) throws Exception {
		
		waitElememt(Elm, wait);
		
		try {
			Elm.click();		
		} catch(Exception e1){
			waitElememt(Elm, wait);
			try {
				Elm.click();				
			} catch (Exception e2){
				Elm.click();
			}
		}
	}
	
	public static void clickSupport(WebElement Elm, int timeout, WebDriverWait wait) throws Exception {
		waitElememt(Elm, wait);
		try {
			
			Elm.click();	
			}catch(Exception e1) {
				
				Thread.sleep(timeout*1000);
				try {
					Elm.click();
				}catch(Exception e2) {
					Elm.click();
				}
			}
	}
	
/*	Select suggest drop down list
	
	@param Elm
	@param timeout
	@thows Exception
*/
	
	public static void selectDropDown(WebElement Elm, int timeout, WebDriverWait wait) throws Exception{
		waitElememt(Elm, wait);
		try {
			Elm.sendKeys(Keys.ARROW_DOWN);
			Elm.sendKeys(Keys.ENTER);
			}catch(Exception e){
				System.out.println("Can not select breed");
			}
			Thread.sleep(timeout*2000);
	}	
	
	
/*	Slelect a list dropdown then select item with text
	
	@param element
	@param typeVal
	@param wait
*/	

	public static void selectDropDown(WebElement element, String typeVal, WebDriverWait wait) {
		waitElememt(element, wait);
		element.click();
		Select oSelect=new Select(element);
		oSelect.selectByVisibleText(typeVal);
	}

	public static void clickSupport(WebElement Elm, int timeout, int interval_miliseconds, WebDriverWait wait) throws Exception {
		waitElememt(Elm, wait);
		for (int i=0; i<timeout*1000/interval_miliseconds; i++) {
			try {
				Elm.click();
				break;
			} catch(Exception e1) {
				if(!(i<timeout*1000/interval_miliseconds)) {
					Elm.click();
				}
			}
			
		}
		
	}
	
	public static void sendKeysSupport(WebElement Elm, String text, WebDriverWait wait) {
		waitElememt(Elm, wait);
		try {
			Elm.clear();
			Elm.sendKeys(text);
			
		} catch(Exception e1) {
			waitElememt(Elm, wait);
			try {
				Elm.sendKeys(text);
			} catch(Exception e2) {
				Elm.clear();
				Elm.sendKeys(text);
			}
		}
		
	}
	
//-----------------------------
	
	public static void sendKeysSupportEnter(WebElement Btn, WebDriverWait wait) {
		waitElememt(Btn, wait);
		try {
			Btn.sendKeys(Keys.ENTER);
			
		} catch(Exception e1) {
			waitElememt(Btn, wait);
			try {
				Btn.sendKeys(Keys.ENTER);
			} catch(Exception e2) {
				Btn.sendKeys(Keys.ENTER);
			}
		}
		
	}
	
	
	
//---------------------------	
	public static void sendKeysSupport(WebElement Elm, int timeout, String text, WebDriverWait wait) throws Exception{
		waitElememt(Elm, wait);
		try {
			Elm.clear();
			Elm.sendKeys(text);
			
		} catch(Exception e1) {
			Thread.sleep(timeout*1000);
			try {
				Elm.sendKeys(text);
			} catch(Exception e2) {
				Elm.clear();
				Elm.sendKeys(text);
			}
		}
		
	}
	
	public static void sendKeysSupport(WebElement Elm, String text, int timeout, int interval_miliseconds, WebDriverWait wait) {
		waitElememt(Elm, wait);
		for (int i=0; i<timeout*1000/interval_miliseconds; i++) {
			try {
				Elm.clear();
				Elm.click();
				break;
			} catch (Exception e2) {
				if(i>timeout*1000/interval_miliseconds) {
					Elm.clear();
					Elm.click();
				}
			}
		}
		
	}
	
	
	public static String getTextSupport(WebElement Elm, WebDriverWait wait) throws Exception{
		waitElememt(Elm, wait);
		String result=null;
		try {
			result=Elm.getText();
		} catch(Exception e1) {
			waitElememt(Elm, wait);
			try {
				result=Elm.getText();
			} catch (Exception e2) {
				InterruptedException e = new InterruptedException();
				throw e;
			}
		}
		return result;
	}

	public static String getTextSupport(WebElement Elm, WebDriverWait wait, int timeout) throws Exception {
		waitElememt(Elm, wait);
		String result=null;
		try {
			result=Elm.getText();
		} catch (Exception e1) {
			Thread.sleep(timeout*1000);
			try {
				result=Elm.getText();
			} catch (Exception e2) {
				InterruptedException e=new InterruptedException(e2.getMessage());
				throw e;
			}
		}		
		return result;
	}

	public static String getTextSupport(WebElement Elm, WebDriverWait wait, int timeout, int interval_miliseconds) throws Exception {
		waitElememt(Elm, wait);
		String result=null;
		for (int i=0; i<timeout*1000/interval_miliseconds; i++) {
			try {
				result=Elm.getText();
				break;				
			} catch (Exception e2) {
				if (!(i<timeout*1000/interval_miliseconds)) {
					result=Elm.getText();
					throw e2;
				}
				
			}
			
		}
		
		return result;
	}
	
	public static WebElement findElementByTextSupport(WebDriver driver, String text, int timeout, WebDriverWait wait) throws Exception {
		Thread.sleep(1000);
		Exception e1 = null;
		WebElement Elm = null;
		String tmp_xpath="//*[text()='"+text+"']";
		for (int i=0; i<timeout; i++) {
			try {
				Elm=driver.findElement(By.xpath(tmp_xpath));
				break;
			} catch (Exception e) {
				waitElememt(Elm, wait);
				e1=e;
			}
			if (Elm == null) {
				throw e1;
			}
			
		}
		return Elm;
		
	}
	
/*	wait for element
	
	@param timeout
	@param driver
	@param bysomething
*/	
	
	public static WebElement findElementSupport(WebDriver driver, By bySomething, int timeout) throws Exception{
		Thread.sleep(1000);
		WebElement Elm=null;
		Exception e1=null;
		for (int i=0; i<timeout; i++) {
			System.out.print("*");
			try {
				Elm=driver.findElement(bySomething);
				break;
				
			} catch (Exception e) {
				Thread.sleep(1000);
				e1=e;
			}
		}
		if (Elm==null) {
			throw e1;
		}
		return Elm;
	}
	
	public static WebElement findElementByXpath(WebDriver driver, String text, int timeout) throws Exception {
		WebElement Elm=null;
		Exception e1=null;
		
		for (int i=0; i<timeout; i++) {
			try {
				Elm=driver.findElement(By.xpath(text));
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				e1=e;
			}
			
		}
		if (Elm==null) {
			throw e1;
		}
		return Elm;
	}
	
	public static WebElement findSupport(WebDriver driver, By something, int times, int interval) throws Exception {
		WebElement Elm=null;
		Exception e1=null;
		
		for (int i=0; i<times; i++) {
			try {
				Elm=driver.findElement(something);
				break;
			} catch (Exception e) {
				Thread.sleep(interval);
				e1=e;
			}			
		}
		if (Elm==null) {
			throw e1;
		}
		return Elm;
	}
	
	public static Boolean forWaitURL(WebDriver driver, String url, int timeout) throws Exception{
		
		Boolean result=false;
		for (int i=0; i<timeout; i++) {
			if (driver.getCurrentUrl().equals(url)) {
				result = true;
				break;
			} else
				Thread.sleep(1000);
		}
		return result;
	}
	
	public static void openBrowserFullScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public static Boolean isElementDisplay(WebDriver driver, WebElement Elm) throws Exception {
		
		try {
			WebDriverWait wait=new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.visibilityOf(Elm));
			return Elm.isDisplayed();
		} catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.TimeoutException e) {
			return false;
		} 
		
	}

	public static void waitForElementTobeGone(WebDriver driver, WebElement Elm, int timeout) throws Exception{
		
	if (isElementDisplay(driver, Elm)) {
		
		new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(Elm)));
		}
		
	}

	public static void hoverTo(WebElement Elm, WebDriver driver) {
		
		Actions actions=new Actions(driver);
		actions.moveToElement(Elm).build().perform();
		
	}
	
	public static void ClickBackBrowserChrome(WebDriver driver) {
		
		driver.navigate().back();
	}
	
	public static void ClickForwardBrowserChrome(WebDriver driver) {
		
		driver.navigate().forward();
	}
	
	public static Boolean CompareLinkUrl(WebDriver driver, String url) {
		String real = driver.getCurrentUrl();
		if(real!=url){
			return false;			
		} else {		
		return true;
		}
	}
	
	public static String Result(Boolean val) throws Exception{
		String result=null;
		if(val==true) {
			result="Pass";
			return result;
		}else {
		result="False";
		return result;
		}
	}	

	public static Boolean VerifyText(WebElement elm, String text) throws Exception{
		String emltext=elm.getText();
		if(emltext==text) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void ScrolltoFindElement(WebDriver driver, WebElement Elm) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Elm );
		
	}
	

}

