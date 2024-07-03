package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:general.properties"})
public interface GeneralConfig extends Config {
    @Config.Key("url.base")
    String url();

    @Config.Key("user")
    String user();

    @Config.Key("password")
    String password();

    @Config.Key("timeout")
    long timeout();

    @Config.Key("webdriver.chrome.driver")
    String chromeDriver();
}
