package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int i=0;
	int retry=1;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		if(i<retry)
		{
			i++;
			return true;
		
		
		}
		
		return false;
	}

	

}
