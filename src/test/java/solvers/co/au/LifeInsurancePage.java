package solvers.co.au;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import support_group.WebElementSuport;

public class LifeInsurancePage {

	private WebDriver driver;
	WebDriverWait wait;
	
	// Constructor
	
	public LifeInsurancePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 20);
	}
	
	//Variables---------------------
	
	
	// find Element-------------------
	
	@FindBy(xpath="//*[text()='Get Started']")
	private WebElement GetStart;
	@FindBy(xpath="//*[text()='Get a Quote']")
	private WebElement GetaQuote;
	@FindBy(xpath="//div/div[3]/div/div[2]/div[2]/a")
	private WebElement LearnMore_1;	
	@FindBy(xpath="//div/div[4]/div[1]/div[1]/div[2]/a")
	private WebElement LearnMore_2;	
	@FindBy(xpath="//div/div[4]/div[2]/div[1]/div[2]/a")
	private WebElement LearnMore_3;		

	
	
	
	
	
	// Function
	// click Get Start button
	
	public Boolean CheckGetStart() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, GetStart, null);
		return true;
	}

	// click Get a Quote
	
	public Boolean CheckGet_A_Quote() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, GetaQuote, null);
		return true;
	}
	
	// click Learn More 1 button
	public Boolean Check1More_1() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, LearnMore_1, null);
		return true;
	}	
	
	// click Learn More 2 button
	public Boolean Check1More_2() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, LearnMore_2,  null);
		return true;
	}	
	
	// click Learn More 3 button
	public Boolean Check1More_3() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, LearnMore_3,  null);
		return true;
	}	
		
	// Input form
	
	public void  InputForm() throws InterruptedException {
		List<WebElement> Elms=driver.findElements(By.xpath("//div[@class='et_pb_newsletter_form']/p"));
		String text=null;
		WebElementSuport.ScrolltoFindElement(driver, Elms.get(0));

		WebElement elm=driver.findElement(By.xpath("//*[contains(@id,'_form_')]/div[1]"));
		elm.click();	
		
		Thread.sleep(150000);

		//		String text=Elms.get(3).getText();
//		System.out.println("The text is: "+text);
//		Elms.get(1).sendKeys("text");
//		text=Elms.get(1).getText();		
//		System.out.println(text);
		
		
	}
	
}
