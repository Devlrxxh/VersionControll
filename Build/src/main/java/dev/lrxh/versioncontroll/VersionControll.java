package dev.lrxh.versioncontroll;

import dev.lrxh.VersionHandler;
import dev.lrxh.versioncontroll.Version.Version;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class VersionControll {
    private final VersionHandler handler;
    private final JavaPlugin plugin;

    public VersionControll(JavaPlugin plugin) {
        this.plugin = plugin;
        this.handler = getVersionHandler();
    }

    private VersionHandler getVersionHandler() {
        Version v = VersionUtils.extractVersion(plugin.getServer().getBukkitVersion());
        if (v == null) return null;
        return v.getVersionHandler();
    }

    public Version getVersion() {
        return VersionUtils.extractVersion(plugin.getServer().getBukkitVersion());
    }
}
