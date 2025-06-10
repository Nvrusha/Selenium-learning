package org.example.Ex13_DataDrivenTesting.ReadingPropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadingValue {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\Config.properties");

        properties.load(file);

        Set<String> keys = properties.stringPropertyNames();

        System.out.println(keys);
    }
}
