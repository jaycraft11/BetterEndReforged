package org.betterx.datagen.betterend.worldgen;

import org.betterx.betterend.BetterEnd;
import org.betterx.wover.block.api.BlockRegistry;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverTagProvider;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;
import org.betterx.wover.tag.api.predefined.CommonBlockTags;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BYGBlockTagsProvider extends WoverTagProvider.ForBlocks {
    public BYGBlockTagsProvider(ModCore modCore) {
        super(modCore);
    }

    private static Block IVIS_PHYLIUM;

    public static void registerBYGDummies() {
        BlockRegistry reg = BlockRegistry.forMod(BetterEnd.BYG);
        IVIS_PHYLIUM = reg.register("ivis_phylium", new Block(BlockBehaviour.Properties.of()));
    }

    @Override
    protected void prepareTags(TagBootstrapContext<Block> context) {
        context.add(CommonBlockTags.END_STONES, IVIS_PHYLIUM);
    }
}
