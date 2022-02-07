package dev.bar.sq;

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
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("CHOOSE YOUR TEAM")){
            p.sendMessage("GUI ACTIVATED");
            if(e.getCurrentItem().getType().equals(Material.RED_BANNER)){
                p.sendMessage("Joined Red team.");
            }
        }


    }


}