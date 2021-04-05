package io.github.sxigames.amogus.Eventos;


import io.github.sxigames.amogus.Amogus;
import io.github.sxigames.amogus.Utils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class JoinEvent implements Listener {
    static Amogus plugin = Amogus.getPlugin();
    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        Set<String> livres = Utils.CoresLivres();
        Random rand = new Random();
        System.out.println(livres.size());
        String aa = livres.toArray()[rand.nextInt(livres.size())].toString();
        Utils.SetCor(e.getPlayer(), aa);
        Utils.setHost(e.getPlayer(), false);
    }

    @EventHandler
    public void OnQuit(PlayerQuitEvent e){
        e.getPlayer().getPersistentDataContainer().remove(new NamespacedKey(plugin, "cor"));
        e.getPlayer().getInventory().clear();
        e.getPlayer().kickPlayer(" ");
        if(Utils.getHost().getName().equals(e.getPlayer().getName())){
            Random random = new Random();
            Collection<? extends Player> players = Bukkit.getOnlinePlayers();
            if(players.size() > 0){
                Utils.setHost(((List<Player>)players).get(random.nextInt(players.size())), true);
            }
            else{
                e.getPlayer().getPersistentDataContainer().remove(new NamespacedKey(plugin, "ishost"));

            }
        }
    }
}
