package org.example.Ex14_TestNG.Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

    /*
     * ✅ Soft Assertion in TestNG
     *
     * ✅ Definition:
     *    - Soft assertions allow the test to continue execution even after assertion failures.
     *    - The test doesn't stop at the failure point.
     *
     * ✅ Provided By:
     *    - org.testng.asserts.SoftAssert class
     *
     * ✅ Behavior:
     *    - Even if a soft assertion fails, remaining lines of code will still execute.
     *    - But at the end, you must call assertAll() to collect and report all failures.
     *
     * ✅ Use Case:
     *    - When you want to validate multiple things in a single test method, but don’t want the test to stop mid-way.
     *
     * ✅ Example:
     */

    @Test
    void testSoftAssertions() {

        // ✅ Create SoftAssert object
        SoftAssert softAssert = new SoftAssert();

        // ✅ Test 1: assertEquals (intentionally failing)
        int actualCount = 5;
        int expectedCount = 10;
        softAssert.assertEquals(actualCount, expectedCount, "❌ Count mismatch!");

        // ✅ Test 2: assertTrue (will pass)
        boolean isLoggedIn = true;
        softAssert.assertTrue(isLoggedIn, "❌ User should be logged in!");

        // ✅ Test 3: assertFalse (will fail)
        boolean isErrorVisible = true;
        softAssert.assertFalse(isErrorVisible, "❌ Error should not be visible!");

        // ✅ Test 4: assertNotNull (will pass)
        String welcomeText = "Welcome!";
        softAssert.assertNotNull(welcomeText, "❌ Welcome text should not be null!");

        // ✅ Test 5: assertNull (will fail)
        String userName = "Admin";
        softAssert.assertNull(userName, "❌ Username should be null!");

        System.out.println("✅ This line prints even if some soft assertions failed...");

        // ✅ VERY IMPORTANT: This will collate and report all assertion failures at once
        softAssert.assertAll();
    }
}
