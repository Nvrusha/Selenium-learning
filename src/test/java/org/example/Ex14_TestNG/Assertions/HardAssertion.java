package org.example.Ex14_TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

    /*
     * ✅ Hard Assertion in TestNG
     *
     * ✅ Definition:
     *    - Hard assertion is used to validate test conditions.
     *    - If the assertion fails, the test execution stops immediately at that point.
     *
     * ✅ Provided By:
     *    - org.testng.Assert class
     *
     * ✅ Behavior:
     *    - After failure, next lines of code inside the same test method won't execute.
     *
     * ✅ Use Case:
     *    - Used for critical validations (Ex: Login success, important page loads etc.)
     *
     * ✅ Example:
     */

    // ✅ Test case for assertEquals
    @Test
    void testAssertEquals() {
        String actualTitle = "LoginPage";
        String expectedTitle = "LoginPag";

        // Asserting both strings are equal
        Assert.assertEquals(actualTitle, expectedTitle, "❌ Titles are not matching!");
        System.out.println("✅ assertEquals passed");
    }

    // ✅ Test case for assertNotEquals
    @Test
    void testAssertNotEquals() {
        int productCount = 5;
        int expectedCount = 10;

        // Asserting both counts are NOT equal
        Assert.assertNotEquals(productCount, expectedCount, "❌ Product counts should not match!");
        System.out.println("✅ assertNotEquals passed");
    }

    // ✅ Test case for assertTrue
    @Test
    void testAssertTrue() {
        boolean isUserLoggedIn = true;

        // Asserting the condition is true
        Assert.assertTrue(isUserLoggedIn, "❌ User should be logged in!");
        System.out.println("✅ assertTrue passed");
    }

    // ✅ Test case for assertFalse
    @Test
    void testAssertFalse() {
        boolean isErrorVisible = false;

        // Asserting the condition is false
        Assert.assertFalse(isErrorVisible, "❌ Error message should not be visible!");
        System.out.println("✅ assertFalse passed");
    }

    // ✅ Test case for assertNull
    @Test
    void testAssertNull() {
        String userName = null;

        // Asserting the object is null
        Assert.assertNull(userName, "❌ Username should be null by default!");
        System.out.println("✅ assertNull passed");
    }

    // ✅ Test case for assertNotNull
    @Test
    void testAssertNotNull() {
        String welcomeText = "Welcome, User!";

        // Asserting the object is not null
        Assert.assertNotNull(welcomeText, "❌ Welcome text should not be null!");
        System.out.println("✅ assertNotNull passed");
    }

}
