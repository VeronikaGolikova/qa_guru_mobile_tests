package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @DefaultValue("Galaxy S21")
    @Config.Key("device")
    String device();

    @DefaultValue("11")
    @Config.Key("version")
    String version();

    @DefaultValue("https://hub.browserstack.com/wd/hub")
    @Config.Key("remoteUrl")
    String remoteUrl();
}