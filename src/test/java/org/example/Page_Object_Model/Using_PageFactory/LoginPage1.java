package org.example.Page_Object_Model.Using_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * ✅ Page Object Model (POM) with PageFactory:
 * This class represents the Login Page of the OrangeHRM application.
 * All elements are initialized using @FindBy annotations and PageFactory.
 */
public class LoginPage1 {

    WebDriver driver;  // WebDriver reference to interact with browser

    // ✅ Constructor to initialize the PageFactory elements
    public LoginPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize all WebElements annotated with @FindBy
    }

    // 🔍 Element Locators using PageFactory (Object Repository)

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWord;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(tagName = "a")
    List<WebElement> links;  // Example of locating multiple elements (optional use)

    // 🧪 Reusable Page Actions (Methods to operate on elements)

    /**
     * Sets the username in the username input field.
     * @param user the username to enter
     */
    public void setUserName(String user) {
        userName.sendKeys(user);
    }

    /**
     * Sets the password in the password input field.
     * @param pwd the password to enter
     */
    public void setPwd(String pwd) {
        passWord.sendKeys(pwd);
    }

    /**
     * Clicks the login button to submit the login form.
     */
    public void clickBtn() {
        loginBtn.click();
    }

    /**
     * (Optional) Returns the total number of links on the page.
     * Example utility method showing use of List<WebElement>.
     */
    public int countLinks() {
        return links.size();
    }
}
