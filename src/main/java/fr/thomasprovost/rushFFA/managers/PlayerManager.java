package fr.thomasprovost.rushFFA.managers;

import fr.thomasprovost.rushFFA.RushFFA;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerManager {

    FileConfiguration config = RushFFA.getInstance().getConfig();

    public void createAccount(Player player){
        if(config.get("player-datas." + player.getUniqueId()) == null){
            config.set("player-datas." + player.getUniqueId() + ".kills", 0);
            config.set("player-datas." + player.getUniqueId() + ".deaths", 0);
            config.set("player-datas." + player.getUniqueId() + ".kd", "0.0");
            config.set("player-datas." + player.getUniqueId() + ".inventory", new ArrayList<>());
            RushFFA.getInstance().saveConfig();
        }
    }

    public void saveInventory(Player player){
        List<ItemStack> items = new ArrayList<>(Arrays.asList(player.getInventory().getContents()));
        config.set("player-datas." + player.getUniqueId() + ".inventory", items);
        RushFFA.getInstance().saveConfig();
    }

    public void loadInventory(Player player){
        List<ItemStack> items = (List<ItemStack>) config.get("player-datas." + player.getUniqueId() + ".inventory");
        player.getInventory().clear();
        for(ItemStack item : items){
            player.getInventory().addItem(item);
        }
    }



}
