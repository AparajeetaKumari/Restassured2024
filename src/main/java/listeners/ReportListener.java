package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReportListener implements ITestListener{
 
	ExtentReports extent = ExtendManager.getInstance();
	ExtentTest extentTest;

	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println("***** Generating Reports*********");
		extent.flush();
	}
	
	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println("Creating Tests for report");
	 extentTest = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		
		extentTest.pass("Test Passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		extentTest.fail("Test Failed:: "+result.getThrowable());
	}
	
	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		extentTest.skip("Test Skipped ::"+result.getThrowable());
	}
}
