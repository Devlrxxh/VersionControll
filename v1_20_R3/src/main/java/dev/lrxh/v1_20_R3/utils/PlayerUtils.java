package dev.lrxh.v1_20_R3.utils;

import dev.lrxh.utils.IPlayerUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class PlayerUtils implements IPlayerUtils {

    @Override
    public void sendTitle(UUID playerUUID, String header, String footer, int delay, int duration, int fadeout) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return;

        player.sendTitle(header, footer, delay, duration, fadeout);
    }

    @Override
    public int getPing(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return 0;

        return player.getPing();
    }

    @Override
    public ItemStack getItemInHand(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return null;

        return player.getInventory().getItemInMainHand();
    }

    @Override
    public void kick(UUID playerUUID, String reason) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return;

        player.kick(Component.text(reason));
    }
}
