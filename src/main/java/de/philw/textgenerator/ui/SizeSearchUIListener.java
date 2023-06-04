package de.philw.textgenerator.ui;

import de.philw.textgenerator.TextGenerator;
import de.philw.textgenerator.manager.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SizeSearchUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.GREEN +
                "Select Size")) {
            return;
        }
        if (e.getCurrentItem() == null) return;
        Player player = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta() == null) return;
            if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("")) return;
            if (TextGenerator.getInstance().getCurrentEdited() == null) {
                String fontSize = e.getCurrentItem().getItemMeta().getLocalizedName();
                ConfigManager.setFontSize(fontSize);
                TextGenerator.getInstance().getTextGeneratorCommand().getTextInstance().setFontSize(Integer.parseInt(fontSize));
                player.sendMessage(ChatColor.GREEN + "Succesfully changed your default font size to " + fontSize);
                player.closeInventory();
            }

    }

}
