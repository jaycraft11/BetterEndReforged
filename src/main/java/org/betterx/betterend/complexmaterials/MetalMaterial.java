package org.betterx.betterend.complexmaterials;

import org.betterx.bclib.blocks.*;
import org.betterx.bclib.items.ModelProviderItem;
import org.betterx.bclib.items.tool.BaseAxeItem;
import org.betterx.bclib.items.tool.BaseHoeItem;
import org.betterx.bclib.items.tool.BaseShovelItem;
import org.betterx.bclib.items.tool.BaseSwordItem;
import org.betterx.bclib.recipes.BCLRecipeBuilder;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.blocks.BulbVineLanternBlock;
import org.betterx.betterend.blocks.BulbVineLanternColoredBlock;
import org.betterx.betterend.blocks.ChandelierBlock;
import org.betterx.betterend.blocks.basis.EndAnvilBlock;
import org.betterx.betterend.item.EndArmorItem;
import org.betterx.betterend.item.tool.EndHammerItem;
import org.betterx.betterend.item.tool.EndPickaxe;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndItems;
import org.betterx.betterend.registry.EndTemplates;
import org.betterx.wover.complex.api.equipment.ArmorSlot;
import org.betterx.wover.complex.api.equipment.ArmorTier;
import org.betterx.wover.recipe.api.RecipeBuilder;
import org.betterx.wover.tag.api.TagManager;
import org.betterx.wover.tag.api.event.context.ItemTagBootstrapContext;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class MetalMaterial implements MaterialManager.Material {
    public final Block ore;
    public final Block block;
    public final Block tile;
    public final Block bars;
    public final Block pressurePlate;
    public final Block door;
    public final Block trapdoor;
    public final Block chain;
    public final Block stairs;
    public final Block slab;

    public final Block chandelier;
    public final Block bulb_lantern;
    public final ColoredMaterial bulb_lantern_colored;

    public final Block anvilBlock;

    public final Item rawOre;
    public final Item nugget;
    public final Item ingot;

    public final Item shovelHead;
    public final Item pickaxeHead;
    public final Item axeHead;
    public final Item hoeHead;
    public final Item swordBlade;
    public final Item swordHandle;

    public final Item shovel;
    public final Item sword;
    public final Item pickaxe;
    public final Item axe;
    public final Item hoe;
    public final Item hammer;

    public final Item forgedPlate;
    public final Item helmet;
    public final Item chestplate;
    public final Item leggings;
    public final Item boots;

    public final TagKey<Item> alloyingOre;
    public final SmithingTemplateItem swordHandleTemplate;

    public final boolean hasOre;
    public final String name;
    public final int anvilLevel;
    public final TagKey<Item> anvilTools;

    private static final TagKey<Block> BARS_BLOCK_TAG = TagManager.BLOCKS.makeCommonTag("bars");
    private static final TagKey<Item> BARS_ITEM_TAG = TagManager.ITEMS.makeCommonTag("bars");
    private static final TagKey<Block> CHAIN_BLOCK_TAG = TagManager.BLOCKS.makeCommonTag("chains");
    private static final TagKey<Item> CHAINS_ITEM_TAG = TagManager.ITEMS.makeCommonTag("chains");

    public static MetalMaterial makeNormal(
            String name,
            MapColor color,
            Tier material,
            ArmorTier armor,
            int anvilLevel,
            TagKey<Item> anvilTools,
            SmithingTemplateItem swordHandleTemplate
    ) {
        return new MetalMaterial(
                name,
                true,
                () -> BlockBehaviour.Properties
                        .ofFullCopy(Blocks.IRON_BLOCK)
                        .mapColor(color),
                material,
                armor,
                anvilLevel,
                anvilTools,
                swordHandleTemplate
        );
    }


    public static MetalMaterial makeOreless(
            String name,
            MapColor color,
            float hardness,
            float resistance,
            Tier material,
            ArmorTier armor,
            int anvilLevel,
            TagKey<Item> anvilTools,
            SmithingTemplateItem swordHandleTemplate
    ) {
        return new MetalMaterial(
                name,
                false,
                () -> BlockBehaviour.Properties
                        .ofFullCopy(Blocks.IRON_BLOCK)
                        .mapColor(color)
                        .destroyTime(hardness)
                        .explosionResistance(resistance),
                material,
                armor,
                anvilLevel,
                anvilTools,
                swordHandleTemplate
        );
    }

    private MetalMaterial(
            String name,
            boolean hasOre,
            Supplier<BlockBehaviour.Properties> settingsSupplier,
            Tier material,
            ArmorTier armor,
            int anvilLevel,
            TagKey<Item> anvilTools,
            SmithingTemplateItem swordHandleTemplate
    ) {
        final BlockBehaviour.Properties settings = settingsSupplier.get();
        final BlockBehaviour.Properties lanternProperties = settingsSupplier
                .get()
                .destroyTime(1)
                .explosionResistance(1)
                .lightLevel((bs) -> 15)
                .sound(SoundType.LANTERN);

        this.anvilLevel = anvilLevel;
        this.anvilTools = anvilTools;
        this.hasOre = hasOre;
        this.name = name;
        this.swordHandleTemplate = swordHandleTemplate;
        rawOre = hasOre ? EndItems.registerEndItem(name + "_raw", new ModelProviderItem(EndItems.makeEndItemSettings())) : null;
        ore = hasOre ? EndBlocks.registerBlock(name + "_ore", new BaseOreBlock(() -> rawOre, 1, 3, 1)) : null;
        alloyingOre = hasOre ? TagManager.ITEMS.makeTag(BetterEnd.C, name + "_alloying") : null;


        block = EndBlocks.registerBlock(name + "_block", new BaseBlock.Metal(settings));
        tile = EndBlocks.registerBlock(name + "_tile", new BaseBlock.Metal(settings));
        stairs = EndBlocks.registerBlock(name + "_stairs", new BaseStairsBlock.Metal(tile));
        slab = EndBlocks.registerBlock(name + "_slab", new BaseSlabBlock.Metal(tile));
        door = EndBlocks.registerBlock(name + "_door", new BaseDoorBlock.Metal(block, BlockSetType.IRON));
        trapdoor = EndBlocks.registerBlock(name + "_trapdoor", new BaseTrapdoorBlock.Metal(block, BlockSetType.IRON));
        bars = EndBlocks.registerBlock(name + "_bars", new BaseBarsBlock.Metal(block));
        chain = EndBlocks.registerBlock(name + "_chain", new BaseChainBlock.Metal(block.defaultMapColor()));
        pressurePlate = EndBlocks.registerBlock(
                name + "_plate",
                new BasePressurePlateBlock.Wood(block, BlockSetType.IRON)
        );

        chandelier = EndBlocks.registerBlock(name + "_chandelier", new ChandelierBlock(block));
        bulb_lantern = EndBlocks.registerBlock(name + "_bulb_lantern", new BulbVineLanternBlock(lanternProperties));
        bulb_lantern_colored = new ColoredMaterial(BulbVineLanternColoredBlock::new, bulb_lantern, false);

        nugget = EndItems.registerEndItem(name + "_nugget", new ModelProviderItem(EndItems.makeEndItemSettings()));
        ingot = EndItems.registerEndItem(name + "_ingot", new ModelProviderItem(EndItems.makeEndItemSettings()));

        shovelHead = EndItems.registerEndItem(name + "_shovel_head");
        pickaxeHead = EndItems.registerEndItem(name + "_pickaxe_head");
        axeHead = EndItems.registerEndItem(name + "_axe_head");
        hoeHead = EndItems.registerEndItem(name + "_hoe_head");
        swordBlade = EndItems.registerEndItem(name + "_sword_blade");
        swordHandle = EndItems.registerEndItem(name + "_sword_handle");

        shovel = EndItems.registerEndTool(name + "_shovel", new BaseShovelItem(material, 1.5F, -3.0F, EndItems.makeEndItemSettings()));
        sword = EndItems.registerEndTool(name + "_sword", new BaseSwordItem(material, 3, -2.4F, EndItems.makeEndItemSettings()));
        pickaxe = EndItems.registerEndTool(name + "_pickaxe", new EndPickaxe(material, 1, -2.8F, EndItems.makeEndItemSettings()));
        axe = EndItems.registerEndTool(name + "_axe", new BaseAxeItem(material, 6.0F, -3.0F, EndItems.makeEndItemSettings()));
        hoe = EndItems.registerEndTool(name + "_hoe", new BaseHoeItem(material, -3, 0.0F, EndItems.makeEndItemSettings()));
        hammer = EndItems.registerEndTool(
                name + "_hammer",
                new EndHammerItem(material, 5.0F, -3.2F, 0.3f, EndItems.makeEndItemSettings())
        );

        forgedPlate = EndItems.registerEndItem(name + "_forged_plate");
        helmet = EndItems.registerEndItem(
                name + "_helmet",
                new EndArmorItem(armor, ArmorSlot.HELMET_SLOT, EndItems.makeEndItemSettings())
        );
        chestplate = EndItems.registerEndItem(
                name + "_chestplate",
                new EndArmorItem(armor, ArmorSlot.CHESTPLATE_SLOT, EndItems.makeEndItemSettings())
        );
        leggings = EndItems.registerEndItem(
                name + "_leggings",
                new EndArmorItem(armor, ArmorSlot.LEGGINGS_SLOT, EndItems.makeEndItemSettings())
        );
        boots = EndItems.registerEndItem(name + "_boots", new EndArmorItem(armor, ArmorSlot.BOOTS_SLOT, EndItems.makeEndItemSettings()));

        anvilBlock = EndBlocks.registerBlock(
                name + "_anvil",
                new EndAnvilBlock(this, block.defaultMapColor(), anvilLevel)
        );

        MaterialManager.register(this);
    }

    @Override
    public void registerRecipes(RecipeOutput context) {
        if (hasOre) {
            RecipeBuilder.blasting(BetterEnd.C.mk(name + "_ingot_furnace_ore"), ingot)
                         .input(ore)
                         .build(context);
            RecipeBuilder.blasting(BetterEnd.C.mk(name + "_ingot_furnace_raw"), ingot)
                         .input(rawOre)
                         .build(context);
            BCLRecipeBuilder.alloying(BetterEnd.C.mk(name + "_ingot_alloy"), ingot)
                            .setInput(alloyingOre, alloyingOre)
                            .outputCount(3)
                            .setExperience(2.1F)
                            .build(context);
        }

        // Basic recipes
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_ingot_from_nuggets"), ingot)
                     .shape("###", "###", "###")
                     .addMaterial('#', nugget)
                     .group("end_metal_ingots_nug")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_nuggets_from_ingot"), nugget)
                     .outputCount(9)
                     .shapeless()
                     .addMaterial('#', ingot)
                     .group("end_metal_nuggets_ing")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_block"), block)
                     .shape("###", "###", "###")
                     .addMaterial('#', ingot)
                     .group("end_metal_blocks")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_ingot_from_block"), ingot)
                     .outputCount(9)
                     .shapeless()
                     .addMaterial('#', block)
                     .group("end_metal_ingots")
                     .build(context);

        // Block recipes
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_tile"), tile)
                     .outputCount(4)
                     .shape("##", "##")
                     .addMaterial('#', block)
                     .group("end_metal_tiles")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_bars"), bars)
                     .outputCount(16)
                     .shape("###", "###")
                     .addMaterial('#', ingot)
                     .group("end_metal_bars")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_pressure_plate"), pressurePlate)
                     .shape("##")
                     .addMaterial('#', ingot)
                     .group("end_metal_plates")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_door"), door)
                     .outputCount(3)
                     .shape("##", "##", "##")
                     .addMaterial('#', ingot)
                     .group("end_metal_doors")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_trapdoor"), trapdoor)
                     .shape("##", "##")
                     .addMaterial('#', ingot)
                     .group("end_metal_trapdoors")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_stairs"), stairs)
                     .outputCount(4)
                     .shape("#  ", "## ", "###")
                     .addMaterial('#', block, tile)
                     .group("end_metal_stairs")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_slab"), slab)
                     .outputCount(6)
                     .shape("###")
                     .addMaterial('#', block, tile)
                     .group("end_metal_slabs")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_chain"), chain)
                     .shape("N", "#", "N")
                     .addMaterial('#', ingot)
                     .addMaterial('N', nugget)
                     .group("end_metal_chain")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_anvil"), anvilBlock)
                     .shape("###", " I ", "III")
                     .addMaterial('#', block, tile)
                     .addMaterial('I', ingot)
                     .group("end_metal_anvil")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_bulb_lantern"), bulb_lantern)
                     .shape("C", "I", "#")
                     .addMaterial('C', chain)
                     .addMaterial('I', ingot)
                     .addMaterial('#', EndItems.GLOWING_BULB)
                     .build(context);

        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_chandelier"), chandelier)
                     .shape("I#I", " # ")
                     .addMaterial('#', ingot)
                     .addMaterial('I', EndItems.LUMECORN_ROD)
                     .group("end_metal_chandelier")
                     .build(context);

        // Tools & armor into nuggets
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_axe_nugget"), nugget)
                     .input(axe)
                     .build(context);
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_hoe_nugget"), nugget)
                     .input(hoe)
                     .build(context);
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_pickaxe_nugget"), nugget)
                     .input(pickaxe)
                     .build(context);
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_sword_nugget"), nugget)
                     .input(sword)
                     .build(context);
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_hammer_nugget"), nugget)
                     .input(hammer)
                     .build(context);
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_helmet_nugget"), nugget)
                     .input(helmet)
                     .build(context);
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_chestplate_nugget"), nugget)
                     .input(chestplate)
                     .build(context);
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_leggings_nugget"), nugget)
                     .input(leggings)
                     .build(context);
        RecipeBuilder.blasting(BetterEnd.C.mk(name + "_boots_nugget"), nugget)
                     .input(boots)
                     .build(context);

        // Tool parts from ingots
        BCLRecipeBuilder.anvil(BetterEnd.C.mk(name + "_shovel_head"), shovelHead)
                        .setPrimaryInput(ingot)
                        .setAnvilLevel(this.anvilLevel)
                        .setAllowedTools(this.anvilTools)
                        .setDamage(this.anvilLevel)
                        .build(context);
        BCLRecipeBuilder.anvil(BetterEnd.C.mk(name + "_pickaxe_head"), pickaxeHead)
                        .setPrimaryInput(ingot)
                        .setInputCount(3)
                        .setAnvilLevel(this.anvilLevel)
                        .setAllowedTools(this.anvilTools)
                        .setDamage(this.anvilLevel)
                        .build(context);
        BCLRecipeBuilder.anvil(BetterEnd.C.mk(name + "_axe_head"), axeHead)
                        .setPrimaryInput(ingot)
                        .setInputCount(3)
                        .setAnvilLevel(this.anvilLevel)
                        .setAllowedTools(this.anvilTools)
                        .setDamage(this.anvilLevel)
                        .build(context);
        BCLRecipeBuilder.anvil(BetterEnd.C.mk(name + "_hoe_head"), hoeHead)
                        .setPrimaryInput(ingot)
                        .setInputCount(2)
                        .setAnvilLevel(this.anvilLevel)
                        .setAllowedTools(this.anvilTools)
                        .setDamage(this.anvilLevel)
                        .build(context);
        BCLRecipeBuilder.anvil(BetterEnd.C.mk(name + "_sword_blade"), swordBlade)
                        .setPrimaryInput(ingot)
                        .setAnvilLevel(this.anvilLevel)
                        .setAllowedTools(this.anvilTools)
                        .setDamage(this.anvilLevel)
                        .build(context);
        BCLRecipeBuilder.anvil(BetterEnd.C.mk(name + "_forged_plate"), forgedPlate)
                        .setPrimaryInput(ingot)
                        .setAnvilLevel(this.anvilLevel)
                        .setAllowedTools(this.anvilTools)
                        .setDamage(this.anvilLevel)
                        .build(context);

        // Tools from parts
        RecipeBuilder.smithing(BetterEnd.C.mk(name + "_hammer"), hammer)
                     .template(EndTemplates.HANDLE_ATTACHMENT)
                     .base(block)
                     .addon(Items.STICK)
                     .build(context);
        RecipeBuilder.smithing(BetterEnd.C.mk(name + "_axe"), axe)
                     .template(EndTemplates.HANDLE_ATTACHMENT)
                     .base(axeHead)
                     .addon(Items.STICK)
                     .build(context);
        RecipeBuilder.smithing(BetterEnd.C.mk(name + "_pickaxe"), pickaxe)
                     .template(EndTemplates.HANDLE_ATTACHMENT)
                     .base(pickaxeHead)
                     .addon(Items.STICK)
                     .build(context);
        RecipeBuilder.smithing(BetterEnd.C.mk(name + "_hoe"), hoe)
                     .template(EndTemplates.HANDLE_ATTACHMENT)
                     .base(hoeHead)
                     .addon(Items.STICK)
                     .build(context);
        RecipeBuilder.smithing(BetterEnd.C.mk(name + "_sword_handle"), swordHandle)
                     .template(this.swordHandleTemplate)
                     .base(Items.STICK)
                     .addon(ingot)
                     .build(context);
        RecipeBuilder.smithing(BetterEnd.C.mk(name + "_sword"), sword)
                     .template(EndTemplates.TOOL_ASSEMBLY)
                     .base(swordBlade)
                     .addon(swordHandle)
                     .build(context);
        RecipeBuilder.smithing(BetterEnd.C.mk(name + "_shovel"), shovel)
                     .template(EndTemplates.HANDLE_ATTACHMENT)
                     .base(shovelHead)
                     .addon(Items.STICK)
                     .build(context);

        // Armor crafting
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_helmet"), helmet)
                     .shape("###", "# #")
                     .addMaterial('#', forgedPlate)
                     .group("end_metal_helmets")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_chestplate"), chestplate)
                     .shape("# #", "###", "###")
                     .addMaterial('#', forgedPlate)
                     .group("end_metal_chestplates")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_leggings"), leggings)
                     .shape("###", "# #", "# #")
                     .addMaterial('#', forgedPlate)
                     .group("end_metal_leggings")
                     .build(context);
        RecipeBuilder.crafting(BetterEnd.C.mk(name + "_boots"), boots)
                     .shape("# #", "# #")
                     .addMaterial('#', forgedPlate)
                     .group("end_metal_boots")
                     .build(context);

    }

    @Override
    public void registerBlockTags(TagBootstrapContext<Block> context) {
        context.add(BlockTags.ANVIL, anvilBlock);
        context.add(BARS_BLOCK_TAG, bars);
        context.add(CHAIN_BLOCK_TAG, chain);
        context.add(BlockTags.BEACON_BASE_BLOCKS, block);
        context.add(BlockTags.DRAGON_IMMUNE, ore, bars);
    }

    @Override
    public void registerItemTags(ItemTagBootstrapContext context) {
        context.add(BARS_ITEM_TAG, bars.asItem());
        context.add(CHAINS_ITEM_TAG, chain.asItem());
        context.add(ItemTags.BEACON_PAYMENT_ITEMS, ingot);
        if (alloyingOre != null) {
            context.add(alloyingOre, ore.asItem(), rawOre);
        }
    }
}