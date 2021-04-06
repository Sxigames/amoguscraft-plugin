package io.github.sxigames.amogus.Eventos;

import io.github.sxigames.amogus.Amogus;
import io.github.sxigames.amogus.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.slot.Slot;
import org.ipvp.canvas.type.ChestMenu;

import java.util.HashMap;
import java.util.Objects;

public class InteractEvent implements Listener {
    Amogus plugin = Amogus.getPlugin();

    @EventHandler(ignoreCancelled = false)
    public void onPlayerInteract(PlayerInteractEvent e) {
        switch(e.getAction()){
            case RIGHT_CLICK_BLOCK:
                if (Objects.requireNonNull(e.getClickedBlock()).getType() == Material.QUARTZ_STAIRS) {
                    e.setCancelled(true);
                    PcLobby.displayMenu(e.getPlayer());
                }
            case RIGHT_CLICK_AIR:
                if (Objects.requireNonNull(e.getPlayer().getInventory().getItemInMainHand()).getItemMeta().getDisplayName().equals("Iniciar")) {
                    System.out.println("Iniciar");
                    if (Bukkit.getOnlinePlayers().size() >= 4) {
                        plugin.getConfig().set("inPartida", true);
                        plugin.saveConfig();
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.getInventory().clear();
                        }
                    } else {
                        e.getPlayer().sendMessage("Não há players suficientes");
                    }
                }
        }
    }

    public static class PcLobby {


        public static Menu createMenu() {
            return ChestMenu.builder(6)
                    .title("\uF808" + ChatColor.WHITE + "\uE001\uF828")
                    .build();
        }

        public static void displayMenu(Player player) {
            Menu menu = createMenu();

            FormatarSlot(menu.getSlot(1, 2), "Vermelho");
            FormatarSlot(menu.getSlot(1, 4), "Azul");
            FormatarSlot(menu.getSlot(1, 6), "Verde");
            FormatarSlot(menu.getSlot(1, 8), "Rosa");
            FormatarSlot(menu.getSlot(3, 2), "Laranja");
            FormatarSlot(menu.getSlot(3, 4), "Amarelo");
            FormatarSlot(menu.getSlot(3, 6), "Preto");
            FormatarSlot(menu.getSlot(3, 8), "Branco");
            FormatarSlot(menu.getSlot(5, 2), "Marrom");
            FormatarSlot(menu.getSlot(5, 4), "Ciano");
            FormatarSlot(menu.getSlot(5, 6), "Lima");
            FormatarSlot(menu.getSlot(5, 8), "Roxo");
            menu.open(player);

        }

        public static void FormatarSlot(Slot slot, String cor) {
            HashMap<String, Player> coresusadas = Utils.ListaCoresUsadas();
            if (coresusadas.containsKey(cor.toLowerCase())) {
                ItemStack is = new ItemStack(Material.BARRIER);
                ItemMeta itemMeta = is.getItemMeta();
                itemMeta.setDisplayName(cor + "(" + coresusadas.get(cor.toLowerCase()).getName() + ")");
                is.setItemMeta(itemMeta);
                slot.setItem(is);
            } else {
                slot.setItem(Utils.createInvisibleItem(cor));
                slot.setClickHandler((player, info) -> Utils.SetCor(player, cor));
            }

        }
    }
}
