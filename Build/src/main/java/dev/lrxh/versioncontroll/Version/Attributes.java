package dev.lrxh.versioncontroll.Version;

import dev.lrxh.VersionHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Attributes {
    private boolean comments;
    private VersionHandler versionHandler;
}
