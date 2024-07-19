package org.betterx.betterend.registry;

import java.util.function.UnaryOperator;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType.Builder;
import net.minecraft.core.registries.BuiltInRegistries;
import org.betterx.betterend.BetterEnd;
import org.betterx.wover.enchantment.api.EnchantmentKey;
import org.betterx.wover.enchantment.api.EnchantmentManager;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.util.Unit;

public class EndEnchantments {
    public final static EnchantmentKey END_VEIL = EnchantmentManager.createKey(BetterEnd.C.mk("end_veil"));


    public static final DataComponentType<Unit> END_VEIL_STATE = registerEnchantment(
            BetterEnd.C.mk("end_veil_state").toString(),
            (builder) -> builder.persistent(Unit.CODEC)
    );

    private static DataComponentType<Unit> registerEnchantment(String string, UnaryOperator<Builder<Unit>> unaryOperator) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, string, unaryOperator.apply(DataComponentType.builder()).build());
    }

    public static void register() {}
}
