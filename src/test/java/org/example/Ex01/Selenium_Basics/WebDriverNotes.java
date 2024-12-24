package org.example.Ex01.Selenium_Basics;

public class WebDriverNotes {
    public static void main(String[] args) {
        //// *************************************
        //// Selenium WebDriver Architecture Notes
        //// *************************************
        //
        //// 1. Overview of WebDriver Architecture
        //// - Selenium WebDriver is a tool for automating browsers.
        //// - It follows a Client-Server architecture.
        //// - Communication between the test script and browser is achieved using HTTP requests.
        //// - The architecture has four key components.
        //
        //
        //// *************************************
        //// 2. Components of WebDriver Architecture
        //// *************************************
        //
        //// (a) Selenium Client Library (API)
        //// - Provides the programming language interface for writing test scripts.
        //// - Supported languages include Java, Python, C#, JavaScript, etc.
        //// - Contains methods like findElement(), click(), sendKeys(), etc., used to interact with web elements.
        //
        //// Example: Using Selenium API to open a browser and navigate to a URL.
        //import org.openqa.selenium.WebDriver;
        //import org.openqa.selenium.chrome.ChromeDriver;
        //
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://example.com");
        //
        //
        //// (b) JSON Wire Protocol (Replaced in Selenium 4)
        //// - In Selenium 3, communication between Selenium API and Browser Drivers was handled using JSON Wire Protocol.
        //// - JSON Wire Protocol converts API commands into HTTP requests and sends them to the browser driver.
        //// - In Selenium 4, JSON Wire Protocol is replaced by the **W3C WebDriver Protocol** for better stability and compatibility.
        //
        //
        //// (c) Browser Driver
        //// - A browser-specific executable (e.g., ChromeDriver, GeckoDriver, etc.).
        //// - Acts as a translator between Selenium commands and browser-specific actions.
        //// - Handles HTTP requests and translates them into browser-understandable commands.
        //
        //// Example: Using WebDriverManager to set up the browser driver.
        //import io.github.bonigarcia.wdm.WebDriverManager;
        //
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver2 = new ChromeDriver(); // Creates a session for Chrome browser.
        //
        //
        //// (d) Web Browser
        //// - Executes the commands received from the browser driver.
        //// - Supported browsers include Chrome, Firefox, Edge, and Safari.
        //// - Sends responses back to the WebDriver API (e.g., status of command execution).
        //
        //
        //// *************************************
        //// 3. Working Mechanism of WebDriver
        //// *************************************
        //
        //// (a) Test Script Execution
        //// - User writes a test script using Selenium API (e.g., driver.get(), driver.findElement()).
        //
        //// (b) Communication via W3C WebDriver Protocol
        //// - Commands are sent as HTTP requests to the browser driver.
        //// - W3C Protocol eliminates intermediate conversions, making communication more direct.
        //
        //// (c) Browser Driver
        //// - Receives the commands and interacts with the browser using native browser automation APIs.
        //
        //// (d) Browser Action Execution
        //// - The browser performs the actions (e.g., click, navigate, etc.) and sends a response back to the driver.
        //
        //// Example: Navigating to a URL and retrieving the page title.
        //driver.get("https://example.com");
        //String pageTitle = driver.getTitle();
        //System.out.println("Page Title: " + pageTitle);
        //
        //
        //// *************************************
        //// 4. Diagram Representation (Selenium 4)
        //// *************************************
        //
        //// Test Script -> Selenium API -> W3C WebDriver Protocol -> Browser Driver -> Browser
        ////                     ^
        ////                    Response (HTTP)
        //
        //// *************************************
        //// 5. Key Features of Selenium 4 Architecture
        //// *************************************
        //
        //// (a) W3C WebDriver Protocol
        //// - Standardizes communication between browser drivers and Selenium.
        //// - Ensures compatibility across all major browsers.
        //// - Faster and more stable compared to JSON Wire Protocol.
        //
        //// (b) Backward Compatibility
        //// - Selenium 4 supports older test scripts written in Selenium 3.
        //
        //// (c) Modern Browser Features
        //// - Includes debugging tools (e.g., capturing network logs) via Chromium DevTools Protocol (CDP).
        //
        //
        //// *************************************
        //// 6. Benefits of WebDriver Architecture
        //// *************************************
        //
        //// - Language Support: Write tests in your preferred programming language.
        //// - Browser Independence: Same code works for multiple browsers.
        //// - Scalability: Easily integrate with CI/CD tools and cloud-based platforms.
        //// - Open-Source: Free to use and extend.

    }
}
