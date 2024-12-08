package org.betterx.betterend.blocks;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import org.betterx.bclib.behaviours.BehaviourBuilders;
import org.betterx.bclib.behaviours.interfaces.BehaviourLeaves;
import org.betterx.bclib.blocks.BaseBlock;
import org.betterx.bclib.interfaces.CustomColorProvider;
import org.betterx.bclib.interfaces.tools.AddMineableShears;
import org.betterx.bclib.util.MHelper;
import org.betterx.betterend.noise.OpenSimplexNoise;
import org.betterx.ui.ColorUtil;
import org.betterx.wover.block.api.BlockTagProvider;
import org.betterx.wover.loot.api.LootLookupProvider;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

import static org.betterx.betterend.registry.EndBlocks.HELIX_TREE_SAPLING;

public class HelixTreeLeavesBlock extends BaseBlock implements BehaviourLeaves, CustomColorProvider, AddMineableShears, BlockTagProvider {
    public static final IntegerProperty COLOR = EndBlockProperties.COLOR;
    private static final OpenSimplexNoise NOISE = new OpenSimplexNoise(0);

    public HelixTreeLeavesBlock() {
        super(BehaviourBuilders
                .createStaticLeaves(MapColor.COLOR_ORANGE, true)
                .sound(SoundType.WART_BLOCK)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(COLOR);
    }

    @Override
    public BlockColor getProvider() {
        return (state, world, pos, tintIndex) -> ColorUtil.color(237, getGreen(state.getValue(COLOR)), 20);
    }

    @Override
    public ItemColor getItemProvider() {
        return (stack, tintIndex) -> ColorUtil.color(237, getGreen(4), 20);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        double px = ctx.getClickedPos().getX() * 0.1;
        double py = ctx.getClickedPos().getY() * 0.1;
        double pz = ctx.getClickedPos().getZ() * 0.1;
        return this.defaultBlockState().setValue(COLOR, MHelper.floor(NOISE.eval(px, py, pz) * 3.5 + 4));
    }

    private int getGreen(int color) {
        float delta = color / 7F;
        return (int) Mth.lerp(delta, 80, 158);
    }

    @Override
    public void registerBlockTags(ResourceLocation location, TagBootstrapContext<Block> context) {
        context.add(this, BlockTags.LEAVES);
    }

    @Override
    public LootTable.Builder registerBlockLoot(@NotNull ResourceLocation location, @NotNull LootLookupProvider provider, @NotNull ResourceKey<LootTable> tableKey)
    {
        return provider.dropLeaves(this, HELIX_TREE_SAPLING);
    }
}
