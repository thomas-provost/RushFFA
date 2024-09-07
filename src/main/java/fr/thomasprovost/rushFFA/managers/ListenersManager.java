package fr.thomasprovost.rushFFA.managers;

import fr.thomasprovost.rushFFA.RushFFA;
import fr.thomasprovost.rushFFA.listeners.GameEvents;
import fr.thomasprovost.rushFFA.listeners.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    private PluginManager pluginManager;
    private RushFFA main;

    public ListenersManager(RushFFA main) {
        this.main = main;
        pluginManager = Bukkit.getPluginManager();
    }

    public void initListeners(){
        pluginManager.registerEvents(new PlayerEvents(), main);
        pluginManager.registerEvents(new GameEvents(), main);
    }
}
