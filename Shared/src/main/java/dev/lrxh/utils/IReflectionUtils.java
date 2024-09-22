package dev.lrxh.utils;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public interface IReflectionUtils {
    void load();

    Object getChunkHandle(Object chunk);

    Object[] getChunkSections(Object chunk);

    void setChunkSections(Object chunk, Object[] sections);

    default void setBlock(JavaPlugin plugin, Location location, Material material, boolean physics) {
        Chunk chunk = location.getChunk();
        chunk.setForceLoaded(true);
        location.getBlock().setType(material, physics);
        chunk.setForceLoaded(false);
    }
}
