package com.alexstark;

import com.alexstark.config.AndroidConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AndroidTest {

    private AndroidConfig config;

    @Test
    public void testAndroid() {
        config = ConfigFactory.create(AndroidConfig.class, System.getProperties());
        assertThat(config.appLocation()).isEqualTo("/Users/alexstark/Downloads/app.android");
        assertThat(config.deviceName()).isEqualTo("Honor20Pro");
        assertThat(config.platformName()).isEqualTo("Android");
        assertThat(config.platformVersion()).isEqualTo("10");
    }

    @Test
    public void testAndroidOverride() {
        System.setProperty("device.name", "Honor20Pro");

        config = ConfigFactory.create(AndroidConfig.class, System.getProperties());
        assertThat(config.deviceName()).isEqualTo("Honor20Pro");

        assertThat(config.appLocation()).isEqualTo("/Users/alexstark/Downloads/app.android");
        assertThat(config.platformName()).isEqualTo("Android");
        assertThat(config.platformVersion()).isEqualTo("10");
    }
}