package org.betterx.betterend.registry;

import org.betterx.bclib.BCLib;
import org.betterx.bclib.api.v2.levelgen.biomes.BCLBiome;
import org.betterx.bclib.api.v2.levelgen.biomes.BCLBiomeRegistry;
import org.betterx.bclib.api.v2.levelgen.biomes.BiomeAPI;
import org.betterx.bclib.api.v3.levelgen.features.BCLConfigureFeature;
import org.betterx.bclib.api.v3.levelgen.features.BCLFeature;
import org.betterx.bclib.api.v3.levelgen.features.BCLFeatureBuilder;
import org.betterx.bclib.api.v3.levelgen.features.config.ConditionFeatureConfig;
import org.betterx.bclib.api.v3.levelgen.features.placement.InBiome;
import org.betterx.bclib.util.JsonFactory;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.complexmaterials.StoneMaterial;
import org.betterx.betterend.config.Configs;
import org.betterx.betterend.world.biome.EndBiome;
import org.betterx.betterend.world.biome.EndBiomeBuilder;
import org.betterx.betterend.world.biome.cave.EndCaveBiome;
import org.betterx.betterend.world.features.*;
import org.betterx.betterend.world.features.bushes.*;
import org.betterx.betterend.world.features.terrain.*;
import org.betterx.betterend.world.features.terrain.caves.CaveChunkPopulatorFeature;
import org.betterx.betterend.world.features.terrain.caves.RoundCaveFeature;
import org.betterx.betterend.world.features.terrain.caves.TunelCaveFeature;
import org.betterx.betterend.world.features.trees.*;
import org.betterx.worlds.together.world.event.WorldBootstrap;
import org.betterx.wover.feature.api.FeatureManager;
import org.betterx.wover.feature.api.configured.ConfiguredFeatureKey;
import org.betterx.wover.feature.api.configured.ConfiguredFeatureManager;
import org.betterx.wover.feature.api.placed.PlacedFeatureKey;
import org.betterx.wover.state.api.WorldState;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.InputStream;
import java.util.List;

