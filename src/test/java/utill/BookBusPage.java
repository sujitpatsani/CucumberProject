package utill;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BookBusPage extends Base {

	public void clickLink(String url) {

		// this.setDriver(BROWSER.CHROME);
		this.setDriver(BROWSER.CHROME);
		this.getDriver().navigate().to(url);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// this.getDriver().findElement(By.id("gi_roundtrip_label")).click();

	}
	
public void popup(){
		
		this.handleSingleWindow();
		System.out.println("hello");
		this.waitForPageLoaded(this.getDriver());
		this.frameToLoadAndSwitchToIt("notification-frame-22a344b57");
		this.getDriver().findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
	}
	
	public void clickBusLink(){
		
		this.waitForPageLoaded(this.getDriver());
		this.getDriver().findElement(By.linkText("Bus")).click();
		
	}

}
