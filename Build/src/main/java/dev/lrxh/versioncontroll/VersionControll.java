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
        this.handler = findVersion(plugin.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3]);
    }

    private VersionHandler findVersion(String version) {
        try {
            plugin.getLogger().info("Detected version " + version);
            return Version.valueOf(version).getVersionHandler();
        } catch (IllegalArgumentException e) {
            plugin.getLogger().severe("Server version not supported " + version);
            plugin.getServer().getPluginManager().disablePlugin(plugin);
            return null;
        }
    }
}
