package me.zerotwo.cardinal.ClickEvents;

import me.zerotwo.cardinal.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.zerotwo.cardinal.Utils.Color.color;

public class MenuClick implements Listener {
    public void openGUI(Player player) {
        Inventory koreMenu = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Player Menu");

        ItemStack uStats=new ItemBuilder(Material.PAPER).amount(1).name(color("&5User Stats")).lore(color("&7[&6Stats&7]")).make();

        koreMenu.setItem(0, uStats);

        player.openInventory(koreMenu);

    }
    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event) {
        Action menuClick = event.getAction();
        ItemStack mainMenu = event.getItem();

        if (menuClick == Action.PHYSICAL || mainMenu == null || mainMenu.getType()==Material.AIR)
            return;
        if(mainMenu.getType()==Material.BOOK)
            openGUI(event.getPlayer());
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Player Menu"))
            return;
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

        if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR){
            player.closeInventory();
            return;
        }
        switch(event.getCurrentItem().getType()) {
            case SKULL:
                player.sendMessage(color("&f[&4Cardinal&7] This is under development right now!"));
                break;
            default:
                player.closeInventory();
                break;
        }
    }

}