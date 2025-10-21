package reporting;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	
		
		public static ExtentReports reporter()
		{
		// TODO Auto-generated method stub
 String path=System.getProperty("user.dir")+"//reports//index.html";
 
 ExtentSparkReporter reporter1=new ExtentSparkReporter(path);
 reporter1.config().setReportName("OrderStack Exeuction Report");
 
 ExtentReports extent=new ExtentReports();
extent.attachReporter(reporter1);
extent.setSystemInfo("Reporter", "Basil Joseph");
 return extent;
		}
	

}
