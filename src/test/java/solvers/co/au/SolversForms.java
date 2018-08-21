package solvers.co.au;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SolversForms {
/*	Function
	
	Waitting and element
	

	@param element: a element by tester, Using Webelement
	
	*/
	
	public static void InputFirstname(WebElement Element, WebDriverWait Wait, String FirstName) {
		
		//wait.until(ExpectedConditions.elementToBeClickable(Element));
		Wait.until(ExpectedConditions.visibilityOf(Element));
		Element.sendKeys(FirstName);
		
	}

	public static void InputLastName(WebElement Element, WebDriverWait Wait, String LastName) {
		
		//wait.until(ExpectedConditions.elementToBeClickable(Element));
		Wait.until(ExpectedConditions.visibilityOf(Element));
		Element.sendKeys(LastName);
		
	}
	
	public static void InputEmail(WebElement Element, WebDriverWait Wait, String Email) {
		
		//wait.until(ExpectedConditions.elementToBeClickable(Element));
		Wait.until(ExpectedConditions.visibilityOf(Element));
		Element.sendKeys(Email);
		
	}
	
	public static void ClickBtnSubscribe(WebElement Btn, WebDriverWait Wait) {
		
		//wait.until(ExpectedConditions.elementToBeClickable(Element));
		Wait.until(ExpectedConditions.visibilityOf(Btn));
		Btn.click();
		
	}
	
	
	public static void InputForm(List<WebElement> Elms, List<String> ListItems, WebDriverWait Wait) {
		
		List<WebElement> elms=Elms;
		List<String> listitmes=ListItems;
		int sizeof_elmlist=elms.size()-1;
		int sizeof_listitmes=ListItems.size();
		for (int i=1; i<sizeof_elmlist; i++) {
			Wait.until(ExpectedConditions.visibilityOfAllElements(elms));
//			Wait.until(ExpectedConditions.visibilityOfAllElements(elms));
			for(int j=0; j<sizeof_listitmes; j++) {
				String n=listitmes.get(j);
				System.out.println(n);
				elms.get(i).sendKeys(listitmes.get(j));
			}
			
		}
		
	}
	
	
	
}
