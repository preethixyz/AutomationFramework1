package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of all generic methods related to excel file
 * @author DEEPOO KADAPA
 *
 */
public class ExcelFileUtility {
	/**
	 * this method will read data from Excel sheet based on sheet name, row no, cell no given by caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String getdatafromexcelfile(String sheetName,int rowNo,int cellNo  ) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		wb.close();
		return value;
		
		}
	
	/**
	 * This method will write data in to Excel sheet
	 */
	public void writedataintoexcelsheet(String sheetName,int rowNo,int cellNo  ) throws Throwable
	{
		
	
	FileInputStream fis = new FileInputStream(IConstants.excelfilepath);
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	
	FileOutputStream fos = new FileOutputStream(IConstants.excelfilepath);
	wb.write(fos);wb.close();
	
	
	}
	
	/**
	 * This Method will read al the data inside a sheet to use in data Provider
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] readMultipleData(String sheetname) throws Throwable
	{
		
	 FileInputStream fis = new FileInputStream(IConstants.excelfilepath);
	 Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(sheetname);
	 int lastRow = sh.getLastRowNum();
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[lastRow][lastCell];
	
	for(int i=0;i<lastRow ;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;
	
	}
	
	
	
	
	
	
	
	
	

}
