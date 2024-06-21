package org.betterx.betterend.registry;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.effects.enchantment.EndVeilEnchantment;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

public class EndEnchantments {
    public final static Holder<Enchantment> END_VEIL = registerEnchantment("end_veil", new EndVeilEnchantment());

    public static Holder<Enchantment> registerEnchantment(String name, Enchantment enchantment) {
        return Registry.registerForHolder(Registries.ENCHANTMENT, BetterEnd.C.mk(name), enchantment);
    }

    public static void register() {
    }
}
