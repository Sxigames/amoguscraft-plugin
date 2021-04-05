package io.github.sxigames.amogus.Loops;

import io.github.sxigames.amogus.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;


public class HostLoop implements Runnable {
    @Override
    public void run() {
        Player host = Utils.getHost();
        if (host != null) {
                ItemStack iniciar = new ItemStack(Material.CARROT_ON_A_STICK);
                ItemMeta itemMeta = iniciar.getItemMeta();
                itemMeta.setDisplayName("Iniciar");
                itemMeta.setCustomModelData(1010);
                iniciar.setItemMeta(itemMeta);
                host.getInventory().setItem(4, iniciar);
        }
    }
}
