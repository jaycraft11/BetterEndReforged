package org.betterx.datagen.betterend.tags;

import org.betterx.bclib.api.v2.ComposterAPI;
import org.betterx.betterend.item.tool.EndHammerItem;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndItems;
import org.betterx.betterend.registry.EndTags;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverTagProvider;
import org.betterx.wover.tag.api.event.context.ItemTagBootstrapContext;
import org.betterx.wover.tag.api.predefined.CommonItemTags;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ItemTagProvider extends WoverTagProvider.ForItems {
    public ItemTagProvider(ModCore modCore) {
        super(modCore);
    }

    @Override
    protected void prepareTags(ItemTagBootstrapContext context) {
        EndItems.getModItems().forEach(item -> {
            FoodProperties food = item.components().get(DataComponents.FOOD);
            if (food != null) {
                float compost = food.nutrition() * food.saturation() * 0.18F;
                ComposterAPI.allowCompost(compost, item);
            }

            if (item instanceof EndHammerItem) {
                context.add(CommonItemTags.HAMMERS, item);
            }
        });

        context.add(ItemTags.BEACON_PAYMENT_ITEMS, EndItems.AETERNIUM_INGOT);

        context.add(CommonItemTags.IRON_INGOTS, EndBlocks.THALLASIUM.ingot);

        context.add(EndTags.ALLOYING_IRON, Items.IRON_ORE, Items.DEEPSLATE_IRON_ORE, Items.RAW_IRON);
        context.add(EndTags.ALLOYING_GOLD, Items.GOLD_ORE, Items.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD);
        context.add(EndTags.ALLOYING_COPPER, Items.COPPER_ORE, Items.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER);

        context.add(ItemTags.FISHES, EndItems.END_FISH_RAW, EndItems.END_FISH_COOKED);
    }
}
