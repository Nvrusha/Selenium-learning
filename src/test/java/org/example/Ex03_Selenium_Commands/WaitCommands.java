package org.example.Ex03_Selenium_Commands;

public class WaitCommands {
    public static void main(String[] args) {
        // *** Wait Commands ***

        /*
        1. Pauses execution for a fixed time (not recommended for dynamic waits).
        Thread.sleep(2000); // Waits for 2 seconds. Avoid overuse.

        2. Sets a global wait time for all element searches.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait example.

        3. Waits for a specific condition to occur using explicit wait.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)); // Waits until an element is visible.

         */
    }
}
