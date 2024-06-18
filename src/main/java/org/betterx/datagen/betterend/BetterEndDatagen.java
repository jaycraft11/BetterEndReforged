package org.betterx.datagen.betterend;

import org.betterx.betterend.BetterEnd;
import org.betterx.datagen.betterend.advancement.EndAdvancementDataProvider;
import org.betterx.datagen.betterend.recipes.EndBlockLootTableProvider;
import org.betterx.datagen.betterend.recipes.EndChestLootTableProvider;
import org.betterx.datagen.betterend.recipes.EndRecipeDataProvider;
import org.betterx.datagen.betterend.recipes.JukeboxRegistryProvider;
import org.betterx.datagen.betterend.tags.BiomeTagProvider;
import org.betterx.datagen.betterend.tags.BlockTagProvider;
import org.betterx.datagen.betterend.tags.ItemTagProvider;
import org.betterx.datagen.betterend.worldgen.EndBiomeModificationProvider;
import org.betterx.datagen.betterend.worldgen.EndBiomesProvider;
import org.betterx.datagen.betterend.worldgen.StructureDataProvider;
import org.betterx.datagen.betterend.worldgen.features.*;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.PackBuilder;
import org.betterx.wover.datagen.api.WoverDataGenEntryPoint;

import net.minecraft.core.RegistrySetBuilder;

public class BetterEndDatagen extends WoverDataGenEntryPoint {
    @Override
    protected void onInitializeProviders(PackBuilder globalPack) {
        EndBiomesProvider.loadAllBiomeConfigs();

        globalPack.addMultiProvider(EndBiomesProvider::new);
        globalPack.addProvider(BlockTagProvider::new);
        globalPack.addProvider(ItemTagProvider::new);
        globalPack.addProvider(BiomeTagProvider::new);
        globalPack.addRegistryProvider(JukeboxRegistryProvider::new);
        globalPack.addMultiProvider(StructureDataProvider::new);
        globalPack.addMultiProvider(VegetationFeaturesProvider::new);
        globalPack.addMultiProvider(OreFeatureProvider::new);
        globalPack.addMultiProvider(LakeFeatureProvider::new);
        globalPack.addMultiProvider(TerrainFeatureProvider::new);
        globalPack.addMultiProvider(CaveFeatureProvider::new);
        globalPack.addProvider(EndBiomeModificationProvider::new);


        globalPack.callOnInitializeDatapack((generator, pack, location) -> {
            if (location == null) {
                pack.addProvider(EndRecipeDataProvider::new);
                pack.addProvider(EndAdvancementDataProvider::new);
                pack.addProvider(EndChestLootTableProvider::new);
                pack.addProvider(EndBlockLootTableProvider::new);
            }
        });
    }

    @Override
    protected ModCore modCore() {
        return BetterEnd.C;
    }

    @Override
    protected void onBuildRegistry(RegistrySetBuilder registryBuilder) {
        super.onBuildRegistry(registryBuilder);
        EndRegistrySupplier.INSTANCE.bootstrapRegistries(registryBuilder);

    }
}
