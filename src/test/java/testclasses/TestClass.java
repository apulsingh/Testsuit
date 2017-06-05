package testclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;
import com.sun.jna.platform.win32.WinBase.SYSTEMTIME;

import javafx.scene.control.Tab;

public class TestClass {

	public static WebDriver webdriver;
	
	@BeforeTest
	public void setup() throws InterruptedException
		{
		System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
		webdriver=new ChromeDriver();
		webdriver.get("http://maharajasjourneys.com/online_exam/index.php");
		webdriver.manage().window().maximize();
		Thread.sleep(3000);
		
	
	}
	@Test(priority=0)
	public void login() throws AWTException, InterruptedException
    {
		webdriver.findElement(By.id("loginid2")).sendKeys("rajsingh");
		webdriver.findElement(By.id("pass2")).sendKeys("rajsingh");
		// Perfrorm keybord enter event.
		webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		
		
	
	}
	
	@Test(priority=1)
	public void giveExam() throws AWTException
	{
		//Perform mouse events by using performs
		Actions act=new Actions(webdriver);
		WebElement ellink=webdriver.findElement(By.linkText("Subject for Quiz"));
		act.contextClick(ellink).build().perform();
		//Perform key down and enter by keyboard
		Robot rb1=new Robot();
		
		rb1.keyPress(KeyEvent.VK_DOWN);
		rb1.keyPress(KeyEvent.VK_ENTER);
		webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Moving to the newly opened tab/ Playing with tabs by using array list
		ArrayList<String> tbbb=new ArrayList<String>(webdriver.getWindowHandles());
		webdriver.switchTo().window(tbbb.get(0)).close();
		webdriver.switchTo().window(tbbb.get(1));
	    webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[1]/td/a/font")).click(); 
	   webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[1]/td/a/font")).click();
	   //Give exam 
	   webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")).click();
	   webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[6]/td/input")).click();
	   webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")).click();
	   webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[6]/td/input")).click();
	   webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")).click();
	   webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[6]/td/input")).click();
		
		WebElement totlmarks=webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[1]/td[2]"));
		String ttle=totlmarks.getText();
		WebElement resultmarks=webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[2]/td[2]"));
		String resul=resultmarks.getText();
		
		System.out.println("Tota Marks: " +ttle);
		System.out.println("Result Marks: " +resul);
	   
		webdriver.quit();
		
	
    }
	
	//Handling i frame:
	@Test(priority=2)
	public void iFrameClick() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
	webdriver=new ChromeDriver();
	webdriver.get("http://demo.guru99.com/selenium/guru99home/");
	webdriver.manage().window().maximize();
	Thread.sleep(3000);
	
	//Switch to iframe find by Id/name
	
	
	webdriver.switchTo().frame("a077aa5e");
	webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	webdriver.findElement(By.xpath("html/body/a/img")).click();
	Thread.sleep(3000);
	ArrayList<String> tbb1=new ArrayList<String>(webdriver.getWindowHandles());
	webdriver.switchTo().window(tbb1.get(0)).close();
	webdriver.switchTo().window(tbb1.get(1));
	WebElement eltste=webdriver.findElement(By.linkText("Testing"));
	//Call Actions class for mouse action
	Actions acss=new Actions(webdriver);
	acss.moveToElement(eltste).build().perform();
	WebElement eltste1=webdriver.findElement(By.linkText("Manual Testing"));
	acss.click(eltste1).build().perform();
	
	
	
	
	
	
	
	
	
	
	

}
	
}
