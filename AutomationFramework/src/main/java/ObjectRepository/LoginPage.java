package ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule1: Create a seperate Pom class foe every WebPage
public class LoginPage {

//Rule2: identify the elements using @FindBy,@FindBys,@FindAll
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	
     @FindBy(id="submitButton")
     private WebElement loginBtn;

//Rule3: Create a constructor to initialize the WebElements
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }

    //Rule4: Provide getters to access WebElements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}


//Bussiness Library
	
	public void loginToapp(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}








}
