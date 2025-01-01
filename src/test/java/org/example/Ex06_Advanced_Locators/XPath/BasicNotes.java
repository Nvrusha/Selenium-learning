package org.example.Ex06_Advanced_Locators.XPath;

public class BasicNotes {
    public static void main(String[] args) {
        /*
         =========================
         XPath Notes
         =========================
         1. **What is XPath?**
            - XPath (XML Path Language) is used to navigate and locate elements in XML or HTML documents.
            - It provides a way to select nodes or elements based on their attributes, text, or structure.
         2. **Types of XPath:**
            a. **Absolute XPath**:
               - Starts from the root of the document (`/`).
               - Example: `/html/body/div[1]/form/input`
               - **Disadvantage:** Fragile, as any structural change can break the path.
            b. **Relative XPath**:
               - Starts from anywhere in the document using `//`.
               - Example: `//input[@id='username']`
               - **Advantage:** More robust and flexible than absolute XPath.
         3. **Basic Syntax:**
            - `//tagname[@attribute='value']`
              * Selects a tag with a specific attribute and value.
              * Example: `//button[@type='submit']` selects a `<button>` with `type="submit"`.
            - `//tagname[text()='exact text']`
              * Selects a tag based on its exact visible text.
              * Example: `//h5[text()='Login Successful']`
         4. **Functions in XPath:**
            a. `contains()`:
               - Matches elements based on partial attribute or text values.
               - Syntax: `//tagname[contains(@attribute, 'partial_value')]`
               - Example: `//div[contains(@class, 'error')]` matches any `<div>` with a `class` containing "error".
            b. `starts-with()`:
               - Matches elements where an attribute starts with a specific value.
               - Syntax: `//tagname[starts-with(@attribute, 'start_value')]`
               - Example: `//input[starts-with(@name, 'user')]` matches `<input>` with `name` starting with "user".
            c. `ends-with()` (not natively supported in XPath 1.0):
               - For XPath 1.0, combine `contains()` and `substring()` for similar functionality.
               - Example: `//tagname[contains(@attribute, 'suffix')]` for approximate ends-with behavior.
         5. **Combining Conditions:**
            - Use `and` or `or` to combine multiple conditions.
            - Syntax: `//tagname[@attribute1='value1' and @attribute2='value2']`
            - Example: `//input[@type='text' and @name='username']` matches an `<input>` with both conditions.
         6. **Axes in XPath:**
            - Axes define the relationship between nodes in the XML/HTML tree.
            a. `parent::`
               - Selects the parent of the current node.
               - Example: `//input[@id='username']/parent::div` selects the parent `<div>` of an `<input>` element.
            b. `child::`
               - Selects direct child nodes.
               - Example: `//div/child::p` selects all `<p>` elements directly inside `<div>`.
            c. `ancestor::`
               - Selects all ancestors (parents, grandparents, etc.) of a node.
               - Example: `//span/ancestor::div` selects all `<div>` elements containing the `<span>`.
            d. `descendant::`
               - Selects all descendants (children, grandchildren, etc.) of a node.
               - Example: `//div/descendant::a` selects all `<a>` tags inside a `<div>`.
            e. `following-sibling::` and `preceding-sibling::`
               - Select siblings of a node in the DOM.
               - Example: `//h2/following-sibling::p` selects all `<p>` tags immediately after `<h2>`.
         7. **Positioning with XPath:**
            - Use `[position()]` or indexes to select elements based on their position in a list.
            - Syntax: `//tagname[index]`
            - Example: `//ul/li[1]` selects the first `<li>` inside a `<ul>`.
            - Last element: `//ul/li[last()]` selects the last `<li>` in a `<ul>`.
         8. **Wildcard Matching:**
            - `*` matches any tag.
              * Example: `//*[@id='username']` matches any element with `id='username'`.
            - `@*` matches any attribute.
              * Example: `//input[@*='value']` matches any `<input>` with an attribute having `value`.
         9. **Common Use Cases:**
            a. Locate elements by ID:
               `//input[@id='username']`
            b. Locate elements by class name:
               `//div[@class='error-message']`
            c. Locate elements by text:
               `//h1[text()='Welcome']`
            d. Locate elements with partial matching:
               `//a[contains(text(), 'Click here')]`
         10. **Best Practices:**
            - Use Relative XPath wherever possible for better robustness.
            - Avoid over-relying on text-based XPath as visible text can change frequently.
            - Test your XPath in browser dev tools to ensure correctness before using it in automation.
        */

    }
}
