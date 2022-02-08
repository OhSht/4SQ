package dev.bar.sq;

import jdk.internal.org.jline.reader.ConfigurationPath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Commands implements CommandExecutor {
    Main plugin;
    public Commands(Main instance) {
        plugin = instance;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(command.getName().equalsIgnoreCase("save")){

            String UUID2 = p.getUniqueId().toString();
            if(args.length == 0){
                    ListenerC listenerC = new ListenerC(plugin);
                    listenerC.saver(p,UUID2);

            }else {
                    p.sendMessage(ChatColor.GREEN + "NO.");
                }
            }
        /*

        team command next up, all of it's args too.

        */
        if(command.getName().equalsIgnoreCase("team")) {

           String[] Colors = {"red","blue","gold","purple","spectator"};

            String arg1 = args[0].toString(); //this is convoluted for a reason hoe
            p.sendMessage(arg1);
            if(arg1.equalsIgnoreCase("red")){ //fixed the problem by changing from ==
                Bukkit.broadcastMessage(ChatColor.RED+""+ChatColor.BOLD+"RED TEAM SPAWN UPDATED");
                plugin.getConfig().set(Colors[0],p.getLocation());
                plugin.saveConfig();
                Bukkit.broadcastMessage(ChatColor.RED+""+ChatColor.BOLD+plugin.getConfig().get(Colors[0]+"x"));


            }
            else if(arg1.equalsIgnoreCase("blue")){ //fixed the problem by changing from ==
                Bukkit.broadcastMessage(ChatColor.BLUE+""+ChatColor.BOLD+"BLUE TEAM SPAWN UPDATED");
                plugin.getConfig().set("Locations"+".BLUE_TEAM"+".X",p.getLocation().getX());
                plugin.getConfig().set("Locations"+".BLUE_TEAM"+".Y",p.getLocation().getY());
                plugin.getConfig().set("Locations"+".BLUE_TEAM"+".Z",p.getLocation().getZ());
                plugin.getConfig().set("Locations"+".BLUE_TEAM"+".Pitch",p.getLocation().getPitch());
                plugin.getConfig().set("Locations"+".BLUE_TEAM"+".Yaw",p.getLocation().getYaw());
            }
            else if(arg1.equalsIgnoreCase("gold")){ //fixed the problem by changing from ==
                Bukkit.broadcastMessage(ChatColor.GOLD+""+ChatColor.BOLD+"GOLD TEAM SPAWN UPDATED");
                plugin.getConfig().set("Locations"+".GOLD_TEAM"+".X",p.getLocation().getX());
                plugin.getConfig().set("Locations"+".GOLD_TEAM"+".Y",p.getLocation().getY());
                plugin.getConfig().set("Locations"+".GOLD_TEAM"+".Z",p.getLocation().getZ());
                plugin.getConfig().set("Locations"+".GOLD_TEAM"+".Pitch",p.getLocation().getPitch());
                plugin.getConfig().set("Locations"+".GOLD_TEAM"+".Yaw",p.getLocation().getYaw());
            }
            else if(arg1.equalsIgnoreCase("purple")){ //fixed the problem by changing from ==
                Bukkit.broadcastMessage(ChatColor.RED+""+ChatColor.BOLD+"PURPLE TEAM SPAWN UPDATED");
                plugin.getConfig().set("Locations"+".PURPLE_TEAM"+".X",p.getLocation().getX());
                plugin.getConfig().set("Locations"+".PURPLE_TEAM"+".Y",p.getLocation().getY());
                plugin.getConfig().set("Locations"+".PURPLE_TEAM"+".Z",p.getLocation().getZ());
                plugin.getConfig().set("Locations"+".PURPLE_TEAM"+".Pitch",p.getLocation().getPitch());
                plugin.getConfig().set("Locations"+".PURPLE_TEAM"+".Yaw",p.getLocation().getYaw());
            }
            else if(arg1.equalsIgnoreCase("spec")){ //fixed the problem by changing from ==
                Bukkit.broadcastMessage(ChatColor.RED+""+ChatColor.BOLD+"PURPLE TEAM SPAWN UPDATED");
                plugin.getConfig().set("Locations"+".SPEC_TEAM"+".X",p.getLocation().getX());
                plugin.getConfig().set("Locations"+".SPEC_TEAM"+".Y",p.getLocation().getY());
                plugin.getConfig().set("Locations"+".SPEC_TEAM"+".Z",p.getLocation().getZ());
                plugin.getConfig().set("Locations"+".SPEC_TEAM"+".Pitch",p.getLocation().getPitch());
                plugin.getConfig().set("Locations"+".SPEC_TEAM"+".Yaw",p.getLocation().getYaw());
            }

        }
        return false;
    }
}
