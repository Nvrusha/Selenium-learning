package org.example.Ex14_TestNG.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class ExtentReportsManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context) {

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/Reports/myReport.html");

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Project Name", "OrangeHRM Automation");
        extent.setSystemInfo("Tester", "Vrushali N");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome 123.0");
        extent.setSystemInfo("OS", "Windows 11");
    }

}
