package com.axevillager.fishonlyfish;

import com.axevillager.fishonlyfish.listeners.FishingHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.ChatColor.YELLOW;
import static org.bukkit.ChatColor.DARK_GREEN;
import static org.bukkit.ChatColor.RED;

/**
 * Main created by Axe_Villager on 2018/05/20.
 */

public class Main extends JavaPlugin {

    private final String pluginName = this.toString();
    private final ConsoleCommandSender console = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        console.sendMessage(YELLOW + pluginName + " is loading...");
        registerListeners();
        console.sendMessage(DARK_GREEN + pluginName + " has been enabled.");
    }

    @Override
    public void onDisable() {
        console.sendMessage(YELLOW + pluginName + " is disabling...");
        console.sendMessage(RED + pluginName + " has been disabled.");
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new FishingHandler(), this);
    }
}
