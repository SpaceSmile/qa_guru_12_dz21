package com.browserstack.helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config{

    String username();

    String accessKey();

    String project();

    String build();

    String name();

    String app();

    String device();

    String osVersion();

    String baseUrl();

    String sessionsUrl();

}
