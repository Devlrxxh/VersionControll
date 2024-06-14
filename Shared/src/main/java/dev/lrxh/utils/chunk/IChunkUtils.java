package dev.lrxh.utils.chunk;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.LinkedHashMap;

public interface IChunkUtils {
    void restoreSnapshot(LinkedHashMap<Chunk, ChunkSnapshot> chunkSnapshots, World world);
    LinkedHashMap<Chunk, ChunkSnapshot> takeSnapshot(World world, Location min, Location max);
}
