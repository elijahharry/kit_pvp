package me.elijah.kits;

import me.elijah.Main;
import me.elijah.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Juggernaut implements CommandExecutor {
	
	private Main plugin;
	public Juggernaut(Main plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){;
		sender.sendMessage(ChatColor.RED +"You must be a player to do this!");
		return true;
	}
		Player p = (Player)sender;
			if(plugin.used.contains(p.getName())){
				p.sendMessage(ChatColor.RED + "You have already selected a kit.");
			} else {
				if(!p.hasPermission("kit.juggernaut")) {
					p.sendMessage(ChatColor.RED + "Purchase access to this kit at " + ChatColor.WHITE + "our store!");
			} else {
				if(p.hasPermission("kit.juggernaut")) {
					plugin.used.add(p.getName());
		p.sendMessage(ChatColor.WHITE + "You have selected the " + ChatColor.AQUA + "juggernaut" + ChatColor.WHITE + " kit!");
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2147483647, 2));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 2147483647, 1));		
		p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2147483647, 1));		
		PlayerInventory inv = p.getInventory();
		Utils.clearInv(p);
		ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
		pvp.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		inv.addItem(pvp);
		inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
		Utils.giveSoup(p);
		p.setMaxHealth(40);
		p.setHealth(40);
				}
			}
			}
			return false;
	}
}
		
