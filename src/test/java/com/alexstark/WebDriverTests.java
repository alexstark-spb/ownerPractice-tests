package com.alexstark;

import com.alexstark.config.HugeWebDriverConfig;
import com.alexstark.config.SimpleWebDriverConfig;
import com.alexstark.config.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTests extends TestBase {

//    private final HugeWebDriverConfig config = new HugeWebDriverConfig();

    private final SimpleWebDriverConfig simpleConfig =
            ConfigFactory.create(SimpleWebDriverConfig.class, System.getProperties());

    private final WebDriverProvider provider = new WebDriverProvider(simpleConfig);

    @Test
    public void testTitle()  {
        WebDriver driver = provider.get();
        driver.get(simpleConfig.getBaseUrl());
        assertEquals(
                "GitHub: Where the world builds software · GitHub",
                driver.getTitle()
        );
        driver.quit();
    }

}
