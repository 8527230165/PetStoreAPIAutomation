package api.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		
	}
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
		test.log(Status.PASS,"Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
		test.log(Status.FAIL,"Test Failed");
		test.log(Status.FAIL,result.getThrowable().getMessage());
		
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
		test.log(Status.SKIP,"Test Skipped");
		test.log(Status.SKIP,result.getThrowable().getMessage());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter(".\\reports\\Test-Report.html");
		spark.config().setDocumentTitle("RestAssuredAutomation");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Pet Users Store API");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Application", "Pet Users Store API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
	}
	public void onFinish(ITestContext context) {
		extent.flush();
		
		try {
			String reportPath=System.getProperty("user.dir")+"\\reports\\Test-Report.html";
			Desktop.getDesktop().browse(new File(reportPath).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
