package io.github.sxigames.amogus.Loops;

import io.github.sxigames.amogus.Amogus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AllLoop implements Runnable {
    static Amogus plugin = Amogus.getPlugin();
    @Override
    public void run() {
        if(!plugin.getConfig().getBoolean("inPartida"))
        for(Player p : Bukkit.getOnlinePlayers()){
            if(Bukkit.getOnlinePlayers().size() <= 3) {
                p.sendActionBar(ChatColor.RED + "" + Bukkit.getOnlinePlayers().size() + " / 10");
            }
            if(Bukkit.getOnlinePlayers().size() <= 6 && Bukkit.getOnlinePlayers().size() > 3) {
                p.sendActionBar(ChatColor.YELLOW + "" + Bukkit.getOnlinePlayers().size() + " / 10");
            }
            if(Bukkit.getOnlinePlayers().size() <= 10 && Bukkit.getOnlinePlayers().size() > 7) {
                p.sendActionBar(Bukkit.getOnlinePlayers().size() + " / 10");
            }
        }
    }
}
