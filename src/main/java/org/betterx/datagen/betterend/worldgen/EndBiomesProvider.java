package org.betterx.datagen.betterend.worldgen;

import org.betterx.betterend.registry.EndBiomes;
import org.betterx.betterend.registry.EndTags;
import org.betterx.betterend.world.biome.air.BiomeIceStarfield;
import org.betterx.betterend.world.biome.cave.*;
import org.betterx.betterend.world.biome.land.*;
import org.betterx.wover.biome.api.builder.BiomeBootstrapContext;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.provider.multi.WoverBiomeProvider;
import org.betterx.wover.tag.api.predefined.CommonBiomeTags;

import org.jetbrains.annotations.NotNull;

public class EndBiomesProvider extends WoverBiomeProvider {
    public EndBiomesProvider(@NotNull ModCore modCore) {
        super(modCore);
    }

    @Override
    protected void bootstrap(BiomeBootstrapContext context) {
        EndBiomes.FOGGY_MUSHROOMLAND.bootstrap(context, new FoggyMushroomlandBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.CHORUS_FOREST.bootstrap(context, new ChorusForestBiome(), CommonBiomeTags.IS_END_HIGHLAND);
        EndBiomes.DUST_WASTELANDS.bootstrap(context, new DustWastelandsBiome(), CommonBiomeTags.IS_END_MIDLAND);
        EndBiomes.NEON_OASIS.bootstrap(context, new NeonOasisBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.PAINTED_MOUNTAINS.bootstrap(context, new PaintedMountainsBiome(), CommonBiomeTags.IS_END_HIGHLAND);
        EndBiomes.MEGALAKE.bootstrap(context, new MegalakeBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.MEGALAKE_GROVE.bootstrap(context, new MegalakeGroveBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.CRYSTAL_MOUNTAINS.bootstrap(context, new CrystalMountainsBiome(), CommonBiomeTags.IS_END_HIGHLAND);
        EndBiomes.SHADOW_FOREST.bootstrap(context, new ShadowForestBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.AMBER_LAND.bootstrap(context, new AmberLandBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.BLOSSOMING_SPIRES.bootstrap(context, new BlossomingSpiresBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.SULPHUR_SPRINGS.bootstrap(context, new SulphurSpringsBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.UMBRELLA_JUNGLE.bootstrap(context, new UmbrellaJungleBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.GLOWING_GRASSLANDS.bootstrap(context, new GlowingGrasslandsBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.DRAGON_GRAVEYARDS.bootstrap(context, new DragonGraveyardsBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.DRY_SHRUBLAND.bootstrap(context, new DryShrublandBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.LANTERN_WOODS.bootstrap(context, new LanternWoodsBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.UMBRA_VALLEY.bootstrap(context, new UmbraValleyBiome(), CommonBiomeTags.IS_END_LAND);
        EndBiomes.ICE_STARFIELD.bootstrap(context, new BiomeIceStarfield(), CommonBiomeTags.IS_SMALL_END_ISLAND);

        EndBiomes.EMPTY_END_CAVE.bootstrap(context, new EmptyEndCaveBiome(), EndTags.IS_END_CAVE);
        EndBiomes.EMPTY_SMARAGDANT_CAVE.bootstrap(context, new EmptySmaragdantCaveBiome(), EndTags.IS_END_CAVE);
        EndBiomes.LUSH_SMARAGDANT_CAVE.bootstrap(context, new LushSmaragdantCaveBiome(), EndTags.IS_END_CAVE);
        EndBiomes.EMPTY_AURORA_CAVE.bootstrap(context, new EmptyAuroraCaveBiome(), EndTags.IS_END_CAVE);
        EndBiomes.LUSH_AURORA_CAVE.bootstrap(context, new LushAuroraCaveBiome(), EndTags.IS_END_CAVE);
        EndBiomes.JADE_CAVE.bootstrap(context, new JadeCaveBiome(), EndTags.IS_END_CAVE);

    }
}
