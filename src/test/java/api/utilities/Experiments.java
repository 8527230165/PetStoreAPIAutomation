/*
 * package api.utilities;
 * 
 * import java.awt.Desktop; import java.io.File; import java.io.IOException;
 * import java.lang.reflect.Method;
 * 
 * import org.testng.ITestContext; import org.testng.ITestListener; import
 * org.testng.ITestResult; import org.testng.annotations.Test;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.reporter.ExtentSparkReporter; import
 * com.aventstack.extentreports.reporter.configuration.Theme;
 * 
 * public class Experiments implements ITestListener {
 * 
 * 
 * public static void main(String[] args) {
 * 
 * System.out.println(System.getProperty("user.dir")+
 * "\\reports\\Test-Report.html");
 * 
 * ExcelReader excel=new
 * ExcelReader(System.getProperty("user.dir")+"\\testData\\Users.xlsx");
 * System.out.println(excel.getSheetName(0)); int rows =
 * excel.getRowCount(excel.getSheetName(0)); int cols =
 * excel.getColumnCount(excel.getSheetName(0));
 * System.out.println(rows+" , "+cols);
 * 
 * 
 * 
 * for(int i=0;i<10;i++) {
 * System.out.println(Math.round((Math.random())*10000)); }
 * 
 * }
 * 
 * public ExtentSparkReporter sparkReporter; public ExtentReports extent; public
 * ExtentTest test;
 * 
 * public void onTestStart(ITestResult result) {
 * 
 * ExtentSparkReporter spark = new
 * ExtentSparkReporter(".\\reports\\Test-Report.html");
 * spark.config().setDocumentTitle("RestAssuredAutomation");
 * spark.config().setTheme(Theme.STANDARD);
 * spark.config().setReportName("Pet Users Store API"); extent = new
 * ExtentReports(); extent.attachReporter(spark);
 * extent.setSystemInfo("Application", "Pet Users Store API");
 * extent.setSystemInfo("Operating System", System.getProperty("os.name"));
 * extent.setSystemInfo("User Name", System.getProperty("user.name"));
 * //test=extent.createTest(result.getMethod().getConstructorOrMethod().
 * getMethod().getAnnotation(Test.class).testName());
 * System.out.println(result.getName()+" started");
 * 
 * }
 * 
 * public void onTestSuccess(ITestResult result) {
 * test=extent.createTest(result.getName());
 * 
 * 
 * Method method = result.getMethod().getConstructorOrMethod().getMethod(); Test
 * test = method.getAnnotation(Test.class); String testname = test.testName();
 * 
 * test.assignCategory(result.getMethod().getGroups());
 * test.createNode(result.getName());
 * 
 * System.out.println(result.getName() + " started");
 * 
 * }
 * 
 * public void onTestFailure(ITestResult result) {
 * test=extent.createTest(result.getName());
 * 
 * 
 * Method method = result.getMethod().getConstructorOrMethod().getMethod(); Test
 * test = method.getAnnotation(Test.class); String testname = test.testName();
 * 
 * test.assignCategory(result.getMethod().getGroups());
 * test.createNode(result.getName()); System.out.println(result.getName() +
 * " failed");
 * 
 * }
 * 
 * public void onFinish(ITestContext context) { //extent.flush();
 * 
 * try { String reportPath = System.getProperty("user.dir") +
 * "\\reports\\Test-Report.html"; Desktop.getDesktop().browse(new
 * File(reportPath).toURI()); } catch (IOException e) { e.printStackTrace(); }
 * 
 * }
 * 
 * }
 */