public class EndFeatures {
    public static final StalactiteFeature STALACTITE_FEATURE = inlineBuild("stalactite_feature", new StalactiteFeature());
    public static final BuildingListFeature BUILDING_LIST_FEATURE = inlineBuild("building_list_feature", new BuildingListFeature());
    public static final VineFeature VINE_FEATURE = inlineBuild("vine_feature", new VineFeature());
    public static final WallPlantFeature WALL_PLANT_FEATURE = inlineBuild("wall_plant_feature", new WallPlantFeature());
    public static final WallPlantOnLogFeature WALL_PLANT_ON_LOG_FEATURE = inlineBuild("wall_plant_on_log_feature", new WallPlantOnLogFeature());
    public static final GlowPillarFeature GLOW_PILLAR_FEATURE = inlineBuild("glow_pillar_feature", new GlowPillarFeature());
    public static final HydraluxFeature HYDRALUX_FEATURE = inlineBuild("hydralux_feature", new HydraluxFeature());
    public static final LanceleafFeature LANCELEAF_FEATURE = inlineBuild("lanceleaf_feature", new LanceleafFeature());
    public static final MengerSpongeFeature MENGER_SPONGE_FEATURE = inlineBuild("menger_sponge_feature", new MengerSpongeFeature());
    public static final CaveChunkPopulatorFeature CAVE_CHUNK_POPULATOR = inlineBuild("cave_chunk_populator", new CaveChunkPopulatorFeature());
    public static final SinglePlantFeature SINGLE_PLANT_FEATURE = inlineBuild("single_plant_feature", new SinglePlantFeature());
    public static final SingleInvertedScatterFeature SINGLE_INVERTED_SCATTER_FEATURE = inlineBuild("single_inverted_scatter_feature", new SingleInvertedScatterFeature());
    public static final DoublePlantFeature DOUBLE_PLANT_FEATURE = inlineBuild("double_plant_feature", new DoublePlantFeature());
    public static final UnderwaterPlantFeature UNDERWATER_PLANT_FEATURE = inlineBuild("underwater_plant_feature", new UnderwaterPlantFeature());
    public static final ArchFeature ARCH_FEATURE = inlineBuild("arch_feature", new ArchFeature());
    public static final ThinArchFeature THIN_ARCH_FEATURE = inlineBuild("thin_arch_feature", new ThinArchFeature());
    public static final CharniaFeature CHARNIA_FEATURE = inlineBuild("charnia_feature", new CharniaFeature());
    public static final BlueVineFeature BLUE_VINE_FEATURE = inlineBuild("blue_vine_feature", new BlueVineFeature());
    public static final FilaluxFeature FILALUX_FEATURE = inlineBuild("filalux_feature", new FilaluxFeature());
    public static final EndLilyFeature END_LILY_FEATURE = inlineBuild("end_lily_feature", new EndLilyFeature());
    public static final EndLotusFeature END_LOTUS_FEATURE = inlineBuild("end_lotus_feature", new EndLotusFeature());
    public static final EndLotusLeafFeature END_LOTUS_LEAF_FEATURE = inlineBuild("end_lotus_leaf_feature", new EndLotusLeafFeature());
    public static final BushFeature BUSH_FEATURE = inlineBuild("bush_feature", new BushFeature());
    public static final SingleBlockFeature SINGLE_BLOCK_FEATURE = inlineBuild("single_block_feature", new SingleBlockFeature());
    public static final BushWithOuterFeature BUSH_WITH_OUTER_FEATURE = inlineBuild("bush_with_outer_feature", new BushWithOuterFeature());
    public static final MossyGlowshroomFeature MOSSY_GLOWSHROOM_FEATURE = inlineBuild("mossy_glowshroom", new MossyGlowshroomFeature());
    public static final PythadendronTreeFeature PYTHADENDRON_TREE_FEATURE = inlineBuild("pythadendron_tree", new PythadendronTreeFeature());
    public static final LacugroveFeature LACUGROVE_FEATURE = inlineBuild("lacugrove", new LacugroveFeature());
    public static final DragonTreeFeature DRAGON_TREE_FEATURE = inlineBuild("dragon_tree", new DragonTreeFeature());
    public static final TenaneaFeature TENANEA_FEATURE = inlineBuild("tenanea", new TenaneaFeature());
    public static final HelixTreeFeature HELIX_TREE_FEATURE = inlineBuild("helix_tree", new HelixTreeFeature());
    public static final UmbrellaTreeFeature UMBRELLA_TREE_FEATURE = inlineBuild("umbrella_tree", new UmbrellaTreeFeature());
    public static final JellyshroomFeature JELLYSHROOM_FEATURE = inlineBuild("jellyshroom", new JellyshroomFeature());
    public static final GiganticAmaranitaFeature GIGANTIC_AMARANITA_FEATURE = inlineBuild("gigantic_amaranita", new GiganticAmaranitaFeature());
    public static final LucerniaFeature LUCERNIA_FEATURE = inlineBuild("lucernia", new LucerniaFeature());
    public static final TenaneaBushFeature TENANEA_BUSH_FEATURE = inlineBuild("tenanea_bush", new TenaneaBushFeature());
    public static final Lumecorn LUMECORN_FEATURE = inlineBuild("lumecorn", new Lumecorn());
    public static final LargeAmaranitaFeature LARGE_AMARANITA_FEATURE = inlineBuild("large_amaranita", new LargeAmaranitaFeature());
    public static final NeonCactusFeature NEON_CACTUS_FEATURE = inlineBuild("neon_cactus", new NeonCactusFeature());

    public static final BCLFeature<BiomeIslandFeature, NoneFeatureConfiguration> BIOME_ISLAND = BCLFeatureBuilder
            .start(BetterEnd.C.mk("overworld_island"), inlineBuild("overworld_island", new BiomeIslandFeature()))
            .build()
            .place()
            .decoration(Decoration.RAW_GENERATION)
            .build();


