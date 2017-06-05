package testclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.glass.events.KeyEvent;
import com.sun.java.swing.plaf.windows.resources.windows;

import sun.awt.Win32ColorModel24;

public class MouseActions {

	   public static WebDriver webdriver;
	   
	 
	   
	   @BeforeClass(enabled=true)
   public void setup() throws InterruptedException
   {
	  System.setProperty("webdriver.chrome.driver","F://NEW_MVNWorkspace//testng//resources//chromedriver.exe"); 
	  
	  webdriver=new ChromeDriver();
	  
	  webdriver.get("http://maharajasjourneys.com/online_exam/index.php");
	   Thread.sleep(2000);
	   
	   
   }
	
   @Test(priority=0, enabled=true)
   public void loginSite() throws AWTException, InterruptedException
   {
	  webdriver.findElement(By.id("loginid2")).sendKeys("rajsingh");
	  webdriver.findElement(By.id("pass2")).sendKeys("rajsingh");
	  //webdriver.findElement(By.id("submit")).click();
	   //pressing enter by using robot Api
	  //webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  Robot rb=new Robot();
	  rb.keyPress(KeyEvent.VK_ENTER);
	  Thread.sleep(3000);
	 // webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 // webdriver.switchTo().alert().dismiss();
	  
	  
	   
	  
   }
	
   @Test(priority=1,enabled=true)
   public void giveExam() throws AWTException, InterruptedException
   {
	 
	   //Using actions class for mouse event
	   WebElement elexap=webdriver.findElement(By.linkText("Subject for Quiz"));
	   Actions actionmou=new Actions(webdriver);
	   actionmou.contextClick(elexap).build().perform();
	   Robot rb=new Robot();
	   rb.keyPress(KeyEvent.VK_DOWN);
	   rb.keyPress(KeyEvent.VK_ENTER);
	   ArrayList<String> tabexam=new ArrayList<String>(webdriver.getWindowHandles());
	   webdriver.switchTo().window(tabexam.get(1));
	   webdriver.close();
	   webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   webdriver.switchTo().window(tabexam.get(0));
	   Thread.sleep(5000);
	   webdriver.quit();
	   
	  
	 
   }
   
   @Test(priority=2)
   public void frameClick() throws AWTException, InterruptedException
   {
	
	   System.setProperty("webdriver.chrome.driver","F://NEW_MVNWorkspace//testng//resources//chromedriver.exe"); 
		  
		  webdriver=new ChromeDriver();
		  
		  webdriver.get("http://demo.guru99.com/selenium/guru99home/");
		   Thread.sleep(2000);
	   
	   webdriver.switchTo().frame("a077aa5e");
	 webdriver.findElement(By.xpath("html/body/a/img")).click();
	Thread.sleep(5000);
	 Actions ac=new Actions(webdriver);
	 
		 
	 ArrayList<String> tabb=new ArrayList<String>(webdriver.getWindowHandles());
	 
	 webdriver.switchTo().window(tabb.get(0));
	 webdriver.close();
	 webdriver.switchTo().window(tabb.get(1));
	 
	 
	 WebElement elTesting=webdriver.findElement(By.linkText("Testing"));
	 ac.moveToElement(elTesting).build().perform();
	 webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 WebElement elmanualTest=webdriver.findElement(By.linkText("Manual Testing"));
	 ac.click(elmanualTest).build().perform();
	 
	 
	   
	   
	   
   }
   
   
   
   
   
   
	
}
