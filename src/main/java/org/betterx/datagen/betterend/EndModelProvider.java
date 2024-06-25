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
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;

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
                             .ignore(EndBlocks.TUBE_WORM)
        );
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
