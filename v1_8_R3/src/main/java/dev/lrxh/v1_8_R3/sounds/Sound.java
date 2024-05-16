package dev.lrxh.v1_8_R3.sounds;

import dev.lrxh.sounds.ISound;

public class Sound implements ISound {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getSound(dev.lrxh.sounds.Sound sound) {
        return (T) org.bukkit.Sound.valueOf(sound.getLegacy());
    }
}
