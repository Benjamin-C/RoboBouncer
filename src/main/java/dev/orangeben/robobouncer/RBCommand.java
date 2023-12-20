package dev.orangeben.robobouncer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class RBCommand implements CommandExecutor {

    private Plugin plugin;

    public RBCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    // Reload the config
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // If there is exactly 1 argument
        if(args.length == 1) {
            // If that argument is reload
            if(args[0].equals(Keys.CMD_RELOAD)) {
                // If the user is allowed to reload
                if(sender.hasPermission(Keys.PREM_RELOAD)) {
                    // Reload config
                    plugin.reloadConfig();
                    RoboBouncer.config = plugin.getConfig();
                    sender.sendMessage("[RoboBouncer] Config reloaded");
                } else {
                    // Tell the user they're not allowed to reload
                    sender.sendMessage("[RoboBouncer] You don't have permission to do that.");
                }
                // Don't show usage hint
                return true;
            }
        }
        // Show usage hint
        return false;
    }
}