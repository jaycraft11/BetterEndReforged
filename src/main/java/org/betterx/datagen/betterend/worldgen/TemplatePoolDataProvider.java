package org.betterx.datagen.betterend.worldgen;

import org.betterx.betterend.world.structures.village.VillagePools;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class TemplatePoolDataProvider {

    public static void buildStructures() {

    }

    public static void bootstrap(BootstrapContext<StructureTemplatePool> ctx) {
        VillagePools.bootstrap(ctx);
    }
}
