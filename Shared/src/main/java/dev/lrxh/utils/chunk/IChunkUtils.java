package dev.lrxh.utils.chunk;

import dev.lrxh.utils.ConcurrentLinkedHashMap;
import dev.lrxh.utils.IReflectionUtils;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Map;

public interface IChunkUtils {

    IReflectionUtils getReflection();

    default void restoreSnapshot(ConcurrentLinkedHashMap<Chunk, Object[]> chunkSnapshots) {
        for (Map.Entry<Chunk, Object[]> entry : chunkSnapshots.entrySet()) {
            Chunk chunk = entry.getKey();
            World world = chunk.getWorld();
            chunk.load();
            getReflection().setChunkSections(chunk, entry.getValue());
            world.refreshChunk(chunk.getX(), chunk.getZ());
        }
    }

    default ConcurrentLinkedHashMap<Chunk, Object[]> takeSnapshot(Location min, Location max) {
        Cuboid cuboid = new Cuboid(min, max);
        ConcurrentLinkedHashMap<Chunk, Object[]> chunkSnapshots = new ConcurrentLinkedHashMap<>();

        for (Chunk chunk : cuboid.getChunks()) {
                chunkSnapshots.put(chunk, getReflection().getChunkSections(chunk));
            }

        return chunkSnapshots;
    }

    default void pasteSnapshot(ConcurrentLinkedHashMap<Chunk, Object[]> chunkSnapshots, Location pasteMin, Location pasteMax, World world) {
        Cuboid pasteCuboid = new Cuboid(pasteMin, pasteMax);

        for (Map.Entry<Chunk, Object[]> entry : chunkSnapshots.entrySet()) {
            Chunk originalChunk = entry.getKey();
            Object[] chunkData = entry.getValue();

            int originalChunkX = originalChunk.getX();
            int originalChunkZ = originalChunk.getZ();

            int originalMinX = originalChunkX * 16;
            int originalMinZ = originalChunkZ * 16;

            int pasteMinX = pasteCuboid.getLowerCorner().getBlockX();
            int pasteMinZ = pasteCuboid.getLowerCorner().getBlockZ();
            int offsetX = pasteMinX - originalMinX;
            int offsetZ = pasteMinZ - originalMinZ;

            int newChunkX = originalChunkX + (offsetX >> 4);
            int newChunkZ = originalChunkZ + (offsetZ >> 4);

            Chunk newChunk = world.getChunkAt(newChunkX, newChunkZ);

            getReflection().setChunkSections(newChunk, chunkData);
            world.refreshChunk(newChunkX, newChunkZ);
        }
    }

}
