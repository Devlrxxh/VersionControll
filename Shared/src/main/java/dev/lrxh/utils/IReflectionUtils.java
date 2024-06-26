package dev.lrxh.utils;


public interface IReflectionUtils {
    void load();

    Object getChunkHandle(Object chunk, Object chunkStatus);

    Object[] getChunkSections(Object chunk);

    void setChunkSections(Object chunk, Object[] sections);
}
