package Vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public JavaUtility jutil = new JavaUtility();
	public  ExcelFileUtility eutil = new ExcelFileUtility();
	 public PropertyFileUtility putil= new PropertyFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	
	public WebDriver driver= null;
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig() throws Throwable
	{
		System.out.println("====db Successful ======");
	}
	
 	@BeforeClass(alwaysRun=true)
 	
 		public void bcConfig() throws Throwable {
 		//Read Browser and Url from Property File
 		 String BROWSER = putil.getDatafromPropertyFile("browser");
 		 
 		String URL = putil.getDatafromPropertyFile("url");
 		
 		if(BROWSER.equalsIgnoreCase("chrome"))
 		{
 			WebDriverManager.chromedriver().setup();
 			driver=new ChromeDriver();
 			System.out.println("---Browser Launched----");
 		}
 	
 		else if(BROWSER.equalsIgnoreCase("Firefox"))
 		{
 			WebDriverManager.firefoxdriver().setup();
 			driver=new FirefoxDriver();
 			System.out.println("---Browser Launched----");
 		}
 	wutil.maximizewindow(driver);
 	wutil.waitforelementstoload(driver);
 	
 		
 	//Load the URL
 		driver.get(URL);
 	}
 	
 @BeforeMethod(alwaysRun=true)
  public void bmconfig() throws Throwable 
  {
	 //read username and password from Propertyfile
	  String USERNAME = putil.getDatafromPropertyFile("username");
	 String PASSWORD = putil.getDatafromPropertyFile("password");
	 
	LoginPage lp = new LoginPage(driver);
	lp.loginToapp(USERNAME, PASSWORD);
	System.out.println("----Login Successful");
	 
  }
 
    @AfterMethod(alwaysRun=true)
 	public void amConfig() throws Throwable 
 	{
 		HomePage hp = new HomePage(driver);
 		hp.logoutApp(driver);
 		System.out.println("----Logout successful---");
 	}
 	
 	
  @AfterClass(alwaysRun=true)
  public void acConfig() throws Throwable 
  {
	  driver.quit();
	  System.out.println("--------Browser Closed----");
  }
 	
 	@AfterSuite(alwaysRun=true)
 	
 		public void asConfig() throws Throwable 
 		{
 			System.out.println("----db connection closed-----");
 		}
 	
 	
 	
 	
 	
 	
 	
 	}


	










