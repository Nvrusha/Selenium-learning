package org.example.Ex14_TestNG.Parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Using_DataProvider {

    WebDriver driver;

    // ✅ Runs once before all test methods in the class
    @BeforeClass
    public void setUp() {
        System.out.println("Launching browser...");
        driver = new ChromeDriver();

        // Set implicit wait for element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // ✅ Test method that runs multiple times using DataProvider input
    @Test(dataProvider = "login")
    void login(String email, String pwd) throws InterruptedException {
        // Navigate to the login page
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();

        // Enter email and password from the DataProvider
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);

        // Click on Login button
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Wait for the page to load (not recommended for production, better to use explicit wait)
        Thread.sleep(2000);

        // ✅ Check if the login was successful by verifying the "My Account" heading is displayed
        boolean myAccountPage = driver.findElement(
                By.xpath("//h2[normalize-space(text())='My Account']")
        ).isDisplayed();

        // ✅ If login is successful, log out and assert true
        if (myAccountPage) {
            // Click on Logout link after successful login
            driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(), 'Logout')]")).click();
            Assert.assertTrue(true);  // Mark test as passed
        } else {
            Assert.fail();  // Mark test as failed
        }
    }

    // ✅ Runs once after all test methods in the class
    @AfterClass
    void tearDown() {
        System.out.println("Closing browser...");
        driver.quit();  // Close browser and end session
    }

    // ✅ DataProvider method supplying email-password combinations
    @DataProvider(name = "login", indices = {0,1})
    Object[][] loginData() {
        Object data[][] = {
                {"nivangunevrushali.vn@gmail.com", "Vrusha123$"},  // valid
                {"abc@gmail.com", "abc123$"},                      // invalid
                {"test@gmail.com", "test123@"},                    // invalid
                {"user1@example.com", "pass1"},                    // invalid
                {"user2@example.com", "pass2"}                     // invalid
        };
        return data;
    }
}