    public static final EndLakeFeature END_LAKE_FEATURE = inlineBuild("end_lake", new EndLakeFeature());
    // Terrain //
    public static final BCLFeature<EndLakeFeature, NoneFeatureConfiguration> END_LAKE = registerLake("end_lake", END_LAKE_FEATURE, 4);
    public static final BCLFeature<EndLakeFeature, NoneFeatureConfiguration> END_LAKE_NORMAL = registerLake("end_lake_normal", END_LAKE_FEATURE, 20);
    public static final BCLFeature<EndLakeFeature, NoneFeatureConfiguration> END_LAKE_RARE = registerLake("end_lake_rare", END_LAKE_FEATURE, 40);
    public static final BCLFeature<DesertLakeFeature, NoneFeatureConfiguration> DESERT_LAKE = registerLake("desert_lake", inlineBuild("desert_lake", new DesertLakeFeature()), 8);
    public static final BCLFeature<RoundCaveFeature, NoneFeatureConfiguration> ROUND_CAVE = registerRawGen("round_cave", inlineBuild("round_cave", new RoundCaveFeature()), 2);
    public static final BCLFeature<SpireFeature, NoneFeatureConfiguration> SPIRE = registerRawGen("spire", inlineBuild("spire", new SpireFeature()), 4);
    public static final BCLFeature<FloatingSpireFeature, NoneFeatureConfiguration> FLOATING_SPIRE = registerRawGen("floating_spire", inlineBuild("floating_spire", new FloatingSpireFeature()), 8);
    public static final BCLFeature<GeyserFeature, NoneFeatureConfiguration> GEYSER = registerRawGen("geyser", inlineBuild("geyser", new GeyserFeature()), 8);
    public static final BCLFeature<SulphuricLakeFeature, NoneFeatureConfiguration> SULPHURIC_LAKE = registerLake("sulphuric_lake", inlineBuild("sulphuric_lake", new SulphuricLakeFeature()), 8);
    public static final BCLFeature<SulphuricCaveFeature, NoneFeatureConfiguration> SULPHURIC_CAVE = BCLFeatureBuilder
            .start(BetterEnd.C.mk("sulphuric_cave"), inlineBuild("sulphuric_cave", new SulphuricCaveFeature()))
            .build()
            .place()
            .decoration(Decoration.RAW_GENERATION)
            .count(2)
            .squarePlacement()
            .onlyInBiome()
            .build();

    public static final IceStarFeature ICE_STAR_FEATURE = inlineBuild("ice_star", new IceStarFeature());
    public static final BCLFeature<IceStarFeature, IceStarFeatureConfig> ICE_STAR = registerRawGen("ice_star", ICE_STAR_FEATURE, new IceStarFeatureConfig(5, 15, 10, 25), 15);
    public static final BCLFeature<IceStarFeature, IceStarFeatureConfig> ICE_STAR_SMALL = registerRawGen("ice_star_small", ICE_STAR_FEATURE, new IceStarFeatureConfig(3, 5, 7, 12), 8);
    public static final BCLFeature<SurfaceVentFeature, NoneFeatureConfiguration> SURFACE_VENT = registerChanced("surface_vent", inlineBuild("surface_vent", new SurfaceVentFeature()), 4);
    public static final BCLFeature<SulphurHillFeature, NoneFeatureConfiguration> SULPHUR_HILL = registerChanced("sulphur_hill", inlineBuild("sulphur_hill", new SulphurHillFeature()), 8);
    public static final BCLFeature<ObsidianPillarBasementFeature, NoneFeatureConfiguration> OBSIDIAN_PILLAR_BASEMENT = registerChanced("obsidian_pillar_basement", inlineBuild("obsidian_pillar_basement", new ObsidianPillarBasementFeature()), 8);
    public static final BCLFeature<ObsidianBoulderFeature, NoneFeatureConfiguration> OBSIDIAN_BOULDER = registerChanced("obsidian_boulder", inlineBuild("obsidian_boulder", new ObsidianBoulderFeature()), 10);
    public static final BCLFeature<FallenPillarFeature, NoneFeatureConfiguration> FALLEN_PILLAR = registerChanced("fallen_pillar", inlineBuild("fallen_pillar", new FallenPillarFeature()), 20);
    public static final BCLFeature<TunelCaveFeature, NoneFeatureConfiguration> TUNEL_CAVE = BCLFeatureBuilder
            .start(BetterEnd.C.mk("tunel_cave"), inlineBuild("tunel_cave", new TunelCaveFeature()))
            .build()
            .place()
            .decoration(Decoration.RAW_GENERATION)
            .count(1)
            .onlyInBiome()
            .build();
    public static final BCLFeature<ArchFeature, ArchFeatureConfig> UMBRALITH_ARCH = registerChanced("umbralith_arch", ARCH_FEATURE, new ArchFeatureConfig(EndBlocks.UMBRALITH.stone, ArchFeatureConfig.SurfaceFunction.UMBRA_VALLEY), 10);
    public static final BCLFeature<ThinArchFeature, ThinArchFeatureConfig> THIN_UMBRALITH_ARCH = registerChanced("thin_umbralith_arch", THIN_ARCH_FEATURE, new ThinArchFeatureConfig(EndBlocks.UMBRALITH.stone), 15);

