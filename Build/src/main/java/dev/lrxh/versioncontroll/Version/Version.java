package dev.lrxh.versioncontroll.Version;

import dev.lrxh.v1_20_R3.v1_20_R3;
import dev.lrxh.v1_8_R3.v1_8_R3;
import lombok.Getter;

@Getter
public enum Version {
    v1_20_R3(new Attributes(true, new v1_20_R3())),
    v1_8_R3(new Attributes(false, new v1_8_R3()));

    private final Attributes attribute;

    Version(Attributes attribute) {
        this.attribute = attribute;
    }
}
