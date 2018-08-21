package solvers.co.au;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import support_group.WebElementSuport;

public class SmartInvestmentPage {

	private WebDriver driver;
	WebDriverWait wait;
	
	// Constructor
	
	public SmartInvestmentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 20);
	}
	
	//Variables---------------------
	
	
	// find Element-------------------

/*	@FindBy(xpath="//div/div[2]/div/div/div[2]/a")
	private List<WebElement> listGetaQuotes;*/
	@FindBy(xpath="//div[2]/a")
	private List<WebElement> listbutton;
	@FindBy(xpath="//*[@id=\'categories-2\']/ul/li")
	private List<WebElement> listcategories;
	@FindBy(xpath="//*[@id=\'recent-posts-2\']/ul/li")
	private List<WebElement> recentpost;
	@FindBy(xpath="//*//ul[@id='menu-footer-1']/li")
	private List<WebElement> extenallink;
	
	
	
	
	
	public Boolean CheckBtn_i(int index) throws Exception{
		SolversUltils.CheckButtonsToLink(driver, listbutton.get(index), null);
		return true;
	}
	
	public Boolean CategoryItem(int index) throws Exception{
		SolversUltils.CheckButtonsToLink(driver, listcategories.get(index), null);
		return true;
		
	}
	
	public Boolean RecentPosts(int index) throws Exception{
		
		SolversUltils.CheckButtonsToLink(driver, recentpost.get(index), null);
		return true;
	}
	
	public Boolean ExtenalLink(int index) throws Exception{
		
		SolversUltils.CheckButtonsToLink(driver, extenallink.get(index), null);
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
