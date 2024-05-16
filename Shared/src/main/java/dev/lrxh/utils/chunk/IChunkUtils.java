package dev.lrxh.utils.chunk;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;

import java.util.LinkedHashMap;

public interface IChunkUtils {
    void restoreSnapshot(LinkedHashMap<Chunk, ChunkSnapshot> chunkSnapshots);
    LinkedHashMap<Chunk, ChunkSnapshot> takeSnapshot(Location min, Location max);
}
