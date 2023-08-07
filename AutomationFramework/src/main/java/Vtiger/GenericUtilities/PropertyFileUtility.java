package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This method will read the data from property file based on given key
 * @param key
 * @return value
 * @throws Throwable 
 * 
 */
public class PropertyFileUtility {
	
	public String getDatafromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	        Properties pro = new Properties();
	        pro.load(fis);
	       String value = pro.getProperty(key);
	       return value;


}
}

