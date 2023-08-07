package Vtiger.Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationsPage;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionCreateOrgwithIndustry {

	@Test
	public void assertionmethod()
	{
	
			JavaUtility jutil= new JavaUtility();
			ExcelFileUtility eutil = new ExcelFileUtility();
			PropertyFileUtility putil = new PropertyFileUtility();
			WebDriverUtility wutil = new WebDriverUtility();
			
			WebDriver driver=null;
			
			
			
			
			//read data from propertyfile--common data
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
			Properties pro = new Properties();
			pro.load(fis);
			
			String BROWSER = putil.getDatafromPropertyFile("browser");
			String URL = putil.getDatafromPropertyFile("url");
			
			String USERNAME= putil.getDatafromPropertyFile("username");
		
			String PASSWORD = putil.getDatafromPropertyFile("password");
			
			//read data from Excel Sheet
			
	String ORGNAME = eutil.getdatafromexcelfile("Organizations", 3, 2) + jutil.getrandommethod();
	String INDUSTRY = eutil.getdatafromexcelfile("Organizations", 3, 3);
			//launch the browser
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println(BROWSER+"------Browser launched");
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println(BROWSER+"------Browser launched");
	}
	else {
		System.out.println("Invalid Browser name");
		}
		
	    
	     
	     driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        //Step3:Load the URl
			driver.get(URL);
			
	//Step4:Login to the application
//			 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(USERNAME);
//		       driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(PASSWORD);
//		       driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
//		       Thread.sleep(2000);
			
			LoginPage lp= new LoginPage(driver);
			lp.loginToapp(USERNAME, PASSWORD);
			
	// Step5: click on Organizations link
		       //driver.findElement(By.linkText("Organizations")).click();
			      HomePage hp = new HomePage(driver);
			      hp.clickOrganizationsLnk();
		       
	//Step6:click on Organizations look up image
		        //driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		     OrganizationsPage op = new OrganizationsPage(driver);
			      op.clickonCreateorgLookUpIMG();
			      
		       
			      
	//Step7: Create Organization
//		       driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
//			      WebElement industryDrop = driver.findElement(By.name("industry"));
//			      wutil.handledropdown(industryDrop, INDUSTRY);
			     
			     CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			      cnop.createOrganization(ORGNAME, INDUSTRY);
			      
	//step8:save
			       driver.findElement(By.cssSelector("[class=\"crmbutton small save\"]")).click();
			       
	 //Step9:validate
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
			      
	//step 10: Logout of Application
//			     WebElement admimg = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//			       
//			       Actions act = new Actions(driver);
//			       act.moveToElement(admimg).perform();
//			       driver.findElement(By.linkText("Sign Out")).click();
//			       System.out.println("Logout Succesful");

			      hp.logoutApp(driver);
			      System.out.println("logout Successful");
			       
		}
		



	}




	}

}
