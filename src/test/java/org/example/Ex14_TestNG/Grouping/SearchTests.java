package org.example.Ex14_TestNG.Grouping;

import org.testng.annotations.Test;

public class SearchTests {
    @Test(groups = {"sanity", "smoke", "functional"})
    void searchWithValidKeyword() {
        System.out.println("✅ Search with valid keyword");
    }

    @Test(groups = {"regression"})
    void searchWithInvalidKeyword() {
        System.out.println("✅ Search with invalid keyword");
    }

    @Test(groups = {"regression"})
    void searchResultCountTest() {
        System.out.println("✅ Search result count verification");
    }
}
