package org.example.Ex11_JavaScriptExecutor.UsesOf_JSExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_FileUpload {
    public static void main(String[] args) throws InterruptedException {

        // -------------------------------------------------------------------------------------
        // 📌 Test Case: Verify Multiple File Upload Functionality on David Walsh Demo Page
        // 📌 Scenario: Upload multiple files on the David Walsh demo website which supports
        // multiple file uploads, and verify if the file input accepts multiple files.
        //
        // ✅ Test Steps:
        // 1️⃣ Launch the browser and open the David Walsh demo file upload page.
        // 2️⃣ Locate the file input element that supports multiple file uploads.
        // 3️⃣ Use sendKeys() with newline-separated file paths to simulate multiple file upload.
        // 4️⃣ Verify the uploaded file names are correctly listed.
        // 5️⃣ Validate the number of uploaded files.
        // 6️⃣ Close the browser.
        // -------------------------------------------------------------------------------------

        // Step 1️⃣: Initialize WebDriver and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2️⃣: Navigate to the demo file upload page
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

        // Step 3️⃣: Locate the file upload input field (supports multiple file selection)
        WebElement fileUpload = driver.findElement(By.xpath("//input[@id='filesToUpload']"));

        // Step 4️⃣: Define full paths of the files to be uploaded (update paths as needed)
        String file1 = "D:\\Software Testing\\Manual Testing Notes.pdf";
        String file2 = "D:\\Software Testing\\Java_Complete_Notes.pdf";

        // Step 5️⃣: Upload both files using newline separator (\n)
        fileUpload.sendKeys(file1 + "\n" + file2);

        // Add wait for files to be processed and displayed
        Thread.sleep(3000);

        // Step 6️⃣: Validate if uploaded file names are correctly displayed on the page
        String fileName1 = driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText();
        String fileName2 = driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText();

        if (fileName1.equals("Manual Testing Notes.pdf") && fileName2.equals("Java_Complete_Notes.pdf")) {
            System.out.println("✅ File name validation passed: Both file names are displayed correctly.");
        }
        else {
            System.out.println("❌ File name validation failed: One or more file names are incorrect.");
            System.out.println("   Expected: Manual Testing Notes.pdf & Java_Complete_Notes.pdf");
            System.out.println("   Found: " + fileName1 + " & " + fileName2);
        }

        // Step 7️⃣: Validate the total number of uploaded files displayed
        int noOfFilesUploaded = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();

        if (noOfFilesUploaded == 2) {
            System.out.println("✅ File count validation passed: 2 files uploaded successfully.");
        } else {
            System.out.println("❌ File count validation failed: Expected 2, but found " + noOfFilesUploaded);
        }

        // Step 8️⃣: Close the browser
        driver.close();
    }
}
