package org.betterx.datagen.betterend.worldgen;

import org.betterx.bclib.api.v3.levelgen.features.BCLFeatureBuilder;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ConfiguredFeatureDataProvider {
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> ctx) {
        BCLFeatureBuilder.registerUnbound(ctx);
    }
}
