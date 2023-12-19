package org.betterx.betterend.mixin.client;

import org.betterx.bclib.api.v2.levelgen.biomes.BiomeAPI;
import org.betterx.betterend.client.ClientOptions;
import org.betterx.betterend.world.biome.EndBiome;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MusicManager.class)
public abstract class MusicTrackerMixin {
    @Final
    @Shadow
    private Minecraft minecraft;

    @Final
    @Shadow
    private RandomSource random;

    @Shadow
    private SoundInstance currentMusic;

    @Shadow
    private int nextSongDelay;

    @Unique
    private static float be_volume = 1;
    @Unique
    private static float be_srcVolume = 0;
    @Unique
    private static long be_time;

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void be_onTick(CallbackInfo info) {
        if (ClientOptions.blendBiomeMusic()) {
            Music musicSound = minecraft.getSituationalMusic();
            if (be_checkNullSound(musicSound) && be_volume > 0 && be_shouldChangeSound(musicSound) && be_isCorrectBiome()) {
                if (be_volume > 0) {
                    if (be_srcVolume < 0) {
                        be_srcVolume = currentMusic.getVolume();
                    }
                    if (currentMusic instanceof AbstractSoundInstance) {
                        ((AbstractSoundInstanceAccessor) currentMusic).setVolume(be_volume);
                    }
                    minecraft.getSoundManager()
                             .updateSourceVolume(currentMusic.getSource(), currentMusic.getVolume() * be_volume);
                    long t = System.currentTimeMillis();
                    if (be_volume == 1 && be_time == 0) {
                        be_time = t;
                    }
                    float delta = (t - be_time) * 0.0005F;
                    be_time = t;
                    be_volume -= delta;
                    if (be_volume < 0) {
                        be_volume = 0;
                    }
                }
                if (be_volume == 0) {
                    be_volume = 1;
                    be_time = 0;
                    be_srcVolume = -1;
                    this.minecraft.getSoundManager().stop(this.currentMusic);
                    this.nextSongDelay = Mth.nextInt(this.random, 0, musicSound.getMinDelay() / 2);
                    this.currentMusic = null;
                }
                if (this.currentMusic == null && this.nextSongDelay-- <= 0) {
                    this.startPlaying(musicSound);
                }
                info.cancel();
            } else {
                be_volume = 1;
            }
        }
    }

    @Unique
    private boolean be_isCorrectBiome() {
        if (minecraft.level == null) {
            return false;
        }
        return BiomeAPI.getRenderBiome(minecraft.level.getBiome(minecraft.player.blockPosition())
                                                      .value()) instanceof EndBiome;
    }

    @Unique
    private boolean be_shouldChangeSound(Music musicSound) {
        return currentMusic != null && !musicSound
                .getEvent()
                .value()
                .getLocation()
                .equals(this.currentMusic.getLocation()) && musicSound.replaceCurrentMusic();
    }

    @Unique
    private boolean be_checkNullSound(Music musicSound) {
        return musicSound != null && musicSound.getEvent() != null;
    }

    @Shadow
    public abstract void startPlaying(Music type);
}
