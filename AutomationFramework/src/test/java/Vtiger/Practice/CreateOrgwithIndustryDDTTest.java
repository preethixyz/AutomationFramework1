package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgwithIndustryDDTTest {

	@Test
	public void CreateOrgwithIndustryDDTTest() throws Throwable{
		
		WebDriver driver=null;
		
		Random r = new Random();
		int random = r.nextInt(100);
		
		//read data from propertyfile--common data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		
		String USERNAME= pro.getProperty("username");
	
		String PASSWORD = pro.getProperty("password");
		
		//read data from Excel Sheet
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organizations");
String ORGNAME = sh.getRow(5).getCell(2).getStringCellValue();
String INDUSTRY = sh.getRow(5).getCell(3).getStringCellValue();

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
		      WebElement industryDrop = driver.findElement(By.name("industry"));
		      Select sel = new Select(industryDrop);
		       sel.selectByValue(INDUSTRY);
		       
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







		       
		       
		       

		       




	













	
	
	
	
	
	
	
	
	
	
	
	
	
	


