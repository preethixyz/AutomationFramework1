package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {

//declaration
@FindBy(xpath="//span[@class='dvHeaderText']")
private RemoteWebElement orgHeaderText;

//Initialization
public OrganizationsInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}



//Utilization


public WebElement getOrgHeaderText() {
	return orgHeaderText;
}


//Bussiness Libtaty
 public String getHeaderText()
 {
	 return orgHeaderText.getText();
 }











}
