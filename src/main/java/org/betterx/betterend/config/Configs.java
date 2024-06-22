package org.betterx.betterend.config;

public class Configs {
    public static final GeneratorConfig GENERATOR_CONFIG = new GeneratorConfig();
    public static final ClientConfig CLENT_CONFIG = new ClientConfig();

    public static void saveConfigs() {
        org.betterx.wover.config.api.Configs.saveConfigs();
    }
}
