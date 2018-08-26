package me.zerotwo.cardinal;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import static me.zerotwo.cardinal.Utils.Color.color;

public class SystemBoard implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ScoreboardManager koreboard= Bukkit.getScoreboardManager();
        Scoreboard kore = koreboard.getMainScoreboard();

        Objective a = kore.registerNewObjective("stats", "");
        a.setDisplaySlot(DisplaySlot.SIDEBAR);
        a.setDisplayName(color("&6Cardinal System"));

        Score name = a.getScore(color("&7Name:" + " " + "&7[" + event.getPlayer().getDisplayName() + "&7]"));
        name.setScore(14);

        player.setScoreboard(kore);
    }
}