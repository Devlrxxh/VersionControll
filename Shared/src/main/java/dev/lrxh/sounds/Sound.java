package dev.lrxh.sounds;

import lombok.Getter;

@Getter
public enum Sound {
    UI_BUTTON_CLICK("CLICK"),
    BLOCK_NOTE_BLOCK_PLING("NOTE_PLING"),
    ENTITY_FIREWORK_ROCKET_BLAST("FIREWORK_BLAST");

    private final String legacy;

    Sound(String legacy) {
        this.legacy = legacy;
    }
}
