package dev.orangeben.robobouncer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import net.kyori.adventure.text.Component;

public class RBListener implements Listener {
    
    @EventHandler
    public void playerJoinEvent(PlayerLoginEvent e) {
        // When someone joins the server
        Player p = e.getPlayer();
        // If they're not allowed
        if(!p.hasPermission(Keys.PERM_JOIN)) {
            // Tell the server they aren't allowed
            e.disallow(Result.KICK_WHITELIST, Component.text(RoboBouncer.config.getString(Keys.CONFIG_KICKMSG)));
        }
    }
}
