package dev.lrxh.v1_8_R3.utils;

import dev.lrxh.utils.IColorUtils;
import org.bukkit.ChatColor;

public class ColorUtils implements IColorUtils {
    @Override
    public String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
