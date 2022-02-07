package dev.bar.sq;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerC implements Listener {

    Main plugin;

    public ListenerC(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();
        event.setJoinMessage(ChatColor.BLACK + p.getDisplayName() + ChatColor.BLACK + " has joined!");

    }






}


