package me.zerotwo.cardinal.Kits;

import me.zerotwo.cardinal.Utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static me.zerotwo.cardinal.Utils.Color.color;

public class SmithKit implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        ItemStack smithAnvil = new ItemBuilder(Material.ANVIL).amount(1).name(color("&8Smith's Anvil")).make();
        ItemStack smithSword = new ItemBuilder(Material.IRON_SWORD).amount(1).name(color("&8Smith's Sword")).make();
        ItemStack smithChest = new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).amount(1).name(color("&8Smith's Chestplate")).make();
        ItemStack smithPants = new ItemBuilder(Material.CHAINMAIL_LEGGINGS).amount(1).name(color("&8Smith's Pants")).make();
        ItemStack smithBoots = new ItemBuilder(Material.CHAINMAIL_BOOTS).amount(1).name(color("&8Smith's Boots")).make();
        ItemStack smithFood = new ItemBuilder(Material.COOKED_BEEF).amount(64).make();
        ItemStack smithLucky1 = new ItemBuilder(Material.IRON_BLOCK).amount(1).make();

        List<ItemStack> smithKit = Arrays.asList(smithAnvil, smithSword, smithChest, smithPants, smithBoots, smithFood, smithLucky1);

        if (command.getName().equalsIgnoreCase("Kit")) {
            if (sender.hasPermission("cardinal.smith")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("Smith")) {
                        p.sendMessage(color("&f[&4Cardinal&7] You have received kit:" + " " + args[0]));
                        smithKit.forEach(item -> p.getPlayer().getInventory().addItem(smithAnvil, smithSword, smithChest, smithPants, smithBoots, smithFood, smithLucky1));
                    } else {
                        p.sendMessage(color("&f{&4Cardinal&7] You do not have the cardinal.smith permission"));
                    }
                }
                if (args.length < 0) {
                    p.sendMessage(color("&f[&4Cardinal&7] Invalid Kit!"));
                    return true;
                }

            }
        }
        return true;
    }
}