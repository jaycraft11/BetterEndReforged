package org.betterx.betterend.mixin.common.portal;

import org.betterx.betterend.portal.TravelerState;
import org.betterx.betterend.portal.TravelingEntity;

import net.minecraft.world.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin implements TravelingEntity {

    @Unique
    private final TravelerState be_travelerState = TravelerState.init((net.minecraft.world.entity.Entity) (Object) this);

    public TravelerState be_getTravelerState() {
        return be_travelerState;
    }

    @Inject(method = "handleNetherPortal", at = @At("HEAD"))
    void be_handleNetherPortal(CallbackInfo ci) {
        if (be_travelerState != null) be_travelerState.portalTick();
    }
}
