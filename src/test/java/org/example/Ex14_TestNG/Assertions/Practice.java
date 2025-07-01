package org.example.Ex14_TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice {

    @Test
    void test(){
        String expectedName = "Vrushali";
        String actualName = "vrushali";

        Assert.assertEquals(expectedName,actualName);
    }


}
