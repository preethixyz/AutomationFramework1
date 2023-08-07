package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationsInfoPage;
import ObjectRepository.OrganizationsPage;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultipleOrgwithIndustry  {

	JavaUtility jutil= new JavaUtility();
	ExcelFileUtility eutil = new ExcelFileUtility();
	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	
@Test(dataProvider ="getdata")

public void CreateMultipleOrg(String ORG,String INDUSTRY) throws Throwable
{
	WebDriver driver = null;
	
	
	
	
	//read data from propertyfile--common data
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String BROWSER = putil.getDatafromPropertyFile("browser");
	String URL = putil.getDatafromPropertyFile("url");
	
	String USERNAME= putil.getDatafromPropertyFile("username");

	String PASSWORD = putil.getDatafromPropertyFile("password");
	
	//read data from Excel Sheet
	
String ORGNAME = ORG+jutil.getrandommethod();

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

wutil.maximizewindow(driver);
wutil.waitforelementstoload(driver);

 
	//Step3: LOad the URL
    
	driver.get(URL);
	//Step4: Login driver application
	
	LoginPage lp = new LoginPage(driver);
	lp.loginToapp(USERNAME, PASSWORD);
	
	//step5: clickdriverganizations link
	HomePage hp = new HomePage(driver);
       hp.clickOrganizationsLnk();
       
       //Step6:click on Organization look up image
     OrganizationsPage op = new OrganizationsPage(driver);
     op.clickonCreateorgLookUpIMG();
     
//step7:createOrganization with Industry dropdown
     CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
      cnop.createOrganization(ORGNAME,INDUSTRY);
      
      //step8: Validate
      OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
	    String OrgHeader = oip.getHeaderText();
	    
	       if(OrgHeader.contains("ORGNAME"))
	       {
	    	   System.out.println("Pass");
	    	   System.out.println(OrgHeader);
	       }
	       else
	       {
	    	   System.out.println("Fail");
	       }
	  
	       //step9: logout of application
	  hp.logoutApp(driver);
	  System.out.println("Logout successful");
}

@DataProvider
public Object[][] getData() throws Throwable
{
	return eutil.readMultipleData("Sheet1");


}



	

	}


