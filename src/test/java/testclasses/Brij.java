package testclasses;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Brij {

	private WebDriver driver;
	  private String baseUrl;
	 // private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
		driver = new ChromeDriver();
	    baseUrl = "http://accounts.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testYoutubesubscribe() throws Exception {
	   
		  driver.get(baseUrl + "/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default#RecoveryEmailAddress=wahi.software%40gmail.com");
		  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		  driver.findElement(By.id("firstname-placeholder")).click();
		  
	    driver.findElement(By.id("FirstName")).clear();
	    driver.findElement(By.id("FirstName")).sendKeys("ramesh");
	    driver.findElement(By.id("LastName")).clear();
	    driver.findElement(By.id("LastName")).sendKeys("singh");
	    driver.findElement(By.id("GmailAddress")).click();
	    driver.findElement(By.id("GmailAddress")).clear();
	    driver.findElement(By.id("GmailAddress")).sendKeys("brajrasik102");
	    driver.findElement(By.id("Passwd")).click();
	    driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys("brajrasik");
	    driver.findElement(By.id("PasswdAgain")).clear();
	    driver.findElement(By.id("PasswdAgain")).sendKeys("brajrasik");
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    
	    driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/div/form/div[5]/fieldset/label[1]/span/div[1]")).click();
	    driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
	    driver.findElement(By.xpath("//div[@id=':5']/div")).click();
	    driver.findElement(By.id("BirthDay")).clear();
	    driver.findElement(By.id("BirthDay")).sendKeys("4");
	    driver.findElement(By.id("BirthYear")).clear();
	    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("BirthYear")).sendKeys("1986");
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/div/form/div[6]/label/div/div")).click();
	    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.xpath("//div[@id=':f']/div")).click();
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("RecoveryEmailAddress")).click();
	    driver.findElement(By.id("RecoveryEmailAddress")).click();
	    driver.findElement(By.id("GmailAddress")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("GmailAddress")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("GmailAddress")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("GmailAddress")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("submitbutton")).click();
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.cssSelector("img.tos-scroll-button-icon")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.cssSelector("img.tos-scroll-button-icon")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("iagreebutton")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("submitbutton")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.id("close-button")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    driver.findElement(By.xpath("(//button[@type='button'])[17]")).click();
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

}
