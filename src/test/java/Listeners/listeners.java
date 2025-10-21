package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ShoppingSite.globaltests.driver_launch;
import reporting.Reports;

public class listeners extends driver_launch implements ITestListener {
	ExtentTest test;
	ThreadLocal<ExtentTest> extension=new ThreadLocal<ExtentTest>();

	ExtentReports extent=Reports.reporter();
	
	@Override
	public void onTestStart(ITestResult result){
		
		
		test= extent.createTest(result.getClass().getName()+":"+result.getMethod().getMethodName());
		extension.set(test);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extension.get().log(Status.PASS,"testcase has passed");}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 extension.get().fail(result.getThrowable());
		
		
		
			String fpath;
			
			try {WebDriver driver = null;
			     try {
					driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				fpath = driver_launch.screenshot(result.getMethod().getMethodName(),driver);
				extension.get().addScreenCaptureFromPath(fpath,result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
