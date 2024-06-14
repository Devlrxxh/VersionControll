package dev.lrxh.utils;

import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public interface IPlayerUtils<T> {
    void sendTitle(UUID playerUUID, String header, String footer, int delay, int duration, int fadeout);

    int getPing(UUID playerUUID);

    ItemStack getItemInHand(UUID playerUUID);

    void kick(UUID playerUUID, String reason);

    void sendMessage(UUID playerUUID, Object message);

    void sendMessage(UUID playerUUID, List<Object> message);

    ItemStack getPlayerHead(UUID playerUUID);
}
