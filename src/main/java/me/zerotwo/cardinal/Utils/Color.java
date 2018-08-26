package me.zerotwo.cardinal.Utils;

import org.bukkit.ChatColor;

public class Color {
    public static String color(String txt) {
        return ChatColor.translateAlternateColorCodes('&', txt);
    }
}
