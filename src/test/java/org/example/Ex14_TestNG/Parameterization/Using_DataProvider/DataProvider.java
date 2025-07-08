package org.example.Ex14_TestNG.Parameterization.Using_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProvider {

    WebDriver driver;

    // ✅ This method runs once before any @Test method in this class.
    // Used to launch the browser and set common configurations.
    @BeforeClass
    public void setUp() {
        System.out.println("Launching browser...");

        // Launch a new Chrome browser instance
        driver = new ChromeDriver();

        // Set an implicit wait (waits up to 10 seconds for elements to appear)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // ✅ This test will run multiple times with different sets of data from the @DataProvider.
    // Each time, the 'email' and 'pwd' values will be taken from the 2D array provided by loginData().
    @Test(dataProvider = "login")
    void login(String email, String pwd) throws InterruptedException {
        // Navigate to the login page of the demo website
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Enter email in the email input field
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        // Enter password in the password input field
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);

        // Click the login button to attempt login
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Add a short delay to allow page to load (Note: Replace with WebDriverWait in real-time frameworks)
        Thread.sleep(2000);

        // ✅ Check if the user successfully landed on the "My Account" page
        boolean myAccountPage = driver.findElement(
                By.xpath("//h2[normalize-space(text())='My Account']")
        ).isDisplayed();

        // ✅ Test passes if login is successful (i.e., "My Account" heading is visible)
        if (myAccountPage) {
            // If login successful, log out for the next test run
            driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(), 'Logout')]")).click();

            // Mark the test as passed
            Assert.assertTrue(true);
        } else {
            // Mark the test as failed if login didn't land on "My Account"
            Assert.fail("Login failed for email: " + email);
        }
    }

    // ✅ This method runs once after all the @Test methods are executed.
    // Used for cleanup: closing the browser here.
    @AfterClass
    void tearDown() {
        System.out.println("Closing browser...");
        driver.quit();  // Quit the driver session
    }

    // ✅ DataProvider method supplies multiple sets of email-password combinations.
    // Each array represents a single test run with one set of login credentials.
    @org.testng.annotations.DataProvider(name = "login", indices = {0,4})
    Object[][] loginData() {
        Object data[][] = {
                {"nivangunevrushali.vn@gmail.com", "Vrusha123$"},  // ✅ valid credentials (will pass)
                {"abc@gmail.com", "abc123$"},                      // ❌ invalid credentials
                {"test@gmail.com", "test123@"},                    // ❌ invalid credentials
                {"user1@example.com", "pass1"},                    // ❌ invalid credentials
                {"user2@example.com", "pass2"}                     // ❌ invalid credentials
        };
        return data;
    }
}
