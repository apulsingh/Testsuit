package testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//Automate online exam created Testsuite
public class GuruRS {

	// Create object for webdriver
	public static WebDriver webdriver;
	static String utl="http://maharajasjourneys.com/online_exam/index.php";
	
	@Test(priority=0)
	public void navigate() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
		 webdriver=new ChromeDriver();
		try{
			webdriver.get("http://maharajasjourneys.com/online_exam/index.php");
		Thread.sleep(5000);
		}
		catch(Exception e)
		{

			System.out.println(e);
		}
	}
	
	@Test(priority=1)
	public void loginSite() throws Exception
	{
		String a="rajsingh";
		String b="rajsingh";
		WebElement txtuname=webdriver.findElement(By.id("loginid2"));
		txtuname.sendKeys(a);
		WebElement txtpwd=webdriver.findElement(By.id("pass2"));
		txtpwd.sendKeys(b);
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement btnsubmit=webdriver.findElement(By.id("submit"));
		btnsubmit.click();
		
			
	}

    
	@Test(priority=2)
	public void verifyHomepage() throws Exception
	{
		String title=webdriver.getTitle();
		try{
		Assert.assertEquals("Wel come to Online Exam", title.toString());
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
			
	}
	
	@Test(priority=3)
	public void giveExam() throws Exception
	{
		webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[1]/td[2]/a")).click();
		// Give Vb exam
		webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[1]/td/a/font")).click();
		// Vb basic test exam
		webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[1]/td/a/font")).click();
		
		//Select ans and click next
		webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")).click();
		webdriver.findElement(By.name("submit")).click();
		webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/input")).click();
		webdriver.findElement(By.name("submit")).click();
		webdriver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[3]/td/input")).click();
		webdriver.findElement(By.name("submit")).click();
		WebElement el1=webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[1]/td[1]"));
		String t=el1.getText();
		WebElement el2=webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[1]/td[2]"));
		String a=el2.getText();	
		//verify total questions
		Assert.assertEquals("Total Question", t.toString());
		Assert.assertEquals("3", a.toString());
	  
		
	}
	
	@Test(priority=4)
	public void pickResult() throws Exception
	{
		//get result of given exam 
		webdriver.findElement(By.xpath("html/body/table[3]/tbody/tr/td[2]/div/strong/a[1]")).click();
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[2]/td[2]/a")).click();
		webdriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebElement el3=webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[2]/td[1]"));
		String c=el3.getText();
		WebElement el4=webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[2]/td[2]"));
		String d=el4.getText();
		WebElement el5=webdriver.findElement(By.xpath("html/body/table[4]/tbody/tr[2]/td[3]"));
		String e=el5.getText();
		
		try{
		System.out.println("Test Name: "+c+"\nTotal Marks: "+d+"\nObtained Marks: "+e);
		}
		catch (Exception e2) {
			System.out.print(e2);
			
		}
		
	}
	
	
}
