package dev.lrxh.versioncontroll.Version;

import dev.lrxh.VersionHandler;
import dev.lrxh.v1_17_R3.v1_17_R3;
import dev.lrxh.v1_18_R3.v1_18_R3;
import dev.lrxh.v1_19_R3.v1_19_R3;
import dev.lrxh.v1_20_R3.v1_20_R3;
import dev.lrxh.v1_16_R3.v1_16_R3;

import lombok.Getter;

@Getter
public enum Version {
    v1_20_R4(new v1_20_R3()),
    v1_20_R3(new v1_20_R3()),
    v1_20_R2(new v1_20_R3()),
    v1_20_R1(new v1_20_R3()),
    v1_19_R4(new v1_19_R3()),
    v1_19_R3(new v1_19_R3()),
    v1_19_R2(new v1_19_R3()),
    v1_19_R1(new v1_19_R3()),
    v1_18_R2(new v1_18_R3()),
    v1_18_R1(new v1_18_R3()),
    v1_17_R2(new v1_17_R3()),
    v1_17_R1(new v1_17_R3()),
    v1_16_R5(new v1_16_R3()),
    v1_16_R4(new v1_16_R3()),
    v1_16_R3(new v1_16_R3()),
    v1_16_R2(new v1_16_R3()),
    v1_16_R1(new v1_16_R3());

    private final VersionHandler versionHandler;

    Version(VersionHandler versionHandler) {
        this.versionHandler = versionHandler;
    }
}
