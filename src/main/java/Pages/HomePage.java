package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="email")
	public WebElement usrname;
	@FindBy(id="pass")
	public WebElement pass;
	
	@FindBy(id="loginbutton")
	public WebElement login;
	
	/*
	 * public HomePage(WebDriver driver) { this.driver = driver; }
	 */
	
	
	
	public LandingPage doLogin(String username,String password) {
			usrname.sendKeys(username);
			pass.sendKeys(password);
			
			login.click();
			return  new LandingPage(driver);
	}

}
