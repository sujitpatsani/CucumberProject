package utill;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class HomePage extends Base {

	public void enterUrl(String url) {

		//this.setDriver(BROWSER.CHROME);
		this.setDriver(BROWSER.CHROME);
		this.getDriver().navigate().to(url);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.getDriver().findElement(By.id("gi_roundtrip_label")).click();
		
	}
	
	public void popup(){
		
		this.handleSingleWindow();
		System.out.println("hello");
		this.waitForPageLoaded(this.getDriver());
		this.frameToLoadAndSwitchToIt("notification-frame-22a344b57");
		this.getDriver().findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();

	}
	
	public void fromTOCitySelection(DataTable arg2){
			this.handleSingleWindow();
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<List<String>> li=arg2.raw();
			String from=li.get(1).get(0);
			String to=li.get(1).get(1);
			this.getDriver().switchTo().defaultContent();
			this.isElementPresent(this.getDriver().findElement(By.id("gi_source_st")));
			this.getDriver().switchTo().defaultContent();
			this.getDriver().findElement(By.id("gi_source_st")).sendKeys(from);
			List<WebElement> formElement=this.getDriver().findElements(By.xpath("//ul[@class='autoSuggestBoxList flt dn']/li/div[2]/div/span[2]"));
			for (WebElement element : formElement) {
				
				System.out.println(element.getText());
				
				if(element.getText().equalsIgnoreCase("(BBI)")){
					element.click();
					break;
				}
				
			}
			this.getDriver().findElement(By.id("gi_destination_st")).sendKeys(to);
			this.getDriver().findElement(By.id("gi_destination_st")).click();
		
	}
	

	
	public void closeBrowser(){
		this.getDriver().quit();
	}
	
	public void selectOneWayTrip(){
		this.getDriver().findElement(By.id("gi_oneway_label")).click();
	}
	
	public void setDepartTime(int month,int day,int year){
		
		String pretext="jrdp_start-calen";
		String departdateID=pretext+"_"+month+"_"+day+"_"+year;
		System.out.println(departdateID);
		this.getDriver().findElement(By.id("searchWidgetCommon")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println(departdateID);
		this.getDriver().findElement(By.id(departdateID)).click();
	}
	
	
	public void setNumberOfTravellers(){
		this.getDriver().findElement(By.xpath("//span[@id='pax_label']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select sel=new Select(this.getDriver().findElement(By.xpath("//select[@name='Adult']")));
		sel.deselectByIndex(2);
		
		this.getDriver().findElement(By.xpath("//select[@name='Adult']/option[2]")).click();
	}
	
	public void setclass(){
		Select sel=new Select(this.getDriver().findElement(By.id("gi_class")));
		sel.selectByIndex(1);
		this.getDriver().findElement(By.xpath("//i[@class='icon-swap ico36 fl txtCenter white']")).click();
	}
	
	public void searchFlight(){
		this.getDriver().findElement(By.id("gi_search_btn")).click();
	}

}
