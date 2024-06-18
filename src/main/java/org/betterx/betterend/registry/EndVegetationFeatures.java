package org.betterx.betterend.registry;

import org.betterx.betterend.BetterEnd;
import org.betterx.wover.feature.api.configured.ConfiguredFeatureKey;
import org.betterx.wover.feature.api.configured.configurators.WithConfiguration;
import org.betterx.wover.feature.api.placed.PlacedConfiguredFeatureKey;
import org.betterx.wover.feature.api.placed.PlacedFeatureKey;
import org.betterx.wover.feature.api.placed.PlacedFeatureManager;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class EndVegetationFeatures {
    //Trees
    public static final PlacedFeatureKey MOSSY_GLOWSHROOM = createVegetationKey("mossy_glowshroom");
    public static final PlacedFeatureKey PYTHADENDRON_TREE = createVegetationKey("pythadendron_tree");
    public static final PlacedFeatureKey LACUGROVE = createVegetationKey("lacugrove");
    public static final PlacedFeatureKey DRAGON_TREE = createVegetationKey("dragon_tree");
    public static final PlacedFeatureKey TENANEA = createVegetationKey("tenanea");
    public static final PlacedFeatureKey HELIX_TREE = createVegetationKey("helix_tree");
    public static final PlacedFeatureKey UMBRELLA_TREE = createVegetationKey("umbrella_tree");
    public static final PlacedFeatureKey JELLYSHROOM = createVegetationKey("jellyshroom");
    public static final PlacedFeatureKey GIGANTIC_AMARANITA = createVegetationKey("gigantic_amaranita");
    public static final PlacedFeatureKey LUCERNIA = createVegetationKey("lucernia");

    //Bushes
    public static final PlacedFeatureKey TENANEA_BUSH = createVegetationKey("tenanea_bush");
    public static final PlacedFeatureKey LUMECORN = createVegetationKey("lumecorn");
    public static final PlacedFeatureKey LARGE_AMARANITA = createVegetationKey("large_amaranita");
    public static final PlacedFeatureKey NEON_CACTUS = createVegetationKey("neon_cactus");
    public static final PlacedConfiguredFeatureKey PYTHADENDRON_BUSH = createVegetationKey("pythadendron_bush", EndConfiguredVegetationFeatures.PYTHADENDRON_BUSH_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey DRAGON_TREE_BUSH = createVegetationKey("dragon_tree_bush", EndConfiguredVegetationFeatures.DRAGON_TREE_BUSH_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey LUCERNIA_BUSH = createVegetationKey("lucernia_bush", EndConfiguredVegetationFeatures.LUCERNIA_BUSH_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey LUCERNIA_BUSH_RARE = createVegetationKey("lucernia_bush_rare", EndConfiguredVegetationFeatures.LUCERNIA_BUSH_RARE_CONFIGURATION);

    //Vines
    public static final PlacedConfiguredFeatureKey DENSE_VINE = createVegetationKey("dense_vine", EndConfiguredVegetationFeatures.DENSE_VINE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey TWISTED_VINE = createVegetationKey("twisted_vine", EndConfiguredVegetationFeatures.TWISTED_VINE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BULB_VINE = createVegetationKey("bulb_vine", EndConfiguredVegetationFeatures.BULB_VINE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey JUNGLE_VINE = createVegetationKey("jungle_vine", EndConfiguredVegetationFeatures.JUNGLE_VINE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BLUE_VINE = createVegetationKey("blue_vine", EndConfiguredVegetationFeatures.BLUE_VINE_CONFIGURATION);

    // Ceil plants
    public static final PlacedConfiguredFeatureKey SMALL_JELLYSHROOM_CEIL = createVegetationKey("small_jellyshroom_ceil", EndConfiguredVegetationFeatures.SMALL_JELLYSHROOM_CEIL_CONFIGURATION);

    // Wall Plants
    public static final PlacedConfiguredFeatureKey PURPLE_POLYPORE = createVegetationKey("purple_polypore", EndConfiguredVegetationFeatures.PURPLE_POLYPORE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey AURANT_POLYPORE = createVegetationKey("aurant_polypore", EndConfiguredVegetationFeatures.AURANT_POLYPORE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey TAIL_MOSS = createVegetationKey("tail_moss", EndConfiguredVegetationFeatures.TAIL_MOSS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CYAN_MOSS = createVegetationKey("cyan_moss", EndConfiguredVegetationFeatures.CYAN_MOSS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey TAIL_MOSS_WOOD = createVegetationKey("tail_moss_wood", EndConfiguredVegetationFeatures.TAIL_MOSS_WOOD_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CYAN_MOSS_WOOD = createVegetationKey("cyan_moss_wood", EndConfiguredVegetationFeatures.CYAN_MOSS_WOOD_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey TWISTED_MOSS = createVegetationKey("twisted_moss", EndConfiguredVegetationFeatures.TWISTED_MOSS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey TWISTED_MOSS_WOOD = createVegetationKey("twisted_moss_wood", EndConfiguredVegetationFeatures.TWISTED_MOSS_WOOD_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BULB_MOSS = createVegetationKey("bulb_moss", EndConfiguredVegetationFeatures.BULB_MOSS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BULB_MOSS_WOOD = createVegetationKey("bulb_moss_wood", EndConfiguredVegetationFeatures.BULB_MOSS_WOOD_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey SMALL_JELLYSHROOM_WALL = createVegetationKey("small_jellyshroom_wall", EndConfiguredVegetationFeatures.SMALL_JELLYSHROOM_WALL_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey SMALL_JELLYSHROOM_WOOD = createVegetationKey("small_jellyshroom_wood", EndConfiguredVegetationFeatures.SMALL_JELLYSHROOM_WOOD_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey JUNGLE_FERN_WOOD = createVegetationKey("jungle_fern_wood", EndConfiguredVegetationFeatures.JUNGLE_FERN_WOOD_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey RUSCUS = createVegetationKey("ruscus", EndConfiguredVegetationFeatures.RUSCUS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey RUSCUS_WOOD = createVegetationKey("ruscus_wood", EndConfiguredVegetationFeatures.RUSCUS_WOOD_CONFIGURATION);

    // Sky plants
    public static final PlacedConfiguredFeatureKey FILALUX = createVegetationKey("filalux", EndConfiguredVegetationFeatures.FILALUX_CONFIGURATION);

    // Water
    public static final PlacedConfiguredFeatureKey BUBBLE_CORAL = createVegetationKey("bubble_coral", EndConfiguredVegetationFeatures.BUBBLE_CORAL_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BUBBLE_CORAL_RARE = createVegetationKey("bubble_coral_rare", EndConfiguredVegetationFeatures.BUBBLE_CORAL_RARE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey END_LILY = createVegetationKey("end_lily", EndConfiguredVegetationFeatures.END_LILY_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey END_LILY_RARE = createVegetationKey("end_lily_rare", EndConfiguredVegetationFeatures.END_LILY_RARE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey END_LOTUS = createVegetationKey("end_lotus", EndConfiguredVegetationFeatures.END_LOTUS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey END_LOTUS_LEAF = createVegetationKey("end_lotus_leaf", EndConfiguredVegetationFeatures.END_LOTUS_LEAF_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey HYDRALUX = createVegetationKey("hydralux", EndConfiguredVegetationFeatures.HYDRALUX_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey POND_ANEMONE = createVegetationKey("pond_anemone", EndConfiguredVegetationFeatures.POND_ANEMONE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey MENGER_SPONGE = createVegetationKey("menger_sponge", EndConfiguredVegetationFeatures.MENGER_SPONGE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey FLAMAEA = createVegetationKey("flamaea", EndConfiguredVegetationFeatures.FLAMAEA_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHARNIA_RED = createVegetationKey("charnia_red", EndConfiguredVegetationFeatures.CHARNIA_RED_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHARNIA_PURPLE = createVegetationKey("charnia_purple", EndConfiguredVegetationFeatures.CHARNIA_PURPLE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHARNIA_CYAN = createVegetationKey("charnia_cyan", EndConfiguredVegetationFeatures.CHARNIA_CYAN_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHARNIA_LIGHT_BLUE = createVegetationKey("charnia_light_blue", EndConfiguredVegetationFeatures.CHARNIA_LIGHT_BLUE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHARNIA_ORANGE = createVegetationKey("charnia_orange", EndConfiguredVegetationFeatures.CHARNIA_ORANGE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHARNIA_GREEN = createVegetationKey("charnia_green", EndConfiguredVegetationFeatures.CHARNIA_GREEN_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHARNIA_RED_RARE = createVegetationKey("charnia_red_rare", EndConfiguredVegetationFeatures.CHARNIA_RED_RARE_CONFIGURATION);

    // Plants
    public static final PlacedConfiguredFeatureKey UMBRELLA_MOSS = createVegetationKey("umbrella_moss", EndConfiguredVegetationFeatures.UMBRELLA_MOSS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CREEPING_MOSS = createVegetationKey("creeping_moss", EndConfiguredVegetationFeatures.CREEPING_MOSS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHORUS_GRASS = createVegetationKey("chorus_grass", EndConfiguredVegetationFeatures.CHORUS_GRASS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CRYSTAL_GRASS = createVegetationKey("crystal_grass", EndConfiguredVegetationFeatures.CRYSTAL_GRASS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey SHADOW_PLANT = createVegetationKey("shadow_plant", EndConfiguredVegetationFeatures.SHADOW_PLANT_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey MURKWEED = createVegetationKey("murkweed", EndConfiguredVegetationFeatures.MURKWEED_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey NEEDLEGRASS = createVegetationKey("needlegrass", EndConfiguredVegetationFeatures.NEEDLEGRASS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey SHADOW_BERRY = createVegetationKey("shadow_berry", EndConfiguredVegetationFeatures.SHADOW_BERRY_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BUSHY_GRASS = createVegetationKey("bushy_grass", EndConfiguredVegetationFeatures.BUSHY_GRASS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BUSHY_GRASS_WG = createVegetationKey("bushy_grass_wg", EndConfiguredVegetationFeatures.BUSHY_GRASS_WG_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey AMBER_GRASS = createVegetationKey("amber_grass", EndConfiguredVegetationFeatures.AMBER_GRASS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey TWISTED_UMBRELLA_MOSS = createVegetationKey("twisted_umbrella_moss", EndConfiguredVegetationFeatures.TWISTED_UMBRELLA_MOSS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey JUNGLE_GRASS = createVegetationKey("jungle_grass", EndConfiguredVegetationFeatures.JUNGLE_GRASS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey SMALL_JELLYSHROOM_FLOOR = createVegetationKey("small_jellyshroom_floor", EndConfiguredVegetationFeatures.SMALL_JELLYSHROOM_FLOOR_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BLOSSOM_BERRY = createVegetationKey("blossom_berry", EndConfiguredVegetationFeatures.BLOSSOM_BERRY_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BLOOMING_COOKSONIA = createVegetationKey("blooming_cooksonia", EndConfiguredVegetationFeatures.BLOOMING_COOKSONIA_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey SALTEAGO = createVegetationKey("salteago", EndConfiguredVegetationFeatures.SALTEAGO_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey VAIOLUSH_FERN = createVegetationKey("vaiolush_fern", EndConfiguredVegetationFeatures.VAIOLUSH_FERN_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey FRACTURN = createVegetationKey("fracturn", EndConfiguredVegetationFeatures.FRACTURN_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey UMBRELLA_MOSS_RARE = createVegetationKey("umbrella_moss_rare", EndConfiguredVegetationFeatures.UMBRELLA_MOSS_RARE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CREEPING_MOSS_RARE = createVegetationKey("creeping_moss_rare", EndConfiguredVegetationFeatures.CREEPING_MOSS_RARE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey TWISTED_UMBRELLA_MOSS_RARE = createVegetationKey("twisted_umbrella_moss_rare", EndConfiguredVegetationFeatures.TWISTED_UMBRELLA_MOSS_RARE_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey ORANGO = createVegetationKey("orango", EndConfiguredVegetationFeatures.ORANGO_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey AERIDIUM = createVegetationKey("aeridium", EndConfiguredVegetationFeatures.AERIDIUM_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey LUTEBUS = createVegetationKey("lutebus", EndConfiguredVegetationFeatures.LUTEBUS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey LAMELLARIUM = createVegetationKey("lamellarium", EndConfiguredVegetationFeatures.LAMELLARIUM_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey SMALL_AMARANITA = createVegetationKey("small_amaranita", EndConfiguredVegetationFeatures.SMALL_AMARANITA_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey GLOBULAGUS = createVegetationKey("globulagus", EndConfiguredVegetationFeatures.GLOBULAGUS_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CLAWFERN = createVegetationKey("clawfern", EndConfiguredVegetationFeatures.CLAWFERN_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey BOLUX_MUSHROOM = createVegetationKey("bolux_mushroom", EndConfiguredVegetationFeatures.BOLUX_MUSHROOM_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey CHORUS_MUSHROOM = createVegetationKey("chorus_mushroom", EndConfiguredVegetationFeatures.CHORUS_MUSHROOM_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey AMBER_ROOT = createVegetationKey("amber_root", EndConfiguredVegetationFeatures.AMBER_ROOT_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey INFLEXIA = createVegetationKey("inflexia", EndConfiguredVegetationFeatures.INFLEXIA_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey FLAMMALIX = createVegetationKey("flammalix", EndConfiguredVegetationFeatures.FLAMMALIX_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey LANCELEAF = createVegetationKey("lanceleaf", EndConfiguredVegetationFeatures.LANCELEAF_CONFIGURATION);
    public static final PlacedConfiguredFeatureKey GLOW_PILLAR = createVegetationKey("glow_pillar", EndConfiguredVegetationFeatures.GLOW_PILLAR_CONFIGURATION);


    private static <F extends Feature<FC>, FC extends FeatureConfiguration> PlacedConfiguredFeatureKey createVegetationKey(
            String name,
            ConfiguredFeatureKey<WithConfiguration<F, FC>> feature
    ) {
        return PlacedFeatureManager.createKey(BetterEnd.C.mk(name), feature);
    }

    private static <F extends Feature<FC>, FC extends FeatureConfiguration> PlacedFeatureKey createVegetationKey(
            String name
    ) {
        return PlacedFeatureManager.createKey(BetterEnd.C.mk(name));
    }
}
