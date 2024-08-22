package dev.lrxh.versioncontroll.Version;

import dev.lrxh.VersionHandler;
import dev.lrxh.v1_16_R3.v1_16_R3;
import dev.lrxh.v1_17_R3.v1_17_R3;
import dev.lrxh.v1_18_R3.v1_18_R3;
import dev.lrxh.v1_19_R3.v1_19_R3;
import dev.lrxh.v1_20_R3.v1_20_R3;
import dev.lrxh.v1_21_R1.v1_21_R1;
import lombok.Getter;

import javax.annotation.Nullable;

@Getter
public enum Version {
    v1_21_R1(20),
    v1_20_R6(19),
    v1_20_R5(18),
    v1_20_R4(17),
    v1_20_R3(16),
    v1_20_R2(15),
    v1_20_R1(14),
    v1_19_R4(13),
    v1_19_R3(12),
    v1_19_R2(11),
    v1_19_R1(10),
    v1_18_R2(9),
    v1_18_R1(8),
    v1_17_R2(7),
    v1_17_R1(6),
    v1_16_R5(5),
    v1_16_R4(4),
    v1_16_R3(3),
    v1_16_R2(2),
    v1_16_R1(1);

    private final int number;

    @Nullable
    public VersionHandler getVersionHandler(){
        switch (this) {
            case v1_16_R1, v1_16_R2, v1_16_R3, v1_16_R4 , v1_16_R5-> {
                return new v1_16_R3();
            }
            case v1_17_R1, v1_17_R2 -> {
                return new v1_17_R3();
            }
            case v1_18_R1, v1_18_R2 -> {
                return new v1_18_R3();
            }
            case v1_19_R1, v1_19_R2, v1_19_R3, v1_19_R4 -> {
                return new v1_19_R3();
            }
            case v1_20_R3, v1_20_R1, v1_20_R2, v1_20_R4, v1_20_R5, v1_20_R6 -> {
                return new v1_20_R3();
            }
            case v1_21_R1 -> {
                return new v1_21_R1();
            }
        }
        return null;
    }

    public boolean isHigherThan(Version version) {
        return number >= version.number;
    }

    Version(int number) {
        this.number = number;
    }
}
