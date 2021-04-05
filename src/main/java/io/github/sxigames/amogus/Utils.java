package io.github.sxigames.amogus;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.skinsrestorer.api.PlayerWrapper;
import net.skinsrestorer.shared.exception.SkinRequestException;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Utils {

    static Amogus plugin = Amogus.getPlugin();
    public static ItemStack createInvisibleItem(String nome) {
        ItemStack is = new ItemStack(Material.STICK);
        ItemMeta itemMeta = is.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RESET + nome);
        itemMeta.setCustomModelData(1234567);
        is.setItemMeta(itemMeta);
        return is;
    }

    public static void SetCor(Player p, String cor) {
        try {
            Amogus.skinsRestorerAPI.setSkin(p.getName(), cor.toLowerCase());
            Amogus.skinsRestorerAPI.applySkin(new PlayerWrapper(p));
            p.getPersistentDataContainer().set(new NamespacedKey(plugin, "cor"), PersistentDataType.STRING, cor.toLowerCase());
        } catch (SkinRequestException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Player> ListaCoresUsadas() {
        HashMap<String, Player> lista = new HashMap<String, Player>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getPersistentDataContainer().has(new NamespacedKey(plugin, "cor"), PersistentDataType.STRING)) {
                lista.put(p.getPersistentDataContainer().get(new NamespacedKey(plugin, "cor"), PersistentDataType.STRING), p);
            }
        }
        return lista;
    }

    public static Set<String> TodasCores() {
        Set<String> set = new HashSet<String>();
        set.add("vermelho");
        set.add("azul");
        set.add("amarelo");
        set.add("branco");
        set.add("ciano");
        set.add("laranja");
        set.add("lima");
        set.add("marrom");
        set.add("preto");
        set.add("rosa");
        set.add("roxo");
        set.add("verde");
        return set;
    }

    public static Set<String> CoresLivres() {
        HashMap<String, Player> lista = ListaCoresUsadas();
        Set<String> usadas = lista.keySet();
        Set<String> todas = TodasCores();
        for (String s : usadas) {
            todas.remove(s);
        }
        return todas;
    }

    public static void setHost(Player p, Boolean replace) {
        NamespacedKey ishost = new NamespacedKey(plugin,"ishost" );
        if(replace){
            if (getHost() != null) {
                getHost().getPersistentDataContainer().remove(ishost);
            }
            p.getPersistentDataContainer().set(ishost, PersistentDataType.STRING, "true");
        }
        else{
            if (getHost() == null) {
                p.getPersistentDataContainer().set(ishost, PersistentDataType.STRING, "true");
            }
        }

    }

    public static Player getHost() {
        Player host = null;
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getPersistentDataContainer().has(new NamespacedKey(plugin, "ishost"), PersistentDataType.STRING)) {
                host = p;
            }
        }
        return host;
    }
}
