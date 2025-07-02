package org.example.Ex14_TestNG.Grouping;

import org.testng.annotations.Test;

public class LoginTests {

    @Test(groups = {"smoke", "sanity"})
    void loginWithValidCredentials() {
        System.out.println("✅ Login with valid credentials");
    }

    @Test(groups = {"regression"})
    void loginWithInvalidPassword() {
        System.out.println("✅ Login with invalid password");
    }

    @Test(groups = {"regression"})
    void forgotPasswordLinkTest() {
        System.out.println("✅ Forgot Password link check");
    }

}
