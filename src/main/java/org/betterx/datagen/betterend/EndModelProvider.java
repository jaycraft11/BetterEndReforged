package org.betterx.datagen.betterend;

import org.betterx.bclib.blocks.BaseVineBlock;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.blocks.basis.PedestalBlock;
import org.betterx.betterend.client.models.EndModels;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.wover.block.api.BlockProperties;
import org.betterx.wover.block.api.BlockRegistry;
import org.betterx.wover.block.api.model.WoverBlockModelGenerators;
import org.betterx.wover.core.api.IntegrationCore;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.provider.WoverModelProvider;

import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class EndModelProvider extends WoverModelProvider {
    @Override
    protected void bootstrapItemModels(ItemModelGenerators itemModelGenerator) {

    }

    @Override
    protected void bootstrapBlockStateModels(WoverBlockModelGenerators generator) {
        this.addFromRegistry(
                generator,
                BlockRegistry.forMod(BetterEnd.C),
                true,
                ModelOverides.create()
                             .override(EndBlocks.TWISTED_VINE, createTwistedVineModel(generator))
                             .override(EndBlocks.AMBER_MOSS, createAmberMossModel(generator))
                             .override(EndBlocks.AMBER_MOSS_PATH, createAmberMossPathModel(generator, EndBlocks.AMBER_MOSS))
                             .override(EndBlocks.QUARTZ_PEDESTAL, block -> PedestalBlock.provideBlockModel(generator, new TextureMapping()
                                     .put(TextureSlot.TOP, IntegrationCore.MINECRAFT.mk("block/quartz_pillar_top"))
                                     .put(TextureSlot.BOTTOM, IntegrationCore.MINECRAFT.mk("block/quartz_block_bottom"))
                                     .put(EndModels.BASE, IntegrationCore.MINECRAFT.mk("block/quartz_block_side"))
                                     .put(EndModels.PILLAR, IntegrationCore.MINECRAFT.mk("block/quartz_pillar")), block))
                             .override(EndBlocks.PURPUR_PEDESTAL, block -> PedestalBlock.provideBlockModel(generator, new TextureMapping()
                                     .put(TextureSlot.TOP, IntegrationCore.MINECRAFT.mk("block/purpur_pillar_top"))
                                     .put(TextureSlot.BOTTOM, IntegrationCore.MINECRAFT.mk("block/purpur_block"))
                                     .put(EndModels.BASE, IntegrationCore.MINECRAFT.mk("block/purpur_block"))
                                     .put(EndModels.PILLAR, IntegrationCore.MINECRAFT.mk("block/purpur_pillar")), block))
                             .ignore(EndBlocks.CRYSTAL_GRASS)
                             .ignore(EndBlocks.SALTEAGO)
                             .ignore(EndBlocks.LAMELLARIUM)
                             .ignore(EndBlocks.INFLEXIA)
                             .ignore(EndBlocks.SHADOW_PLANT)
                             .ignore(EndBlocks.AERIDIUM)
                             .ignore(EndBlocks.BLOOMING_COOKSONIA)
                             .ignore(EndBlocks.BUSHY_GRASS)
                             .ignore(EndBlocks.JUNGLE_GRASS)
                             .ignore(EndBlocks.AMBER_GRASS)
                             .ignore(EndBlocks.VAIOLUSH_FERN)
                             .ignore(EndBlocks.FRACTURN)
                             .ignore(EndBlocks.LUTEBUS)
                             .ignore(EndBlocks.ORANGO)
                             .ignore(EndBlocks.GLOBULAGUS)
                             .ignore(EndBlocks.CLAWFERN)
                             .ignore(EndBlocks.JUNGLE_FERN)
                             .ignore(EndBlocks.BULB_MOSS)
                             .ignore(EndBlocks.FLAMAEA)
                             .ignore(EndBlocks.CAVE_BUSH)
                             .ignore(EndBlocks.BULB_VINE)
                             .ignore(EndBlocks.BULB_VINE_SEED)
                             .ignore(EndBlocks.SILK_MOTH_NEST)
                             .ignore(EndBlocks.SILK_MOTH_HIVE)
                             .ignore(EndBlocks.SMARAGDANT_SUBBLOCKS.stairs)
                             .ignore(EndBlocks.SMARAGDANT_SUBBLOCKS.wall)
                             .ignore(EndBlocks.GOLD_CHANDELIER)
                             .ignore(EndBlocks.IRON_CHANDELIER)
                             .ignore(EndBlocks.LUCERNIA_OUTER_LEAVES)
                             .ignore(EndBlocks.SULPHUR_CRYSTAL)
                             .ignore(EndBlocks.MOSSY_OBSIDIAN)
                             .ignore(EndBlocks.HYDROTHERMAL_VENT)
                             .ignore(EndBlocks.FLAVOLITE_RUNED_ETERNAL)
                             .ignore(EndBlocks.FLAVOLITE_RUNED)
                             .ignore(EndBlocks.MOSSY_GLOWSHROOM_HYMENOPHORE)
                             .ignore(EndBlocks.END_LOTUS_SEED)
                             .ignore(EndBlocks.END_LOTUS_LEAF)
                             .ignore(EndBlocks.CAVE_PUMPKIN)
                             .ignore(EndBlocks.NEON_CACTUS_BLOCK_STAIRS)
                             .ignore(EndBlocks.NEON_CACTUS_BLOCK)
                             .ignore(EndBlocks.FILALUX)
                             .ignore(EndBlocks.CREEPING_MOSS)
                             .ignore(EndBlocks.RESPAWN_OBELISK)
                             .ignore(EndBlocks.TWISTED_UMBRELLA_MOSS)
                             .ignore(EndBlocks.BLOSSOM_BERRY)
                             .ignore(EndBlocks.CAVE_PUMPKIN_SEED)
                             .ignore(EndBlocks.CHORUS_MUSHROOM)
                             .ignore(EndBlocks.SHADOW_BERRY)
                             .ignore(EndBlocks.LUMECORN_SEED)
                             .ignore(EndBlocks.HYDRALUX_SAPLING)
                             .ignore(EndBlocks.CHORUS_GRASS)
                             .ignore(EndBlocks.SMALL_JELLYSHROOM)
                             .ignore(EndBlocks.CAVE_GRASS)
                             .ignore(EndBlocks.GLOWING_PILLAR_SEED)
                             .ignore(EndBlocks.END_LILY_SEED)
                             .ignore(EndBlocks.BLUE_VINE_SEED)
                             .ignore(EndBlocks.TUBE_WORM)
                             .ignore(EndBlocks.AMBER_ROOT)
                             .ignore(EndBlocks.PURPLE_POLYPORE)
                             .ignore(EndBlocks.NEON_CACTUS)
                             .ignore(EndBlocks.AURANT_POLYPORE)
                             .ignore(EndBlocks.NEEDLEGRASS)
                             .ignore(EndBlocks.VIOLECITE.flowerPot)
                             .ignore(EndBlocks.UMBRALITH.flowerPot)
                             .ignore(EndBlocks.SULPHURIC_ROCK.flowerPot)
                             .ignore(EndBlocks.VIRID_JADESTONE.flowerPot)
                             .ignore(EndBlocks.AZURE_JADESTONE.flowerPot)
                             .ignore(EndBlocks.SANDY_JADESTONE.flowerPot)
                             .ignore(EndBlocks.FLAVOLITE.flowerPot)
                             .ignore(EndBlocks.ENDSTONE_FLOWER_POT)
                             .ignore(EndBlocks.SMARAGDANT_CRYSTAL_SHARD)
                             .ignore(EndBlocks.END_LOTUS_STEM)
                             .ignore(EndBlocks.THALLASIUM.chandelier)
                             .ignore(EndBlocks.TERMINITE.chandelier)
                             .ignore(EndBlocks.RUTISCUS)
                             .ignore(EndBlocks.MURKWEED)
                             .ignore(EndBlocks.LANCELEAF_SEED)
                             .ignore(EndBlocks.CHARNIA_RED)
                             .ignore(EndBlocks.CHARNIA_CYAN)
                             .ignore(EndBlocks.CHARNIA_GREEN)
                             .ignore(EndBlocks.CHARNIA_ORANGE)
                             .ignore(EndBlocks.CHARNIA_PURPLE)
                             .ignore(EndBlocks.CHARNIA_LIGHT_BLUE)
                             .ignore(EndBlocks.BOLUX_MUSHROOM)
                             .ignore(EndBlocks.SMALL_AMARANITA_MUSHROOM)
                             .ignore(EndBlocks.FLAMMALIX)
                             .ignore(EndBlocks.BUBBLE_CORAL)
                             .ignore(EndBlocks.FILALUX_WINGS)
        );
    }

    private static ModelOverides.@NotNull BlockModelProvider createAmberMossPathModel(
            WoverBlockModelGenerators generator,
            Block baseBlock
    ) {
        return block -> {
            final var endStone = TextureMapping.getBlockTexture(Blocks.END_STONE);
            final var baseTexture = TextureMapping.getBlockTexture(block, "_top");
            final var models = List.of("_1", "_2", "_3").stream().map(suffix -> {
                final var side = TextureMapping.getBlockTexture(baseBlock, "_side" + suffix);
                final var mapping = new TextureMapping()
                        .put(TextureSlot.BOTTOM, endStone)
                        .put(TextureSlot.TOP, baseTexture)
                        .put(TextureSlot.SIDE, side);
                return EndModels.PATH.createWithSuffix(block, suffix, mapping, generator.modelOutput());
            }).toList();

            buildRotated(generator, block, models);
        };
    }

    private static ModelOverides.@NotNull BlockModelProvider createAmberMossModel(WoverBlockModelGenerators generator) {
        return block -> {
            final var endStone = TextureMapping.getBlockTexture(Blocks.END_STONE);
            final var baseTexture = TextureMapping.getBlockTexture(block, "_top");
            final var models = List.of("_1", "_2", "_3").stream().map(suffix -> {
                final var side = TextureMapping.getBlockTexture(block, "_side" + suffix);
                final var mapping = new TextureMapping()
                        .put(TextureSlot.DOWN, endStone)
                        .put(TextureSlot.UP, baseTexture)
                        .put(TextureSlot.PARTICLE, side)
                        .put(TextureSlot.EAST, side)
                        .put(TextureSlot.NORTH, side)
                        .put(TextureSlot.SOUTH, side)
                        .put(TextureSlot.WEST, side);
                return ModelTemplates.CUBE.createWithSuffix(block, suffix, mapping, generator.modelOutput());
            }).toList();

            buildRotated(generator, block, models);
        };
    }

    private static void buildRotated(WoverBlockModelGenerators generator, Block block, List<ResourceLocation> models) {
        final ArrayList<Variant> variants = new ArrayList<>(models.size() * 4);
        models.forEach(model -> {
            variants.add(Variant.variant().with(VariantProperties.MODEL, model));
            variants.add(Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));
            variants.add(Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180));
            variants.add(Variant.variant()
                                .with(VariantProperties.MODEL, model)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));
        });

        generator.acceptBlockState(MultiVariantGenerator.multiVariant(block, variants.toArray(new Variant[0])));
        generator.delegateItemModel(block, models.get(0));
    }

    private static ModelOverides.@NotNull BlockModelProvider createTwistedVineModel(WoverBlockModelGenerators generator) {
        return block -> {
            final var itemTextureLocation = TextureMapping.getBlockTexture(block, "_bottom");
            var bottomMapping = new TextureMapping()
                    .put(TextureSlot.TEXTURE, itemTextureLocation);
            var middleMapping = new TextureMapping()
                    .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block));
            var topMapping = new TextureMapping()
                    .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block))
                    .put(EndModels.ROOTS, TextureMapping.getBlockTexture(block, "_roots"));

            var bottom_1 = EndModels.CROSS_NO_DISTORTION.createWithSuffix(block, "_bottom_1", bottomMapping, generator.modelOutput());
            var bottom_2 = EndModels.CROSS_NO_DISTORTION_INVERTED.createWithSuffix(block, "_bottom_2", bottomMapping, generator.modelOutput());
            var middle_1 = EndModels.CROSS_NO_DISTORTION.createWithSuffix(block, "_middle_1", middleMapping, generator.modelOutput());
            var middle_2 = EndModels.CROSS_NO_DISTORTION_INVERTED.createWithSuffix(block, "_middle_2", middleMapping, generator.modelOutput());
            var top = EndModels.TWISTED_VINE.createWithSuffix(block, "_top", topMapping, generator.modelOutput());

            generator.acceptBlockState(MultiVariantGenerator
                    .multiVariant(block)
                    .with(PropertyDispatch.property(BaseVineBlock.SHAPE)
                                          .select(
                                                  BlockProperties.TripleShape.TOP,
                                                  Variant.variant().with(VariantProperties.MODEL, top)
                                          )
                                          .select(
                                                  BlockProperties.TripleShape.MIDDLE,
                                                  List.of(
                                                          Variant.variant().with(VariantProperties.MODEL, middle_1),
                                                          Variant.variant().with(VariantProperties.MODEL, middle_2)
                                                  )

                                          )
                                          .select(
                                                  BlockProperties.TripleShape.BOTTOM,
                                                  List.of(
                                                          Variant.variant().with(VariantProperties.MODEL, bottom_1),
                                                          Variant.variant().with(VariantProperties.MODEL, bottom_2)
                                                  )
                                          )
                    )
            );

            generator.createFlatItem(block, itemTextureLocation);
        };
    }

    public EndModelProvider(ModCore modCore) {
        super(modCore);
    }
}
