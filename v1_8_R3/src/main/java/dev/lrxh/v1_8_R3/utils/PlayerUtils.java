package dev.lrxh.v1_8_R3.utils;

import dev.lrxh.utils.IPlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.github.paperspigot.Title;

import java.util.UUID;

public class PlayerUtils implements IPlayerUtils {

    @Override
    public void sendTitle(UUID playerUUID, String header, String footer, int delay, int duration, int fadeout) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return;

        player.sendTitle(new Title(header, footer, delay, duration, fadeout));
    }

    @Override
    public int getPing(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return 0;

        return player.spigot().getPing();
    }

    @Override
    public ItemStack getItemInHand(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return null;

        return player.getItemInHand();
    }

    @Override
    public void kick(UUID playerUUID, String reason) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return;

        player.kickPlayer(reason);
    }
}
