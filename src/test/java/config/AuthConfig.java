package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/auth.properties"
})
public interface AuthConfig extends Config {

    @DefaultValue("bsuser_hKP1tB")
    String login();

    @DefaultValue("XzrfCDpaXwxymkUa9jVP")
    String password();
}