package testclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;

import javafx.beans.property.SetProperty;

public class IFrame {

	public static WebDriver webdriver;
	
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
		webdriver=new ChromeDriver();
		webdriver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		webdriver.manage().window().maximize();
		Thread.sleep(2000);
		
		
	}
	
	
@Test(priority=0)
public void airPackageClick() throws InterruptedException, AWTException
{
	
	   WebElement irctctour=webdriver.findElement(By.linkText("IRCTC Tourism"));
	   
	   Actions acs=new Actions(webdriver);
	
	   acs.moveToElement(irctctour).build().perform();
	   webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  
	   WebElement airtct=webdriver.findElement(By.linkText("Air Packages"));
	   acs.moveToElement(airtct).build().perform();
	   webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	   acs.click(airtct).build().perform();
	  
	   webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   
	   ArrayList<String> tbbs=new ArrayList<String>(webdriver.getWindowHandles());
	   webdriver.switchTo().window(tbbs.get(0)).close();
	   webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	   webdriver.switchTo().window(tbbs.get(1));
	   
	   Thread.sleep(2000);
    
	

}	
@Test(priority=1)
public void tapFlightsAndBook() throws InterruptedException, AWTException
{
	
	   webdriver.findElement(By.xpath(".//*[@id='main-menu']/li[3]/a")).click();
	   
	   webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	   ArrayList<String> tbbs1=new ArrayList<String>(webdriver.getWindowHandles());
	   webdriver.switchTo().window(tbbs1.get(0)).close();
	   webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	   webdriver.switchTo().window(tbbs1.get(1));
	   

}	
	
@Test(priority=2)
public void searchDomesticFlight() throws InterruptedException, AWTException
{
	
	  
	//Enter Source
	webdriver.findElement(By.xpath(".//*[@id='origin']")).sendKeys("LUCKNOW");
	   
	   webdriver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
	   
     WebElement namecity=webdriver.findElement(By.xpath(".//*[@id='ui-active-menuitem']"));
	   
	   Actions acs=new Actions(webdriver);
	
	   acs.moveToElement(namecity).build().perform();
	   webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  acs.click(namecity).build().perform();
	 
	  //Enter Destination
	  webdriver.findElement(By.xpath(".//*[@id='destination']")).sendKeys("DELHI");
	   
	   webdriver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
	   
    WebElement namecityd=webdriver.findElement(By.xpath(".//*[@id='ui-active-menuitem']"));
	   
	   //Actions acs=new Actions(webdriver);
	
	   acs.moveToElement(namecityd).build().perform();
	   webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  acs.click(namecityd).build().perform(); 
	  	   
	   //Select Date
	  
	  webdriver.findElement(By.xpath(".//*[@id='where']/div[4]/img")).click();
	  webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	WebElement eldate=webdriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[3]/a"));
	
	acs.doubleClick(eldate).build().perform();
	 
	   //select item from Airlines preference dropdown
	
		Select cmpnm=new Select(webdriver.findElement(By.xpath(".//*[@id='searchopt_dom']/div[2]/div/select")));
	cmpnm.selectByIndex(3);
	
    //Tap on search
	webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	webdriver.findElement(By.xpath(".//*[@id='showdometic']/div[6]")).click();
	
	
	
}	
	
}
