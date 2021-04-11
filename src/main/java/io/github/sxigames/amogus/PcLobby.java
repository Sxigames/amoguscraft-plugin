package io.github.sxigames.amogus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.slot.Slot;
import org.ipvp.canvas.type.ChestMenu;

import java.util.HashMap;

public class PcLobby {
    public static Menu createMenuCores() {
        return ChestMenu.builder(6)
                .title("\uF808" + ChatColor.WHITE + "\uE001\uF828")
                .build();
    }
    public static Menu createMenuCosmeticos() {
        return ChestMenu.builder(6)
                .title("\uF808" + ChatColor.WHITE + "\uE002\uF828")
                .build();
    }

    public static void displayMenuCosmeticos(Player player) {
        Menu menu = createMenuCosmeticos();
        menu.getSlot(6, 2).setItem(Utils.createInvisibleItem("Voltar Página"));
        menu.getSlot(6, 8).setItem(Utils.createInvisibleItem("Proxima Página"));
        menu.getSlot(6,  2).setClickHandler((p, info) -> displayMenuCores(p));
        menu.open(player);

    }
    public static void displayMenuCores(Player player) {
        Menu menu = createMenuCores();

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
        menu.getSlot(6, 2).setItem(Utils.createInvisibleItem("Voltar Página"));
        menu.getSlot(6, 8).setItem(Utils.createInvisibleItem("Proxima Página"));
        menu.getSlot(6,  8).setClickHandler((p, info) -> displayMenuCosmeticos(p));
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

