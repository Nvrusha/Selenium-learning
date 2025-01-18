package org.example.Ex08_SVG_Elements;

public class Notes {
    public static void main(String[] args) {
        /*
         ==========================================================
         SVG Selenium Notes:
         ==========================================================
         SVG (Scalable Vector Graphics) is an XML-based vector image format.
         These elements often belong to a different XML namespace, so standard locators
         like `By.tagName` or direct `svg` references may not work in Selenium.


         ==========================================================


         1. **What is SVG?**
            - SVG is an XML-based format for vector graphics.
            - It is widely used in web pages for interactive, scalable images (e.g., maps, charts).
            - SVG elements have unique structures, attributes, and namespaces.

         2. **Why is SVG Different in Selenium?**
            - Unlike regular HTML, SVG elements belong to the SVG namespace.
            - Standard locators like `tagName("svg")` may not work directly.
            - Instead, XPath expressions with `*[name()='svg']` are required to address namespace differences.

         3. **Identifying SVG Elements in XPath**:
            - Use `*[name()='svg']` to identify the root SVG element.
            - To traverse nested SVG elements:
              - Example: `//*[name()='svg']/*[name()='g']/*[name()='path']`.

         4. **Common SVG Element Types**:
            - `<svg>`: The root element of the SVG structure.
            - `<g>`: Grouping element for organizing SVG shapes.
            - `<path>`: Defines a shape (e.g., lines, curves) in SVG.
            - `<circle>`, `<rect>`, `<text>`: Represent specific SVG shapes and text.

         5. **Interacting with SVG Elements**:
            - Use `WebElement.click()` for interactive elements.
            - Example: Click on a specific region or shape within the SVG.
            - Retrieve attributes like `aria-label`, `fill`, or `id` to validate or locate elements.

         6. **Scrolling to SVG Elements**:
            - Use JavaScript if the target SVG element is offscreen:
              ```java
              WebElement element = driver.findElement(By.xpath("//*[name()='svg']"));
              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
              ```

         7. **Dynamic Content in SVGs**:
            - SVGs can be interactive and loaded dynamically via JavaScript.
            - Use explicit waits to ensure all elements are fully loaded before interacting.

         8. **XPath Best Practices for SVG**:
            - Combine `*[name()='svg']` with meaningful attributes for better locators.
            - Example: `//*[name()='path'][@aria-label='StateName']`.

         9. **Common Challenges**:
            - Namespace issues: Use `*[name()='tag']` for proper selection.
            - Dynamic elements: Handle with explicit waits or JavaScript execution.
            - Visibility: Ensure SVG elements are visible and not obscured by overlays.

         10. **Debugging Tips**:
             - Use browser DevTools to inspect the SVG structure.
             - Right-click on an element, select "Inspect," and view the SVG hierarchy.
             - Look for unique attributes (`id`, `aria-label`) to use in XPath.

         ==========================================================
        */
    }
}
