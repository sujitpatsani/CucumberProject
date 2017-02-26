package utill;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	String browserName;
	private static WebDriver driver;
	final static Logger log = Logger.getLogger(Base.class);
	WebDriverWait wait= new WebDriverWait(this.getDriver(),10);

	protected WebDriver getDriver() {
		// Creating the driver for CHROME
		if (browserName.equalsIgnoreCase("chrome") && driver == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities()
					.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			File file = new File("C:\\chromeselnium\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());
			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();

			return driver;

		}
		// Creating the driver for IE
		else if (browserName.equalsIgnoreCase("ie") && driver == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities()
					.internetExplorer();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			File file = new File("C:\\chromeselnium\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);

			driver.manage().window().maximize();
			return driver;

		}
		// Creating the driver for FIREFOX
		else if (browserName.equalsIgnoreCase("firefox") && driver == null) {
			driver = new FirefoxDriver();
			return driver;
		}

		else
			return driver;
	}

	protected void setDriver(BROWSER browser) {

		this.browserName = browser.getBrowserName();
	}

	public void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver)
						.executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public void frameToLoadAndSwitchToIt(String frameName) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(frameName));

	}

	public boolean isElementPresent(WebElement Element) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		for (int i = 0; i < 100; i++) {
			try {
				if (Element.isDisplayed())
					return true;
				else
					Thread.sleep(100);
			} catch (Exception e) {
				try {
					Thread.sleep(100);
				} catch (Exception e1) {
					// System.out.println("Failed Loop");
				}
			}

		}
		return false;
	}

	public void handleSingleWindow() {
		this.waitForPageLoaded(this.getDriver());
		Set<String> windows = this.getDriver().getWindowHandles();
		String windowpopup = windows.iterator().next();
		this.getDriver().switchTo().window(windowpopup);
	}

	public Alert aleart() {
		
		Alert myAleart=wait.until(ExpectedConditions.alertIsPresent());
		return myAleart;
		

	}
	
	public void visibilityOfElementLocated(By element){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
