package dev.lrxh.gameRule;

import lombok.Getter;

@Getter
public enum GameRule {
    DO_WEATHER_CYCLE("doWeatherCycle "),
    DO_DAYLIGHT_CYCLE("doDaylightCycle"),
    DO_IMMEDIATE_RESPAWN(null);

    private final String legacy;

    GameRule(String legacy) {
        this.legacy = legacy;
    }
}
