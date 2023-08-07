package Vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;

public class BParallelCreateOrganizationwithIndustryDropDown extends BaseClass{
	
		
		@Test
		public void createOrgwithIndustryUsingDDTTest() throws Throwable
		{
			
			//read data from Excel Sheet
			
	String ORGNAME = eutil.getdatafromexcelfile("Organizations", 3, 2) + jutil.getrandommethod();
	String INDUSTRY = eutil.getdatafromexcelfile("Organizations", 3, 3);
			//launch the browser
	
		       
		       By driver;
			driver.findElement(By.linkText("Organizations")).click();
		       driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		      
		       driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			      WebElement industryDrop = driver.findElement(By.name("industry"));
			      wutil.handledropdown(industryDrop, INDUSTRY);
			      
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
		
	

@Test
public void sample()
{
	System.out.println("Sample");
}
	}




}
