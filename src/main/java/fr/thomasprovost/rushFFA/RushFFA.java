package fr.thomasprovost.rushFFA;

import org.bukkit.plugin.java.JavaPlugin;

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

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getLogger().info("Loading RushFFA plugin by thomas-provost...");
    }

    //--------
    // Getters
    //--------
    public static RushFFA getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling RushFFA plugin by thomas-provost...");
    }
}
