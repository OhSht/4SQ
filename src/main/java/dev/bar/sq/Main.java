package dev.bar.sq;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new ListenerC(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
