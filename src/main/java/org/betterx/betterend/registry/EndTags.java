package org.betterx.betterend.registry;

import org.betterx.betterend.BetterEnd;
import org.betterx.wover.tag.api.TagManager;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class EndTags {
    // Table with common (c) tags:
    // https://fabricmc.net/wiki/tutorial:tags

    public static final TagKey<Biome> IS_END_CAVE = TagManager.BIOMES.makeTag(BetterEnd.C, "is_end_cave");

    // Block Tags
    public static final TagKey<Block> PEDESTALS = TagManager.BLOCKS.makeTag(BetterEnd.C, "pedestal");

    // Item Tags
    public static final TagKey<Item> ALLOYING_IRON = TagManager.ITEMS.makeTag(BetterEnd.C, "alloying_iron");
    public static final TagKey<Item> ALLOYING_GOLD = TagManager.ITEMS.makeTag(BetterEnd.C, "alloying_gold");
    public static final TagKey<Item> ALLOYING_COPPER = TagManager.ITEMS.makeTag(BetterEnd.C, "alloying_copper");

    public static final TagKey<Block> BONEMEAL_SOURCE_DRAGON_BONE = TagManager.BLOCKS.makeTag(
            BetterEnd.C,
            "bonemeal/source/dragon_bone"
    );
    public static final TagKey<Block> BONEMEAL_TARGET_DRAGON_BONE = TagManager.BLOCKS.makeTag(
            BetterEnd.C,
            "bonemeal/target/dragon_bone"
    );

    public static final TagKey<Block> BONEMEAL_SOURCE_WATER_GRASS = TagManager.BLOCKS.makeTag(
            BetterEnd.C,
            "bonemeal/source/water_grass"
    );

    public static final TagKey<Block> BONEMEAL_TARGET_WATER_GRASS = TagManager.BLOCKS.makeTag(
            BetterEnd.C,
            "bonemeal/target/water_grass"
    );

    public static void register() {


    }
}
