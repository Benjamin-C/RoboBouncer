package dev.orangeben.robobouncer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class RoboBouncer extends JavaPlugin {

    public static FileConfiguration config;

    @Override
    public void onEnable() {
        // Load plugin config
        this.saveDefaultConfig();
        config = this.getConfig();
        // Initialize listeners
        getServer().getPluginManager().registerEvents(new RBListener(), this);
        // Initialize commands
        this.getCommand("robobouncer").setExecutor(new RBCommand(this));
        // Say hi
        getLogger().info(getName() + " loaded");
    }

    @Override
    public void onDisable() {
        // Say bye
        getLogger().info(getName() + " unloaded");
    }
}
