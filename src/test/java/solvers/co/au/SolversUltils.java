package solvers.co.au;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support_group.WebElementSuport;

public class SolversUltils {
	//-------------------------------------------- ultils
		public static Boolean CheckButtonsToLink(WebDriver driver, WebElement elm_Button, String url) throws Exception{
			
		WebDriverWait wait=new WebDriverWait(driver, 20);	
		WebElementSuport.ClickSupport(elm_Button, wait);
		String actual=driver.getCurrentUrl();
		ReturnPreviousPage(driver);
		if(actual==url) {
			return true;
		}else {
			return false;
		}
	}	
	
	public static void ReturnPreviousPage(WebDriver driver) {
		WebElementSuport.ClickBackBrowserChrome(driver);
		
	}	
	
	public static int GetSizeOfListElement(List<WebElement> Elms) {
		
		int size= Elms.size();
		return size;
		
		
	}
	
	
	
	
}
