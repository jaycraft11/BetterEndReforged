package org.betterx.betterend.world.biome.cave;

import org.betterx.bclib.api.v2.levelgen.biomes.BCLBiomeSettings;
import org.betterx.bclib.api.v3.levelgen.features.BCLFeature;
import org.betterx.bclib.api.v3.levelgen.features.BCLFeatureBuilder;
import org.betterx.bclib.interfaces.SurfaceMaterialProvider;
import org.betterx.bclib.util.WeightedList;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndBiomes;
import org.betterx.betterend.registry.EndFeatures;
import org.betterx.betterend.registry.EndSounds;
import org.betterx.betterend.world.biome.EndBiome;
import org.betterx.betterend.world.biome.EndBiomeBuilder;
import org.betterx.betterend.world.features.terrain.caves.CaveChunkPopulatorFeature;
import org.betterx.betterend.world.features.terrain.caves.CaveChunkPopulatorFeatureConfig;

import com.mojang.datafixers.util.Function13;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EndCaveBiome extends EndBiome {
    public static final MapCodec<EndCaveBiome> CODEC = simpleCaveBiomeCodec(EndCaveBiome::new);


    public static <T extends EndCaveBiome> MapCodec<T> simpleCaveBiomeCodec(final Function13<Float, ResourceKey<Biome>, List<Climate.ParameterPoint>, Float, Float, Integer, Boolean, ResourceKey<Biome>, ResourceKey<Biome>, Boolean, SurfaceMaterialProvider, WeightedList<Holder<ConfiguredFeature<?, ?>>>, WeightedList<Holder<ConfiguredFeature<?, ?>>>, T> factory) {
        return codec(
                Codec.BOOL.fieldOf("has_caves").orElse(true).forGetter(EndBiome::hasCaves),
                SurfaceMaterialProvider.CODEC.fieldOf("surface")
                                             .orElse(new DefaultSurfaceMaterialProvider())
                                             .forGetter(o -> o.surfMatProv),
                WeightedList.listCodec(ConfiguredFeature.CODEC, "configured_features", "configured_feature")
                            .fieldOf("floor_features")
                            .forGetter(o -> (WeightedList) ((EndCaveBiome) o).floorFeatures),
                WeightedList.listCodec(ConfiguredFeature.CODEC, "configured_features", "configured_feature")
                            .fieldOf("ceil_features")
                            .forGetter(o -> (WeightedList) ((EndCaveBiome) o).ceilFeatures),
                factory
        );
    }

    public static final KeyDispatchDataCodec<EndCaveBiome> KEY_CODEC = KeyDispatchDataCodec.of(CODEC);

    @Override
    public KeyDispatchDataCodec<? extends EndCaveBiome> codec() {
        return KEY_CODEC;
    }


    protected EndCaveBiome(
            float fogDensity,
            @NotNull ResourceKey<Biome> biome,
            @NotNull List<Climate.ParameterPoint> parameterPoints,
            float terrainHeight,
            float genChance,
            int edgeSize,
            boolean vertical,
            @Nullable ResourceKey<Biome> edge,
            @Nullable ResourceKey<Biome> parent,
            boolean hasCaves,
            SurfaceMaterialProvider surface,
            WeightedList<Holder<ConfiguredFeature<?, ?>>> floorFeatures,
            WeightedList<Holder<ConfiguredFeature<?, ?>>> ceilFeatures
    ) {
        super(
                fogDensity, biome, parameterPoints, terrainHeight,
                genChance, edgeSize, vertical,
                edge, parent,
                hasCaves,
                surface
        );
        this.floorFeatures.addAll((WeightedList) floorFeatures);
        this.ceilFeatures.addAll((WeightedList) ceilFeatures);
    }

    public static abstract class Config extends EndBiome.Config {
        protected Config() {
            super();
        }


        @Override
        public void addCustomBuildData(EndBiomeBuilder builder) {
            BCLFeature<CaveChunkPopulatorFeature, CaveChunkPopulatorFeatureConfig> feature = BCLFeatureBuilder
                    .start(
                            BetterEnd.C.mk(ID.getPath() + "_cave_populator"),
                            EndFeatures.CAVE_CHUNK_POPULATOR
                    )
                    .configuration(new CaveChunkPopulatorFeatureConfig(ID))
                    .build()
                    .place()
                    .decoration(GenerationStep.Decoration.UNDERGROUND_DECORATION)
                    .count(1)
                    .onlyInBiome()
                    .build();

            builder.feature(feature)
                   .intendedType(EndBiomes.END_CAVE)
                   .music(EndSounds.MUSIC_CAVES)
                   .loop(EndSounds.AMBIENT_CAVES);
        }

        @Override
        public boolean hasCaves() {
            return false;
        }

        @Override
        public boolean hasReturnGateway() {
            return false;
        }

    }

    private final WeightedList<Holder<? extends ConfiguredFeature<?, ?>>> floorFeatures = new WeightedList<>();
    private final WeightedList<Holder<? extends ConfiguredFeature<?, ?>>> ceilFeatures = new WeightedList<>();

    public EndCaveBiome(ResourceKey<Biome> biomeID, BCLBiomeSettings settings) {
        super(biomeID, settings);
    }

    public void addFloorFeature(Holder<? extends ConfiguredFeature<?, ?>> feature, float weight) {
        floorFeatures.add(feature, weight);
    }

    public void addCeilFeature(Holder<? extends ConfiguredFeature<?, ?>> feature, float weight) {
        ceilFeatures.add(feature, weight);
    }

    public Holder<? extends ConfiguredFeature<?, ?>> getFloorFeature(RandomSource random) {
        return floorFeatures.isEmpty() ? null : floorFeatures.get(random);
    }

    public Holder<? extends ConfiguredFeature<?, ?>> getCeilFeature(RandomSource random) {
        return ceilFeatures.isEmpty() ? null : ceilFeatures.get(random);
    }

    public float getFloorDensity() {
        return 0;
    }

    public float getCeilDensity() {
        return 0;
    }

    public BlockState getCeil(BlockPos pos) {
        return null;
    }

    public BlockState getWall(BlockPos pos) {
        return null;
    }

    public static EndCaveBiome create(EndBiome.Config biomeConfig) {
        return (EndCaveBiome) EndBiome.create(biomeConfig, EndBiomes.END_CAVE);
    }
}
