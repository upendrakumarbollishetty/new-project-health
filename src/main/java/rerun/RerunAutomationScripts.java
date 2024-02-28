package rerun;

import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class RerunAutomationScripts implements ITestNGListener{

	private int retrycount=0;
	private static final int maxcount = 5;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retrycount < maxcount) {
			retrycount++;
		return true;
		}
	return false;
		
	}



}
