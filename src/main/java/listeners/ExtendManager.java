package listeners;

import org.codehaus.groovy.ast.tools.GeneralUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.GenericUtil;

public class ExtendManager {
	
	
	public static ExtentReports reports;
	public static ExtentReports getInstance() {
		if(reports==null) {
			reports=cretaeInstance();
			return reports;
		}else {
			return reports;
		}
	}
	
	public static ExtentReports cretaeInstance() {
		String path = System.getProperty("user.dir")+"/Reports/APIAutomationReport"+GenericUtil.getCurrentFormattedDate()+"html";
		System.out.println("Reprts can be found in::"+path);
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(path);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("API Automation Test Results");
		sparkReport.config().setDocumentTitle("Automation Report");
		
		reports = new ExtentReports();
		reports.attachReporter(sparkReport);
		
		return reports;
		
	}

}
