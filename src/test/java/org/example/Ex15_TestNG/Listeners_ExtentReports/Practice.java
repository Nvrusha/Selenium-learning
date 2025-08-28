package org.example.Ex15_TestNG.Listeners_ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

// ✅ This is an alternative way to implement a TestNG listener directly in the test class.
// ✅ Instead of declaring the listener in the extentreports.xml file, we can attach it here using the @Listeners annotation.
// ✅ It tells TestNG to use the specified listener class (MyListener) for this test class only.
// ✅ This approach is useful when you want listener behavior limited to specific test classes or for quick debugging.
@Listeners(org.example.Ex15_TestNG.Listeners_ExtentReports.MyListener.class)

public class Practice {

    WebDriver driver; // ✅ WebDriver instance used by listener methods (e.g., for screenshots on failure)

    // ✅ Setup method runs once before the first @Test method in the class
    // Listeners like ITestListener’s onStart() would be triggered before this if used
    @BeforeClass
    void setUp() throws InterruptedException {
        driver = new ChromeDriver(); // ✅ Launch browser (listener can log this setup)

        driver.manage().window().maximize(); // ✅ Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // ✅ Set implicit wait

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // ✅ Navigate to login page
        Thread.sleep(3000); // ✅ (For demo purpose only — listener can log slow page load if needed)
    }

    // ✅ Test case 1: Check logo presence
    // If this test fails, ITestListener’s onTestFailure() can be used to capture screenshot/log details
    @Test(priority = 1)
    void testLogo() {
        boolean logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
        Assert.assertEquals(logo, true, "❌ Logo is not displayed on the login page.");
    }

    // ✅ Test case 2: Validate page title
    // If skipped due to testURL failure, listener’s onTestSkipped() will be triggered
    @Test(priority = 2, dependsOnMethods = {"testURL"})
    void testTitle() {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "❌ Page title does not match.");
    }

    // ✅ Test case 3: Validate login page URL
    // Listener can capture actual vs expected values if test fails
    @Test(priority = 3)
    void testURL() throws InterruptedException {
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/logi", // (Intentional mistake to demonstrate listener on failure)
                "❌ URL mismatch for the login page."
        );
        Thread.sleep(2000); // (Avoid in real test cases — listener can log slow responses)
    }

    // ✅ Runs once after all @Test methods complete
    // Listener’s onFinish() would run after this for final reporting/logging
    @AfterClass
    void tearDown() {
        driver.quit(); // ✅ Close browser; can also be handled in listener’s onFinish() if needed
    }
}
