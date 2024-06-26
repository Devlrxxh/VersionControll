package dev.lrxh.utils.chunk;

import dev.lrxh.utils.ConcurrentLinkedHashMap;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

public interface IChunkUtils {
    void restoreSnapshot(ConcurrentLinkedHashMap<Chunk, Object[]> chunkSnapshots, World world);

    ConcurrentLinkedHashMap<Chunk, Object[]> takeSnapshot(World world, Location min, Location max);
}
