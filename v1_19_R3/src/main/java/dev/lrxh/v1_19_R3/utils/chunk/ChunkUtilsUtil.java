package dev.lrxh.v1_19_R3.utils.chunk;

import dev.lrxh.utils.IReflectionUtils;
import dev.lrxh.utils.chunk.IChunkUtils;
import dev.lrxh.v1_19_R3.utils.ReflectionUtils;

public class ChunkUtilsUtil implements IChunkUtils {
    private final ReflectionUtils reflection = new ReflectionUtils();

    @Override
    public IReflectionUtils getReflection() {
        return reflection;
    }
}