    // Ores //
    public static final BCLFeature<OreFeature, OreConfiguration> THALLASIUM_ORE = registerOre("thallasium_ore", EndBlocks.THALLASIUM.ore, 24, 8);
    public static final BCLFeature<OreFeature, OreConfiguration> ENDER_ORE = registerOre("ender_ore", EndBlocks.ENDER_ORE, 12, 4);
    public static final BCLFeature<OreFeature, OreConfiguration> AMBER_ORE = registerOre("amber_ore", EndBlocks.AMBER_ORE, 60, 6);
    public static final BCLFeature<OreFeature, OreConfiguration> DRAGON_BONE_BLOCK_ORE = registerOre("dragon_bone_ore", EndBlocks.DRAGON_BONE_BLOCK, 24, 8);
    public static final BCLFeature<OreLayerFeature, OreLayerFeatureConfig> VIOLECITE_LAYER = registerLayer("violecite_layer", EndBlocks.VIOLECITE, 15, 16, 128, 8);

    public static final BCLFeature<OreLayerFeature, OreLayerFeatureConfig> FLAVOLITE_LAYER = registerLayer("flavolite_layer", EndBlocks.FLAVOLITE, 12, 16, 128, 6);

    // Buildings
    public static final BCLFeature<CrashedShipFeature, NBTFeatureConfig> CRASHED_SHIP = registerChanced("crashed_ship", inlineBuild("crashed_ship", new CrashedShipFeature()), new NBTFeatureConfig(EndBiome.Config.DEFAULT_MATERIAL.getTopMaterial()), 500);

    // Mobs
    public static final BCLFeature<SilkMothNestFeature, NoneFeatureConfiguration> SILK_MOTH_NEST = registerChanced("silk_moth_nest", inlineBuild("silk_moth_nest", new SilkMothNestFeature()), 2);

    // Caves
    public static final BCLConfigureFeature<SmaragdantCrystalFeature, NoneFeatureConfiguration> SMARAGDANT_CRYSTAL = BCLFeatureBuilder
            .start(BetterEnd.C.mk("smaragdant_crystal"), inlineBuild("smaragdant_crystal", new SmaragdantCrystalFeature()))
            .build();
    public static final BCLConfigureFeature<SingleBlockFeature, SimpleBlockConfiguration> SMARAGDANT_CRYSTAL_SHARD = BCLFeatureBuilder
            .start(BetterEnd.C.mk("smaragdant_crystal_shard"), SINGLE_BLOCK_FEATURE)
            .configuration(new SimpleBlockConfiguration(SimpleStateProvider.simple(EndBlocks.SMARAGDANT_CRYSTAL_SHARD)))
            .build();

    public static final BCLConfigureFeature<BigAuroraCrystalFeature, NoneFeatureConfiguration> BIG_AURORA_CRYSTAL = BCLFeatureBuilder
            .start(BetterEnd.C.mk("big_aurora_crystal"), inlineBuild("big_aurora_crystal", new BigAuroraCrystalFeature()))
            .build();
    public static final BCLConfigureFeature<BushFeature, BushFeatureConfig> CAVE_BUSH = BCLFeatureBuilder
            .start(BetterEnd.C.mk("cave_bush"), BUSH_FEATURE)
            .configuration(new BushFeatureConfig(EndBlocks.CAVE_BUSH, EndBlocks.CAVE_BUSH))
            .build();
    public static final BCLConfigureFeature<SingleBlockFeature, SimpleBlockConfiguration> CAVE_GRASS = BCLFeatureBuilder
            .start(BetterEnd.C.mk("cave_grass"), SINGLE_BLOCK_FEATURE)
            .configuration(new SimpleBlockConfiguration(SimpleStateProvider.simple(EndBlocks.CAVE_GRASS)))
            .build();
    public static final BCLConfigureFeature<VineFeature, VineFeatureConfig> RUBINEA = BCLFeatureBuilder
            .start(BetterEnd.C.mk("rubinea"), VINE_FEATURE)
            .configuration(new VineFeatureConfig(EndBlocks.RUBINEA, 8))
            .build();

