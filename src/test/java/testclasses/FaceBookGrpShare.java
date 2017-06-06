package testclasses;

import static org.testng.Assert.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	   
	   
	  }
	  @Test
	  public void test1() throws Exception {
		  
		// Create object of HashMap Class
					Map<String, Object> prefs = new HashMap<String, Object>();
			              
			                // Set the notification setting it will override the default setting
					prefs.put("profile.default_content_setting_values.notifications", 2);
			 
			                // Create object of ChromeOption class
					ChromeOptions options = new ChromeOptions();
			 
			                // Set the experimental option
					options.setExperimentalOption("prefs", prefs);
			 
			                // pass the options object in Chrome driver
			 
					 driver = new ChromeDriver(options);
		  driver.get(baseUrl + "/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("airline0000@gmail.com");
		    driver.findElement(By.id("pass")).clear();
		    driver.findElement(By.id("pass")).sendKeys("padma@1922");
		   
		    // Click login button
		    driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[3]/label/input")).click();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		         		 
		   
		   
		//Click on braj wasi on home page
		 
		    WebDriverWait wait = new WebDriverWait (driver, 20);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/ul/li/div/div/div/ul/li[2]/div/div[2]/div/div/div/a")));
		    
		    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/ul/li/div/div/div/ul/li[2]/div/div[2]/div/div/div/a")).click();
		    
		   // Tap share button on brajwasi page 
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div/button")));
		    		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div/button")).click();
		   		    		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		   
		   		    if(isAlertPresent()==false)
		   		    {
		   		    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[21]/div[2]/div/div/div/div/div/div[1]/div/div[1]/h3/div/div/div/a/span[2]/i")));
			    		driver.findElement(By.xpath("html/body/div[21]/div[2]/div/div/div/div/div/div[1]/div/div[1]/h3/div/div/div/a/span[2]/i")).click();
		   		    }
		   		    else
		   		    {
		   		    	System.out.println("Element not found");
		   		    }
		   //Tap on select group drop down
		   		    		
				   		    		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	    		
		   		    		
				   		    	 //select share group
				   		    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='fbPhotoSnowliftFeedback']/div/div/div/div/div/div[2]/div/span[3]/a/em")));
						    		driver.findElement(By.xpath("//div[@id='fbPhotoSnowliftFeedback']/div/div/div/div/div/div[2]/div/span[3]/a/em")).click();
						   		    		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);   		    		
				   		    		
		  //  driver.findElement(By.xpath("//div[@id='fbPhotoSnowliftFeedback']/div/div/div/div/div/div[2]/div/span[3]/a/em")).click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("html/body/div[22]/div/div/div/ul/li[3]/a/span/span/span/em")).click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='js_nf']/div/ul/li[3]/a/span/span/span/em")));
    		driver.findElement(By.xpath("//div[@id='js_nf']/div/ul/li[3]/a/span/span/span/em")).click();
		    
		  		   
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
