package Vtiger.GenericUtilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementationClass implements ITestListener {

public void onTestStart(ITestResult result)
{
	String methodName= result.getMethod().getMethodName();
	System.out.println("---Execution Started------"+methodName);
}


public void onTestSuccess(ITestResult result)
{
	String methodName= result.getMethod().getMethodName();
	System.out.println("---PASS------"+methodName);
}


public void onTestFailure(ITestResult result)
{
	String methodName= result.getMethod().getMethodName();
	System.out.println("---FAIL------"+methodName);
	System.out.println(result.getThrowable());
}

public void onTestSkipped(ITestResult result)
{
	String methodName= result.getMethod().getMethodName();
	System.out.println("---SKIP------"+methodName);
	System.out.println(result.getThrowable());
}

public void onTestFailedwithSuccessPercentage(ITestResult result)
{
	
}

public void onStart(ITestResult result)
{
	//start of <suite>--@Before Suite
	System.out.println("-------suite execution started----");
}

public void onFinish(ITestResult result)
{

	//end of </suite>--@Before Suite
	System.out.println("-------suite execution ended----");	
}






}
