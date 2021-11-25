package com.alexstark;

import com.alexstark.config.WebDriverConfig;
import com.alexstark.config.WebDriverProvider;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTests extends TestBase {

    private final WebDriverConfig config = new WebDriverConfig();

    private final WebDriverProvider provider = new WebDriverProvider(config);

    @Test
    public void testTitle()  {
        WebDriver driver = provider.get();
        driver.get(config.getBaseUrl());
        assertEquals(
                "GitHub: Where the world builds software · GitHub",
                driver.getTitle()
        );
        driver.quit();
    }

}
