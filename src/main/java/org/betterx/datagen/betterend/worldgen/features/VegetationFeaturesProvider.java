package org.betterx.datagen.betterend.worldgen.features;

import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndConfiguredVegetationFeatures;
import org.betterx.betterend.registry.EndFeatures;
import org.betterx.betterend.registry.EndVegetationFeatures;
import org.betterx.betterend.world.features.*;
import org.betterx.betterend.world.features.bushes.BushFeatureConfig;
import org.betterx.betterend.world.features.bushes.BushWithOuterFeatureConfig;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.provider.multi.WoverFeatureProvider;
import org.betterx.wover.feature.api.placed.PlacedConfiguredFeatureKey;
import org.betterx.wover.feature.api.placed.PlacedFeatureKey;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import org.jetbrains.annotations.NotNull;

public class VegetationFeaturesProvider extends WoverFeatureProvider {
    public VegetationFeaturesProvider(@NotNull ModCore modCore) {
        super(modCore, modCore.id("vegetation"));
    }

    private static <F extends Feature<FC>, FC extends FeatureConfiguration> void registerVegetation(
            BootstrapContext<PlacedFeature> context,
            PlacedFeatureKey key,
            F feature,
            FC config,
            int density
    ) {
        key.inlineConfiguration(context)
           .configuration(feature)
           .configuration(config)
           .inlinePlace()
           .onEveryLayerMax(density)
           .onlyInBiome()
           .register();
    }

    private static <F extends Feature<FC>, FC extends FeatureConfiguration> void registerVegetation(
            BootstrapContext<PlacedFeature> context,
            PlacedConfiguredFeatureKey key,
            int density
    ) {
        key.place(context)
           .onEveryLayerMax(density)
           .onlyInBiome()
           .register();
    }

    private static <F extends Feature<FC>, FC extends FeatureConfiguration> void registerVegetation(
            BootstrapContext<PlacedFeature> context,
            PlacedFeatureKey key,
            F feature,
            int density
    ) {
        key
                .inlineConfiguration(context)
                .configuration(feature)
                .inlinePlace()
                .onEveryLayerMax(density)
                .onlyInBiome()
                .register();
    }

