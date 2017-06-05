package testclasses;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dataportfolio 
{
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "http://localhost:8081";
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  }
	  
	  @Test(priority=0)
	  public void loginToApplication() throws InterruptedException
	  
	  {
		    driver.get(baseUrl+"/data-portfolio-ii/login");
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("demouser");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("demouser");
		    driver.findElement(By.xpath("//input[@value='Login']")).click();
		    driver.manage().window().maximize();
		    Thread.sleep(3000);
		  
	  }
	  @Test(priority=1)
	  public void addData() throws InterruptedException
	  
	  {
		  //driver.findElement(By.cssSelector("span.description-txt")).click(); 
		    driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/a/span/span/h3")).click();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    driver.findElement(By.id("systemName")).clear();
		    driver.findElement(By.id("systemName")).sendKeys("Rajasi");
		    driver.findElement(By.id("systemAlias")).clear();
		    driver.findElement(By.id("systemAlias")).sendKeys("testingh");
		    driver.findElement(By.id("description")).clear();
		    driver.findElement(By.id("description")).sendKeys("test description");
		    new Select(driver.findElement(By.id("region"))).selectByVisibleText("Global");
		    new Select(driver.findElement(By.id("itFunctionalArea"))).selectByVisibleText("Commercial");
		    driver.findElement(By.id("itSystemOwner")).clear();
		    driver.findElement(By.id("itSystemOwner")).sendKeys("commer");
		    new Select(driver.findElement(By.id("domain"))).selectByVisibleText("Regulatory");
		    new Select(driver.findElement(By.id("systemFunction"))).selectByVisibleText("Human Resources");
		    driver.findElement(By.id("businessSystemOwner")).clear();
		    driver.findElement(By.id("businessSystemOwner")).sendKeys("yougesh");
		    driver.findElement(By.id("executiveSponsor")).clear();
		    driver.findElement(By.id("executiveSponsor")).sendKeys("mayank");
		    driver.findElement(By.id("general-info-next")).click();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("validated"))).selectByVisibleText("Qualified");
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("assetType"))).selectByVisibleText("Tool");
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("service"))).selectByVisibleText("MSP");
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("hostingModel"))).selectByVisibleText("Otsuka Data Center");
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    driver.findElement(By.id("purchasedLicenses")).clear();
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    driver.findElement(By.id("purchasedLicenses")).sendKeys("23");
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    driver.findElement(By.id("activeUsers")).clear();
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    driver.findElement(By.id("activeUsers")).sendKeys("56");
		    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		    driver.findElement(By.id("system-info-next")).click();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("complianceRisk"))).selectByVisibleText("No Risk [1]");
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("systemRelation"))).selectByVisibleText("1 - 5 [1]");
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("systemLongevity"))).selectByVisibleText("1 - 5 [1]");
		    driver.findElement(By.id("system-classification-submit")).click();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("html/body/div[5]/div[3]/div/button[1]")).click();
		   		   
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    driver.findElement(By.id("systemCombo")).clear();
		    driver.findElement(By.id("systemCombo")).sendKeys("Rajasi");
		    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		    driver.findElement(By.id("nameAndLocationResponse")).clear();
		    driver.findElement(By.id("nameAndLocationResponse")).sendKeys("test");
		    driver.findElement(By.id("nameAndLocationComment")).clear();
		    driver.findElement(By.id("nameAndLocationComment")).sendKeys("test comment");
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    new Select(driver.findElement(By.id("categoryOfPersonalInformationResponse"))).selectByVisibleText("Clinical Data");
		    driver.findElement(By.id("nextButtonEqc")).click();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    driver.findElement(By.id("naiFirstNameInitial")).click();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    driver.findElement(By.id("eapqEduInfo")).click();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    driver.findElement(By.id("eapqEduInfo")).click();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    driver.findElement(By.id("paeUserEmpAccount")).click();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    driver.findElement(By.id("submitEqc")).click();
		    Thread.sleep(10000);
		  
	  }

	  @Test(priority=2)
	  public void updateData()
	  
	  {
		WebElement wel= driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div[1]/div[2]"));
		Actions acs=new Actions(driver);  
		acs.moveToElement(wel).build().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		  new Select(driver.findElement(By.id("ddl-update-system-list"))).selectByVisibleText("Testrajatasdwew");
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		    driver.findElement(By.id("systemAlias")).clear();
		    driver.findElement(By.id("systemAlias")).sendKeys("Rajasi");
		    driver.findElement(By.id("description")).clear();
		    driver.findElement(By.id("description")).sendKeys("test description edited");
		    new Select(driver.findElement(By.id("region"))).selectByVisibleText("Japan");
		    new Select(driver.findElement(By.id("itFunctionalArea"))).selectByVisibleText("R&D");
		    driver.findElement(By.id("general-info-next")).click();
		    new Select(driver.findElement(By.id("service"))).selectByVisibleText("Otsuka");
		    driver.findElement(By.id("system-info-next")).click();
		    driver.findElement(By.id("system-classification-submit")).click();
		    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		    driver.findElement(By.id("nameAndLocationResponse")).clear();
		    driver.findElement(By.id("nameAndLocationResponse")).sendKeys("test edited");
		    driver.findElement(By.id("nameAndLocationComment")).clear();
		    driver.findElement(By.id("nameAndLocationComment")).sendKeys("test comment edited");
		    new Select(driver.findElement(By.id("categoryOfPersonalInformationResponse"))).selectByVisibleText("HR Data");
		    driver.findElement(By.id("nextButtonEqc")).click();
		    driver.findElement(By.id("percAge")).click();
		    driver.findElement(By.id("percGender")).click();
		    driver.findElement(By.id("submitEqc")).click();
		    driver.findElement(By.xpath("//a[7]/span")).click();
		    driver.findElement(By.cssSelector("canvas")).click();
		    driver.findElement(By.cssSelector("canvas")).click();
		    driver.findElement(By.cssSelector("canvas")).click();
		    driver.findElement(By.cssSelector("canvas")).click();
		    driver.findElement(By.xpath("//body/div/div/div/a[2]/span")).click();
		  
		  
	  }
	  
	  
	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	
}
