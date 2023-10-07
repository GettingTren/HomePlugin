package me.ilgroggo.homeplugin;

import me.ilgroggo.homeplugin.commands.HomeCommand;
import me.ilgroggo.homeplugin.commands.SetHomeCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomePlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        // config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // register the sethome command
        getCommand("sethome").setExecutor(new SetHomeCommand(this));
        getCommand("home").setExecutor(new HomeCommand(this));

    }
}
