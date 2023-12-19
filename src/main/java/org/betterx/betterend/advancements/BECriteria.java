package org.betterx.betterend.advancements;

import org.betterx.betterend.BetterEnd;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class BECriteria {
    public static PlayerTrigger PORTAL_ON;
    public static PlayerTrigger PORTAL_TRAVEL;
    public static PlayerTrigger INFUSION_FINISHED;

    public static Criterion<PlayerTrigger.TriggerInstance> PORTAL_ON_TRIGGER;
    public static Criterion<PlayerTrigger.TriggerInstance> PORTAL_TRAVEL_TRIGGER;
    public static Criterion<PlayerTrigger.TriggerInstance> INFUSION_FINISHED_TRIGGER;

    public static <T extends CriterionTrigger<?>> T register(ResourceLocation id, T trigger) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES, id, trigger);
    }


    public static void register() {
        PORTAL_ON = register(BetterEnd.makeID("portal_on"), new PlayerTrigger());
        PORTAL_TRAVEL = register(BetterEnd.makeID("portal_travel"), new PlayerTrigger());
        INFUSION_FINISHED = register(BetterEnd.makeID("infusion_finished"), new PlayerTrigger());

        PORTAL_ON_TRIGGER = PORTAL_ON.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty()));
        PORTAL_TRAVEL_TRIGGER = PORTAL_TRAVEL.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty()));
        INFUSION_FINISHED_TRIGGER = INFUSION_FINISHED.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty()));
    }
}
