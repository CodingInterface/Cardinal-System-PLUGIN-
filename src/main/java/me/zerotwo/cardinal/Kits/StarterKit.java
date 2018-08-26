package me.zerotwo.cardinal.Kits;

import me.zerotwo.cardinal.Utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import static me.zerotwo.cardinal.Utils.Color.color;

public class StarterKit implements Listener, CommandExecutor {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPlayedBefore()) return;
        ItemStack mainMenu=new ItemBuilder(Material.BOOK).amount(1).name(color("&6Player Menu")).make();
        event.getPlayer().getInventory().addItem(mainMenu);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        ItemStack mainMenu=new ItemBuilder(Material.CHEST).amount(1).name(color("&6User Menu")).make();
        if (command.getName().equalsIgnoreCase("Kit")) {
            if (sender.hasPermission("cardinal.starter")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("Starter")) {
                        p.sendMessage(color("&f[&4Cardinal&7] You have received kit:" + " " + args[0]));
                        p.getPlayer().getInventory().addItem(mainMenu);
                    } else {
                        p.sendMessage(color("&f{&4Cardinal&7] You do not have the cardinal.starter permission"));
                    } if (args.length < 0) {
                        p.sendMessage(color("&f[&4Cardinal&7] Invalid Kit!"));
                        return true;
                    }
                }
            }
        }
        return true;
    }
}