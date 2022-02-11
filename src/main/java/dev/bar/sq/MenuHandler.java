package dev.bar.sq;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.sun.org.apache.xml.internal.utils.res.StringArrayWrapper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.Objects;

public class MenuHandler implements Listener {


    Main plugin;
    public MenuHandler(Main instance) {
        plugin = instance; //forced extention to main.java

    }
    public void launcher(Player p, int x,String[] Colors){
        ChatColor[] ChatC = {ChatColor.RED,ChatColor.BLUE,ChatColor.GOLD,ChatColor.LIGHT_PURPLE,ChatColor.WHITE};

        Location loc = new Location(Bukkit.getWorld("world"),
                plugin.getConfig().getDouble(Colors[x]+".x"),
                plugin.getConfig().getDouble(Colors[x]+".y"),
                plugin.getConfig().getDouble(Colors[x]+".z"));
        p.teleport(loc.add(0,150,0));
        p.setVelocity(new Vector(0, 5, 0));
        int diameter = 10; //Diameter of the circle centered on loc
        PlayerInventory inventory = p.getInventory();
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        item.setItemMeta(meta);
        ItemStack item1 = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta1 = item.getItemMeta();
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        item.setItemMeta(meta1);

        ItemStack item5 = new ItemStack(Material.BOW);
        ItemMeta meta5 = item.getItemMeta();
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
        meta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        item.setItemMeta(meta5);
        ItemStack item6 = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta6 = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
        meta.addEnchant(Enchantment.OXYGEN, 1, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        item.setItemMeta(meta6);
        ItemStack item7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta7 = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.addEnchant(Enchantment.THORNS, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        item.setItemMeta(meta7);
        ItemStack item8 = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta8 = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.addEnchant(Enchantment.THORNS, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        item.setItemMeta(meta8);
        ItemStack item9 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta9 = item.getItemMeta();
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        item.setItemMeta(meta9);
        p.getInventory().clear();
        p.getInventory().setHelmet(item6);
        p.getInventory().setChestplate(item7);
        p.getInventory().setLeggings(item8);
        p.getInventory().setBoots(item9);
        p.getInventory().setItem(0,item1);

        for (int i = 0; i < 3; i++)
        {
            Location newLocation = loc.add(new Vector(Math.random()-0.5, 0, Math.random()-0.5).multiply(diameter));
        }
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            public void run() {
                p.setVelocity(new Vector(0, -150, 0));

                p.sendTitle(ChatColor.GREEN+"JOINING", ChatC[x]+Colors[x].toUpperCase()+" Team", 1, 80, 1);

            }
        }, 100);
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            public void run() {
                p.setVelocity(new Vector(0, -150, 0));

                Objects.requireNonNull(Bukkit.getServer().getWorld("world")).spawnEntity(p.getLocation(), EntityType.FIREWORK);

            }
        }, 125);

    }


    @EventHandler
    public void onChestOpen(InventoryClickEvent e) {
        String[] Colors = {"red","blue","gold","purple","spectator"};
        ItemStack Helm = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack Chesty = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack Pants = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack BOOTS = new ItemStack(Material.DIAMOND_BOOTS);

        ItemMeta Chest_meta = Chesty.getItemMeta();
        Chest_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,true);

        Player p = (Player) e.getWhoClicked();
        p.sendMessage(e.getView().getTitle());
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED+" "+ChatColor.BOLD+"CHOOSE YOUR TEAM")){
            e.setCancelled(true);
            p.sendMessage("GUI ACTIVATED");
            if(e.getCurrentItem().getType().equals(Material.RED_BANNER)){
                p.closeInventory();
                p.sendMessage("Joined Red team.");
                plugin.getConfig().set(p.getUniqueId() + ".Color", "red");
                plugin.saveConfig();
                launcher(p,0,Colors);

            }else if(e.getCurrentItem().getType().equals(Material.BLUE_BANNER)){
                p.closeInventory();
                p.sendMessage("Joined Blue team.");
                plugin.getConfig().set(p.getUniqueId() + ".Color", "blue");
                plugin.saveConfig();

                launcher(p,1,Colors);

            }
            if(e.getCurrentItem().getType().equals(Material.YELLOW_BANNER)){
                p.closeInventory();
                p.sendMessage("Joined Gold team.");
                plugin.getConfig().set(p.getUniqueId() + ".Color", "gold");
                plugin.saveConfig();
                launcher(p,2,Colors);

            }
            if(e.getCurrentItem().getType().equals(Material.PURPLE_BANNER)){
                p.closeInventory();
                p.sendMessage("Joined Purple team.");
                plugin.getConfig().set(p.getUniqueId() + ".Color", "purple");
                plugin.saveConfig();
                launcher(p,3,Colors);

            }if(e.getCurrentItem().getType().equals(Material.WHITE_BANNER)){
                p.closeInventory();
                if(plugin.getConfig().get(p.getUniqueId() + ".Spectating")=="yes"){
                    p.sendMessage(ChatColor.DARK_GRAY+"SPECTATING OVER.");
                    plugin.getConfig().set(p.getUniqueId() + ".Spectating","no");
                    plugin.getConfig().set(p.getUniqueId() + ".Color", "null");
                    plugin.saveConfig();
                }else{
                    p.sendMessage(ChatColor.DARK_GRAY+"SPECTATING STARTED.");
                    plugin.getConfig().set(p.getUniqueId() + ".Spectating","yes");
                    plugin.getConfig().set(p.getUniqueId() + ".Color", "Spectator");
                    plugin.saveConfig();

                }



            }
            if(e.getCurrentItem().getType().equals(Material.BARRIER)){
                p.closeInventory();

            }
        }


    }


}