package org.betterx.datagen.betterend.worldgen;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndStructures;
import org.betterx.wover.biome.api.modification.BiomeModification;
import org.betterx.wover.biome.api.modification.BiomeModificationRegistry;
import org.betterx.wover.biome.api.modification.predicates.BiomePredicate;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverRegistryContentProvider;

import net.minecraft.data.worldgen.BootstrapContext;

public class EndBiomeModificationProvider extends WoverRegistryContentProvider<BiomeModification> {
    public EndBiomeModificationProvider(
            ModCore modCore
    ) {
        super(modCore, "BetterEnd - Biome Modifications", BiomeModificationRegistry.BIOME_MODIFICATION_REGISTRY);
    }

    @Override
    protected void bootstrap(BootstrapContext<BiomeModification> context) {
        BiomeModification
                .build(context, BetterEnd.C.id("eternal_portals"))
                .not(
                        BiomePredicate.or(
                                BiomePredicate.inNamespace("minecraft"),
                                BiomePredicate.inNamespace(BetterEnd.C),
                                BiomePredicate.pathContains("mountain"),
                                BiomePredicate.pathContains("lake")
                        )
                )
                .addStructureSet(EndStructures.ETERNAL_PORTAL)
                .register();
    }
}