    public static final BCLConfigureFeature<VineFeature, VineFeatureConfig> MAGNULA = BCLFeatureBuilder
            .start(BetterEnd.C.mk("magnula"), VINE_FEATURE)
            .configuration(new VineFeatureConfig(EndBlocks.MAGNULA, 8))
            .build();

    public static final BCLConfigureFeature<StalactiteFeature, StalactiteFeatureConfig> END_STONE_STALACTITE = BCLFeatureBuilder
            .start(BetterEnd.C.mk("end_stone_stalactite"), STALACTITE_FEATURE)
            .configuration(new StalactiteFeatureConfig(true, EndBlocks.END_STONE_STALACTITE, Blocks.END_STONE))
            .build();


    public static final BCLConfigureFeature<StalactiteFeature, StalactiteFeatureConfig> END_STONE_STALAGMITE = BCLFeatureBuilder
            .start(BetterEnd.C.mk("end_stone_stalagmite"), STALACTITE_FEATURE)
            .configuration(new StalactiteFeatureConfig(false, EndBlocks.END_STONE_STALACTITE, Blocks.END_STONE))
            .build();
    public static final BCLConfigureFeature<StalactiteFeature, StalactiteFeatureConfig> END_STONE_STALACTITE_CAVEMOSS = BCLFeatureBuilder
            .start(BetterEnd.C.mk("end_stone_stalactite_cavemoss"), STALACTITE_FEATURE)
            .configuration(new StalactiteFeatureConfig(true, EndBlocks.END_STONE_STALACTITE_CAVEMOSS, Blocks.END_STONE, EndBlocks.CAVE_MOSS))
            .build();
    public static final BCLConfigureFeature<StalactiteFeature, StalactiteFeatureConfig> END_STONE_STALAGMITE_CAVEMOSS = BCLFeatureBuilder
            .start(BetterEnd.C.mk("end_stone_stalagmite_cavemoss"), STALACTITE_FEATURE)
            .configuration(new StalactiteFeatureConfig(false, EndBlocks.END_STONE_STALACTITE_CAVEMOSS, EndBlocks.CAVE_MOSS))
            .build();
    public static final BCLConfigureFeature<CavePumpkinFeature, NoneFeatureConfiguration> CAVE_PUMPKIN = BCLFeatureBuilder
            .start(BetterEnd.C.mk("cave_pumpkin"), inlineBuild("cave_pumpkin", new CavePumpkinFeature()))
            .build();


    private static final Holder<PlacedFeature> BONEMEAL_END_MOSS_NOT_GLOWING_GRASSLANDS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_end_moss_not_glowing_grasslands"))
            .add(EndBlocks.CREEPING_MOSS, 10)
            .add(EndBlocks.UMBRELLA_MOSS, 10)
            .inlinePlace()
            .build().placedFeature;

    private static final Holder<PlacedFeature> BONEMEAL_END_MOSS_GLOWING_GRASSLANDS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_end_moss_glowing_grasslands"))
            .add(EndBlocks.CREEPING_MOSS, 10)
            .add(EndBlocks.UMBRELLA_MOSS, 10)
            .add(EndBlocks.BLOOMING_COOKSONIA, 100)
            .add(EndBlocks.VAIOLUSH_FERN, 100)
            .add(EndBlocks.FRACTURN, 100)
            .add(EndBlocks.SALTEAGO, 100)
            .add(EndBlocks.TWISTED_UMBRELLA_MOSS, 10)
            .inlinePlace()
            .build().placedFeature;

    public static final BCLConfigureFeature<Feature<ConditionFeatureConfig>, ConditionFeatureConfig> BONEMEAL_END_MOSS = BCLFeatureBuilder
            .start(BetterEnd.C.mk("bonemeal_end_moss"), BCLFeature.CONDITION)
            .configuration(new ConditionFeatureConfig(InBiome.matchingID(EndBiomes.GLOWING_GRASSLANDS.location()), BONEMEAL_END_MOSS_GLOWING_GRASSLANDS, BONEMEAL_END_MOSS_NOT_GLOWING_GRASSLANDS))
            .build();

    private static final Holder<PlacedFeature> BONEMEAL_RUTISCUS_NOT_LANTERN_WOODS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_rutiscus_not_lantern_woods"))
            .add(EndBlocks.ORANGO, 100)
            .add(EndBlocks.AERIDIUM, 20)
            .add(EndBlocks.LUTEBUS, 20)
            .add(EndBlocks.LAMELLARIUM, 100)
            .inlinePlace()
            .build().placedFeature;

