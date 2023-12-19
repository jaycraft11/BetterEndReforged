package org.betterx.betterend.integration.rei;

import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;

public class REIBlastingDisplay extends REIAlloyingDisplay {
    public REIBlastingDisplay(RecipeHolder<BlastingRecipe> recipe) {
        super(recipe, recipe.value().getExperience(), recipe.value().getCookingTime());
    }
}