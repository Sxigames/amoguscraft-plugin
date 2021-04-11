package io.github.sxigames.amogus.Eventos;

import io.github.sxigames.amogus.Amogus;
import io.github.sxigames.amogus.PcLobby;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class InteractEvent implements Listener {
    Amogus plugin = Amogus.getPlugin();

    @EventHandler(ignoreCancelled = false)
    public void onPlayerInteract(PlayerInteractEvent e) {
        switch (e.getAction()) {
            case RIGHT_CLICK_BLOCK:
                if (e.getClickedBlock().getType() == Material.QUARTZ_STAIRS) {
                    e.setCancelled(true);
                    PcLobby.displayMenuCores(e.getPlayer());
                }
            case RIGHT_CLICK_AIR:
                if (Objects.requireNonNull(e.getPlayer().getInventory().getItemInMainHand()).getItemMeta().getDisplayName().equals("Iniciar")) {
                    e.setCancelled(true);
                    System.out.println("Iniciar");
                    if (Bukkit.getOnlinePlayers().size() >= 4) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.getInventory().clear();
                        }
                        plugin.getConfig().set("inPartida", true);
                        plugin.saveConfig();
                    } else {
                        e.getPlayer().sendMessage("Não há players suficientes");
                    }
                }
        }
    }
}
