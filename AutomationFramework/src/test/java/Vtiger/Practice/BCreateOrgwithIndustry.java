package Vtiger.Practice;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationsInfoPage;
import ObjectRepository.OrganizationsPage;
import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BCreateOrgwithIndustry  extends BaseClass{
	@Test(groups="SmokeExecution")
	public void creareorgwithindustry() throws Throwable {
		
		
		//read data from Excel Sheet
		

		JavaUtility jutil = new JavaUtility();
		  ExcelFileUtility eutil = new ExcelFileUtility();
		  PropertyFileUtility putil= new PropertyFileUtility();
		 WebDriverUtility wutil = new WebDriverUtility();
		
		
		
		
String ORGNAME = eutil.getdatafromexcelfile("Organizations", 3, 2) + jutil.getrandommethod();
String INDUSTRY = eutil.getdatafromexcelfile("Organizations", 3, 3);


		//launch the browser

		
//Step4:Login to the application
//		 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(USERNAME);
//	       driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(PASSWORD);
//	       driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
//	       Thread.sleep(2000);
		
	
// Step5: click on Organizations link
	      // driver.findElement(By.linkText("Organizations")).click();
		      HomePage hp = new HomePage(driver);
		      hp.clickOrganizationsLnk();
	       
//Step6:click on Organizations look up image
	        //driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	     OrganizationsPage op = new OrganizationsPage(driver);
		      op.clickonCreateorgLookUpIMG();
		      
	       
		      
//Step7: Create Organization
	       driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		      WebElement industryDrop = driver.findElement(By.name("industry"));
		      wutil.handledropdown(industryDrop, INDUSTRY);
		     
		     CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		      cnop.createOrganization(ORGNAME, INDUSTRY);
		      
//step8:save
		       driver.findElement(By.cssSelector("[class=\"crmbutton small save\"]")).click();
		       
 //Step9:validate
		    OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		     String orgHeader = oip.getHeaderText();
		     Assert.assertTrue(orgHeader.contains(ORGNAME));
		     
		     
//step 10: Logout of Application
		    
	}
	
	@Test(groups="SmokeExecution")
	public void demo() {
		System.out.println("demo");
	}
}
	









