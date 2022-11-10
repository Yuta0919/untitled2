package javajava.hardcore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HardCore extends JavaPlugin implements Listener {
    public int deathcount;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void PlayerDeath(PlayerDeathEvent e){
        deathcount++;
        int a=Bukkit.getOnlinePlayers().size()-deathcount;
        e.getPlayer().setGameMode(GameMode.SPECTATOR);
        Bukkit.broadcastMessage(ChatColor.RED+e.getPlayer().getName()+"が死んだ！！");
        Bukkit.broadcastMessage(ChatColor.AQUA+"残り"+a+"人");
    }
}