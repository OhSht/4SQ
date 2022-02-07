package dev.bar.sq;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        final FileConfiguration config = this.getConfig();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ListenerC(this), this);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
