package dev.lrxh.v1_16_R3.utils.chunk;

import dev.lrxh.utils.ConcurrentLinkedHashMap;
import dev.lrxh.utils.chunk.Cuboid;
import dev.lrxh.utils.chunk.IChunkUtils;
import dev.lrxh.v1_16_R3.utils.ReflectionUtils;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Map;

public class ChunkUtilsUtil implements IChunkUtils {
    private final ReflectionUtils reflection = new ReflectionUtils();

    @Override
    public void restoreSnapshot(ConcurrentLinkedHashMap<Chunk, Object[]> chunkSnapshots, World world) {
        for (Map.Entry<Chunk, Object[]> entry : chunkSnapshots.entrySet()) {
            Chunk chunk = entry.getKey();
            reflection.setChunkSections(chunk, entry.getValue());
            world.refreshChunk(chunk.getX(), chunk.getZ());
        }
    }

    @Override
    public ConcurrentLinkedHashMap<Chunk, Object[]> takeSnapshot(World world, Location min, Location max) {
        Cuboid cuboid = new Cuboid(min, max);
        ConcurrentLinkedHashMap<Chunk, Object[]> chunkSnapshots = new ConcurrentLinkedHashMap<>();

        for (int x = cuboid.getLowerCorner().getBlockX() >> 4; x <= cuboid.getUpperCorner().getBlockX() >> 4; x++) {
            for (int z = cuboid.getLowerCorner().getBlockZ() >> 4; z <= cuboid.getUpperCorner().getBlockZ() >> 4; z++) {
                Chunk chunk = world.getChunkAt(x, z);
                chunkSnapshots.put(chunk, reflection.getChunkSections(chunk));
            }
        }

        return chunkSnapshots;
    }
}
