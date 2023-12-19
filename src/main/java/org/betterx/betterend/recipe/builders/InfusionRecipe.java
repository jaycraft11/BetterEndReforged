package org.betterx.betterend.recipe.builders;

import org.betterx.bclib.BCLib;
import org.betterx.bclib.interfaces.UnknownReceipBookCategory;
import org.betterx.bclib.recipes.AbstractSingleInputRecipeBuilder;
import org.betterx.bclib.recipes.BCLRecipeManager;
import org.betterx.bclib.util.ItemUtil;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.rituals.InfusionRitual;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Arrays;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public class InfusionRecipe implements Recipe<InfusionRitual>, UnknownReceipBookCategory {
    public static final Codec<Ingredient[]> CODEC_CATALYSTS = RecordCodecBuilder.create(instance -> instance
            .group(
                    Builder.catalyst(Catalysts.NORTH),
                    Builder.catalyst(Catalysts.NORTH_EAST),
                    Builder.catalyst(Catalysts.EAST),
                    Builder.catalyst(Catalysts.SOUTH_EAST),
                    Builder.catalyst(Catalysts.SOUTH),
                    Builder.catalyst(Catalysts.SOUTH_WEST),
                    Builder.catalyst(Catalysts.WEST),
                    Builder.catalyst(Catalysts.NORTH_WEST)
            ).apply(instance, Builder::fromCodec)
    );

    public static final Codec<InfusionRecipe> CODEC = RecordCodecBuilder.create(instance -> instance
            .group(
                    ItemUtil.CODEC_INGREDIENT_WITH_NBT.fieldOf("input").forGetter(i -> i.input),
                    ItemUtil.CODEC_ITEM_STACK_WITH_NBT.fieldOf("result").forGetter(i -> i.output),
                    Codec.INT.optionalFieldOf("time", 1).forGetter(InfusionRecipe::getInfusionTime),
                    CODEC_CATALYSTS.fieldOf("catalysts").forGetter(i -> i.catalysts),
                    ExtraCodecs.strictOptionalField(Codec.STRING, "group")
                               .forGetter(i -> Optional.ofNullable(i.group))
            ).apply(instance, InfusionRecipe::new)

    );
    public final static String GROUP = "infusion";
    public final static RecipeType<InfusionRecipe> TYPE = BCLRecipeManager.registerType(BetterEnd.MOD_ID, GROUP);
    public final static Serializer SERIALIZER = BCLRecipeManager.registerSerializer(
            BetterEnd.MOD_ID,
            GROUP,
            new Serializer()
    );

    private final Ingredient[] catalysts;
    private Ingredient input;
    private ItemStack output;
    private int time;
    private String group;

    private InfusionRecipe() {
        this(null, null);
    }

    private InfusionRecipe(Ingredient input, ItemStack output) {
        this(input, output, 1, new Ingredient[]{
                Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY,
                Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY
        }, (String) null);
    }

    private InfusionRecipe(
            Ingredient input,
            ItemStack output,
            int time,
            Ingredient[] catalysts,
            Optional<String> group
    ) {
        this(input, output, time, catalysts, group.orElse(null));
    }

    private InfusionRecipe(Ingredient input, ItemStack output, int time, Ingredient[] catalysts, String group) {
        this.input = input;
        this.output = output;
        this.catalysts = catalysts;
        this.time = time;
        this.group = group;
    }

    public static Builder create(String id, ItemLike output) {
        return create(BetterEnd.makeID(id), output);
    }

    public static Builder create(ResourceLocation id, ItemLike output) {
        return new Builder(id, output);
    }

    public static Builder create(String id, ItemStack output) {
        return create(BetterEnd.makeID(id), output);
    }

    public static Builder create(ResourceLocation id, ItemStack output) {
        return new Builder(id, output);
    }

    public static Builder create(String id, Enchantment enchantment, int level) {
        return create(BetterEnd.makeID(id), enchantment, level);
    }

    public static Builder create(ResourceLocation id, Enchantment enchantment, int level) {
        return new Builder(id, createEnchantedBook(enchantment, level));
    }

    public static ItemStack createEnchantedBook(Enchantment enchantment, int level) {
        ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
        EnchantedBookItem.addEnchantment(book, new EnchantmentInstance(enchantment, level));
        return book;
    }

    public int getInfusionTime() {
        return this.time;
    }

    @Override
    public boolean matches(InfusionRitual inv, Level world) {
        boolean valid = this.input.test(inv.getItem(0));
        if (!valid) return false;
        for (int i = 0; i < 8; i++) {
            valid &= this.catalysts[i].test(inv.getItem(i + 1));
        }
        return valid;
    }

    @Override
    public @NotNull ItemStack assemble(InfusionRitual ritual, RegistryAccess acc) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> defaultedList = NonNullList.create();
        defaultedList.add(input);
        defaultedList.addAll(Arrays.asList(catalysts));
        return defaultedList;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess acc) {
        return this.output;
    }


    @Override
    @Environment(EnvType.CLIENT)
    public @NotNull String getGroup() {
        return this.group;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return TYPE;
    }

    public static class Builder extends AbstractSingleInputRecipeBuilder<Builder, InfusionRecipe> {
        @NotNull
        private static RecordCodecBuilder<Ingredient[], Optional<Ingredient>> catalyst(Catalysts slot) {
            return ExtraCodecs.strictOptionalField(ItemUtil.CODEC_INGREDIENT_WITH_NBT, slot.key)
                              .forGetter(builder ->
                                      builder[slot.index] == null || builder[slot.index].isEmpty()
                                              ? Optional.empty()
                                              : Optional.of(builder[slot.index])
                              );
        }

        private static Ingredient[] fromCodec(
                Optional<Ingredient> north,
                Optional<Ingredient> north_east,
                Optional<Ingredient> east,
                Optional<Ingredient> south_east,
                Optional<Ingredient> south,
                Optional<Ingredient> south_west,
                Optional<Ingredient> west,
                Optional<Ingredient> north_west
        ) {
            Ingredient[] result = new Ingredient[8];
            result[Catalysts.NORTH.index] = north.orElse(null);
            result[Catalysts.NORTH_EAST.index] = north_east.orElse(null);
            result[Catalysts.EAST.index] = east.orElse(null);
            result[Catalysts.SOUTH_EAST.index] = south_east.orElse(null);
            result[Catalysts.SOUTH.index] = south.orElse(null);
            result[Catalysts.SOUTH_WEST.index] = south_west.orElse(null);
            result[Catalysts.WEST.index] = west.orElse(null);
            result[Catalysts.NORTH_WEST.index] = north_west.orElse(null);
            return result;
        }

        private final Ingredient[] catalysts;
        private int time;

        protected Builder(ResourceLocation id, ItemLike output) {
            this(id, new ItemStack(output, 1));
        }

        protected Builder(ResourceLocation id, ItemStack output) {
            super(id, output);
            this.catalysts = new Ingredient[]{
                    Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY,
                    Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY
            };
            this.time = 1;
        }

        @Override
        protected InfusionRecipe createRecipe(ResourceLocation id) {
            checkRecipe();
            return new InfusionRecipe(this.primaryInput, this.output, this.time, this.catalysts, this.group);
        }

        @Override
        public Builder setGroup(String group) {
            return super.setGroup(group);
        }

        /**
         * @param input -
         * @return -
         * @deprecated use {@link #setPrimaryInput(ItemLike...)}
         */
        @Deprecated(forRemoval = true)
        public Builder setInput(ItemLike input) {
            super.setPrimaryInputAndUnlock(input);
            return this;
        }

        public Builder setTime(int time) {
            this.time = time;
            return this;
        }

        public Builder addCatalyst(Catalysts slot, ItemLike... items) {
            this.catalysts[slot.index] = Ingredient.of(items);
            return this;
        }

        public Builder addCatalyst(Catalysts slot, ItemStack stack) {
            this.catalysts[slot.index] = Ingredient.of(stack);
            return this;
        }

        public Builder addCatalyst(Catalysts slot, TagKey<Item> tag) {
            this.catalysts[slot.index] = Ingredient.of(tag);
            return this;
        }

        @Override
        protected boolean checkRecipe() {
            if (time < 0) {
                BCLib.LOGGER.warning(
                        "Time should be positive, recipe {} will be ignored!",
                        id
                );
                return false;
            }
            return super.checkRecipe();
        }

        @Override
        protected RecipeSerializer<InfusionRecipe> getSerializer() {
            return SERIALIZER;
        }
    }

    public enum Catalysts {
        NORTH(0, "north"),
        NORTH_EAST(1, "north_east"),
        EAST(2, "east"),
        SOUTH_EAST(3, "south_east"),
        SOUTH(4, "south"),
        SOUTH_WEST(5, "south_west"),
        WEST(6, "west"),
        NORTH_WEST(7, "north_west");

        public final int index;
        public final String key;

        Catalysts(int index, String key) {
            this.index = index;
            this.key = key;
        }
    }

    public static class Serializer implements RecipeSerializer<InfusionRecipe> {
        @Override
        public @NotNull Codec<InfusionRecipe> codec() {
            return InfusionRecipe.CODEC;
        }

        @Override
        public @NotNull InfusionRecipe fromNetwork(FriendlyByteBuf buffer) {
            InfusionRecipe recipe = new InfusionRecipe();
            recipe.input = Ingredient.fromNetwork(buffer);
            recipe.output = buffer.readItem();
            recipe.group = buffer.readUtf();
            recipe.time = buffer.readVarInt();
            for (int i = 0; i < 8; i++) {
                recipe.catalysts[i] = Ingredient.fromNetwork(buffer);
            }
            return recipe;
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, InfusionRecipe recipe) {
            recipe.input.toNetwork(buffer);
            buffer.writeItem(recipe.output);
            buffer.writeUtf(recipe.group);
            buffer.writeVarInt(recipe.time);
            for (int i = 0; i < 8; i++) {
                recipe.catalysts[i].toNetwork(buffer);
            }
        }
    }

    public static void register() {
        //we call this to make sure that TYPE is initialized
    }
}
