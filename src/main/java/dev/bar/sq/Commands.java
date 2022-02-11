package dev.bar.sq;

import jdk.internal.org.jline.reader.ConfigurationPath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

public class Commands implements CommandExecutor {
    Main plugin;
    public Commands(Main instance) {
        plugin = instance;
    }



//saving method thing
    public void saved(Location ploc, String[] Colors,int x){
        Bukkit.broadcastMessage(ChatColor.WHITE+"> "+ChatColor.BOLD+Colors[x].toUpperCase(Locale.ROOT)+" TEAM SPAWN UPDATED");
        plugin.getConfig().set(Colors[x]+".x",ploc.getX());
        plugin.getConfig().set(Colors[x]+".y",ploc.getY());
        plugin.getConfig().set(Colors[x]+".z",ploc.getZ());
        plugin.getConfig().set(Colors[x]+".z",ploc.getZ());
        plugin.getConfig().set(Colors[x]+".yaw",ploc.getYaw());
        plugin.getConfig().set(Colors[x]+".pitch",ploc.getPitch());

        plugin.saveConfig();
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
            Location ploc = p.getLocation();
            if(arg1.equalsIgnoreCase("red")){ //fixed the problem by changing from ==
                saved(ploc,Colors,0);
            }
            else if(arg1.equalsIgnoreCase("blue")){ //fixed the problem by changing from ==
                saved(ploc,Colors,1);
            }
            else if(arg1.equalsIgnoreCase("gold")){ //fixed the problem by changing from ==
                saved(ploc,Colors,2);
            }
            else if(arg1.equalsIgnoreCase("purple")){ //fixed the problem by changing from ==
                saved(ploc,Colors,3);
            }
            else if(arg1.equalsIgnoreCase("spec")){ //fixed the problem by changing from ==
                saved(ploc,Colors,4);
            }

        }
        return false;
    }
}
