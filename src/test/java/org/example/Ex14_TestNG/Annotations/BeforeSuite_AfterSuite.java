package org.example.Ex14_TestNG.Annotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeSuite_AfterSuite {

    @Test
    void test1(){
        System.out.println("This is a test..");
    }

    @BeforeSuite
    void BS(){
        System.out.println("This is Before suite...");
    }

    @AfterSuite
    void AS(){
        System.out.println("This is After suite...");
    }
}
