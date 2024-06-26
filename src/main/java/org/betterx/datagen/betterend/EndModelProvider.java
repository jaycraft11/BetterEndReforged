package org.betterx.datagen.betterend;

import org.betterx.bclib.blocks.BaseVineBlock;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.client.models.EndModels;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.wover.block.api.BlockProperties;
import org.betterx.wover.block.api.BlockRegistry;
import org.betterx.wover.block.api.model.WoverBlockModelGenerators;
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
