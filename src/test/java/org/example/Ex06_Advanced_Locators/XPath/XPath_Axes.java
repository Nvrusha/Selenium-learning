package org.example.Ex06_Advanced_Locators.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPath_Axes {
    public static void main(String[] args) {
        // Set up ChromeOptions to maximize the browser window
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open Wikipedia
        driver.get("https://www.wikipedia.org/");

        // 1. ancestor: Select all ancestor nodes of the search input field
        WebElement ancestorDiv = driver.findElement(By.xpath("//input[@id='searchInput']/ancestor::div"));
        System.out.println("Ancestor Div Class: " + ancestorDiv.getAttribute("class"));

        // 2. child: Select all child nodes of the main content wrapper
        WebElement childNode = driver.findElement(By.xpath("//nav[@class='central-featured']/child::*"));
        System.out.println("Child Node Tag: " + childNode.getTagName() + " | Text: " + childNode.getText());

        // 3. descendant: Select all descendant nodes under the main wrapper
        WebElement descendantNode = driver.findElement(By.xpath("//nav[@class='central-featured']/descendant::*"));
        System.out.println("Descendant Node Tag: " + descendantNode.getTagName() + " | Text: " + descendantNode.getText());

        // 4. following: Select all nodes following the search input field
        WebElement followingNode = driver.findElement(By.xpath("//input[@id='searchInput']/following::*"));
        System.out.println("Following Node Tag: " + followingNode.getTagName() + " | Text: " + followingNode.getText());

        // 5. following-sibling: Select sibling nodes after the logo
        WebElement followingSiblingNode = driver.findElement(By.xpath("//div[@class='central-textlogo']/following-sibling::div"));
        System.out.println("Following Sibling Node Tag: " + followingSiblingNode.getTagName() + " | Text: " + followingSiblingNode.getText());

        // 6. preceding: Select all nodes before the footer
        WebElement precedingNode = driver.findElement(By.xpath("//footer/preceding::*"));
        System.out.println("Preceding Node Tag: " + precedingNode.getTagName() + " | Text: " + precedingNode.getText());

        // 7. preceding-sibling: Select sibling nodes before the English language link
        WebElement precedingSiblingNode = driver.findElement(By.xpath("//nav[@class='central-featured']/preceding-sibling::*"));
        System.out.println("Preceding Sibling Node Tag: " + precedingSiblingNode.getTagName() + " | Text: " + precedingSiblingNode.getText());

        // 8. parent: Select the parent of the search input field
        WebElement parentNode = driver.findElement(By.xpath("//input[@id='searchInput']/parent::div"));
        System.out.println("Parent Node Tag: " + parentNode.getTagName() + " | Class: " + parentNode.getAttribute("class"));

        // 9. descendant-or-self: Select the wrapper and all its descendants
        WebElement descendantOrSelfNode = driver.findElement(By.xpath("//nav[@class='central-featured']/descendant-or-self::*"));
        System.out.println("Descendant or Self Node Tag: " + descendantOrSelfNode.getTagName() + " | Text: " + descendantOrSelfNode.getText());

        // 10. self: Select the search input field itself
        WebElement selfNode = driver.findElement(By.xpath("//input[@id='searchInput']/self::input"));
        System.out.println("Self Node Tag: " + selfNode.getTagName() + " | Placeholder: " + selfNode.getAttribute("placeholder"));

        // Example Print to Verify (Optional)
        System.out.println("Ancestor Div Class: " + ancestorDiv.getAttribute("class"));
        System.out.println("Child Node Found: " + (childNode != null));
        System.out.println("Self Node Tag Name: " + selfNode.getTagName());

        // Close the browser
        driver.quit();
    }
}
