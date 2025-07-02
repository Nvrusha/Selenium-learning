package org.example.Ex14_TestNG.Method_Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice {
    /*
     * ✅ TestNG @dependsOnMethods - Study Notes
     *
     * ✅ Purpose:
     * --------------------
     * - Used when one test method depends on the successful execution of another test method.
     * - Controls execution flow in test automation.
     * - If a parent method fails, all dependent (child) methods will automatically be SKIPPED.
     *
     * ✅ Syntax:
     * --------------------
     * @Test(dependsOnMethods = {"methodName"})
     * public void yourTest() {
     *     // Test steps
     * }
     *
     * ✅ Real-life Example Scenario: (Open App → Login → Search → Add to Cart)
     * --------------------
     */

    // ✅ Test 1: Open the application
    @Test(priority = 1)
    void openApp() {
        // Intentionally failing this test to see dependency behavior
        Assert.assertTrue(false);  // This will fail the test
        //Assert.assertTrue(true);  // This assertion passes
        System.out.println("✅ Opened app successfully...");
    }

    // ✅ Test 2: Login functionality (Depends on openApp)
    @Test(priority = 2, dependsOnMethods = {"openApp"})
    void login() {
        // This test will only run if openApp() passes
        Assert.assertTrue(true);  // This assertion passes
        System.out.println("✅ Login Test: Successfully logged in...");
    }

    // ✅ Test 3: Product Search functionality (Depends on login)
    @Test(dependsOnMethods = {"login"})
    void searchProductTest() {
        // This test will only run if login() passes
        Assert.assertTrue(true);  // Dummy pass
        System.out.println("✅ Search Test: Product search executed after successful login...");
    }

    // ✅ Test 4: Add to Cart functionality (Depends on searchProductTest)
    @Test(dependsOnMethods = {"searchProductTest"})
    void addToCartTest() {
        // This test will only run if searchProductTest() passes
        System.out.println("✅ Add to Cart Test: Product added to cart after search...");
    }

    /*
     * ✅ Expected Execution Flow:
     * --------------------
     * Step 1: TestNG first runs openApp()
     * Step 2: If openApp passes → Runs login()
     * Step 3: If login passes → Runs searchProductTest()
     * Step 4: If searchProductTest passes → Runs addToCartTest()
     *
     * ✅ BUT:
     * Since openApp() FAILS (intentionally failed using Assert.assertTrue(false)),
     * → All dependent tests (login, searchProductTest, addToCartTest) will be SKIPPED!
     *
     * ✅ Interview Tip:
     * --------------------
     * - Very useful in real projects for setting pre-conditions like:
     *   Open browser → Login → Perform actions → Logout
     * - Avoids meaningless execution when preconditions fail.
     *
     * ✅ Notes:
     * --------------------
     * - You can also set multiple dependencies like this:
     *   @Test(dependsOnMethods = {"method1", "method2"})
     *   → Test will run only if BOTH method1 and method2 pass.
     */
}
