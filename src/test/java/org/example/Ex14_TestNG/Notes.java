package org.example.Ex14_TestNG;

import org.apache.hc.core5.reactor.Command;
import org.testng.annotations.Test;

public class Notes {

    @Test(priority = 1)
    void openapp(){
        System.out.println("Opening the web application");
    }

    @Test(priority = 2)
    void login(){
        System.out.println("Logging into application");
    }

    @Test(priority = 3)
    void logout(){
        System.out.println("Logging out of application");
    }
}
