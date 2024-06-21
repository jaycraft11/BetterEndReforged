package org.betterx.betterend.config;

import org.betterx.bclib.BCLib;
import org.betterx.bclib.config.PathConfig;
import org.betterx.betterend.BetterEnd;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class Configs {
    public static final PathConfig GENERATOR_CONFIG = new PathConfig(BetterEnd.MOD_ID, "generator", false);

    @Environment(value = EnvType.CLIENT)
    public static final PathConfig CLENT_CONFIG = new PathConfig(BetterEnd.MOD_ID, "client", false);

    public static void saveConfigs() {
        GENERATOR_CONFIG.saveChanges();

        if (BCLib.isClient()) {
            CLENT_CONFIG.saveChanges();
        }
    }
}
