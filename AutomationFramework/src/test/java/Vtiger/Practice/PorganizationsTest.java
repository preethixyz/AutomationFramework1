package Vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PorganizationsTest {

	 @Test
	 public void organizationsTest() throws Throwable
	 {
		 
		 WebDriver driver;
	       WebDriverManager.firefoxdriver().setup();
	       driver=new FirefoxDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       
	       
	       driver.get("http://localhost:8888");
	       driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
	       driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
	       driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
	       Thread.sleep(2000);
	     
	       driver.findElement(By.linkText("Organizations")).click();
	       driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	      
	      Random r = new Random();
	    int random = r.nextInt(1000);
	    String orgname = "PennaCement"+random;
	      
	       driver.findElement(By.name("accountname")).sendKeys(orgname);
	      WebElement industryDrop = driver.findElement(By.name("industry"));
	      Select sel = new Select(industryDrop);
	       sel.selectByValue("Chemicals");
	       
	       driver.findElement(By.cssSelector("[class=\"crmbutton small save\"]")).click();
	       String orgHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	       if(orgHeader.contains("orgname"))
	       {
	    	   System.out.println("Pass");
	    	   System.out.println("OrgHeader:PennaCement");
	       }
	       else
	       {
	    	   System.out.println("Fail");
	       }
	       
	     WebElement admimg = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	       
	       Actions act = new Actions(driver);
	       act.moveToElement(admimg).perform();
	       driver.findElement(By.linkText("Sign Out")).click();
	       System.out.println("Logout Succesful");
	       
	       
	       

	}

}
