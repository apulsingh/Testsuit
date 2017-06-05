package dsur;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;


public class dsurSuite {
 
	public static WebDriver webdriver;
	public static String compdname;
  @BeforeClass
  public void setup() throws InterruptedException
  
  {
	 System.setProperty("webdriver.chrome.driver", "F://NEW_MVNWorkspace//testng//resources//chromedriver.exe");
	 webdriver=new ChromeDriver();
	 webdriver.get("http://localhost:8080/dsur/");
	  Thread.sleep(3000);
  }
  @Test(priority=0)
  public void loginToDsur()
  {
	  webdriver.findElement(By.id("username")).sendKeys("demouser");
	  webdriver.findElement(By.id("password")).sendKeys("demouser");
	  webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  webdriver.findElement(By.xpath(".//*[@id='submitForm']/div[3]/label[3]/input")).click();
	  webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	  webdriver.findElement(By.xpath(".//*[@id='submitForm']/div[5]/input")).click();
	  webdriver.manage().window().maximize();
	  //verify home page
	  webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  WebElement eltitle=webdriver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/h2"));
	  String ttl=eltitle.getText();
	  Assert.assertEquals("Development Safety Update Report", ttl.toString());
	  
	  
  }
  
  @Test(priority=1)
  public void uploadCompound() throws InterruptedException, AWTException
  {
	  // Uploading Tolvapton with start and end date is 01-07-2017 & 30-09-2017 
	  
	Select cmpnm=new Select(webdriver.findElement(By.id("compoundName")));
	cmpnm.selectByVisibleText("Tolvaptan(OPC-41061)");
	Thread.sleep(3000);
	
	webdriver.findElement(By.xpath(".//*[@id='txt_41']")).click();
	webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	
	//Select date 01-07-2017 from calendar control
	//Month
	Select cldt=new Select(webdriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]")));
	cldt.selectByIndex(6);
	webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	//Year
	Select clyr=new Select(webdriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]")));
	clyr.selectByIndex(10);
	webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	webdriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[7]/a")).click();
	Thread.sleep(3000);
	
	//Click on cal2 icon
	webdriver.findElement(By.xpath(".//*[@id='txt_42']")).click();
	webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	//Select date 30-09-2017 from calendar control
		//Month
		Select cldt1=new Select(webdriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]")));
		cldt1.selectByIndex(8);
		webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//Year
		Select clyr1=new Select(webdriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]")));
		clyr1.selectByIndex(10);
		webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		webdriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[7]/a")).click();
		Thread.sleep(3000);
	
	 // Q 4 ans No
		
     // Q 5 ans Yes ,  cumulative post marketing exposure data: Yes  
		               //Is it patient/patient years  : patient years   
		               //Is it Otsuka pharmaceuticals product: Yes
      // Q 6 ans  significant actions been taken related to safety during the reporting: Not sure
	  //Q 7  Serious Adverse Reactions (SARs) during the reporting period:  Yes
	  //Q8   Are there multiple DSURs for this product?:  No
      // Q9 Automatically Bind
	  // 10 . Please enter QPPV name  Automatically bind
	  //11. Were there any expanded access/compassionate use programmes ongoing: Not Sure
	  //12. Were there any other clinical trial/study sources that became available: Not Sure
	  //13. . Is the product under development as a component of a fixed combination product : Yes
		             // Has a previously characterised or new safety finding from a combination therapy:  Updated
	  //14. Are there any long term followup studies: No
	  //15. Were there published/draft abstracts/manuscripts with safety findings: Yes
	  //16.  Were there any updates to the IB during the reporting period? : Yes
		
		webdriver.findElement(By.xpath(".//*[@id='Yes~4,30_3']")).click();
		webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		webdriver.findElement(By.xpath(".//*[@id='Yes~31_30']")).click();
		webdriver.findElement(By.xpath(".//*[@id='Patient-Years_31']")).click();
		webdriver.findElement(By.xpath(".//*[@id='Yes_4']")).click();
		webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath(".//*[@id='Not Sure_7']")).click();
		webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath(".//*[@id='Yes~_9']")).click();
		
		webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath(".//*[@id='Yes~33_32']")).click();
		webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

		
		webdriver.findElement(By.xpath(".//*[@id='Updated_33']")).click();
		//Select  Medical Safety Product Lead
				
		  //webdriver.findElement(By.xpath(".//*[@id='trnglBtn']/span[1]")).click();
		  //webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath(".//*[@id='systemCombo']")).clear();
		webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath(".//*[@id='systemCombo']")).sendKeys("anna");
		webdriver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
		//Call Robot framework for mouse event
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		
				 
		webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
		webdriver.findElement(By.xpath(".//*[@id='No~_36']")).click();
		webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath(".//*[@id='Yes_40']")).click();
		webdriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath(".//*[@id='Yes_43']")).click();
		webdriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		webdriver.findElement(By.xpath(".//*[@id='studyNextBtn']")).click();
		
		//webdriver.switchTo().alert().accept();
		webdriver.findElement(By.xpath("html/body/div[5]/div[3]/div/button[1]")).click();
		Thread.sleep(3000);
  }
  
  @Test(priority=2)
  public void uploadFiles() throws AWTException
  {
	  
	  Select slcal=new Select(webdriver.findElement(By.xpath(".//*[@id='fileCategory_0']")));
	  
	  slcal.selectByValue("CALENDAR_DOWNLOAD");
	  webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	
	  //Upload calander upload
	  
	  webdriver.findElement(By.id("uploadBtn_0")).clear();
	    webdriver.findElement(By.id("uploadBtn_0")).sendKeys("C:\\Users\\averma\\Desktop\\DSUR_Overview\\Calendar download_11Nov16.xlsx"); 

	    webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    new Select(webdriver.findElement(By.id("fileCategory_1"))).selectByVisibleText("ONGOING_GSL_SEC5");
	  
	   // webdriver.findElement(By.id("uploadBtn_1")).click();
	    webdriver.findElement(By.id("uploadBtn_1")).clear();
	    webdriver.findElement(By.id("uploadBtn_1")).sendKeys("C:\\Users\\averma\\Desktop\\DSUR_Overview\\(section 5) ongoing MAH interventional studies in the period.xlsx");
	    webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    new Select(webdriver.findElement(By.id("fileCategory_2"))).selectByVisibleText("COMPETED_GSL_SEC5");
	   // webdriver.findElement(By.id("uploadBtn_2")).click();
	    webdriver.findElement(By.id("uploadBtn_2")).clear();
	    webdriver.findElement(By.id("uploadBtn_2")).sendKeys("C:\\Users\\averma\\Desktop\\DSUR_Overview\\(section 5) completed MAH interventional studies in the period.xlsx");
	    webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    webdriver.findElement(By.id("sourceNext")).click();
	    webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    webdriver.findElement(By.id("progress_first")).click();
	    webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    webdriver.findElement(By.id("progress_first")).click();
	    webdriver.findElement(By.cssSelector("img[alt=\"Download Word File\"]")).click();
	    webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    webdriver.quit();
	  
	  
	  
  }
  
}
