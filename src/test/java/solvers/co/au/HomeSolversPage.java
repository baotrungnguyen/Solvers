package solvers.co.au;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support_group.WebElementSuport;

import java.util.Set;
import java.util.logging.Logger;

public class HomeSolversPage {

	private WebDriver driver;
	WebDriverWait wait;
	
	// Constructor
	public HomeSolversPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver, 20);
	
	}
	//Variables---------------------
	String msg="Success! Thanks for joining.";
	//links--------------
	String Insurance="https://solvers.com.au/insurance/";
	String Finance="https://solvers.com.au/finance/";
	String Career="https://solvers.com.au/career/";
	String Property="https://solvers.com.au/property/";
	String Articles="https://solvers.com.au/blog/";
	
	// find Element-------------------
	@FindBy(xpath="//*[text()='Get Started']")
	private WebElement getstart;
	@FindBy(xpath="//div[1]/div[1]/a[text()='Insurance']")
	private WebElement insurance;
	@FindBy(xpath="//div[2]/div[1]/a[text()='Finance']")
	private WebElement finance;
	@FindBy(xpath="//div[3]/div[1]/a[text()='Career']")
	private WebElement career;
	@FindBy(xpath="//div[4]/div[1]/a[text()='Property']")
	private WebElement property;
	@FindBy(xpath="//a[text()='More Articles']")
	private WebElement arcticles;
		//-----------form elements
	@FindBy(xpath="//p[1]/input[1]")
	private WebElement firstname;
	@FindBy(xpath="//p[2]/input[1]")
	private WebElement lastname;
	@FindBy(xpath="//p[3]/input[1]")
	private WebElement email;
	@FindBy(xpath="//a/span[2]")
	private WebElement subscribe;
	@FindBy(xpath="//h2[contains(text(),'Success! Thanks for joining.')]")
	private WebElement success;
	
	
	// Function
	// click Get Start button
	public Boolean CheckGetStart() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, getstart, null);
		return true;
	}
	
	
	public void ClickGetStart() throws Exception {
		WebElementSuport.ClickSupport(getstart, wait);		
	}

	// click Insurance button
	public void ClickInsurance() throws Exception {
		WebElementSuport.ClickSupport(insurance, wait);
	}
	
	public Boolean CheckInsurance() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, insurance, Insurance);
		return true;
	}
	
	// click Finance button
	public void ClickFinance() throws Exception {
		WebElementSuport.ClickSupport(finance, wait);
	}
	public Boolean CheckFinance() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, finance, Insurance);
		return true;
	}	
	
	// click Career button
	public void ClickCareer() throws Exception {
		WebElementSuport.ClickSupport(career, wait);
	}
	public Boolean CheckCarrer() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, career, Career);
		return true;
	}

	
	// click Property button
	public void ClickProperty() throws Exception {
		WebElementSuport.ClickSupport(property, wait);
	}
	public Boolean CheckProperty() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, property, Property);
		return true;
	}

	
	// click Arcticles button
	public void ClickArcticles() throws Exception {
		WebElementSuport.ClickSupport(arcticles, wait);
	}
	public Boolean CheckArticles() throws Exception{
		SolversUltils.CheckButtonsToLink(driver, arcticles, Articles);
		return true;
	}

		
	public void InputSubscribe(String Firstname, String Lastname, String Email) throws Exception {
		String base=driver.getWindowHandle();
		WebElementSuport.sendKeysSupport(firstname,Firstname, wait);
		WebElementSuport.sendKeysSupport(lastname,Lastname,wait);
		WebElementSuport.sendKeysSupport(email, Email, wait);

		//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_form_')]/div[1]"))).click();


		//WebElementSuport.sendKeysSupportEnter(subscribe, wait);
		
	}
	
	public Boolean VerifySucces() throws Exception{
		if(WebElementSuport.VerifyText(success, msg)) {
			return true;
			
		}else {
			
			return false;
		}
		
	}
	
	
	
	
	
}
