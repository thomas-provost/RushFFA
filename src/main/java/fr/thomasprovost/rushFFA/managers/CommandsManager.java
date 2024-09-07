package fr.thomasprovost.rushFFA.managers;

import fr.thomasprovost.rushFFA.RushFFA;
import fr.thomasprovost.rushFFA.commands.RushFFACommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class CommandsManager {

    private RushFFA main;

    public CommandsManager(RushFFA main) {
        this.main = main;
    }

    public void initCommand(){
        main.getCommand("rushffa").setExecutor(new RushFFACommand());
    }
}
