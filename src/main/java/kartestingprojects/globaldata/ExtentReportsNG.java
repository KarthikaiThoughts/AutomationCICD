package kartestingprojects.globaldata;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	
	public static ExtentReports extentMethod() {
		ExtentReports extent; 
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		//Extent Reports, ExtentSparkreporter
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Test Results");
		reporter.config().setDocumentTitle("Test results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Karthikaiselvi Attili");
		return extent;
}
}

