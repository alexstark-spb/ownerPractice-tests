package com.alexstark;

import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static final String BASE_URL = "https://github.com";

    @BeforeAll
    static void setupBeforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:/BrowserDrivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:/BrowserDrivers/geckodriver.exe");
    }
}
