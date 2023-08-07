package Vtiger.Practice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PContactsTest {
	@Test
	public void contactsTest() throws Throwable
	{
		
	

	
       WebDriver driver;
       WebDriverManager.firefoxdriver().setup();
       driver=new FirefoxDriver();
       driver.get("http://localhost:8888");
       driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
       driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
       driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
       Thread.sleep(2000);
     
       driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
       Thread.sleep(2000);
       
       driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
          driver.findElement(By.cssSelector("[name=\"lastname\"]")).sendKeys("Rakesh");
          driver.findElement(By.cssSelector("[class=\"crmButton small save\"]")).click();
        driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
          driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();

	}

}


