package org.betterx.betterend.registry;

import org.betterx.betterend.BetterEnd;
import org.betterx.wover.enchantment.api.EnchantmentKey;
import org.betterx.wover.enchantment.api.EnchantmentManager;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

public class EndEnchantments {
    public final static EnchantmentKey END_VEIL = EnchantmentManager.createKey(BetterEnd.C.mk("end_veil"));
    // new EndVeilEnchantment()

    public static Holder<Enchantment> registerEnchantment(String name, Enchantment enchantment) {
        return Registry.registerForHolder(Registries.ENCHANTMENT, BetterEnd.C.mk(name), enchantment);
    }

    public static void register() {
    }
}
