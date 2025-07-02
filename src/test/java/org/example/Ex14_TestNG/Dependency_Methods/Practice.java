package org.example.Ex14_TestNG.Dependency_Methods;

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
     * - If the dependent method fails, the child tests will be SKIPPED automatically.
     *
     * ✅ Syntax:
     * --------------------
     * @Test(dependsOnMethods = {"methodName"})
     * public void yourTest() {
     *     // Test steps
     * }
     *
     * ✅ Example Scenario: (OpenApp → Login → Search → Add to Cart)
     * --------------------
     */


    @Test(priority = 1)
        void openApp(){
            Assert.assertTrue(false);
        System.out.println("✅ Opened app successfully...");

        }


    // ✅ 1st Test: Login functionality
    @Test(priority = 2, dependsOnMethods = {"openApp"})
    void login() {
        // This is the first independent test
        Assert.assertTrue(true);
        System.out.println("✅ Login Test: Successfully logged in...");
        // Imagine a real assertion here
    }

    // ✅ 2nd Test: Product search, which depends on login success
    @Test(dependsOnMethods = {"login"})
    void searchProductTest() {
        // This test will only run if loginTest passes
        Assert.assertTrue(true);
        System.out.println("✅ Search Test: Product search executed after successful login...");
    }

    // ✅ 3rd Test: Adding product to cart, which depends on search success
    @Test(dependsOnMethods = {"searchProductTest"})
    void addToCartTest() {
        // This test runs only if searchProductTest passes
        System.out.println("✅ Add to Cart Test: Product added to cart after search...");
    }

    /*
     * ✅ Execution Flow:
     * --------------------
     * 1) TestNG will first run: loginTest()
     * 2) If login passes → then runs searchProductTest()
     * 3) If search passes → then runs addToCartTest()
     * 4) If any parent test fails, the child tests are marked as SKIPPED
     *
     * ✅ Interview Tip:
     * --------------------
     * - If a method has multiple dependencies:
     *   @Test(dependsOnMethods = {"method1", "method2"})
     *   → This test will only run if both method1 and method2 PASS.
     */
}
