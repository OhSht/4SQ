package dev.bar.sq;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ListenerC implements Listener {
    Main plugin;

    public ListenerC(Main instance) {
        plugin = instance; //forced extention to main.java
    }



    public void saver(Player p, String UUID) {//function that manual saves the sender's data to the config.yml


        plugin.getConfig().set(p.getName() + ".UUID", UUID);
        plugin.getConfig().set(p.getName() + ".Money", 0);
        plugin.getConfig().set(p.getName() + ".Level", 0);
        plugin.getConfig().set(p.getName() + ".Color", "null");

        plugin.saveConfig();
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {

        Player p = event.getPlayer();
        String UUID = p.getUniqueId().toString();
        if(!plugin.getConfig().contains(p.getName() + ".UUID")){
                p.sendMessage("Saving your Data :)");
                saver(p,UUID);
        }else {
            event.setJoinMessage(p.getDisplayName() + ChatColor.GOLD + " has joined! Your UUID is: "+ plugin.getConfig().get(p.getName() + ".UUID"));
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        //Define the player

        Player player = event.getPlayer();
        //Define the item in their hand
        Block block = event.getClickedBlock();

        event.getPlayer().sendMessage(ChatColor.GREEN + "You have clicked the block: " + block.getType());
        if(block.getType()==Material.CRIMSON_WALL_SIGN){
            Inventory gui = Bukkit.createInventory(player, 9,ChatColor.RED+" "+ChatColor.BOLD+"CHOOSE YOUR TEAM");

            //all of the items in the GUI
            ItemStack RED = new ItemStack(Material.RED_BANNER);
            ItemStack BLUE = new ItemStack(Material.BLUE_BANNER);
            ItemStack GOLD = new ItemStack(Material.YELLOW_BANNER);
            ItemStack PURPLE = new ItemStack(Material.PURPLE_BANNER);
            ItemStack SPAWN = new ItemStack(Material.WHITE_BANNER);



            //setting all of the metas or descriptions of the items
            ItemMeta RED_meta = RED.getItemMeta();
            ItemMeta BLUE_meta = BLUE.getItemMeta();
            ItemMeta GOLD_meta = GOLD.getItemMeta();
            ItemMeta PURPLE_meta = PURPLE.getItemMeta();
            ItemMeta SPAWN_meta = SPAWN.getItemMeta();
            RED_meta.setDisplayName(ChatColor.RED+"RED TEAM");
            SPAWN_meta.setDisplayName(ChatColor.RED+"SPECTATOR");
            BLUE_meta.setDisplayName(ChatColor.BLUE+""+ChatColor.BOLD+"BLUE TEAM");
            GOLD_meta.setDisplayName(ChatColor.GOLD+""+ChatColor.BOLD+"GOLD TEAM");
            PURPLE_meta.setDisplayName(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"PURPLE TEAM");

            ArrayList<String> SPAWN_lore = new ArrayList<>();
            SPAWN_lore.add(ChatColor.GRAY+"SPECTATOR TEAM, YOU WILL NOT DIE.");
            SPAWN_meta.setLore(SPAWN_lore);//optional lore


            //sets the itemmeta in
            RED.setItemMeta(RED_meta);
            BLUE.setItemMeta(BLUE_meta);
            GOLD.setItemMeta(GOLD_meta);
            RED.setItemMeta(PURPLE_meta);
            SPAWN.setItemMeta(SPAWN_meta);

            ItemStack[] teams = {RED,BLUE,GOLD,PURPLE,SPAWN}; //puts all of the teams in array
            gui.setContents(teams);  //sets the contents from array
            player.openInventory(gui);//opens GUI


        }
    }

}


