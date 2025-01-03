package org.example.Ex06_Advanced_Locators.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPath_Functions {
    public static void main(String[] args) {
        // Set up ChromeOptions to maximize the browser window
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open Wikipedia
        driver.get("https://www.wikipedia.org/");

        // Example 1: Using the "text()" function to match the text of an element
        // XPath: //a[text()='English'] - Selects the link with text "English"
        WebElement englishLink = driver.findElement(By.xpath("//a[text()='English']"));
        System.out.println("Text function - English Link Found: " + englishLink.getText());

        // Example 2: Using the "contains()" function to find elements with specific text
        // XPath: //a[contains(text(),'Wiki')] - Selects any <a> tag that contains the text "Wiki"
        WebElement wikiLink = driver.findElement(By.xpath("//a[contains(text(),'Wiki')]"));
        System.out.println("Contains function - Wiki Link Found: " + wikiLink.getText());

        // Example 3: Using the "starts-with()" function to match text that starts with a specific value
        // XPath: //a[starts-with(text(),'Re')] - Selects links starting with the text "Re"
        WebElement startWithLink = driver.findElement(By.xpath("//a[starts-with(text(),'Re')]"));
        System.out.println("Starts-with function - Link Found: " + startWithLink.getText());

        // Example 4: Using the "and" operator to match two conditions
        // XPath: //input[@id='searchInput' and @name='search'] - Selects an <input> with both id="searchInput" and name="search"
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput' and @name='search']"));
        System.out.println("And operator function - Search Input Field Found: " + searchInput.getAttribute("name"));

        // Example 5: Using the "or" operator to match one of two conditions
        // XPath: //input[@id='searchInput' or @id='searchLanguage'] - Selects an <input> with either id="searchInput" or id="searchLanguage"
        WebElement searchLanguageInput = driver.findElement(By.xpath("//input[@id='searchInput' or @id='searchLanguage']"));
        System.out.println("Or operator function - Search Language Input Field Found: " + searchLanguageInput.getAttribute("id"));

        // Example 6: Using the "not()" function to exclude certain elements
        // XPath: //a[not(text()='English')] - Selects any <a> element whose text is not "English"
        WebElement notEnglishLink = driver.findElement(By.xpath("//a[not(text()='English')]"));
        System.out.println("Not function - Found Link (Not English): " + notEnglishLink.getText());

        // Example 7: Using the "normalize-space()" function to remove leading and trailing spaces
        // XPath: //input[normalize-space(@id)='searchInput'] - Selects <input> with id="searchInput" and removes leading/trailing spaces
        WebElement normalizedSpaceInput = driver.findElement(By.xpath("//input[normalize-space(@id)='searchInput']"));
        System.out.println("Normalize-space function - Search Input Field: " + normalizedSpaceInput.getAttribute("id"));

        // Example 8: Using the "position()" function to select the nth element
        // XPath: //nav[@class='central-featured']//div[position()=2] - Selects the 2nd <div> element in the central-featured nav
        WebElement secondLink = driver.findElement(By.xpath("//nav[@class='central-featured']//div[position()=2]"));
        System.out.println("Position function - Second Link: " + secondLink.getText());

        // Example 9: Using the "last()" function to select the last element
        // XPath: //nav[@class='central-featured']//div[last()] - Selects the last div element in the central-featured nav
        WebElement lastLink = driver.findElement(By.xpath("//nav[@class='central-featured']//div[last()]"));
        System.out.println("Last function - Last Link: " + lastLink.getText());

        // Close the browser
        driver.quit();
    }
}
