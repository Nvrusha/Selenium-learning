package org.example.TestNG.Annotations;

import org.testng.annotations.*;

public class AllAnnotations {

    @BeforeSuite
    void BS(){
        System.out.println("Before suite..");
    }
    @AfterSuite
    void AS(){
        System.out.println("After suite..");
        System.out.println();
    }

    @BeforeTest
    void BT(){
        System.out.println("Before Test..");
    }
    @AfterTest
    void AT(){
        System.out.println("After Test..");
    }

    @BeforeClass
    void BC(){
        System.out.println("Before Class..");
    }
    @AfterClass
    void AC(){
        System.out.println("After class..");
    }

    @BeforeMethod
    void BM(){
        System.out.println("Before Method..");
    }
    @AfterMethod
    void AM(){
        System.out.println("After Method..");
    }

    @Test
    void test1(){
        System.out.println("This is a test 1...");
    }
    @Test
    void test2(){
        System.out.println("This is a test 2...");
    }

}
