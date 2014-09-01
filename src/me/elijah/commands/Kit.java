package me.elijah.commands;

import java.util.HashMap;

import me.elijah.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kit implements CommandExecutor{
	
	private Main plugin;
	public Kit(Main plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){;
			sender.sendMessage(ChatColor.RED +"You must be a player to do this!");
			return true;
		}
		Player p = (Player)sender;
		if(label.equalsIgnoreCase("kit")){
			p.sendMessage(ChatColor.AQUA + "Type " + ChatColor.WHITE + "/kits" + ChatColor.AQUA + " to view all the kits!");
			p.sendMessage(ChatColor.AQUA + " ");
            p.sendMessage(ChatColor.AQUA + "To select a kit, type " + ChatColor.WHITE + "/(kitname)" + ChatColor.AQUA + "!");
		}
		return false;
	}
}
