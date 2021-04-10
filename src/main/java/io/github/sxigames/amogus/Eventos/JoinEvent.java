package io.github.sxigames.amogus.Eventos;


import io.github.sxigames.amogus.Amogus;
import io.github.sxigames.amogus.Utils;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
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
        e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), rand.nextInt(10-6) + 6, 64 ,-1));
    }
}
