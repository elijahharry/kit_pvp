package me.elijah.commands;

import java.util.HashMap;

import me.elijah.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor{
	
	private Main plugin;
	public Commands(Main plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){;
			sender.sendMessage(ChatColor.RED +"You must be a player to do this!");
			return true;
		}
		Player p = (Player)sender;
		if(label.equalsIgnoreCase("me")){
			p.sendMessage(ChatColor.AQUA + "Yes, you are you! Have a cookie!");
			p.getInventory().addItem(new ItemStack(Material.COOKIE));
		}
		return false;
	}
}