    private static final Holder<PlacedFeature> BONEMEAL_RUTISCUS_LANTERN_WOODS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_rutiscus_lantern_woods"))
            .add(EndBlocks.AERIDIUM, 20)
            .add(EndBlocks.BOLUX_MUSHROOM, 5)
            .add(EndBlocks.LAMELLARIUM, 100)
            .inlinePlace()
            .build().placedFeature;

    public static final BCLConfigureFeature<Feature<ConditionFeatureConfig>, ConditionFeatureConfig> BONEMEAL_RUTISCUS = BCLFeatureBuilder
            .start(BetterEnd.C.mk("bonemeal_rutiscus"), BCLFeature.CONDITION)
            .configuration(new ConditionFeatureConfig(InBiome.matchingID(EndBiomes.LANTERN_WOODS.location()), BONEMEAL_RUTISCUS_LANTERN_WOODS, BONEMEAL_RUTISCUS_NOT_LANTERN_WOODS))
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_END_MYCELIUM = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_end_mycelium"))
            .add(EndBlocks.CREEPING_MOSS, 100)
            .add(EndBlocks.UMBRELLA_MOSS, 100)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_JUNGLE_MOSS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_jungle_moss"))
            .add(EndBlocks.JUNGLE_GRASS, 100)
            .add(EndBlocks.TWISTED_UMBRELLA_MOSS, 100)
            .add(EndBlocks.SMALL_JELLYSHROOM, 10)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_SANGNUM = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_sangnum"))
            .add(EndBlocks.CLAWFERN, 100)
            .add(EndBlocks.GLOBULAGUS, 100)
            .add(EndBlocks.SMALL_AMARANITA_MUSHROOM, 10)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_MOSSY_DRAGON_BONE = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_mossy_dragon_bone"))
            .add(EndBlocks.CLAWFERN, 100)
            .add(EndBlocks.GLOBULAGUS, 100)
            .add(EndBlocks.SMALL_AMARANITA_MUSHROOM, 10)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_MOSSY_OBSIDIAN = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_mossy_obsidian"))
            .add(EndBlocks.CLAWFERN, 100)
            .add(EndBlocks.GLOBULAGUS, 100)
            .add(EndBlocks.SMALL_AMARANITA_MUSHROOM, 10)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_CAVE_MOSS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_cave_moss"))
            .add(EndBlocks.CAVE_GRASS, 100)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_CHORUS_NYLIUM = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_chorus_nylium"))
            .add(EndBlocks.CHORUS_GRASS, 100)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_CRYSTAL_MOSS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_crystal_moss"))
            .add(EndBlocks.CRYSTAL_GRASS, 100)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_SHADOW_GRASS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_shadow_grass"))
            .add(EndBlocks.SHADOW_PLANT, 100)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_PINK_MOSS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_pink_moss"))
            .add(EndBlocks.BUSHY_GRASS, 100)
            .build();

    public static final BCLConfigureFeature<RandomPatchFeature, RandomPatchConfiguration> BONEMEAL_AMBER_MOSS = BCLFeatureBuilder
            .startBonemealPatch(BetterEnd.C.mk("bonemeal_amber_moss"))
            .add(EndBlocks.AMBER_GRASS, 100)
            .build();


    public static <F extends Feature<FC>, FC extends FeatureConfiguration> F inlineBuild(String name, F feature) {
        ResourceLocation l = BetterEnd.C.mk(name);

        final Registry<Feature<?>> features;
        if (WorldState.registryAccess() != null) {
            features = WorldBootstrap.getLastRegistryAccess().registryOrThrow(Registries.FEATURE);
        } else {
            features = BuiltInRegistries.FEATURE;
        }

        if (features.containsKey(l)) {
            return (F) features.get(l);
        }


        return FeatureManager.register(l, feature);
    }

    private static PlacedFeatureKey registerVegetation(
            String name, DoublePlantFeatureConfig config, int density
    ) {
        return registerVegetation(name, DOUBLE_PLANT_FEATURE, config, density);
    }

    private static PlacedFeatureKey registerVegetation(
            String name, SinglePlantFeatureConfig config, int density
    ) {
        return registerVegetation(name, SINGLE_PLANT_FEATURE, config, density);
    }

