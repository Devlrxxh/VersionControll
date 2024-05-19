package dev.lrxh.versioncontroll.Version;

import dev.lrxh.v1_20_R3.v1_20_R3;
import dev.lrxh.v1_19_R3.v1_19_R3;
import dev.lrxh.v1_18_R3.v1_18_R3;
import dev.lrxh.v1_17_R3.v1_17_R3;
import lombok.Getter;

@Getter
public enum Version {
    v1_20_R4(new Attributes(true, new v1_20_R3())),
    v1_20_R3(new Attributes(true, new v1_20_R3())),
    v1_20_R2(new Attributes(true, new v1_20_R3())),
    v1_20_R1(new Attributes(true, new v1_20_R3())),
    v1_19_R4(new Attributes(true, new v1_19_R3())),
    v1_19_R3(new Attributes(true, new v1_19_R3())),
    v1_19_R2(new Attributes(true, new v1_19_R3())),
    v1_19_R1(new Attributes(true, new v1_19_R3())),
    v1_18_R2(new Attributes(true, new v1_18_R3())),
    v1_18_R1(new Attributes(true, new v1_18_R3())),
    v1_17_R3(new Attributes(true, new v1_17_R3())),
    v1_17_R2(new Attributes(true, new v1_17_R3())),
    v1_17_R1(new Attributes(true, new v1_17_R3()));
    private final Attributes attribute;

    Version(Attributes attribute) {
        this.attribute = attribute;
    }
}
