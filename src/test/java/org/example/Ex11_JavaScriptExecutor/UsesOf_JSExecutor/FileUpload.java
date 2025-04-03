package org.example.Ex11_JavaScriptExecutor.UsesOf_JSExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {

        // -------------------------------------------------------------------------------------
        // 📌 Test Case: Verify File Upload Functionality on SelectorsHub
        // 📌 Scenario: Upload a file on the SelectorsHub website after scrolling to bring the
        // upload element into view.
        //
        // ✅ Test Steps:
        // 1️⃣ Open the browser and navigate to SelectorsHub XPath Practice Page.
        // 2️⃣ Scroll down to the file upload section.
        // 3️⃣ Locate the file upload input field.
        // 4️⃣ Upload a file using sendKeys() method.
        // 5️⃣ Verify that the correct file name is displayed after upload.
        // 6️⃣ Close the browser.
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Initialize WebDriver and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Navigate to the SelectorsHub XPath Practice Page
        driver.get("https://selectorshub.com/xpath-practice-page/");

        // Step 3️⃣: Locate the file upload input field (not in view initially)
        WebElement fileUpload = driver.findElement(By.xpath("//input[@id='myFile']"));

        // Step 4️⃣: Scroll down to make the file upload field visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", fileUpload);
        Thread.sleep(3000);  // Wait for the scroll to complete

        // Step 5️⃣: Upload the file using sendKeys()
        String fileToUpload = "D:\\Software Testing\\Manual Testing Notes.pdf";
        fileUpload.sendKeys(fileToUpload);

        // Step 6️⃣: Validate if the correct file is uploaded
        String uploadedFilePath = (String) js.executeScript("return arguments[0].value;", fileUpload); // Get the uploaded file path
        String uploadedFileName = uploadedFilePath.substring(uploadedFilePath.lastIndexOf("\\") + 1); // Extract file name

        // Step 7️⃣: Check if the uploaded file name matches the expected file name
        if (uploadedFileName.equals("Manual Testing Notes.pdf")) {
            System.out.println("✅ File uploaded successfully: " + uploadedFileName);
        } else {
            System.out.println("❌ Upload failed! Expected: Manual Testing Notes.pdf but got: " + uploadedFileName);
        }

        // Step 8️⃣: Close the browser
        driver.close();
    }
}
