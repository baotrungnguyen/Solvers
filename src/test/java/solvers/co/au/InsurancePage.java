package solvers.co.au;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import support_group.WebElementSuport;

public class InsurancePage {

	private WebDriver driver;
	WebDriverWait wait;
	
	// Constructor
	
	public InsurancePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 20);
	}
	
	//Variables---------------------
	
	
	// find Element-------------------
	
	@FindBy(xpath="//*[text()='Get a Quote']")
	private WebElement GetaQuote;
	@FindBy(xpath="//div/div[2]/div[3]/div[1]/div/a")
	private WebElement FindOutMore1;
	@FindBy(xpath="//div/div[2]/div[3]/div[2]/div/a")
	private WebElement FindOutMore2;	
	@FindBy(xpath="//div/div[2]/div[3]/div[3]/div/a")
	private WebElement FindOutMore3;	
	@FindBy(xpath="//div/div[3]/div/div[2]/div[2]/a")
	private WebElement LearnMoreBlog;
	@FindBy(xpath="//div/div[4]/div/div[1]/div[2]/a")
	private WebElement LearnMoremedicare; //https://solvers.com.au/what-is-the-medicare-levy-surcharge/
	@FindBy(xpath="//div/div[6]/div/div/div[3]/a")
	private WebElement MoreArticles;
//	@FindBy(xpath="//div[1]/div[9]/div/div[2]/div[1]/div[2]")
//	private List<WebElement> FormsSolvrers;
//	String Xpath="//div[1]/div[9]/div/div[2]/div[1]/div[2]";
//	List<WebElement> ListWeb= driver.findElements(By.xpath(Xpath));
	
	
	// Function
	// click Get A Quote button
	
	public Boolean CheckGetAQuote() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, GetaQuote, null);
		return true;
	}

	// click FindOutMore1 button
	public Boolean FindOutMore1() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, FindOutMore1, null);
		return true;
	}
	
	// click FindOutMore2 button
	public Boolean FindOutMore2() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, FindOutMore2, null);
		return true;
	}	
	
	// click FindOutMore3 button
	public Boolean FindOutMore3() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, FindOutMore3, null);
		return true;
	}	
	
	// click Learn More button
	public Boolean LearnMoreBlog() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, LearnMoreBlog, null);
		return true;
	}	
		
	// click Learn More button
	public Boolean LearnMoremedicare() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, LearnMoremedicare, null);
		return true;
	}		
	
	// click Learn More button
	public Boolean MoreArticles() throws Exception{
		WebElementSuport.ScrolltoFindElement(driver, MoreArticles);
		SolversUltils.CheckButtonsToLink(driver, MoreArticles, null);
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
