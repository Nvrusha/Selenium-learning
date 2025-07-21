package org.example.Page_Object_Model.Without_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the Login Page using the Page Object Model (POM) design pattern.
 * It contains WebElement locators and reusable methods (actions) to interact with the login page.
 */
public class LoginPage {

    WebDriver driver;  // This WebDriver reference will be used to locate and interact with elements

    // ✅ Constructor to initialize the WebDriver instance from the calling test class
    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔍 Element Locators (Object Repository) - Using By class to locate elements using XPath

    By userName = By.xpath("//input[@placeholder=\"Username\"]");   // Locator for username input field
    By passWord = By.xpath("//input[@placeholder=\"Password\"]");   // Locator for password input field
    By loginBtn = By.xpath("//button[@type=\"submit\"]");           // Locator for login button

    // 🧪 Action Methods - These are user-defined methods to perform actions on the web elements

    /**
     * Method to enter username in the username field
     * @param user - value to be entered in the username field
     */
    public void setUserName(String user){
        driver.findElement(userName).sendKeys(user);
    }

    /**
     * Method to enter password in the password field
     * @param pwd - value to be entered in the password field
     */
    public void setPwd(String pwd){
        driver.findElement(passWord).sendKeys(pwd);
    }

    /**
     * Method to click the login button
     * @param btn - parameter not used (you can remove it for clarity)
     */
    public void clickBtn(){
        driver.findElement(loginBtn).click();
    }

    // 💡 Optional: You can overload or modify this method to remove the unused parameter
}
