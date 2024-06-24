package org.betterx.datagen.betterend;

import org.betterx.bclib.client.models.BCLModels;
import org.betterx.bclib.complexmaterials.ComplexMaterial;
import org.betterx.bclib.complexmaterials.set.wood.WoodSlots;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.wover.block.api.BlockRegistry;
import org.betterx.wover.block.api.model.WoverBlockModelGenerators;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.provider.WoverModelProvider;

import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class EndModelProvider extends WoverModelProvider {


    @Override
    protected void bootstrapItemModels(ItemModelGenerators itemModelGenerator) {

    }

    @Override
    protected void bootstrapBlockStateModels(WoverBlockModelGenerators generator) {
        this.addFromRegistry(
                generator,
                BlockRegistry.forMod(BetterEnd.C),
                true
        );

        addFurniture(generator, EndBlocks.LACUGROVE, Blocks.CYAN_WOOL);
        addFurniture(generator, EndBlocks.JELLYSHROOM, Blocks.PURPLE_WOOL);
        addFurniture(generator, EndBlocks.TENANEA, Blocks.PINK_WOOL);
        addFurniture(generator, EndBlocks.LUCERNIA, Blocks.WHITE_WOOL);
        addFurniture(generator, EndBlocks.PYTHADENDRON, Blocks.BLACK_WOOL);
        addFurniture(generator, EndBlocks.DRAGON_TREE, Blocks.BLACK_WOOL);
        addFurniture(generator, EndBlocks.MOSSY_GLOWSHROOM, Blocks.GRAY_WOOL);
        addFurniture(generator, EndBlocks.HELIX_TREE, Blocks.GRAY_WOOL);
        addFurniture(generator, EndBlocks.END_LOTUS, Blocks.LIGHT_BLUE_WOOL);
        addFurniture(generator, EndBlocks.UMBRELLA_TREE, Blocks.MAGENTA_WOOL);
    }

    protected void addFurniture(WoverBlockModelGenerators generator, ComplexMaterial mat, Block cloth) {
        addFurniture(
                generator,
                mat.getBlock(WoodSlots.PLANKS),
                cloth,
                mat.getBlock(WoodSlots.BAR_STOOL),
                mat.getBlock(WoodSlots.CHAIR),
                mat.getBlock(WoodSlots.TABURET)
        );
    }

    private static void addFurniture(
            WoverBlockModelGenerators generator,
            Block base,
            Block cloth,
            Block barStool,
            Block chair,
            Block taburet
    ) {
        BCLModels.createBarStoolBlockModel(generator, barStool, base, cloth);
        BCLModels.createChairBlockModel(generator, chair, base, cloth);
        BCLModels.createTaburetBlockModel(generator, taburet, base);
    }

    public EndModelProvider(ModCore modCore) {
        super(modCore);
    }
}
