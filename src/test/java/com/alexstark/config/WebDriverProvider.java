package com.alexstark.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final SimpleWebDriverConfig CONFIG;

    public WebDriverProvider(final SimpleWebDriverConfig CONFIG) {

        this.CONFIG = CONFIG;
    }

    @Override
    public WebDriver get() {
        if (CONFIG.getBrowser().equals(Browser.FIREFOX)) {
            return new FirefoxDriver();
        }
        return new ChromeDriver();
    }
}
