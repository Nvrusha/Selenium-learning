package org.example.Ex06_Advanced_Locators.XPath;

public class BasicNotes {
    public static void main(String[] args) {
// -----------------------------------------
// 📌 XPath Notes
// -----------------------------------------

// 🌟 What is XPath?
// XPath (XML Path Language) is used to navigate and locate nodes in an XML or HTML document.
// It is commonly used in web automation (e.g., Selenium) to locate elements on a webpage.

// -----------------------------------------
// ✨ Basic Syntax
// -----------------------------------------
// - XPath uses a path-like syntax to identify elements.
// Example:
//    /html/body/div   -> Selects the <div> element within <body> in the <html> structure.
//    //div            -> Selects all <div> elements, regardless of location.

// -----------------------------------------
// 🎯 Types of XPath
// -----------------------------------------
// 1️⃣ **Absolute XPath**:
//    Starts from the root node (/) and specifies the entire path.
//    Example: /html/body/div[1]/h1
//    Pros: Precise location.
//    Cons: Brittle; breaks if the structure changes.

// 2️⃣ **Relative XPath**:
//    Starts with a double forward slash (//), allowing you to search from anywhere in the document.
//    Example: //div[@class='container']
//    Pros: More flexible and robust than absolute XPath.

// -----------------------------------------
// 🛠️ Commonly Used XPath Functions
// -----------------------------------------
// 1️⃣ **[@attribute='value']**:
//    Selects elements with a specific attribute value.
//    Example: //input[@id='username']

// 2️⃣ **text()**:
//    Selects elements based on their visible text content.
//    Example: //button[text()='Login']

// 3️⃣ **contains()**:
//    Selects elements containing a partial match of text or attributes.
//    Example: //div[contains(@class, 'header')]
//             //p[contains(text(), 'welcome')]

// 4️⃣ **starts-with()**:
//    Matches elements whose attribute values start with a specific string.
//    Example: //input[starts-with(@id, 'user_')]

// 5️⃣ **last()**:
//    Selects the last element in a set.
//    Example: //li[last()]

// 6️⃣ **position()**:
//    Selects elements by position in a set.
//    Example: (//input)[2] -> Selects the second input element.

// -----------------------------------------
// 🌍 Using XPath Axes
// -----------------------------------------
// Axes are used to find elements in relation to other elements.
// Examples:
// - **parent::** Selects the parent node.
//   Example: //span/parent::div
// - **child::** Selects the child nodes.
//   Example: //div/child::p
// - **ancestor::** Selects all ancestor nodes.
//   Example: //div/ancestor::html
// - **following-sibling::** Selects all siblings after the current node.
//   Example: //h1/following-sibling::p
// - **preceding-sibling::** Selects all siblings before the current node.
//   Example: //p/preceding-sibling::h1

// -----------------------------------------
// 🔍 Using XPath in Selenium
// -----------------------------------------
// XPath is a popular locator strategy in Selenium for finding web elements.
// Example in Java Selenium:
// WebElement element = driver.findElement(By.xpath("//button[@id='submit']"));

// -----------------------------------------
// ⚡ Tips for Writing Efficient XPath
// -----------------------------------------
// - Prefer **Relative XPath** for better stability.
// - Use functions like **contains()** and **text()** for dynamic elements.
// - Avoid long **Absolute XPath** as they are prone to breaking with changes in structure.
// - Use browser developer tools (e.g., Chrome DevTools) to verify your XPath.

// -----------------------------------------
// ✅ Practical Example
// -----------------------------------------
// Example HTML:
// <div class="login-form">
//    <input id="username" type="text" />
//    <input id="password" type="password" />
//    <button id="login">Login</button>
// </div>
//
// XPath Selectors:
// 1️⃣ //div[@class='login-form']              -> Select the entire login form.
// 2️⃣ //input[@id='username']                 -> Select the username input field.
// 3️⃣ //button[contains(@id, 'login')]        -> Select the login button.
// 4️⃣ //input[starts-with(@id, 'user')]       -> Select the username field based on the starting ID.

// -----------------------------------------


    }
}
