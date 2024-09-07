package fr.thomasprovost.rushFFA.listeners;

import fr.thomasprovost.rushFFA.RushFFA;
import fr.thomasprovost.rushFFA.utils.Locations;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GameEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Location spawn = new Location(Bukkit.getWorlds().get(0), 0, 100, 0);
        if(RushFFA.getInstance().getConfig().getString("spawn") != null){
            spawn = Locations.parseStringToLoc(RushFFA.getInstance().getConfig().getString("spawn"));
        }
        player.teleport(spawn);
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
        for(String message : RushFFA.getInstance().getConfig().getStringList("messages.french.join-message")){
            player.sendMessage(message);
        }
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.getInventory().clear();
    }
}
