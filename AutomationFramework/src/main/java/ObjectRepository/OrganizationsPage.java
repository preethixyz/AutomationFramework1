package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private RemoteWebElement createOrgLookUpImg;

//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Utilization

	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

//Bussiness Library
	
	public void clickonCreateorgLookUpIMG()
	{
		createOrgLookUpImg.click();
	}







}
