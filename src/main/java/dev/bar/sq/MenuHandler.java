package dev.bar.sq;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuHandler implements Listener {

    Main plugin;

    public MenuHandler(Main instance) {
        plugin = instance; //forced extention to main.java

    }

    @EventHandler
    public void onChestOpen(InventoryClickEvent e) {
        String[] Colors = {"red","blue","gold","purple","spectator"};

        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED+" "+ChatColor.BOLD+"CHOOSE YOUR TEAM")){
            e.setCancelled(true);
            //cancells the movement n stuff
            p.sendMessage("GUI ACTIVATED");
            if(e.getCurrentItem().getType().equals(Material.RED_BANNER)){
                p.sendMessage("Joined Red team.");
                p.sendMessage(String.valueOf(plugin.getConfig().getDouble("red"+".x")));
                p.sendMessage(String.valueOf(plugin.getConfig().getDouble((Colors[0]+".x"))));
                Location loc = new Location(Bukkit.getWorld("world"),
                        plugin.getConfig().getDouble(Colors[0]+".x"),
                        plugin.getConfig().getDouble(Colors[0]+".y"),
                        plugin.getConfig().getDouble(Colors[0]+".z"));
                p.teleport(loc);

            }

        }


    }


}