package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyfilePractice {

	public static void main(String[] args) throws Throwable {
		// step1:Load the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//step2:create object of Properties class from java.util
		Properties pro = new Properties();
		
		//step3: Load the file in to Properties file
		pro.load(fis);
		
		//step4:Provide the Key and the vvalue
		String value = pro.getProperty("username");
		System.out.println(value);

	}

}
