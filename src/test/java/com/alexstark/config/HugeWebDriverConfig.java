package com.alexstark.config;

import java.net.MalformedURLException;
import java.net.URL;

public class HugeWebDriverConfig {

    public URL getRemoteUrl() {
        String remoteUrl = System.getProperty("remoteUrl");
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPort() {
        String port = System.getProperty("port");
        return Integer.parseInt(port);
    }

    public Browser getBrowser() {

        return Browser.valueOf(System.getProperty("browser"));
    }

    public String getBaseUrl() {
        return System.getProperty("baseUrl");
    }
}
