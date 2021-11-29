package com.alexstark;

import com.alexstark.config.WebConfig;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void setupBeforeAll() {

        if (System.getProperty("stage") != null) {
            WebConfig config = ConfigFactory
                    .create(WebConfig.class, System.getProperties());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
            Configuration.browser = config.getBrowser();
            Configuration.browserVersion = config.getVersion();
            Configuration.browserSize = config.getSize();
            if (config.isRemote()) {
                String login = config.selenideLogin();
                String password = config.selenidePassword();
                String url = config.getRemoteUrl();
                Configuration.remote = String.format("https://%s:%s@%s", login, password, url);
            }
        }
    }
}
