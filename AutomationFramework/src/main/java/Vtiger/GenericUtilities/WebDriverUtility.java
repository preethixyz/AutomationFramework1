package Vtiger.GenericUtilities;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all reusable methods related to webriver actions
 * @author DEEPOO KADAPA
 *
 */
public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * 2param driver
	 */
public void maximizewindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 * This method will minimize the window
 * 2param driver
 */

public void minimizewindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * This method will wait for all findelement and find elements operations to be performed
 * @param driver
 */
public void waitforelementstoload(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

/**
 * This method will wait for until specified element is visible or not
 * @param driver
 * @param element
 */
public void waitforelementtobevisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
	
	
}
/**
 * This method will handle dropdown using index
 * @param element
 * @param index
 */
public void handledropdown(WebElement element, int index)
{
	Select sel = new Select( element);
	sel.selectByIndex(index);
}


/**
 * This method will handle dropdown using value
 * @param element
 * @param element
 * @param value
 */

public void handledropdown(WebElement element, String value)
{
	Select sel = new Select( element);
	sel.selectByValue(value);
}

/**
 * This method will handle dropdown using visibletext
 * @param element
 * @param text
 * @param element
 */
public void handledropdown(String text,WebElement element)
{
	Select sel = new Select( element);
	sel.selectByVisibleText(text);
}

//example for compile time polymorphism bcz same method with different implementation  method overloading
/**
 * This method will perform mouseHover action on a target element
 * @param driver
 * @param element
 */

public void mouseHoverActions(WebDriver driver, WebElement element)
{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}

/**
 * This method  will double click anywhere on the web page
 * @param driver
 */
public void doubleclickAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.doubleClick().perform();
}

/**
 * This method will double click on target element
 * @param driver
 * @param element
 */
public void doubleclickAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}

/**
 * This method will perform right click anywhere on web page
 */
public void rightclickAction(WebDriver driver)
{
      Actions act = new Actions(driver);
      act.contextClick().perform();
}


/**
 * This method will perform right click on particular web element
 * @param driver
 * @param element
 */
public void rightclickAction(WebDriver driver,WebElement element)
{
      Actions act = new Actions(driver);
      act.contextClick(element).perform();
}
/**
 * This method will perform drag and drop method
 * @param driver
 * @param srcelement
 * @param targrtelement
 */
public void draganddrop(WebDriver driver,WebElement srcelement, WebElement targrtelement)
{
	       Actions act = new Actions(driver);
	       act.dragAndDrop(srcelement, targrtelement).perform();
}

/**
 * This method will perform click and hold actions
 * @param driver
 * @param element
 */
public void clickandHold(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.clickAndHold(element).perform();
}
/**
 * this method is used to release the element based on clickandhold
 * @param driver
 * @param element
 */
public void release(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.release(element).perform();
}
/**
 * this method is used to move the cursor anywhere on the webpage on offset values
 * @param driver
 * @param xoffset
 * @param yoffset
 */
public void moveAcrossWebpage(WebDriver driver,int xoffset,int yoffset)
{
	Actions act = new Actions(driver);
	act.moveByOffset(xoffset, yoffset).perform();
}
/**
 * This method will scroll vertically for 500 pixels
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("Window.scrollBY(0,500)", "");
}
/**
 * This method will scroll vertically until the element reference
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView()",element );
}
/**
 * This method will accept the confirmation popup
 * @param driver
 */
public void acceptalert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 *  This method will cancel the confirmation popup
 * @param driver
 * @param driver
 */

public void cancelalert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method will capture the alert message and return to the caller
 * @param driver
 * @return
 */
public String  getAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}


/**
 * This method will handle frame based on frame index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will handle the frame based on name or ID attributes
 * @param driver
 * @param nameorID
 */
public void handleFrame(WebDriver driver,String nameorID)
{
	driver.switchTo().frame(nameorID);
}
/**
 * This method will handle the frame based on  web element
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * This method will help to switch the control back to immediate Parent
 * @param driver
 */
public void switchtoParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();

}
/**
 * This method will help to switch the control back to current page
 * @param driver
 */
public void switchToDefaultpage(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * This method will switch the selenium control from parent to child or from child to parent based on partial window title
 * @param driver
 * @param partialwinTitle
 */
public void switchTowindow(WebDriver driver,String partialwinTitle)
{
	//step1: capture all the window IDs
	Set<String> allWindowIDs = driver.getWindowHandles();
	
	//step2: iterate through individual IDs
	for(String winID : allWindowIDs)
	{
		//step3: switch to each ID and capture the title
		String currenttitle = driver.switchTo().window(winID).getTitle();
		
		//step4: compare the title with required reference
		if(currenttitle.contains(partialwinTitle))
		{
			break;
		}
		
	}
}

public String takeScreenShot(WebDriver driver, String Screenshotname) throws Throwable
{
	TakesScreenshot ts= (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(".\\Screenshots"+Screenshotname+".png");
	Files.copy(src, dst);//this class is from commons IO tool
	
	return dst.getAbsolutePath();//attach the screeenshots to extent reports
	
}



























}