    @Override
    protected void bootstrapConfigured(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        //Bushes
        EndConfiguredVegetationFeatures.PYTHADENDRON_BUSH_CONFIGURATION
                .bootstrap(context)
                .configuration(new BushFeatureConfig(EndBlocks.PYTHADENDRON_LEAVES, EndBlocks.PYTHADENDRON.getBark()))
                .register();
        EndConfiguredVegetationFeatures.DRAGON_TREE_BUSH_CONFIGURATION
                .bootstrap(context)
                .configuration(new BushFeatureConfig(EndBlocks.DRAGON_TREE_LEAVES, EndBlocks.DRAGON_TREE.getBark()))
                .register();
        EndConfiguredVegetationFeatures.LUCERNIA_BUSH_CONFIGURATION
                .bootstrap(context)
                .configuration(new BushWithOuterFeatureConfig(EndBlocks.LUCERNIA_LEAVES, EndBlocks.LUCERNIA_OUTER_LEAVES, EndBlocks.LUCERNIA.getBark()))
                .register();
        EndConfiguredVegetationFeatures.LUCERNIA_BUSH_RARE_CONFIGURATION
                .bootstrap(context)
                .configuration(new BushWithOuterFeatureConfig(EndBlocks.LUCERNIA_LEAVES, EndBlocks.LUCERNIA_OUTER_LEAVES, EndBlocks.LUCERNIA.getBark()))
                .register();

        //Vines
        EndConfiguredVegetationFeatures.DENSE_VINE_CONFIGURATION
                .bootstrap(context)
                .configuration(new VineFeatureConfig(EndBlocks.DENSE_VINE, 24))
                .register();
        EndConfiguredVegetationFeatures.TWISTED_VINE_CONFIGURATION
                .bootstrap(context)
                .configuration(new VineFeatureConfig(EndBlocks.TWISTED_VINE, 24))
                .register();
        EndConfiguredVegetationFeatures.BULB_VINE_CONFIGURATION
                .bootstrap(context)
                .configuration(new VineFeatureConfig(EndBlocks.BULB_VINE, 24))
                .register();
        EndConfiguredVegetationFeatures.JUNGLE_VINE_CONFIGURATION
                .bootstrap(context)
                .configuration(new VineFeatureConfig(EndBlocks.JUNGLE_VINE, 24))
                .register();
        EndConfiguredVegetationFeatures.BLUE_VINE_CONFIGURATION
                .bootstrap(context)
                .configuration(ScatterFeatureConfig.blueVine())
                .register();

        // Ceil plants
        EndConfiguredVegetationFeatures.SMALL_JELLYSHROOM_CEIL_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.SMALL_JELLYSHROOM, 8))
                .register();

        // Wall Plants
        EndConfiguredVegetationFeatures.PURPLE_POLYPORE_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.PURPLE_POLYPORE, 3))
                .register();
        EndConfiguredVegetationFeatures.AURANT_POLYPORE_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.AURANT_POLYPORE, 3))
                .register();
        EndConfiguredVegetationFeatures.TAIL_MOSS_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.TAIL_MOSS, 3))
                .register();
        EndConfiguredVegetationFeatures.CYAN_MOSS_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.CYAN_MOSS, 3))
                .register();
        EndConfiguredVegetationFeatures.TAIL_MOSS_WOOD_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.TAIL_MOSS, 4))
                .register();
        EndConfiguredVegetationFeatures.CYAN_MOSS_WOOD_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.CYAN_MOSS, 4))
                .register();
        EndConfiguredVegetationFeatures.TWISTED_MOSS_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.TWISTED_MOSS, 6))
                .register();
        EndConfiguredVegetationFeatures.TWISTED_MOSS_WOOD_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.TWISTED_MOSS, 6))
                .register();
        EndConfiguredVegetationFeatures.BULB_MOSS_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.BULB_MOSS, 6))
                .register();
        EndConfiguredVegetationFeatures.BULB_MOSS_WOOD_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.BULB_MOSS, 6))
                .register();
        EndConfiguredVegetationFeatures.SMALL_JELLYSHROOM_WALL_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.SMALL_JELLYSHROOM, 4))
                .register();
        EndConfiguredVegetationFeatures.SMALL_JELLYSHROOM_WOOD_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.SMALL_JELLYSHROOM, 4))
                .register();
        EndConfiguredVegetationFeatures.JUNGLE_FERN_WOOD_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.JUNGLE_FERN, 3))
                .register();
        EndConfiguredVegetationFeatures.RUSCUS_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.RUSCUS, 6))
                .register();
        EndConfiguredVegetationFeatures.RUSCUS_WOOD_CONFIGURATION
                .bootstrap(context)
                .configuration(new WallPlantFeatureConfig(EndBlocks.RUSCUS, 6))
                .register();


        //Sky plants
        EndConfiguredVegetationFeatures.FILALUX_CONFIGURATION
                .bootstrap(context)
                .configuration(ScatterFeatureConfig.filalux())
                .register();

        // Water
        EndConfiguredVegetationFeatures.BUBBLE_CORAL_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.BUBBLE_CORAL, 6))
                .register();
        EndConfiguredVegetationFeatures.BUBBLE_CORAL_RARE_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.BUBBLE_CORAL, 3))
                .register();
        EndConfiguredVegetationFeatures.END_LILY_CONFIGURATION
                .bootstrap(context)
                .configuration(new ScatterFeatureConfig(6))
                .register();
        EndConfiguredVegetationFeatures.END_LILY_RARE_CONFIGURATION
                .bootstrap(context)
                .configuration(new ScatterFeatureConfig(3))
                .register();
        EndConfiguredVegetationFeatures.END_LOTUS_CONFIGURATION
                .bootstrap(context)
                .configuration(new ScatterFeatureConfig(7))
                .register();
        EndConfiguredVegetationFeatures.END_LOTUS_LEAF_CONFIGURATION
                .bootstrap(context)
                .configuration(new ScatterFeatureConfig(20))
                .register();
        EndConfiguredVegetationFeatures.HYDRALUX_CONFIGURATION
                .bootstrap(context)
                .configuration(new ScatterFeatureConfig(5))
                .register();
        EndConfiguredVegetationFeatures.POND_ANEMONE_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.POND_ANEMONE, 6))
                .register();
        EndConfiguredVegetationFeatures.MENGER_SPONGE_CONFIGURATION
                .bootstrap(context)
                .configuration(new ScatterFeatureConfig(5))
                .register();
        EndConfiguredVegetationFeatures.FLAMAEA_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.FLAMAEA, 12, false, 5))
                .register();
        EndConfiguredVegetationFeatures.CHARNIA_RED_CONFIGURATION
                .bootstrap(context)
                .configuration(SinglePlantFeatureConfig.charnia(EndBlocks.CHARNIA_RED))
                .register();
        EndConfiguredVegetationFeatures.CHARNIA_PURPLE_CONFIGURATION
                .bootstrap(context)
                .configuration(SinglePlantFeatureConfig.charnia(EndBlocks.CHARNIA_PURPLE))
                .register();
        EndConfiguredVegetationFeatures.CHARNIA_CYAN_CONFIGURATION
                .bootstrap(context)
                .configuration(SinglePlantFeatureConfig.charnia(EndBlocks.CHARNIA_CYAN))
                .register();
        EndConfiguredVegetationFeatures.CHARNIA_LIGHT_BLUE_CONFIGURATION
                .bootstrap(context)
                .configuration(SinglePlantFeatureConfig.charnia(EndBlocks.CHARNIA_LIGHT_BLUE))
                .register();
        EndConfiguredVegetationFeatures.CHARNIA_ORANGE_CONFIGURATION
                .bootstrap(context)
                .configuration(SinglePlantFeatureConfig.charnia(EndBlocks.CHARNIA_ORANGE))
                .register();
        EndConfiguredVegetationFeatures.CHARNIA_GREEN_CONFIGURATION
                .bootstrap(context)
                .configuration(SinglePlantFeatureConfig.charnia(EndBlocks.CHARNIA_GREEN))
                .register();
        EndConfiguredVegetationFeatures.CHARNIA_RED_RARE_CONFIGURATION
                .bootstrap(context)
                .configuration(SinglePlantFeatureConfig.charnia(EndBlocks.CHARNIA_RED))
                .register();

        // Plants
        EndConfiguredVegetationFeatures.UMBRELLA_MOSS_CONFIGURATION
                .bootstrap(context)
                .configuration(new DoublePlantFeatureConfig(EndBlocks.UMBRELLA_MOSS, EndBlocks.UMBRELLA_MOSS_TALL, 5))
                .register();
        EndConfiguredVegetationFeatures.CREEPING_MOSS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.CREEPING_MOSS, 5))
                .register();
        EndConfiguredVegetationFeatures.CHORUS_GRASS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.CHORUS_GRASS, 4))
                .register();
        EndConfiguredVegetationFeatures.CRYSTAL_GRASS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.CRYSTAL_GRASS, 8, false))
                .register();
        EndConfiguredVegetationFeatures.SHADOW_PLANT_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.SHADOW_PLANT, 6))
                .register();
        EndConfiguredVegetationFeatures.MURKWEED_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.MURKWEED, 3))
                .register();
        EndConfiguredVegetationFeatures.NEEDLEGRASS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.NEEDLEGRASS, 3))
                .register();
        EndConfiguredVegetationFeatures.SHADOW_BERRY_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.SHADOW_BERRY, 2))
                .register();
        EndConfiguredVegetationFeatures.BUSHY_GRASS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.BUSHY_GRASS, 8, false))
                .register();
        EndConfiguredVegetationFeatures.BUSHY_GRASS_WG_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.BUSHY_GRASS, 5))
                .register();
        EndConfiguredVegetationFeatures.AMBER_GRASS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.AMBER_GRASS, 6))
                .register();
        EndConfiguredVegetationFeatures.TWISTED_UMBRELLA_MOSS_CONFIGURATION
                .bootstrap(context)
                .configuration(new DoublePlantFeatureConfig(EndBlocks.TWISTED_UMBRELLA_MOSS, EndBlocks.TWISTED_UMBRELLA_MOSS_TALL, 6))
                .register();
        EndConfiguredVegetationFeatures.JUNGLE_GRASS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.JUNGLE_GRASS, 7, 3))
                .register();
        EndConfiguredVegetationFeatures.SMALL_JELLYSHROOM_FLOOR_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.SMALL_JELLYSHROOM, 5, 5))
                .register();
        EndConfiguredVegetationFeatures.BLOSSOM_BERRY_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.BLOSSOM_BERRY, 4, 4))
                .register();
        EndConfiguredVegetationFeatures.BLOOMING_COOKSONIA_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.BLOOMING_COOKSONIA, 5))
                .register();
        EndConfiguredVegetationFeatures.SALTEAGO_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.SALTEAGO, 5))
                .register();
        EndConfiguredVegetationFeatures.VAIOLUSH_FERN_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.VAIOLUSH_FERN, 5))
                .register();
        EndConfiguredVegetationFeatures.FRACTURN_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.FRACTURN, 5))
                .register();
        EndConfiguredVegetationFeatures.UMBRELLA_MOSS_RARE_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.UMBRELLA_MOSS, 3))
                .register();
        EndConfiguredVegetationFeatures.CREEPING_MOSS_RARE_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.CREEPING_MOSS, 3))
                .register();
        EndConfiguredVegetationFeatures.TWISTED_UMBRELLA_MOSS_RARE_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.TWISTED_UMBRELLA_MOSS, 3))
                .register();
        EndConfiguredVegetationFeatures.ORANGO_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.ORANGO, 5))
                .register();
        EndConfiguredVegetationFeatures.AERIDIUM_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.AERIDIUM, 5, 4))
                .register();
        EndConfiguredVegetationFeatures.LUTEBUS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.LUTEBUS, 5, 2))
                .register();
        EndConfiguredVegetationFeatures.LAMELLARIUM_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.LAMELLARIUM, 5))
                .register();
        EndConfiguredVegetationFeatures.SMALL_AMARANITA_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.SMALL_AMARANITA_MUSHROOM, 5, 5))
                .register();
        EndConfiguredVegetationFeatures.GLOBULAGUS_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.GLOBULAGUS, 5, 3))
                .register();
        EndConfiguredVegetationFeatures.CLAWFERN_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.CLAWFERN, 5, 4))
                .register();
        EndConfiguredVegetationFeatures.BOLUX_MUSHROOM_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.BOLUX_MUSHROOM, 5, 5))
                .register();
        EndConfiguredVegetationFeatures.CHORUS_MUSHROOM_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.CHORUS_MUSHROOM, 3, 5))
                .register();
        EndConfiguredVegetationFeatures.AMBER_ROOT_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.AMBER_ROOT, 5, 5))
                .register();
        EndConfiguredVegetationFeatures.INFLEXIA_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.INFLEXIA, 7, false, 3))
                .register();
        EndConfiguredVegetationFeatures.FLAMMALIX_CONFIGURATION
                .bootstrap(context)
                .configuration(new SinglePlantFeatureConfig(EndBlocks.FLAMMALIX, 3, false, 7))
                .register();
        EndConfiguredVegetationFeatures.LANCELEAF_CONFIGURATION
                .bootstrap(context)
                .configuration(ScatterFeatureConfig.lanceleaf())
                .register();
        EndConfiguredVegetationFeatures.GLOW_PILLAR_CONFIGURATION
                .bootstrap(context)
                .configuration(ScatterFeatureConfig.glowPillar())
                .register();

    }

    @Override
    protected void bootstrapPlaced(BootstrapContext<PlacedFeature> context) {
        //Trees
        registerVegetation(context, EndVegetationFeatures.MOSSY_GLOWSHROOM, EndFeatures.MOSSY_GLOWSHROOM_FEATURE, 2);
        registerVegetation(context, EndVegetationFeatures.PYTHADENDRON_TREE, EndFeatures.PYTHADENDRON_TREE_FEATURE, 1);
        registerVegetation(context, EndVegetationFeatures.LACUGROVE, EndFeatures.LACUGROVE_FEATURE, 4);
        registerVegetation(context, EndVegetationFeatures.DRAGON_TREE, EndFeatures.DRAGON_TREE_FEATURE, 2);
        registerVegetation(context, EndVegetationFeatures.TENANEA, EndFeatures.TENANEA_FEATURE, 3);
        registerVegetation(context, EndVegetationFeatures.HELIX_TREE, EndFeatures.HELIX_TREE_FEATURE, 1);
        registerVegetation(context, EndVegetationFeatures.UMBRELLA_TREE, EndFeatures.UMBRELLA_TREE_FEATURE, 2);
        registerVegetation(context, EndVegetationFeatures.JELLYSHROOM, EndFeatures.JELLYSHROOM_FEATURE, 2);
        registerVegetation(context, EndVegetationFeatures.GIGANTIC_AMARANITA, EndFeatures.GIGANTIC_AMARANITA_FEATURE, 1);
        registerVegetation(context, EndVegetationFeatures.LUCERNIA, EndFeatures.LUCERNIA_FEATURE, 3);

        //Bushes
        registerVegetation(context, EndVegetationFeatures.TENANEA_BUSH, EndFeatures.TENANEA_BUSH_FEATURE, 12);
        registerVegetation(context, EndVegetationFeatures.LUMECORN, EndFeatures.LUMECORN_FEATURE, 5);
        registerVegetation(context, EndVegetationFeatures.LARGE_AMARANITA, EndFeatures.LARGE_AMARANITA_FEATURE, 5);
        registerVegetation(context, EndVegetationFeatures.NEON_CACTUS, EndFeatures.NEON_CACTUS_FEATURE, 2);
        registerVegetation(context, EndVegetationFeatures.PYTHADENDRON_BUSH, 3);
        registerVegetation(context, EndVegetationFeatures.DRAGON_TREE_BUSH, 5);
        registerVegetation(context, EndVegetationFeatures.LUCERNIA_BUSH, 10);
        registerVegetation(context, EndVegetationFeatures.LUCERNIA_BUSH_RARE, 1);

        //Vines
        registerVegetation(context, EndVegetationFeatures.DENSE_VINE, 3);
        registerVegetation(context, EndVegetationFeatures.TWISTED_VINE, 1);
        registerVegetation(context, EndVegetationFeatures.BULB_VINE, 5);
        registerVegetation(context, EndVegetationFeatures.JUNGLE_VINE, 5);
        registerVegetation(context, EndVegetationFeatures.BLUE_VINE, 1);

        // Ceil plants
        registerVegetation(context, EndVegetationFeatures.SMALL_JELLYSHROOM_CEIL, 8);

        // Wall Plants
        registerVegetation(context, EndVegetationFeatures.PURPLE_POLYPORE, 5);
        registerVegetation(context, EndVegetationFeatures.AURANT_POLYPORE, 5);
        registerVegetation(context, EndVegetationFeatures.TAIL_MOSS, 15);
        registerVegetation(context, EndVegetationFeatures.CYAN_MOSS, 15);
        registerVegetation(context, EndVegetationFeatures.TAIL_MOSS_WOOD, 25);
        registerVegetation(context, EndVegetationFeatures.CYAN_MOSS_WOOD, 25);
        registerVegetation(context, EndVegetationFeatures.TWISTED_MOSS, 15);
        registerVegetation(context, EndVegetationFeatures.TWISTED_MOSS_WOOD, 25);
        registerVegetation(context, EndVegetationFeatures.BULB_MOSS, 1);
        registerVegetation(context, EndVegetationFeatures.BULB_MOSS_WOOD, 15);
        registerVegetation(context, EndVegetationFeatures.SMALL_JELLYSHROOM_WALL, 4);
        registerVegetation(context, EndVegetationFeatures.SMALL_JELLYSHROOM_WOOD, 8);
        registerVegetation(context, EndVegetationFeatures.JUNGLE_FERN_WOOD, 12);
        registerVegetation(context, EndVegetationFeatures.RUSCUS, 10);
        registerVegetation(context, EndVegetationFeatures.RUSCUS_WOOD, 10);

        //Sky plants
        registerVegetation(context, EndVegetationFeatures.FILALUX, 1);

        // Water
        registerVegetation(context, EndVegetationFeatures.BUBBLE_CORAL, 10);
        registerVegetation(context, EndVegetationFeatures.BUBBLE_CORAL_RARE, 4);
        registerVegetation(context, EndVegetationFeatures.END_LILY, 10);
        registerVegetation(context, EndVegetationFeatures.END_LILY_RARE, 4);
        registerVegetation(context, EndVegetationFeatures.END_LOTUS, 6);
        registerVegetation(context, EndVegetationFeatures.END_LOTUS_LEAF, 4);
        registerVegetation(context, EndVegetationFeatures.HYDRALUX, 5);
        registerVegetation(context, EndVegetationFeatures.POND_ANEMONE, 10);
        registerVegetation(context, EndVegetationFeatures.MENGER_SPONGE, 1);
        registerVegetation(context, EndVegetationFeatures.FLAMAEA, 20);
        registerVegetation(context, EndVegetationFeatures.CHARNIA_RED, 10);
        registerVegetation(context, EndVegetationFeatures.CHARNIA_PURPLE, 10);
        registerVegetation(context, EndVegetationFeatures.CHARNIA_CYAN, 10);
        registerVegetation(context, EndVegetationFeatures.CHARNIA_LIGHT_BLUE, 10);
        registerVegetation(context, EndVegetationFeatures.CHARNIA_ORANGE, 10);
        registerVegetation(context, EndVegetationFeatures.CHARNIA_GREEN, 10);
        registerVegetation(context, EndVegetationFeatures.CHARNIA_RED_RARE, 2);

        // Plants
        registerVegetation(context, EndVegetationFeatures.UMBRELLA_MOSS, 3);
        registerVegetation(context, EndVegetationFeatures.CREEPING_MOSS, 3);
        registerVegetation(context, EndVegetationFeatures.CHORUS_GRASS, 3);
        registerVegetation(context, EndVegetationFeatures.CRYSTAL_GRASS, 5);
        registerVegetation(context, EndVegetationFeatures.SHADOW_PLANT, 5);
        registerVegetation(context, EndVegetationFeatures.MURKWEED, 2);
        registerVegetation(context, EndVegetationFeatures.NEEDLEGRASS, 1);
        registerVegetation(context, EndVegetationFeatures.SHADOW_BERRY, 1);
        registerVegetation(context, EndVegetationFeatures.BUSHY_GRASS, 10);
        registerVegetation(context, EndVegetationFeatures.BUSHY_GRASS_WG, 8);
        registerVegetation(context, EndVegetationFeatures.AMBER_GRASS, 7);
        registerVegetation(context, EndVegetationFeatures.TWISTED_UMBRELLA_MOSS, 3);
        registerVegetation(context, EndVegetationFeatures.JUNGLE_GRASS, 6);
        registerVegetation(context, EndVegetationFeatures.SMALL_JELLYSHROOM_FLOOR, 2);
        registerVegetation(context, EndVegetationFeatures.BLOSSOM_BERRY, 3);
        registerVegetation(context, EndVegetationFeatures.BLOOMING_COOKSONIA, 5);
        registerVegetation(context, EndVegetationFeatures.SALTEAGO, 5);
        registerVegetation(context, EndVegetationFeatures.VAIOLUSH_FERN, 5);
        registerVegetation(context, EndVegetationFeatures.FRACTURN, 5);
        registerVegetation(context, EndVegetationFeatures.UMBRELLA_MOSS_RARE, 2);
        registerVegetation(context, EndVegetationFeatures.CREEPING_MOSS_RARE, 2);
        registerVegetation(context, EndVegetationFeatures.TWISTED_UMBRELLA_MOSS_RARE, 2);
        registerVegetation(context, EndVegetationFeatures.ORANGO, 6);
        registerVegetation(context, EndVegetationFeatures.AERIDIUM, 5);
        registerVegetation(context, EndVegetationFeatures.LUTEBUS, 5);
        registerVegetation(context, EndVegetationFeatures.LAMELLARIUM, 6);
        registerVegetation(context, EndVegetationFeatures.SMALL_AMARANITA, 4);
        registerVegetation(context, EndVegetationFeatures.GLOBULAGUS, 6);
        registerVegetation(context, EndVegetationFeatures.CLAWFERN, 5);
        registerVegetation(context, EndVegetationFeatures.BOLUX_MUSHROOM, 2);
        registerVegetation(context, EndVegetationFeatures.CHORUS_MUSHROOM, 1);
        registerVegetation(context, EndVegetationFeatures.AMBER_ROOT, 1);
        registerVegetation(context, EndVegetationFeatures.INFLEXIA, 16);
        registerVegetation(context, EndVegetationFeatures.FLAMMALIX, 5);
        registerVegetation(context, EndVegetationFeatures.LANCELEAF, 2);
        registerVegetation(context, EndVegetationFeatures.GLOW_PILLAR, 1);
    }
}
