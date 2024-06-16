package org.betterx.betterend.registry;

import org.betterx.bclib.interfaces.NumericProvider;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.world.surface.SplitNoiseCondition;
import org.betterx.betterend.world.surface.SulphuricSurfaceNoiseCondition;
import org.betterx.betterend.world.surface.UmbraSurfaceNoiseCondition;
import org.betterx.betterend.world.surface.VerticalBandNoiseCondition;

import net.minecraft.core.Registry;

public class EndNumericProviders {
    public static void register() {
        Registry.register(
                NumericProvider.NUMERIC_PROVIDER,
                BetterEnd.C.mk("sulphuric_surf"),
                SulphuricSurfaceNoiseCondition.CODEC
        );

        Registry.register(
                NumericProvider.NUMERIC_PROVIDER,
                BetterEnd.C.mk("vertical_band"),
                VerticalBandNoiseCondition.CODEC
        );

        Registry.register(
                NumericProvider.NUMERIC_PROVIDER,
                BetterEnd.C.mk("split_noise"),
                SplitNoiseCondition.CODEC
        );

        Registry.register(
                NumericProvider.NUMERIC_PROVIDER,
                BetterEnd.C.mk("umbra_srf"),
                UmbraSurfaceNoiseCondition.CODEC
        );
    }
}
