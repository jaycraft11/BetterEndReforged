package org.betterx.betterend.world.biome.cave;

import org.betterx.bclib.api.v2.levelgen.biomes.BCLBiomeSettings;
import org.betterx.bclib.interfaces.SurfaceMaterialProvider;
import org.betterx.bclib.util.WeightedList;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndFeatures;
import org.betterx.betterend.registry.EndParticles;
import org.betterx.betterend.world.biome.EndBiome;
import org.betterx.betterend.world.biome.EndBiomeBuilder;
import org.betterx.wover.block.api.BlockProperties;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LushAuroraCaveBiome extends EndCaveBiome.Config {
    public static final MapCodec<Biome> CODEC = EndCaveBiome.simpleCaveBiomeCodec(LushAuroraCaveBiome.Biome::new);
    public static final KeyDispatchDataCodec<LushAuroraCaveBiome.Biome> KEY_CODEC = KeyDispatchDataCodec.of(CODEC);

    public static class Biome extends EndCaveBiome {
        public Biome(ResourceKey<net.minecraft.world.level.biome.Biome> biomeID, BCLBiomeSettings settings) {
            super(biomeID, settings);

            this.addFloorFeature(EndFeatures.BIG_AURORA_CRYSTAL.configuredFeature, 1);
            this.addFloorFeature(EndFeatures.CAVE_BUSH.configuredFeature, 5);
            this.addFloorFeature(EndFeatures.CAVE_GRASS.configuredFeature, 40);
            this.addFloorFeature(EndFeatures.END_STONE_STALAGMITE_CAVEMOSS.configuredFeature, 5);

            this.addCeilFeature(EndFeatures.CAVE_BUSH.configuredFeature, 1);
            this.addCeilFeature(EndFeatures.CAVE_PUMPKIN.configuredFeature, 1);
            this.addCeilFeature(EndFeatures.RUBINEA.configuredFeature, 3);
            this.addCeilFeature(EndFeatures.MAGNULA.configuredFeature, 1);
            this.addCeilFeature(EndFeatures.END_STONE_STALACTITE_CAVEMOSS.configuredFeature, 10);
        }

        @Override
        public KeyDispatchDataCodec<? extends EndCaveBiome> codec() {
            return LushAuroraCaveBiome.KEY_CODEC;
        }

        protected Biome(
                float fogDensity,
                @NotNull ResourceKey<net.minecraft.world.level.biome.Biome> biome,
                @NotNull List<Climate.ParameterPoint> parameterPoints,
                float terrainHeight,
                float genChance,
                int edgeSize,
                boolean vertical,
                @Nullable ResourceKey<net.minecraft.world.level.biome.Biome> edge,
                @Nullable ResourceKey<net.minecraft.world.level.biome.Biome> parent,
                boolean hasCaves,
                SurfaceMaterialProvider surface,
                WeightedList<Holder<ConfiguredFeature<?, ?>>> floorFeatures,
                WeightedList<Holder<ConfiguredFeature<?, ?>>> ceilFeatures
        ) {
            super(
                    fogDensity, biome, parameterPoints, terrainHeight,
                    genChance, edgeSize, vertical,
                    edge, parent,
                    hasCaves, surface, floorFeatures, ceilFeatures
            );
        }

        @Override
        public float getFloorDensity() {
            return 0.2F;
        }

        @Override
        public float getCeilDensity() {
            return 0.1F;
        }

        @Override
        public BlockState getCeil(BlockPos pos) {
            return EndBlocks.CAVE_MOSS.defaultBlockState()
                                      .setValue(BlockProperties.TRIPLE_SHAPE, BlockProperties.TripleShape.TOP);
        }
    }

    public LushAuroraCaveBiome() {
        super();
    }

    @Override
    public void addCustomBuildData(EndBiomeBuilder builder) {
        super.addCustomBuildData(builder);
        builder.fogColor(150, 30, 68)
               .fogDensity(2.0F)
               .plantsColor(108, 25, 46)
               .waterAndFogColor(186, 77, 237)
               .particles(EndParticles.GLOWING_SPHERE, 0.001F)
        ;
    }

    @Override
    public SurfaceMaterialProvider surfaceMaterial() {
        return new EndBiome.DefaultSurfaceMaterialProvider() {
            @Override
            public BlockState getTopMaterial() {
                return EndBlocks.CAVE_MOSS.defaultBlockState();
            }
        };
    }
}
