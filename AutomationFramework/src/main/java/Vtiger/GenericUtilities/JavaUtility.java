package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * This class consists of all generic methods related to java
 * @author DEEPOO KADAPA
 *
 */
public class JavaUtility {

	/**
	 * This method will generate a random number for every execution
	 * @return Random values
	 */
	public int getrandommethod()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	/**
	 * This method will generate System Date
	 */
	
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
		
	}
/**
 * This method will generate System date in Specific Format	
 * return currentSystemdate
 */
	
public String getSystemDateInFormat()
{
	Date d = new Date();
	String[] date = d.toString().split(" ");
	String currentdate = date[2];
	String month = date[1];
	String Year = date[5];
	String time = date[3].replace(":", "-");
	
	String dateInFormat = currentdate+"-"+month+"-"+Year+"-"+time;
	return dateInFormat;
}



}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


