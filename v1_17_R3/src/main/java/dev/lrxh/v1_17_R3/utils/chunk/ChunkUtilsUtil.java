package dev.lrxh.v1_17_R3.utils.chunk;

import dev.lrxh.utils.chunk.Cuboid;
import dev.lrxh.utils.chunk.IChunkUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;

import java.util.LinkedHashMap;

public class ChunkUtilsUtil implements IChunkUtils {
    @Override
    public void restoreSnapshot(LinkedHashMap<Chunk, ChunkSnapshot> chunkSnapshots) {
        synchronized (chunkSnapshots) {
            for (Chunk chunk : chunkSnapshots.keySet()) {
                ChunkSnapshot snapshot = chunkSnapshots.get(chunk);
                for (int x = 0; x < 16; x++) {
                    for (int y = 0; y < chunk.getWorld().getMaxHeight(); y++) {
                        for (int z = 0; z < 16; z++) {
                            Material material = snapshot.getBlockType(x, y, z);
                            BlockData blockData = snapshot.getBlockData(x, y, z);

                            Block block = chunk.getBlock(x, y, z);
                            block.setType(material);
                            block.setBlockData(blockData, false);
                        }
                    }
                    for (Entity entity : chunk.getEntities()) {
                        if (entity instanceof HumanEntity) continue;
                        entity.remove();
                    }
                }
            }
        }
    }

    @Override
    public LinkedHashMap<Chunk, ChunkSnapshot> takeSnapshot(Location min, Location max) {
        Cuboid cuboid = new Cuboid(min, max);
        World world = cuboid.getLowerCorner().getWorld();
        LinkedHashMap<Chunk, ChunkSnapshot> chunkSnapshots = new LinkedHashMap<>();

        for (int x = cuboid.getLowerCorner().getBlockX() >> 4; x <= cuboid.getUpperCorner().getBlockX() >> 4; x++) {
            for (int z = cuboid.getLowerCorner().getBlockZ() >> 4; z <= cuboid.getUpperCorner().getBlockZ() >> 4; z++) {
                Chunk chunk = world.getChunkAt(x, z);
                ChunkSnapshot snapshot = chunk.getChunkSnapshot();
                chunkSnapshots.put(chunk, snapshot);
            }
        }
        return chunkSnapshots;
    }
}
