package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	//declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industrtyDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
		
	}

	
//utilization
	

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustrtyDropdown() {
		return industrtyDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Bussiness Library
	/**
	 * This method will Create Organization with mandatory feilds
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
	}
	
	public void createOrganization(String ORGNAME,String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
	handledropdown(industrtyDropdown, INDUSTRY);
	saveBtn.click();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
