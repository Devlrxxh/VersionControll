package dev.lrxh.versioncontroll;

import dev.lrxh.versioncontroll.Version.Version;
import lombok.experimental.UtilityClass;

import javax.annotation.Nullable;

@UtilityClass
public class VersionUtils {

    @Nullable
    public Version extractVersion(String bukkitVersion) {
        String[] versionParts = bukkitVersion.split("-")[0].split("\\.");
        if (versionParts.length >= 2) {
            int majorVersion = Integer.parseInt(versionParts[0]);
            int minorVersion = Integer.parseInt(versionParts[1]);
            int patchVersion = versionParts.length >= 3 ? Integer.parseInt(versionParts[2]) : 0;

            return Version.valueOf("v" + majorVersion + "_" + minorVersion + "_R" + patchVersion);
        }
        return null;
    }
}
