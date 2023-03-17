package com.inetbanking.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.interbanking.testCases.BaseClass;


public class Reporting extends BaseClass implements ITestListener{

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public static String screenshotsSubFolderName = "TestFailedScreenShots";
	public static WebDriver driver;

	@BeforeSuite
	public void onStart  (ITestContext testcontext) {
		String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-report-" +timeStamp+  ".html";
		htmlReporter=new ExtentSparkReporter("R:\\JAVA\\Workspace\\InerBanking2\\ExtentReports\\" +repName+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Sesha Sai Sagar");

		htmlReporter.config().setDocumentTitle("InetBanking Test Project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);	 
	}
	@AfterMethod
	public void onTestSuccess(ITestResult tr) {
		logger =extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	
	@AfterMethod
	public void onTestFailure(ITestResult tr) {
		logger =extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
			String screenshotPath = captureScreenshots(tr.getTestContext().getName()+ "_" +tr.getMethod().getMethodName()+".jpg");
			String s = screenshotPath;
			System.out.println(s);
			logger.addScreenCaptureFromPath(s);
		


	}
	@AfterMethod
	public void onTestSkipped(ITestResult tr) {

		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}

	@AfterSuite
	public void onFinish(ITestContext testcontext) {
		extent.flush();
	}

}


