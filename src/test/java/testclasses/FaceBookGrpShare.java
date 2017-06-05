package testclasses;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FaceBookGrpShare {

	
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	   
		 
		  System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
		  driver = new ChromeDriver();
	    baseUrl = "https://www.facebook.com";
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	  @Test
	  public void test1() throws Exception {
		  
		  driver.get(baseUrl + "/");
		  ChromeOptions options = new ChromeOptions();
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("airline0000@gmail.com");
		    driver.findElement(By.id("pass")).clear();
		    driver.findElement(By.id("pass")).sendKeys("padma@1922");
		    options.addArguments("--disable-notifications");
		    driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[3]/label/input")).click();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
			  options.addArguments("--disable-notifications");
		    driver.switchTo().alert().accept();
		    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("div._19bk > strong")).click();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   // driver.switchTo().alert().dismiss();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("div._52eh._5bcu")).click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("a._5dec._xcx")).click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//div[@id='fbPhotoSnowliftFeedback']/div/div/div/div/div/div[2]/div/span[3]/a/em")).click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("span._55pe > span > em._4qba")).click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//div[@id='js_nf']/div/ul/li[3]/a/span/span/span/em")).click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.id("audience_group")).clear();
		    driver.findElement(By.id("audience_group")).sendKeys("Kirtan and Spirituality, Los Angeles");
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("(//button[@value='1'])[13]")).click();
		    Thread.sleep(10000);
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
