package org.betterx.datagen.betterend.tags;

import org.betterx.betterend.registry.EndStructures;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverTagProvider;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class BiomeTagProvider extends WoverTagProvider.ForBiomes {
    public BiomeTagProvider(ModCore modCore) {
        super(modCore);
    }

    @Override
    protected void prepareTags(TagBootstrapContext<Biome> context) {
        context.add(
                EndStructures.ETERNAL_PORTAL.biomeTag,
                Biomes.END_BARRENS,
                Biomes.END_MIDLANDS,
                Biomes.END_HIGHLANDS
        );
    }
}
