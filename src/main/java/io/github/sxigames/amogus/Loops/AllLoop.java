package io.github.sxigames.amogus.Loops;

import io.github.sxigames.amogus.Amogus;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AllLoop implements Runnable {
    static Amogus plugin = Amogus.getPlugin();
    @Override
    public void run() {
        if(!plugin.getConfig().getBoolean("inPartida"))
            if(Bukkit.getOnlinePlayers().size() <= 3) {
                Bukkit.getServer().sendActionBar(Component.text(ChatColor.RED + "" + Bukkit.getOnlinePlayers().size() + " / 10"));
            }
            if(Bukkit.getOnlinePlayers().size() <= 6 && Bukkit.getOnlinePlayers().size() > 3) {
                Bukkit.getServer().sendActionBar(Component.text(ChatColor.YELLOW + "" + Bukkit.getOnlinePlayers().size() + " / 10"));
            }
            if(Bukkit.getOnlinePlayers().size() <= 10 && Bukkit.getOnlinePlayers().size() > 7) {
                Bukkit.getServer().sendActionBar(Component.text(Bukkit.getOnlinePlayers().size() + " / 10"));
        }
    }
}
