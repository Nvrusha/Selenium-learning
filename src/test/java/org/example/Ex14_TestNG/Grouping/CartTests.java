package org.example.Ex14_TestNG.Grouping;

import org.testng.annotations.Test;

public class CartTests {
    @Test(groups = {"sanity"})
    void addProductToCart() {
        System.out.println("✅ Add product to cart");
    }

    @Test(groups = {"regression"})
    void removeProductFromCart() {
        System.out.println("✅ Remove product from cart");
    }

    @Test(groups = {"smoke"})
    void verifyCartIconVisibility() {
        System.out.println("✅ Verify cart icon visibility");
    }
}
