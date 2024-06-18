package org.betterx.betterend.registry;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.world.features.*;
import org.betterx.betterend.world.features.bushes.BushFeature;
import org.betterx.betterend.world.features.bushes.BushFeatureConfig;
import org.betterx.betterend.world.features.bushes.BushWithOuterFeature;
import org.betterx.betterend.world.features.bushes.BushWithOuterFeatureConfig;
import org.betterx.wover.feature.api.configured.ConfiguredFeatureKey;
import org.betterx.wover.feature.api.configured.ConfiguredFeatureManager;
import org.betterx.wover.feature.api.configured.configurators.WithConfiguration;

public class EndConfiguredVegetationFeatures {
    //Bushes
    public static ConfiguredFeatureKey<WithConfiguration<BushFeature, BushFeatureConfig>> PYTHADENDRON_BUSH_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("pythadendron_bush"), EndFeatures.BUSH_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<BushFeature, BushFeatureConfig>> DRAGON_TREE_BUSH_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("dragon_tree_bush"), EndFeatures.BUSH_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<BushWithOuterFeature, BushWithOuterFeatureConfig>> LUCERNIA_BUSH_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("lucernia_bush"), EndFeatures.BUSH_WITH_OUTER_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<BushWithOuterFeature, BushWithOuterFeatureConfig>> LUCERNIA_BUSH_RARE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("lucernia_bush_rare"), EndFeatures.BUSH_WITH_OUTER_FEATURE);

    //Vines
    public static ConfiguredFeatureKey<WithConfiguration<VineFeature, VineFeatureConfig>> DENSE_VINE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("dense_vine"), EndFeatures.VINE_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<VineFeature, VineFeatureConfig>> TWISTED_VINE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("twisted_vine"), EndFeatures.VINE_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<VineFeature, VineFeatureConfig>> BULB_VINE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("bulb_vine"), EndFeatures.VINE_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<VineFeature, VineFeatureConfig>> JUNGLE_VINE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("jungle_vine"), EndFeatures.VINE_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<BlueVineFeature, ScatterFeatureConfig>> BLUE_VINE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("blue_vine"), EndFeatures.BLUE_VINE_FEATURE);

    // Ceil plants
    public static ConfiguredFeatureKey<WithConfiguration<SingleInvertedScatterFeature, SinglePlantFeatureConfig>> SMALL_JELLYSHROOM_CEIL_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("small_jellyshroom_ceil"), EndFeatures.SINGLE_INVERTED_SCATTER_FEATURE);

    // Wall Plants //
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> PURPLE_POLYPORE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("purple_polypore"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> AURANT_POLYPORE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("aurant_polypore"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantFeature, WallPlantFeatureConfig>> TAIL_MOSS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("tail_moss"), EndFeatures.WALL_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantFeature, WallPlantFeatureConfig>> CYAN_MOSS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("cyan_moss"), EndFeatures.WALL_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> TAIL_MOSS_WOOD_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("tail_moss_wood"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> CYAN_MOSS_WOOD_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("cyan_moss_wood"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantFeature, WallPlantFeatureConfig>> TWISTED_MOSS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("twisted_moss"), EndFeatures.WALL_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> TWISTED_MOSS_WOOD_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("twisted_moss_wood"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantFeature, WallPlantFeatureConfig>> BULB_MOSS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("bulb_moss"), EndFeatures.WALL_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> BULB_MOSS_WOOD_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("bulb_moss_wood"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantFeature, WallPlantFeatureConfig>> SMALL_JELLYSHROOM_WALL_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("small_jellyshroom_wall"), EndFeatures.WALL_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> SMALL_JELLYSHROOM_WOOD_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("small_jellyshroom_wood"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> JUNGLE_FERN_WOOD_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("jungle_fern_wood"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantFeature, WallPlantFeatureConfig>> RUSCUS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("ruscus"), EndFeatures.WALL_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<WallPlantOnLogFeature, WallPlantFeatureConfig>> RUSCUS_WOOD_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("ruscus_wood"), EndFeatures.WALL_PLANT_ON_LOG_FEATURE);

    //Sky plants
    public static ConfiguredFeatureKey<WithConfiguration<FilaluxFeature, ScatterFeatureConfig>> FILALUX_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("filalux"), EndFeatures.FILALUX_FEATURE);

    // Water
    public static ConfiguredFeatureKey<WithConfiguration<UnderwaterPlantFeature, SinglePlantFeatureConfig>> BUBBLE_CORAL_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("bubble_coral"), EndFeatures.UNDERWATER_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<UnderwaterPlantFeature, SinglePlantFeatureConfig>> BUBBLE_CORAL_RARE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("bubble_coral_rare"), EndFeatures.UNDERWATER_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<EndLilyFeature, ScatterFeatureConfig>> END_LILY_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("end_lily"), EndFeatures.END_LILY_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<EndLilyFeature, ScatterFeatureConfig>> END_LILY_RARE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("end_lily_rare"), EndFeatures.END_LILY_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<EndLotusFeature, ScatterFeatureConfig>> END_LOTUS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("end_lotus"), EndFeatures.END_LOTUS_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<EndLotusLeafFeature, ScatterFeatureConfig>> END_LOTUS_LEAF_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("end_lotus_leaf"), EndFeatures.END_LOTUS_LEAF_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<HydraluxFeature, ScatterFeatureConfig>> HYDRALUX_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("hydralux"), EndFeatures.HYDRALUX_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<UnderwaterPlantFeature, SinglePlantFeatureConfig>> POND_ANEMONE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("pond_anemone"), EndFeatures.UNDERWATER_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<MengerSpongeFeature, ScatterFeatureConfig>> MENGER_SPONGE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("menger_sponge"), EndFeatures.MENGER_SPONGE_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> FLAMAEA_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("flamaea"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<CharniaFeature, SinglePlantFeatureConfig>> CHARNIA_RED_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("charnia_red"), EndFeatures.CHARNIA_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<CharniaFeature, SinglePlantFeatureConfig>> CHARNIA_PURPLE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("charnia_purple"), EndFeatures.CHARNIA_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<CharniaFeature, SinglePlantFeatureConfig>> CHARNIA_CYAN_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("charnia_cyan"), EndFeatures.CHARNIA_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<CharniaFeature, SinglePlantFeatureConfig>> CHARNIA_LIGHT_BLUE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("charnia_light_blue"), EndFeatures.CHARNIA_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<CharniaFeature, SinglePlantFeatureConfig>> CHARNIA_ORANGE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("charnia_orange"), EndFeatures.CHARNIA_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<CharniaFeature, SinglePlantFeatureConfig>> CHARNIA_GREEN_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("charnia_green"), EndFeatures.CHARNIA_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<CharniaFeature, SinglePlantFeatureConfig>> CHARNIA_RED_RARE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("charnia_red_rare"), EndFeatures.CHARNIA_FEATURE);

    //Plants
    public static ConfiguredFeatureKey<WithConfiguration<DoublePlantFeature, DoublePlantFeatureConfig>> UMBRELLA_MOSS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("umbrella_moss"), EndFeatures.DOUBLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> CREEPING_MOSS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("creeping_moss"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> CHORUS_GRASS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("chorus_grass"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> CRYSTAL_GRASS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("crystal_grass"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> SHADOW_PLANT_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("shadow_plant"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> MURKWEED_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("murkweed"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> NEEDLEGRASS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("needlegrass"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> SHADOW_BERRY_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("shadow_berry"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> BUSHY_GRASS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("bushy_grass"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> BUSHY_GRASS_WG_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("bushy_grass_wg"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> AMBER_GRASS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("amber_grass"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<DoublePlantFeature, DoublePlantFeatureConfig>> TWISTED_UMBRELLA_MOSS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("twisted_umbrella_moss"), EndFeatures.DOUBLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> JUNGLE_GRASS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("jungle_grass"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> SMALL_JELLYSHROOM_FLOOR_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("small_jellyshroom_floor"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> BLOSSOM_BERRY_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("blossom_berry"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> BLOOMING_COOKSONIA_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("blooming_cooksonia"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> SALTEAGO_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("salteago"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> VAIOLUSH_FERN_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("vaiolush_fern"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> FRACTURN_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("fracturn"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> UMBRELLA_MOSS_RARE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("umbrella_moss_rare"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> CREEPING_MOSS_RARE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("creeping_moss_rare"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> TWISTED_UMBRELLA_MOSS_RARE_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("twisted_umbrella_moss_rare"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> ORANGO_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("orango"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> AERIDIUM_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("aeridium"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> LUTEBUS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("lutebus"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> LAMELLARIUM_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("lamellarium"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> SMALL_AMARANITA_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("small_amaranita"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> GLOBULAGUS_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("globulagus"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> CLAWFERN_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("clawfern"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> BOLUX_MUSHROOM_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("bolux_mushroom"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> CHORUS_MUSHROOM_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("chorus_mushroom"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> AMBER_ROOT_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("amber_root"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> INFLEXIA_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("inflexia"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<SinglePlantFeature, SinglePlantFeatureConfig>> FLAMMALIX_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("flammalix"), EndFeatures.SINGLE_PLANT_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<LanceleafFeature, ScatterFeatureConfig>> LANCELEAF_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("lanceleaf"), EndFeatures.LANCELEAF_FEATURE);
    public static ConfiguredFeatureKey<WithConfiguration<GlowPillarFeature, ScatterFeatureConfig>> GLOW_PILLAR_CONFIGURATION = ConfiguredFeatureManager.configuration(BetterEnd.C.mk("glow_pillar"), EndFeatures.GLOW_PILLAR_FEATURE);
}
