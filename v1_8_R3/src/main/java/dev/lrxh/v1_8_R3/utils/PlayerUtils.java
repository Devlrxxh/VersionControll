package dev.lrxh.v1_8_R3.utils;

import dev.lrxh.utils.IPlayerUtils;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.github.paperspigot.Title;

import java.util.UUID;

public class PlayerUtils implements IPlayerUtils<Object> {

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

    @Override
    public void sendMessage(UUID playerUUID, Object message) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) return;

        if(message instanceof String){
            player.sendMessage((String) message);
        } else if (message instanceof BaseComponent) {
            player.sendMessage((BaseComponent) message);
        }
    }

    @Override
    public ItemStack getPlayerHead(UUID playerUUID) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setOwner(Bukkit.getPlayer(playerUUID).getName());
        head.setItemMeta(skullMeta);
        return head;
    }
}
