package me.ilgroggo.homeplugin.commands;

import me.ilgroggo.homeplugin.HomePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private final HomePlugin plugin;

    public SetHomeCommand(HomePlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){

            Player p = (Player) commandSender;

            Location location = p.getLocation();

            if(strings.length == 0){

                plugin.getConfig().set("home home", location);
                plugin.saveConfig();
                p.sendMessage(ChatColor.GREEN + "Home location set successfully.");


            }else if(strings.length == 1) {

                plugin.getConfig().set("home " + strings[0], location);
                plugin.saveConfig();
                p.sendMessage(ChatColor.GREEN + "Home " + strings[0] + " location set successfully.");

            }if(strings.length > 1){

                p.sendMessage(ChatColor.RED + "Please use only 1 argument to set this home's name.");
                plugin.saveConfig();
                p.sendMessage(ChatColor.RED + "Please try again.");

            }



        }


        return true;
    }
}
