package io.github.sxigames.amogus;


import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import io.github.sxigames.amogus.Eventos.InteractEvent;
import io.github.sxigames.amogus.Eventos.JoinEvent;
import io.github.sxigames.amogus.Eventos.QuitEvent;
import io.github.sxigames.amogus.Loops.AllLoop;
import io.github.sxigames.amogus.Loops.HostLoop;
import net.skinsrestorer.api.SkinsRestorerAPI;
import org.bukkit.Bukkit;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.ipvp.canvas.MenuFunctionListener;

import java.util.Objects;

public final class Amogus extends JavaPlugin {
    public static SkinsRestorerAPI skinsRestorerAPI;
    private static Amogus plugin;
    public static ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        plugin = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
        skinsRestorerAPI = SkinsRestorerAPI.getApi();
        getConfig().addDefault("inPartida", false);
        getConfig().addDefault("inReuinao", false);
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new MenuFunctionListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new HostLoop(), 0L, 0L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new AllLoop(), 0L, 0L);
    }

    @Override
    public void onDisable() {

    }

    public static Amogus getPlugin() {
        return plugin;
    }
}

