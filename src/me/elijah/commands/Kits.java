package me.elijah.commands;

import java.util.HashMap;

import me.elijah.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kits implements CommandExecutor{
	
	private Main plugin;
	public Kits(Main plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){;
			sender.sendMessage(ChatColor.RED +"You must be a player to do this!");
			return true;
		}
		Player p = (Player)sender;
		if(label.equalsIgnoreCase("kits")){
			p.sendMessage("§7§lDefault Kits:");
			p.sendMessage("§7PvP, Archer, Heavy");
			p.sendMessage("§a§lVIP Kits:");
			p.sendMessage("§aSpecialist, Reaper, Berserker, Ninja");
			p.sendMessage("§aPoseidon, Assassin, Phantom, Viper, Snail");
			p.sendMessage("§aBlizzard, Kangaroo, Wizard, Gunner, Blur, Juggernaut");
		}
		return false;
	}
}