    private static <F extends Feature<NoneFeatureConfiguration>> PlacedFeatureKey registerVegetation(
            String name, F feature, int density
    ) {
        return registerVegetation(name, feature, NoneFeatureConfiguration.NONE, density);
    }

    private static <F extends Feature<FC>, FC extends FeatureConfiguration> PlacedFeatureKey registerVegetation(
            String name, F feature, FC config, int density
    ) {
        ResourceLocation id = BetterEnd.C.mk(name);
        ConfiguredFeatureKey k = ConfiguredFeatureManager.configuration(id, feature);
        return BCLFeatureBuilder
                .start(id, feature)
                .configuration(config)
                .build()
                .place()
                .onEveryLayerMax(density)
                .onlyInBiome()
                .build();
    }


    private static <F extends Feature<NoneFeatureConfiguration>> BCLFeature<F, NoneFeatureConfiguration> registerRawGen(
            String name, F feature, int chance
    ) {
        return registerRawGen(name, feature, FeatureConfiguration.NONE, chance);
    }

    private static <F extends Feature<FC>, FC extends FeatureConfiguration> BCLFeature<F, FC> registerRawGen(
            String name, F feature, FC config, int chance
    ) {
        return BCLFeatureBuilder
                .start(BetterEnd.C.mk(name), feature)
                .configuration(config)
                .build()
                .place()
                .decoration(Decoration.RAW_GENERATION)
                .onceEvery(chance)
                .squarePlacement()
                .onlyInBiome()
                .build();
    }

    private static <F extends Feature<NoneFeatureConfiguration>> BCLFeature<F, NoneFeatureConfiguration> registerLake(
            String name, F feature, int chance
    ) {
        return BCLFeatureBuilder
                .start(BetterEnd.C.mk(name), feature)
                .build()
                .place()
                .decoration(Decoration.LAKES)
                .onceEvery(chance)
                .squarePlacement()
                .onlyInBiome()
                .build();
    }

    private static <F extends Feature<NoneFeatureConfiguration>> BCLFeature<F, NoneFeatureConfiguration> registerChanced(
            String name, F feature, int chance
    ) {
        return registerChanced(name, feature, FeatureConfiguration.NONE, chance);
    }

    private static <F extends Feature<FC>, FC extends FeatureConfiguration> BCLFeature<F, FC> registerChanced(
            String name, F feature, FC config, int chance
    ) {
        return BCLFeatureBuilder
                .start(BetterEnd.C.mk(name), feature)
                .configuration(config)
                .build()
                .place()
                .decoration(Decoration.SURFACE_STRUCTURES)
                .onceEvery(chance)
                .squarePlacement()
                .onlyInBiome()
                .build();
    }

    private static BCLFeature<OreFeature, OreConfiguration> registerOre(
            String name, Block blockOre, int veins, int veinSize
    ) {
        return BCLFeatureBuilder
                .startOre(BetterEnd.C.mk(name))
                .add(Blocks.END_STONE, blockOre)
                .veinSize(veinSize)
                .discardChanceOnAirExposure(0)
                .build()
                .place()
                .decoration(Decoration.UNDERGROUND_ORES)
                .count(veins)
                .randomHeight8FromFloorCeil()
                .squarePlacement()
                .onlyInBiome()
                .build();
    }

    private static BCLFeature<OreLayerFeature, OreLayerFeatureConfig> registerLayer(
            String name, Block block, float radius, int minY, int maxY, int count
    ) {
        OreLayerFeature layer = inlineBuild("ore_layer", new OreLayerFeature());
        return BCLFeatureBuilder
                .start(BetterEnd.C.mk(name), layer)
                .configuration(new OreLayerFeatureConfig(block.defaultBlockState(), radius, minY, maxY))
                .build()
                .place()
                .onlyInBiome()
                .decoration(GenerationStep.Decoration.UNDERGROUND_ORES)
                .count(count)
                .build();
    }

    private static BCLFeature<OreLayerFeature, OreLayerFeatureConfig> registerLayer(
            String name, StoneMaterial material, float radius, int minY, int maxY, int count
    ) {
        return registerLayer(name, material.stone, radius, minY, maxY, count);
    }

