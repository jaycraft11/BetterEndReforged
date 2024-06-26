package org.betterx.betterend.client.models;

import org.betterx.betterend.BetterEnd;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;

import java.util.Optional;

public class EndModels {
    public static final TextureSlot ROOTS = TextureSlot.create("roots");

    public static final ModelTemplate TWISTED_VINE = new ModelTemplate(Optional.of(BetterEnd.C.mk("block/twisted_vine")), Optional.empty(), TextureSlot.TEXTURE, ROOTS);
    public static final ModelTemplate CROSS_NO_DISTORTION = new ModelTemplate(Optional.of(BetterEnd.C.mk("block/cross_no_distortion")), Optional.empty(), TextureSlot.TEXTURE);
    public static final ModelTemplate CROSS_NO_DISTORTION_INVERTED = new ModelTemplate(Optional.of(BetterEnd.C.mk("block/cross_no_distortion_inverted")), Optional.empty(), TextureSlot.TEXTURE);
    public static final ModelTemplate PATH = new ModelTemplate(Optional.of(BetterEnd.C.mk("block/path")), Optional.empty(), TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE);


}
