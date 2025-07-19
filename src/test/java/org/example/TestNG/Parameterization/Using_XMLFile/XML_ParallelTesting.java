package org.example.TestNG.Parameterization.Using_XMLFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class XML_ParallelTesting {

    WebDriver driver; // ✅ WebDriver instance (non-static) to avoid conflicts during parallel execution

    // ✅ This method runs once before any @Test method in the class.
    // ✅ @Parameters is used to receive the browser name from XML for cross-browser parallel execution
    @BeforeClass
    @Parameters({"browser"})
    void setUp(String br) {

        // ✅ Launching the browser based on the value passed from the XML file
        // ✅ Each thread will run with its own instance of WebDriver for isolation
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("❌ Invalid browser passed from XML.");
                return;
        }

        // ✅ Ensuring all windows start maximized
        driver.manage().window().maximize();

        // ✅ Implicit wait to handle dynamic loading elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ✅ Navigating to the login page of OrangeHRM demo site
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // ✅ Test 1: Verifies logo presence on the login screen
    // 🔁 Will run in parallel across different browsers if defined in XML suite
    @Test(priority = 1)
    void testLogo() {
        boolean logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
        Assert.assertEquals(logo, true, "❌ Logo is not displayed on the login page.");
    }

    // ✅ Test 2: Verifies that the page title is correct
    // ✅ Useful for confirming navigation and page loading during parallel tests
    @Test(priority = 2)
    void testTitle() {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "❌ Page title does not match.");
    }

    // ✅ Test 3: Confirms the browser is on the correct login page
    @Test(priority = 3)
    void testURL() throws InterruptedException {
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                "❌ URL mismatch for the login page."
        );
        Thread.sleep(2000); // (Only for demo — use WebDriverWait in real projects)
    }

    // ✅ This runs once after all tests — closes browser session for this thread
    @AfterClass
    void tearDown() {
        driver.quit(); // ✅ Important: Quits the browser only for the current thread/test
    }
}
