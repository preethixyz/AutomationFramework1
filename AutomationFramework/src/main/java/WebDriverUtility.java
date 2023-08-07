import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of all reusable methods related to WebDriver actions
 * @author DEEPOO KADAPA
 *
 */
public class WebDriverUtility {
/**
 * This method will maximize the window
 * 
 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 *  This method will minimize the window
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();
}

/**
 * This method will wait for all find element and find elements to be performed
 * @param driver
 */
public void waitForElementsToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

/**
 * This method will until the specified element is visible
 * @param driver
 * @param element
 */
public void waitForElementsToBeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**This method will handle dropdown using index*/

public void handleDropDown(WebElement element, int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}

/**
 * This method will handle dropdown using index
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element,String value)
{
	Select sel = new Select(element);
	sel.selectByValue(value);
	
}

/**
 * This method will handle dropdown using visibleText
 */
public void handleDropDown(String text,WebElement element)
{
Select sel = new Select(element);
sel.selectByVisibleText(text);
}

/**
 * This method will perform mouse hover action on target element
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
		}

/**
 * This method will perform double click anywhere on WebPage
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver, WebElement element)
{
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}

/**This method will perform right click anyehere on WebPage*/
public void rightClickaction(WebDriver driver)
{ 
	Actions act = new Actions(driver);
	act.contextClick().perform();
}


/**
 * This method will perform right click on particular WebElement
 * @param driver
 * @param element
 */
public void rightClickaction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.contextClick(element);
}

/**
 * This method will Perform drag and drop method
 * @param driver
 * @param srcelement
 * @param targetelement
 */
public void draganddrop(WebDriver driver, WebElement srcelement,WebElement targetelement)
{
	Actions act = new Actions(driver);
	act.dragAndDrop(srcelement, targetelement).perform();
}













}

