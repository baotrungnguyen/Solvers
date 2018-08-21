package po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	//Constructor 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Find Elements
	
	@FindBy (id="username") private WebElement username;
	@FindBy (id="password") private WebElement password;
	
	//Action
	
	public LoginPage LoginWith(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		password.sendKeys(Keys.ENTER);
		return this;
	}
	

}
