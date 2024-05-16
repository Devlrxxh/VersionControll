package dev.lrxh.v1_8_R3.utils.chunk;

import dev.lrxh.utils.chunk.Cuboid;
import dev.lrxh.utils.chunk.IChunkUtils;
import org.bukkit.*;
import org.bukkit.block.Block;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChunkUtilsUtil implements IChunkUtils {
    @Override
    public void restoreSnapshot(LinkedHashMap<Chunk, ChunkSnapshot> chunkSnapshots) {
        for (Map.Entry<Chunk, ChunkSnapshot> entry : chunkSnapshots.entrySet()) {
            Chunk chunk = entry.getKey();
            ChunkSnapshot snapshot = entry.getValue();

            for (int x = 0; x < 16; x++) {
                for (int y = 0; y < chunk.getWorld().getMaxHeight(); y++) {
                    for (int z = 0; z < 16; z++) {
                        int typeId = snapshot.getBlockTypeId(x, y, z);
                        byte blockData = (byte) snapshot.getBlockData(x, y, z);
                        Material material = Material.getMaterial(typeId);

                        if (material != null) {
                            Block block = chunk.getBlock(x, y, z);
                            block.setType(material);
                            block.setData(blockData);
                        }
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
