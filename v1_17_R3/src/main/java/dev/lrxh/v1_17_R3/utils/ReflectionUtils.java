package dev.lrxh.v1_17_R3.utils;

import dev.lrxh.utils.IReflectionUtils;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils implements IReflectionUtils {

    private Class<?> CRAFT_CHUNK_CLASS;
    private Method CHUNK_HANDLE;
    private Class<?> CHUNK_STATUS_CLASS;
    private Field CHUNK_STATUS_FIELD;
    private Field GET_SECTIONS_FIELD;
    private Class<?> I_CHUNK_ACCESS_CLASS;


    public ReflectionUtils() {
        load();
    }

    @Override
    public void load() {
        try {
            String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
            String CRAFT_BUKKIT_PACKAGE = "org.bukkit.craftbukkit." + version + ".";
            String NET_MINECRAFT_SERVER_PACKAGE = "net.minecraft.";

            CRAFT_CHUNK_CLASS = Class.forName(CRAFT_BUKKIT_PACKAGE + "CraftChunk");

            I_CHUNK_ACCESS_CLASS = Class.forName(NET_MINECRAFT_SERVER_PACKAGE + "world.level.chunk.IChunkAccess");
            GET_SECTIONS_FIELD = I_CHUNK_ACCESS_CLASS.getDeclaredField("k");
            GET_SECTIONS_FIELD.setAccessible(true);

            CHUNK_HANDLE = CRAFT_CHUNK_CLASS.getDeclaredMethod("getHandle", Class.forName(NET_MINECRAFT_SERVER_PACKAGE + "world.level.chunk.ChunkStatus"));

            CHUNK_STATUS_CLASS = Class.forName(NET_MINECRAFT_SERVER_PACKAGE + "world.level.chunk.ChunkStatus");

            CHUNK_STATUS_FIELD = CHUNK_STATUS_CLASS.getDeclaredField("k");
            CHUNK_STATUS_FIELD.setAccessible(true);

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize NMS Reflection", e);
        }
    }

    @Override
    @SneakyThrows
    public Object getChunkHandle(Object chunk, Object chunkStatus) {
        Object craftChunk = CRAFT_CHUNK_CLASS.cast(chunk);
        return CHUNK_HANDLE.invoke(craftChunk, chunkStatus);
    }

    @Override
    @SneakyThrows
    public Object[] getChunkSections(Object chunk) {
        Object fullChunkStatus = CHUNK_STATUS_FIELD.get(null);
        Object nmsChunk = getChunkHandle(chunk, fullChunkStatus);
        Object iChunkAccess = I_CHUNK_ACCESS_CLASS.cast(nmsChunk);

        return (Object[]) GET_SECTIONS_FIELD.get(iChunkAccess);
    }

    @Override
    @SneakyThrows
    public void setChunkSections(Object chunk, Object[] sections) {
        Object fullChunkStatus = CHUNK_STATUS_FIELD.get(null);
        Object nmsChunk = getChunkHandle(chunk, fullChunkStatus);
        Object iChunkAccess = I_CHUNK_ACCESS_CLASS.cast(nmsChunk);
        GET_SECTIONS_FIELD.set(iChunkAccess, sections);
    }
}
