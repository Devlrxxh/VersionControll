package dev.lrxh.v1_17_R3.utils;

import dev.lrxh.utils.IColorUtils;
import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils implements IColorUtils {
    private final Pattern hexPattern = Pattern.compile("&#[A-Fa-f0-9]{6}");


    public String color(String text) {
        if (text == null) {
            return "";
        } else {
            Matcher matcher = hexPattern.matcher(text);
            while (matcher.find()) {
                try {
                    String color = matcher.group();
                    String hexColor = color.replace("&", "").replace("x", "#");
                    net.md_5.bungee.api.ChatColor bungeeColor = net.md_5.bungee.api.ChatColor.of(hexColor);
                    text = text.replace(color, bungeeColor.toString());
                } catch (Exception ignored) {
                }
            }

            text = ChatColor.translateAlternateColorCodes('&', text);
            return text;
        }
    }
}
