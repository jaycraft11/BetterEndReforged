package org.betterx.betterend.client.render;

import org.betterx.bclib.items.elytra.BCLElytraItem;
import org.betterx.bclib.items.elytra.BCLElytraUtils;
import org.betterx.betterend.item.model.ArmoredElytraModel;
import org.betterx.betterend.registry.EndEntitiesRenders;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(value = EnvType.CLIENT)
public class ArmoredElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {
    private static final ResourceLocation VANILLA_WINGS = ResourceLocation.withDefaultNamespace("textures/entity/elytra.png");
    private final ArmoredElytraModel<T> elytraModel;

    public ArmoredElytraLayer(RenderLayerParent<T, M> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent, entityModelSet);
        elytraModel = new ArmoredElytraModel<>(entityModelSet.bakeLayer(EndEntitiesRenders.ARMORED_ELYTRA));
    }

    public ResourceLocation wingTextureOverride(T livingEntity) {
        ItemStack itemStack = (BCLElytraUtils.slotProvider == null)
                ? livingEntity.getItemBySlot(EquipmentSlot.CHEST)
                : BCLElytraUtils.slotProvider.getElytra(livingEntity, livingEntity::getItemBySlot);

        if (itemStack != null && itemStack.getItem() instanceof BCLElytraItem) {
            return ((BCLElytraItem) itemStack.getItem()).getModelTexture();
        }
        return VANILLA_WINGS;
    }

    // Derived from Vanilla render Code im ElytraLayer. This code retains the original MC License
    // We just need to change the default render Texture here, but can not inject that code properly
    // so we need to replicate it...
    public void render(
            PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T livingEntity,
            float f, float g, float h, float j, float k, float l
    ) {
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        if (itemStack.getItem() instanceof BCLElytraItem) {
            ResourceLocation resourceLocation;
            if (livingEntity instanceof AbstractClientPlayer abstractClientPlayer) {
                final PlayerSkin playerSkin = abstractClientPlayer.getSkin();
                if (playerSkin.elytraTexture() != null) {
                    resourceLocation = playerSkin.elytraTexture();
                } else if (playerSkin.capeTexture() != null && abstractClientPlayer.isModelPartShown(PlayerModelPart.CAPE)) {
                    resourceLocation = playerSkin.capeTexture();
                } else {
                    resourceLocation = wingTextureOverride(livingEntity);
                }
            } else {
                resourceLocation = wingTextureOverride(livingEntity);
            }

            poseStack.pushPose();
            poseStack.translate(0.0F, 0.0F, 0.125F);
            this.getParentModel().copyPropertiesTo(this.elytraModel);
            this.elytraModel.setupAnim(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(multiBufferSource, RenderType.armorCutoutNoCull(resourceLocation), itemStack.hasFoil());
            this.elytraModel.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}
