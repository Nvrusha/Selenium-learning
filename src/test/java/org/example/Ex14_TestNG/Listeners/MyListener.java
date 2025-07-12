package org.example.Ex14_TestNG.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    public void onStart(ITestContext context) {
        System.out.println("All test have started...");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test started...");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed...");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed...");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped...");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }


    public void onFinish(ITestContext context) {
    }

}
