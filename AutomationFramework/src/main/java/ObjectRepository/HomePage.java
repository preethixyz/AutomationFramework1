package ObjectRepository;

import java.security.PrivateKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

//declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement oppurtunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
//Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOppurtunitiesLnk() {
		return oppurtunitiesLnk;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

public WebElement getAdministratorImg() {

		return administratorImg;
	}

	

	//Business library
	/**
	 * This method will click on Organizations link
	 */
	public void clickOrganizationsLnk()
	{
		organizationsLnk.click();	
	}

/**
 * This method will click on contacts link	
 */
	
public void clickContactsLnk()
{
	contactsLnk.click();
}
/**
 * This method will click on oppurtunities link
 */
public void clickoppurtunitiesLnk()
{
	oppurtunitiesLnk.click();
}

/** This method will logout of Application
*/
public void logoutApp(WebDriver driver)
{
	mouseHoverActions(driver, administratorImg);
	Thread.sleep(1000);
	signoutLnk.click();
	
}


	
}











}
