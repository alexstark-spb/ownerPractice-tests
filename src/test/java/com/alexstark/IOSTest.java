package com.alexstark;

import com.alexstark.config.IOSConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IOSTest {

    private IOSConfig config;

    @Test
    public void testRemoteFile() {
        config = ConfigFactory.create(IOSConfig.class, System.getProperties());
        assertThat(config.appLocation()).isEqualTo("/Users/alexstark/Downloads/app.ios");
        assertThat(config.deviceName()).isEqualTo("IPhone 11");
        assertThat(config.platformName()).isEqualTo("IOS");
        assertThat(config.platformVersion()).isEqualTo("15.1");
    }


}