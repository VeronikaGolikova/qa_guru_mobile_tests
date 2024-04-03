package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @DefaultValue("Google Pixel 3")
    String device();

    @DefaultValue("9.0")
    String version();

    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String remoteUrl();
}