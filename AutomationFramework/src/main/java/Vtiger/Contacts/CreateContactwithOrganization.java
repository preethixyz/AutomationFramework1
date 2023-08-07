package Vtiger.Contacts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrganization  {

	public static void main(String[] args) throws Throwable {
		
	 
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
		
String ORGNAME = eutil.getdatafromexcelfile("Contacts", 4, 3) + jutil.getrandommethod();
String LASTNAME = eutil.getdatafromexcelfile("Contacts", 4, 2);
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

driver.get(URL);

 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(USERNAME);
   driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(PASSWORD);
   driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
   Thread.sleep(2000);
   
   driver.findElement(By.linkText("Organizations")).click();
   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
  
   driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
    
      
      
       driver.findElement(By.cssSelector("[class=\"crmbutton small save\"]")).click();
       String orgHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
       if(orgHeader.contains(ORGNAME))
       {
    	   System.out.println("Pass");
    	   System.out.println("OrgHeader:Wipro");
       }
       else
       {
    	   System.out.println("Fail");
       }
       
//Create Contact using organization
      // click on contacts link
       
	driver.findElement(By.linkText("Contacts")).click();
	
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
	
	wutil.switchTowindow(driver, "Accounts");
	
	driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
	
	driver.findElement(By.name("search")).click();
	
	driver.findElement(By.xpath("//a[text()='" + ORGNAME +"']")).click();
	
	wutil.switchTowindow(driver, "Contacts");
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(ContactHeader.contains(LASTNAME))
	{
		System.out.println("pass");
		
	}
	else
	{
		System.out.println("fail");
	}
	
	   WebElement admimg = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
       
       Actions act = new Actions(driver);
       act.moveToElement(admimg).perform();
       driver.findElement(By.linkText("Sign Out")).click();
       System.out.println("Logout Succesful");

       
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}




