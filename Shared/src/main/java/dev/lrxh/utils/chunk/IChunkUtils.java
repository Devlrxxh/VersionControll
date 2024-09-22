package dev.lrxh.utils.chunk;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public interface IChunkUtils {

    default void setBlock(JavaPlugin plugin, Location location, Material material, boolean physics) {
        Chunk chunk = location.getChunk();
        chunk.setForceLoaded(true);
        location.getBlock().setType(material, physics);
        chunk.setForceLoaded(false);
    }
}
