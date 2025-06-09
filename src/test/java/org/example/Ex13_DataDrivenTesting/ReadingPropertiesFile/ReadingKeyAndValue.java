package org.example.Ex13_DataDrivenTesting.ReadingPropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * ✅ Test Case: Read Configuration from Properties File
 * -----------------------------------------------------
 * 🎯 Objective:
 *     Verify that the application can successfully read and print key-value pairs
 *     from a properties file located in the TestData directory.
 *
 * 🧪 Steps:
 *   1. Load 'Config.properties' using FileInputStream.
 *   2. Read values for keys: url, browser, username, password, timeout.
 *   3. Print these values to validate correct loading.
 *   4. Retrieve and print all keys using stringPropertyNames().
 *
 * ✅ Expected Result:
 *   - All values should print without errors.
 *   - All property keys should be displayed.
 *   - File should close properly after reading.
 */

public class ReadingKeyAndValue {
    public static void main(String[] args) throws IOException {

        // Create a Properties object to hold key-value pairs
        Properties properties = new Properties();

        // Load the properties file using FileInputStream
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/TestData/Config.properties");

        // Load all key-value pairs from the file into the properties object
        properties.load(file);

        // Retrieve specific property values using getProperty()
        String url = properties.getProperty("url");
        String browser = properties.getProperty("browser");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String timeout = properties.getProperty("timeout");

        // Print the configuration values for verification
        System.out.println("URL: " + url);
        System.out.println("Browser: " + browser);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Timeout: " + timeout);

        // Print a separator for clarity
        System.out.println("---------- All Keys ----------");

        // Get and print all the keys in the properties file
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(key);
        }

        // Close the FileInputStream
        file.close();
    }
}
