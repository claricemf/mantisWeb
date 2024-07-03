package config;

import org.aeonbits.owner.ConfigCache;

public class GeneralConfigManager {

    private GeneralConfigManager(){
    }

    public static GeneralConfig configuration() {
        return ConfigCache.getOrCreate(GeneralConfig.class);
    }
}
