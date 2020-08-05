package Testcase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;

import Pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	@Test
	public void loginTest() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * HomePage home= new HomePage(driver); //HomePage home =
		 * PageFactory.initElements(driver, HomePage.class)
		 * home.doLogin("subha.utest1@gmail.com", "utestutest");
		 * 
		 * LandingPage lp= new LandingPage(driver); lp.gotoProfile();
		 */
		new HomePage(driver).doLogin("subha.utest1@gmail.com", "utestutest").gotoProfile();

	}

}
