package fr.thomasprovost.rushFFA;

import fr.minuskube.inv.InventoryManager;
import fr.thomasprovost.rushFFA.game.GameTask;
import fr.thomasprovost.rushFFA.managers.CommandsManager;
import fr.thomasprovost.rushFFA.managers.ListenersManager;
import fr.thomasprovost.rushFFA.managers.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.Configuration;
import java.io.File;

/*
    * RushFFA is a Minecraft mini-game plugin.
    * This class is the main class of the plugin.
    *
    * @version 1.0
    * @author thomas-provost
    * @since 07/09/2024
 */

public final class RushFFA extends JavaPlugin {

    private static RushFFA instance;
    private static Configuration languagesConfig;
    private static InventoryManager inventoryManager;
    private static ListenersManager listenersManager;
    private static CommandsManager commandsManager;
    private static PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        File languagesFile = new File(getDataFolder(), "languages.yml");
        if (!languagesFile.exists()) {
            saveResource("languages.yml", false);
        }
        getLogger().info("Loading RushFFA plugin by thomas-provost...");

        GameTask gameTask = new GameTask();
        gameTask.runTaskTimer(this, 0, 20);

        listenersManager = new ListenersManager(this);
        listenersManager.initListeners();

        commandsManager = new CommandsManager(this);
        commandsManager.initCommand();

        inventoryManager = new InventoryManager(this);
        inventoryManager.init();

        playerManager = new PlayerManager();
    }

    //--------
    // Getters
    //--------
    public static RushFFA getInstance() {
        return instance;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    //--------
    // Methods
    //--------
    public void reloadPlugin() {
        reloadConfig();
    }

    public static InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public Configuration getLanguagesConfig() {
        return languagesConfig;
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling RushFFA plugin by thomas-provost...");
    }
}
