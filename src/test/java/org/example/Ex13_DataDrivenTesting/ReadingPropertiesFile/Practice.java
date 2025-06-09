package org.example.Ex13_DataDrivenTesting.ReadingPropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Practice {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        FileInputStream file = new FileInputStream(System.getProperty("user + dir") + "\\TestData\\Config.properties");

        properties.load(file);

        String url = properties.getProperty("url");
        String browser = properties.getProperty("browser");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String timeout = properties.getProperty("timeout");

        System.out.println(url + "" + browser + "" + username + "" + password + "" + timeout);
    }
}
