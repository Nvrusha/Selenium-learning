package org.example.Ex15_TestNG.Listeners_ExtentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    // 🔄 Called before any test starts
    public void onStart(ITestContext context) {
        System.out.println("🔵 Test Suite Started: " + context.getName());
    }

    // 🧪 Called when an individual test method starts
    public void onTestStart(ITestResult result) {
        System.out.println("🟡 Test Started: " + result.getMethod().getMethodName());
    }

    // ✅ Called when a test method passes
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getMethod().getMethodName());
    }

    // ❌ Called when a test method fails
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getMethod().getMethodName());
    }

    // ⚠️ Called when a test is skipped
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test Skipped: " + result.getMethod().getMethodName());
    }

    // ⏱️ Called when a test fails due to timeout
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("⏱️ Test Failed due to Timeout: " + result.getMethod().getMethodName());
        this.onTestFailure(result);
    }

    // (Optional) Called if a test fails but is still within the success percentage
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("⚠️ Test Partially Failed (within success %): " + result.getMethod().getMethodName());
    }

    // 🔚 Called after all tests have run
    public void onFinish(ITestContext context) {
        System.out.println("🔴 Test Suite Finished: " + context.getName());
    }
}
