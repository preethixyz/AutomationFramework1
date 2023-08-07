package Vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
@Test(dataProvider="Phones")
public void addToCart(String name, int price,String model)
{
	System.out.println("name is "+name+" Price is "+price+" model is +model ");
}

@DataProvider(name="Phones")

	public Object[][] getData()
	{
		Object[][] data = new Object[3][3];
		
		data[0][0] = "Iphone";
		data[0][1] = 20000;
		data[0][2] = "S13";
		
		

		data[1][0] = "Samsung";
		data[1][1] = 15000;
		data[1][2] = "S14";
		

		data[2][0] = "Vivo";
		data[2][1] = 18000;
		data[2][2] = "Y13";
		
		return data;
		
		
		
	}
}

























