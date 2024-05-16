package dev.lrxh.utils;

import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public interface IPlayerUtils {
    void sendTitle(UUID playerUUID, String header, String footer, int delay, int duration, int fadeout);
    int getPing(UUID playerUUID);
    ItemStack getItemInHand(UUID playerUUID);
    void kick(UUID playerUUID, String reason);
}
