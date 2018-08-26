package me.zerotwo.cardinal;

import me.zerotwo.cardinal.Kits.SmithKit;
import me.zerotwo.cardinal.Kits.StarterKit;
import org.bukkit.plugin.java.JavaPlugin;

import static me.zerotwo.cardinal.Utils.Color.color;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(color("&3Cardinal System is now generating server files"));
        getServer().getPluginManager().registerEvents(new SystemBoard(), this);
        getCommand("kit").setExecutor(new SmithKit());
        getCommand("kit").setExecutor(new StarterKit());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(color("&4Cardinal shutting down and saving files"));
    }
}
