package dev.lrxh.v1_20_R3.utils;

import dev.lrxh.utils.IPlayerUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class PlayerUtils implements IPlayerUtils<Object> {

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

    @Override
    public void sendMessage(UUID playerUUID, Object message) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return;

        if(message instanceof String){
            player.sendMessage((String) message);
        } else if (message instanceof TextComponent) {
            player.sendMessage((TextComponent) message);
        }
    }

    @Override
    public ItemStack getPlayerHead(UUID playerUUID) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getPlayer(playerUUID));
        head.setItemMeta(skullMeta);
        return head;
    }
}