    public static void addBiomeFeatures(ResourceLocation id, Holder<Biome> biome) {
        if (!BetterEnd.MOD_ID.equals(id.getNamespace())) {
            BiomeAPI.addBiomeFeature(biome, FLAVOLITE_LAYER);
            BiomeAPI.addBiomeFeature(biome, THALLASIUM_ORE);
            BiomeAPI.addBiomeFeature(biome, ENDER_ORE);
            BiomeAPI.addBiomeFeature(biome, CRASHED_SHIP);
            BCLBiome bclbiome = BiomeAPI.getBiome(id);
            if (!BCLBiomeRegistry.isEmptyBiome(bclbiome)) {
                BCLFeature<BuildingListFeature, BuildingListFeatureConfig> feature = getBiomeStructures(bclbiome.getID());
                if (feature != null) {
                    BiomeAPI.addBiomeFeature(biome, feature);
                }
            }

            boolean hasCaves = !(bclbiome instanceof EndCaveBiome);
            if (!(bclbiome instanceof EndCaveBiome) && bclbiome instanceof EndBiome endBiome) {
                hasCaves = endBiome.hasCaves();
            }
            if (hasCaves && !BiomeAPI.wasRegisteredAsEndVoidBiome(id) /*!BiomeAPI.END_VOID_BIOME_PICKER.containsImmutable(id)*/) {
                if (Configs.BIOME_CONFIG.getBoolean(id, "hasCaves", true)) {
                    BiomeAPI.addBiomeFeature(biome, ROUND_CAVE);
                    BiomeAPI.addBiomeFeature(biome, TUNEL_CAVE);
                }
            }
        }
    }

    private static BCLFeature<BuildingListFeature, BuildingListFeatureConfig> getBiomeStructures(ResourceLocation loc) {
        String ns = loc.getNamespace();
        String nm = loc.getPath();
        return getBiomeStructures(ns, nm);
    }

    private static BCLFeature<BuildingListFeature, BuildingListFeatureConfig> getBiomeStructures(String ns, String nm) {
        ResourceLocation id = new ResourceLocation(ns, nm + "_structures");

        if (WorldBootstrap.getLastRegistryAccess() != null) {
            Registry<PlacedFeature> features = WorldBootstrap
                    .getLastRegistryAccess()
                    .registryOrThrow(Registries.PLACED_FEATURE);
            if (features.containsKey(id)) {
                BCLib.LOGGER.info("Feature for " + id + " was already build");
            }
        }

        String path = "/data/" + ns + "/structures/biome/" + nm + "/";
        InputStream inputstream = EndFeatures.class.getResourceAsStream(path + "structures.json");
        if (inputstream != null) {
            JsonObject obj = JsonFactory.getJsonObject(inputstream);
            JsonArray structures = obj.getAsJsonArray("structures");
            if (structures != null) {
                List<BuildingListFeature.StructureInfo> list = Lists.newArrayList();
                structures.forEach((entry) -> {
                    JsonObject e = entry.getAsJsonObject();
                    String structure = path + e.get("nbt").getAsString() + ".nbt";
                    NBTFeature.TerrainMerge terrainMerge = NBTFeature.TerrainMerge.getFromString(e
                            .get("terrainMerge")
                            .getAsString());
                    int offsetY = e.get("offsetY").getAsInt();
                    list.add(new BuildingListFeature.StructureInfo(structure, offsetY, terrainMerge));
                });
                if (!list.isEmpty()) {
                    return BCLFeatureBuilder
                            .start(new ResourceLocation(ns, nm + "_structures"), BUILDING_LIST_FEATURE)
                            .configuration(new BuildingListFeatureConfig(list, Blocks.END_STONE.defaultBlockState()))
                            .build()
                            .place()
                            .decoration(Decoration.SURFACE_STRUCTURES)
                            .onceEvery(10)
                            .squarePlacement()
                            .onlyInBiome()
                            .build();
                }
            }
        }
        return null;
    }

    public static EndBiomeBuilder addDefaultFeatures(
            ResourceLocation biomeID, EndBiomeBuilder builder, boolean hasCaves
    ) {
        builder.feature(THALLASIUM_ORE);
        builder.feature(ENDER_ORE);
        builder.feature(CRASHED_SHIP);

        BCLFeature<BuildingListFeature, BuildingListFeatureConfig> feature = getBiomeStructures(biomeID);
        if (feature != null) {
            builder.feature(feature);
        }

        if (hasCaves) {
            builder.feature(ROUND_CAVE);
            builder.feature(TUNEL_CAVE);
        }

        return builder;
    }

    public static void register() {
    }
}
