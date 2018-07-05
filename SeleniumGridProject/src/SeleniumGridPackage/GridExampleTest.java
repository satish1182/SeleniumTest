package SeleniumGridPackage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jndi.toolkit.url.Uri;

public class GridExampleTest {
	
	public WebDriver driver;
	public static String appURL = "http://www.google.com";
	public DesiredCapabilities cap;
	@BeforeClass
	public void setUp() throws MalformedURLException {
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SatishC\\workspace\\SeleniumGridProject\\geckodriver.exe");
//		cap = DesiredCapabilities.firefox();
		
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		cap = DesiredCapabilities.chrome();
		cap.setPlatform(org.openqa.selenium.Platform.ANY);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInIEBrowser() {
		System.out.println("*** Navigation to Application ***");
		driver.navigate().to(appURL);
		String strPageTitle = driver.getTitle();
		System.out.println("*** Verifying page title ***");
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}
	
	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}