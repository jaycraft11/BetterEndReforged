package org.betterx.betterend.complexmaterials;

import org.betterx.bclib.complexmaterials.WoodenComplexMaterial;
import org.betterx.bclib.complexmaterials.entry.RecipeEntry;
import org.betterx.bclib.complexmaterials.entry.SlotMap;
import org.betterx.bclib.complexmaterials.set.wood.HangingSign;
import org.betterx.bclib.complexmaterials.set.wood.WoodSlots;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.wover.recipe.api.CraftingRecipeBuilder;
import org.betterx.wover.recipe.api.RecipeBuilder;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Consumer;

public class JellyLucerniaWoodMaterial extends EndWoodenComplexMaterial {
    public JellyLucerniaWoodMaterial() {
        super("lucernia_jellyshroom", MapColor.COLOR_PURPLE, MapColor.COLOR_ORANGE);
    }

    @Override
    protected SlotMap<WoodenComplexMaterial> createMaterialSlots() {
        return SlotMap.<WoodenComplexMaterial>of(new HangingSign() {
            @Override
            public void addRecipeEntry(WoodenComplexMaterial parentMaterial, Consumer<RecipeEntry> adder) {
                adder.accept(new RecipeEntry(suffix, (ctx, mat, id) ->
                {
                    CraftingRecipeBuilder craftingRecipeBuilder1 = RecipeBuilder.crafting(id, parentMaterial.getBlock(suffix));
                    CraftingRecipeBuilder craftingRecipeBuilder2 = craftingRecipeBuilder1.outputCount(3);
                    CraftingRecipeBuilder craftingRecipeBuilder = craftingRecipeBuilder2.shape("I I", "o#o", "o#o")
                                                                                        .addMaterial('#', EndBlocks.LUCERNIA.getBlock(WoodSlots.STRIPPED_LOG))
                                                                                        .addMaterial('o', EndBlocks.JELLYSHROOM.getBlock(WoodSlots.LOG))
                                                                                        .addMaterial('I', Items.CHAIN);
                    craftingRecipeBuilder.group("sign")
                                         .setCategory(RecipeCategory.DECORATIONS)
                                         .build(ctx);
                }
                ));
            }
        });
    }
}
