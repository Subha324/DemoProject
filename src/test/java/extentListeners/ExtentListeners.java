package extentListeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utilities.ScreenShotUtil;

public class ExtentListeners implements ITestListener {

	
	
	
	
	
	static Date d= new Date();
	static String fileName="Extent_" +d.toString().replace(":", "_").replace(" ","_") +".html";
	private static ExtentReports extent = ExtentManager.creatInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	public static ExtentTest test; 
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
	      
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		String text="<b> Test Case: -" +methodName.toUpperCase()+"SKIPPED</b>";
		Markup m = MarkupHelper.createLabel(text,ExtentColor.GREEN);
		
		//Markup m = MarkupHelper.createLabel("TestCase Failed",ExtentColor.GREEN);
		test.log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		ScreenShotUtil.captureScreenshot();
		
	//ReportNG
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("<a href="+ScreenShotUtil.fileName+" target=\"_blank\"> screenshot </a>");
		Reporter.log("<br> ");
		Reporter.log("<a href="+ScreenShotUtil.fileName+" target=\"_blank\"> <img src="+ScreenShotUtil.fileName+" height=200 width=200> </a>");
		
		
		
		
		
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());//2
		test.fail(exceptionMessage);
		
		String methodName=result.getMethod().getMethodName();
		String text="<b> Test Case: -" +methodName.toUpperCase()+"FAILED</b>";
		Markup m = MarkupHelper.createLabel(text,ExtentColor.RED);
		
		//Markup m = MarkupHelper.createLabel("TestCase Failed",ExtentColor.RED);
		test.log(Status.FAIL,  m);
		String screenshot=ScreenShotUtil.fileName;
		try {
			test.fail("<b><font color=red>screenshot of failure</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String text="<b> Test Case: -" +methodName.toUpperCase()+"SKIPPED</b>";
		Markup m = MarkupHelper.createLabel(text,ExtentColor.YELLOW);
		
		//Markup m = MarkupHelper.createLabel("TestCase Failed",ExtentColor.YELLOW);
		test.log(Status.SKIP, m);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
		
	}
	

}
