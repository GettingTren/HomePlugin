package me.ilgroggo.homeplugin.commands;

import me.ilgroggo.homeplugin.HomePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private final HomePlugin plugin;

    public HomeCommand(HomePlugin plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){

            Player p = (Player) commandSender;

            if(strings.length == 0){

                Location location = plugin.getConfig().getLocation("home home");

                if(location != null){

                    p.teleport(location);
                    p.sendMessage(ChatColor.GREEN + "Teleported Successfully to Home.");

                }

            }else if(strings.length == 1){

                Location location = plugin.getConfig().getLocation("home " + strings[0]);

                if(location != null){

                    p.teleport(location);
                    p.sendMessage(ChatColor.GREEN + "Teleported Successfully to " + strings[0]);

                }

            }if(strings.length > 1){

                p.sendMessage(ChatColor.RED + "Please use only 1 argument after this command.");
                p.sendMessage(ChatColor.RED + "Example: /home <home name>");

            }

        }


        return true;
    }
}
