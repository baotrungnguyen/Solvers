package solvers.co.au;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import support_group.WebElementSuport;

public class EssentialLifePage {

	private WebDriver driver;
	WebDriverWait wait;
	
	// Constructor
	
	public EssentialLifePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 20);
	}
	
	//Variables---------------------
	
	
	// find Element-------------------

/*	@FindBy(xpath="//div/div[2]/div/div/div[2]/a")
	private List<WebElement> listGetaQuotes;*/
	@FindBy(xpath="//div/div/div/div[2]/div/a")
	private List<WebElement> listbutton;
	
	
	
	public Boolean CheckBtn_i(int index) throws Exception{
		SolversUltils.CheckButtonsToLink(driver, listbutton.get(index), null);
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
