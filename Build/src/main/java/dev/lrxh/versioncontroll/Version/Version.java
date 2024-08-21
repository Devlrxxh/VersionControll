package dev.lrxh.versioncontroll.Version;

import dev.lrxh.VersionHandler;
import dev.lrxh.v1_16_R3.v1_16_R3;
import dev.lrxh.v1_17_R3.v1_17_R3;
import dev.lrxh.v1_18_R3.v1_18_R3;
import dev.lrxh.v1_19_R3.v1_19_R3;
import dev.lrxh.v1_20_R3.v1_20_R3;
import lombok.Getter;

import javax.annotation.Nullable;

@Getter
public enum Version {
    v1_20_R4(),
    v1_20_R3(),
    v1_20_R2(),
    v1_20_R1(),
    v1_19_R4(),
    v1_19_R3(),
    v1_19_R2(),
    v1_19_R1(),
    v1_18_R2(),
    v1_18_R1(),
    v1_17_R2(),
    v1_17_R1(),
    v1_16_R5(),
    v1_16_R4(),
    v1_16_R3(),
    v1_16_R2(),
    v1_16_R1();

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
            case v1_20_R3, v1_20_R1, v1_20_R2, v1_20_R4 -> {
                return new v1_20_R3();
            }
        }
        return null;
    }
}
