package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
		
	}

	/*
	 * public LandingPage (WebDriver driver) { PageFactory.initElements(driver,
	 * this); }
	 */
	@FindBy(xpath = "//*[@id=\"navItem_100010364910757\"]/a/div")
	public WebElement profile;

	public LandingPage gotoProfile() {
		profile.click();
		return this;
	}

	public void updateStatus() {

	}

	public void gotoPages() {

	}
}
