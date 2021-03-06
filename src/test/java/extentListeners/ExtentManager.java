package extentListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
  private static ExtentReports extent;
  
  public static ExtentReports creatInstance(String fileName) {
	  ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	 
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("My Automation Report" );
		htmlReporter.config().setReportName("Automation Test Result");
		htmlReporter.config().setTheme(Theme.STANDARD);
		 extent= new ExtentReports();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Automation Tester","Subha");
		 extent.setSystemInfo("Organization","Applause");
		 extent.setSystemInfo("BuildNumber","Test123");
		 extent.setSystemInfo("Automation Tester","Subha");
		 return extent;
	
  }




}
