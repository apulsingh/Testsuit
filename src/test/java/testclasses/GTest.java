package testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class GTest {
      
	public static WebDriver webdriver;
	public static String b;
	public static String b1;
	public static String CustId;
	public static String Custemail;
	public static String msgacid;
	@BeforeTest
	public void setup() throws Exception
	{
	 System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
		webdriver=new ChromeDriver();
		// Maximize window
		webdriver.manage().window().maximize();
		// Delete cookies
		webdriver.manage().deleteAllCookies();
		webdriver.get("http://demo.guru99.com/V4/");
		Thread.sleep(5000);
		
	}
	
	@Test(priority=0)
	public void registration() throws Exception
	{
		
	webdriver.findElement(By.xpath("html/body/div[3]/ol/li[1]/a")).click();
	WebElement textemail=webdriver.findElement(By.xpath("html/body/form/table/tbody/tr[5]/td[2]/input"));
	textemail.sendKeys("rajat_singh529@yahoo.com");
	webdriver.findElement(By.xpath("html/body/form/table/tbody/tr[6]/td[2]/input")).click();
	webdriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	WebElement txtuid=webdriver.findElement(By.xpath("html/body/table/tbody/tr[4]/td[2]"));
	b=txtuid.getText();
	WebElement txtpwd=webdriver.findElement(By.xpath("html/body/table/tbody/tr[5]/td[2]"));
    b1=txtpwd.getText();
	System.out.println(b+b1);
//	webdriver.quit();
		
	}
	
	@Test(priority=2)
	public void loginWithCredential() throws Exception
	{
		
		Thread.sleep(3000);
		webdriver.navigate().back();
		webdriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		webdriver.navigate().back();
		webdriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(b);
		webdriver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(b1);
		webdriver.findElement(By.name("btnReset")).click();
		webdriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(b);
		webdriver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(b1);
		webdriver.findElement(By.name("btnLogin")).click();
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=3)
	public void verifyHomePage() throws Exception
	{
		Thread.sleep(2000);
		//get text of the home page
				WebElement elTitle=webdriver.findElement(By.xpath("html/body/div[1]/h2"));
				String stle=elTitle.getText();
			    Assert.assertEquals("Guru99 Bank", stle.toString());
			   
			    				
			
	}
	@Test(priority=4, dependsOnMethods="verifyHomePage")
	public void verifyManagerId() throws Exception
	{
		Thread.sleep(3000);
		//Verify manager id on home page
		WebElement mngrid=webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
		String mngr=mngrid.getText();
		String mngr1="Manger Id : "+b;
		Assert.assertEquals(mngr1,mngr.toString());
		
	
			
	}
	
	@Test(priority=5)
	public void addNewCustomer() throws Exception
	{
		Thread.sleep(5000);
		webdriver.findElement(By.linkText("New Customer")).click();
		webdriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.name("name")).sendKeys("qwaqwa");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
		webdriver.findElement(By.xpath(".//*[@id='dob']")).sendKeys("2014-02-09");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")).sendKeys("R 185 Railway colony");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")).sendKeys("Lucknow");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")).sendKeys("Uttar pradesh");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")).sendKeys("232323");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input")).sendKeys("10101010101010");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input")).sendKeys("qwaqwa@rr.com");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input")).sendKeys("anurahhh@123");
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.name("sub")).click();
		
		
		
	}
	
	@Test(priority=6)
	public void customerAddedSuccessfully() throws Exception
	{
		// customer added successfull with cust id and emailid
		
		WebElement cid=webdriver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[4]/td[2]"));
		CustId=cid.getText();
		WebElement cemail=webdriver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[13]/td[2]"));
			
		Custemail=cemail.getText();
		
		System.out.println("New Customer Id: " +CustId+     "New Email Id: " +Custemail);
		
		webdriver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[14]/td/a")).click();
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=7)
	public void editCustomer() throws Exception
	{
		// customer added successfull with cust id and emailid
		
		Thread.sleep(2000);
		webdriver.findElement(By.linkText("Edit Customer")).click();
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(CustId);
		
				
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")).click();
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")).clear();
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")).sendKeys("Bihar");
		webdriver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]")).click();
		
	}
	
	@Test(priority=8)
	public void deleteCustomer() throws Exception
	{
		// customer added successfull with cust id and emailid
		
		Thread.sleep(2000);
		webdriver.findElement(By.linkText("Delete Account")).click();
		Thread.sleep(2000);
		webdriver.findElement(By.name("accountno")).sendKeys(CustId);
		webdriver.findElement(By.name("AccSubmit")).click();
		Thread.sleep(2000);
		webdriver.switchTo().alert().accept();	
		Thread.sleep(2000);
		webdriver.switchTo().alert().accept();
		
		
	}
	
	@Test(priority=9)
	public void addNewAc() throws Exception
	{
		// Adding new account
		
		Thread.sleep(2000);
		webdriver.findElement(By.linkText("New Account")).click();
		Thread.sleep(1000);
		webdriver.findElement(By.name("cusid")).sendKeys(CustId);
		
		Select drp = new Select(webdriver.findElement(By.name("selaccount")));         
		drp.selectByIndex(0);
		webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		webdriver.findElement(By.name("inideposit")).sendKeys("5000");
		webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		webdriver.findElement(By.name("button2")).click();
		
		WebElement succmsg=webdriver.findElement(By.xpath(".//*[@id='account']/tbody/tr[1]/td/p"));
		String msgsucc=succmsg.getText();
		
		WebElement acidd=webdriver.findElement(By.xpath(".//*[@id='account']/tbody/tr[4]/td[2]"));
		msgacid=acidd.getText();
		
		System.out.println("Success message: "+msgsucc);
		System.out.println("Account Id: "+msgacid);
		System.out.println("Customer Id: "+CustId);
		
		
	}
	
	
	
	
}
