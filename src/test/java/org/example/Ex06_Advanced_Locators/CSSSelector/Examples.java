package org.example.Ex06_Advanced_Locators.CSSSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Examples {
    public static void main(String[] args) {

        /* Set up WebDriver */
        WebDriver driver = new ChromeDriver();

        // Open a test website
        driver.get("https://www.wikipedia.org/");

        // ============================================================
        // CSS SELECTORS - DETAILED NOTES WITH EXAMPLES
        // ============================================================
        // 1. Basic Selectors
        // ------------------
        // 1.1 Tag Name Selector
        // Select the first <input> element (search input field).

        WebElement tagNameSelector = driver.findElement(By.cssSelector("input"));

        // 1.2 ID Selector
        // Select the search input field using its ID.
        WebElement idSelector = driver.findElement(By.cssSelector("#searchInput"));

        // 1.3 Class Selector
        // Select the search button using its class.
        WebElement classSelector = driver.findElement(By.cssSelector(".pure-button-primary-progressive"));

        // ------------------------------------------------------------

        // 2. Attribute Selectors
        // -----------------------

        // 2.1 Attribute Presence Selector
        // Select all elements that have a 'lang' attribute.
        WebElement attributeSelector = driver.findElement(By.cssSelector("[lang]"));

        // 2.2 Exact Attribute Value Selector
        // Select the English language link using its lang attribute.
        WebElement exactValueSelector = driver.findElement(By.cssSelector("a[lang='en']"));

        // 2.3 Attribute Starts With Selector (^)
        // Select all links where href starts with 'https://'.
        WebElement startsWithSelector = driver.findElement(By.cssSelector("a[href^='https://']"));

        // 2.4 Attribute Ends With Selector ($)
        // Select the logo's image where src ends with '.svg'.
        WebElement endsWithSelector = driver.findElement(By.cssSelector("img[src$='.svg']"));

        // 2.5 Attribute Contains Selector (*)
        // Select the search input field where name contains 'search'.
        WebElement containsSelector = driver.findElement(By.cssSelector("input[name*='search']"));

        // ------------------------------------------------------------

        // 3. Combinators
        // --------------

        // 3.1 Descendant Selector (Space)
        // Select all <span> elements inside <div class='central-featured-lang'>.
        WebElement descendantSelector = driver.findElement(By.cssSelector("div.central-featured-lang span"));

        // 3.2 Child Selector (>)
        // Select all direct <a> children of <div class='langlist'>
        WebElement childSelector = driver.findElement(By.cssSelector("div.langlist > a"));

        // 3.3 Adjacent Sibling Selector (+)
        // Select the first <nav> after <div>.
        WebElement adjacentSiblingSelector = driver.findElement(By.cssSelector("div.central-textlogo + nav"));

        // 3.4 General Sibling Selector (~)
        // Select all <nav> siblings after the central-textlogo div.
        WebElement generalSiblingSelector = driver.findElement(By.cssSelector("div.central-textlogo ~ nav"));

        // ------------------------------------------------------------

        // 4. Pseudo-Classes
        // ------------------

        // 4.1 First Child (:first-child)
        // Select the first language link in the central-featured block.
        WebElement firstChildSelector = driver.findElement(By.cssSelector("nav.central-featured div:first-child"));

        // 4.2 Last Child (:last-child)
        // Select the last language link in the central-featured block.
        WebElement lastChildSelector = driver.findElement(By.cssSelector("nav.central-featured div:last-child"));

        // 4.3 Nth Child (:nth-child(n))
        // Select the second language link in the central-featured block.
        WebElement nthChildSelector = driver.findElement(By.cssSelector("nav.central-featured div:nth-child(2)"));

        // 4.4 Not Selector (:not(selector))
        // Select all <input> elements except the search input field.
        WebElement notSelector = driver.findElement(By.cssSelector("input:not(#searchInput)"));

        // ------------------------------------------------------------

        // 5. Compound Selectors
        // ----------------------

        // Combine multiple conditions to select specific elements.
        // Select the search input field with both ID and name attributes.
        WebElement compoundSelector = driver.findElement(By.cssSelector("input#searchInput[name='search']"));

        // ------------------------------------------------------------

        // Example Print to Verify (Optional)
        System.out.println("Tag Name Selector Found: " + (tagNameSelector != null));
        System.out.println("ID Selector Value: " + idSelector.getAttribute("id"));
        System.out.println("Class Selector Text: " + classSelector.getText());
        System.out.println("Compound Selector Placeholder: " + compoundSelector.getAttribute("placeholder"));

        // Close the browser
        driver.quit();
            }
        }


