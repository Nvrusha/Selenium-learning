package org.example.Ex04_Selenium_Options_Locators;

public class OptionsClass_Notes {
    public static void main(String[] args) {
        // 1. Start Browser Maximized
        // options.addArguments("--start-maximized");

        // 2. Open Browser in Incognito Mode
        // options.addArguments("--incognito");

        // 3. Run Browser in Headless Mode (No GUI)
        // options.addArguments("--headless");
        // options.addArguments("--disable-gpu"); // For compatibility with headless mode

        // 4. Disable Browser Notifications
        // options.addArguments("--disable-notifications");

        // 5. Disable InfoBars (e.g., "Chrome is being controlled by automated software")
        // options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        // options.setExperimentalOption("useAutomationExtension", false);

        // 6. Add a Chrome Extension
        // options.addExtensions(new File("path/to/extension.crx"));

        // 7. Set Custom Download Directory
        // HashMap<String, Object> prefs = new HashMap<>();
        // prefs.put("download.default_directory", "/path/to/download");
        // options.setExperimentalOption("prefs", prefs);

        // 8. Disable Browser Sandbox (use cautiously)
        // options.addArguments("--no-sandbox");

        // 9. Disable GPU (useful for headless mode)
        // options.addArguments("--disable-gpu");

        // 10. Block Popups & Save Behavior
        // HashMap<String, Object> prefs = new HashMap<>();
        // prefs.put("profile.default_content_settings.popups", 0);  // Disable popups
        // prefs.put("download.prompt_for_download", false);  // Don't prompt for downloads
        // options.setExperimentalOption("prefs", prefs);

        // 11. Block Images (Speeds up tests)
        // HashMap<String, Object> prefs = new HashMap<>();
        // prefs.put("profile.managed_default_content_settings.images", 2);  // Block images
        // options.setExperimentalOption("prefs", prefs);

        // 12. Ignore SSL Certificate Warnings
        // options.addArguments("--ignore-certificate-errors");

        // 13. Emulate Mobile Devices (e.g., iPhone X)
        // HashMap<String, Object> mobileEmulation = new HashMap<>();
        // mobileEmulation.put("deviceName", "iPhone X");
        // options.setExperimentalOption("mobileEmulation", mobileEmulation);

        // 14. Set Custom User-Agent String
        // options.addArguments("user-agent=MyCustomUserAgent");

        // 15. Disable All Extensions
        // options.addArguments("--disable-extensions");

        // 16. Allow Running Insecure Content
        // options.addArguments("--allow-running-insecure-content");

        // 17. Set Proxy Server
        // options.addArguments("--proxy-server=http://proxy-address:port");

        // 18. Enable Verbose Logging
        // options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));
    }
}
