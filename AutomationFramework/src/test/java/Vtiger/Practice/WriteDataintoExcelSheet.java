package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataintoExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis);
		Sheet sh1 = wb1.createSheet("Practice");
		Row rw1 = sh1.createRow(4);
		Cell cl1 = rw1.createCell(5);
		cl1.setCellValue("Spider Man");
		
//		Row rw2 = sh1.createRow(8);
//		Cell cl2 = rw2.createCell(7);
//		cl2.setCellValue("Keyboard");
		
		FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		wb1.write(fos);
		System.out.println("data added");
		
		wb1.close();
		
		

	}

}
