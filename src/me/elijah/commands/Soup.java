package me.elijah.commands;

import me.elijah.Main;
import me.elijah.Utils;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class Soup implements CommandExecutor {
	
	private Main plugin;
	public Soup(Main plugin){
		this.plugin = plugin;
	}

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    final Player p = (Player)sender;

    if ((commandLabel.equalsIgnoreCase("soup")) && 
      (p.hasPermission("kit.soup"))) {
      p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 10));
      p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 10));
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 10));
      Utils.giveSoup(p);
      p.sendMessage("§bYou received soup!");
    }else{
        if ((commandLabel.equalsIgnoreCase("soup")) && 
        	      (!p.hasPermission("kit.soup"))) {
            p.sendMessage("§cYou need a rank to do this!");
        }
    }
	return false;
  }
}