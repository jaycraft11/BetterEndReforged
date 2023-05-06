package org.betterx.betterend.registry;

import org.betterx.bclib.particles.BCLParticleType;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.particle.*;

import com.mojang.serialization.Codec;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class EndParticles {
    public static SimpleParticleType GLOWING_SPHERE;
    public static SimpleParticleType PORTAL_SPHERE;
    public static ParticleType<InfusionParticleType> INFUSION;
    public static SimpleParticleType SULPHUR_PARTICLE;
    public static SimpleParticleType GEYSER_PARTICLE;
    public static SimpleParticleType SNOWFLAKE;
    public static SimpleParticleType AMBER_SPHERE;
    public static SimpleParticleType BLACK_SPORE;
    public static SimpleParticleType TENANEA_PETAL;
    public static SimpleParticleType JUNGLE_SPORE;
    public static SimpleParticleType FIREFLY;
    public static SimpleParticleType SMARAGDANT;

    public static void init() {
        GLOWING_SPHERE = register("glowing_sphere");
        PORTAL_SPHERE = register("portal_sphere");
        INFUSION = register(
                "infusion",
                InfusionParticleType.PARAMETERS_FACTORY,
                InfusionParticleType.CODEC
        );
        SULPHUR_PARTICLE = register("sulphur_particle");
        GEYSER_PARTICLE = registerFar("geyser_particle");
        SNOWFLAKE = register("snowflake");
        AMBER_SPHERE = register("amber_sphere");
        BLACK_SPORE = register("black_spore");
        TENANEA_PETAL = register("tenanea_petal");
        JUNGLE_SPORE = register("jungle_spore");
        FIREFLY = register("firefly");
        SMARAGDANT = register("smaragdant_particle");
    }

    public static void register() {
        init();
        ParticleFactoryRegistry.getInstance().register(GLOWING_SPHERE, ParticleGlowingSphere.FactoryGlowingSphere::new);
        ParticleFactoryRegistry.getInstance().register(PORTAL_SPHERE, PaticlePortalSphere.FactoryPortalSphere::new);
        ParticleFactoryRegistry.getInstance().register(INFUSION, InfusionParticle.InfusionFactory::new);
        ParticleFactoryRegistry.getInstance().register(SULPHUR_PARTICLE, ParticleSulphur.FactorySulphur::new);
        ParticleFactoryRegistry.getInstance().register(GEYSER_PARTICLE, ParticleGeyser.FactoryGeyser::new);
        ParticleFactoryRegistry.getInstance().register(SNOWFLAKE, ParticleSnowflake.FactorySnowflake::new);
        ParticleFactoryRegistry.getInstance().register(AMBER_SPHERE, ParticleGlowingSphere.FactoryGlowingSphere::new);
        ParticleFactoryRegistry.getInstance().register(BLACK_SPORE, ParticleBlackSpore.FactoryBlackSpore::new);
        ParticleFactoryRegistry.getInstance().register(TENANEA_PETAL, ParticleTenaneaPetal.FactoryTenaneaPetal::new);
        ParticleFactoryRegistry.getInstance().register(JUNGLE_SPORE, ParticleJungleSpore.FactoryJungleSpore::new);
        ParticleFactoryRegistry.getInstance().register(FIREFLY, FireflyParticle.FireflyParticleFactory::new);
        ParticleFactoryRegistry.getInstance().register(SMARAGDANT, SmaragdantParticle.SmaragdantParticleFactory::new);
    }

    private static SimpleParticleType register(String name) {
        return BCLParticleType.register(BetterEnd.makeID(name));
    }

    private static SimpleParticleType registerFar(String name) {
        return BCLParticleType.register(BetterEnd.makeID(name), true);
    }

    private static <T extends ParticleOptions> ParticleType<T> register(
            String name,
            ParticleOptions.Deserializer<T> type,
            Codec<T> codec
    ) {
        return BCLParticleType.register(BetterEnd.makeID(name), type, codec);
    }
}
