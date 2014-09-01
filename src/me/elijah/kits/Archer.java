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

public class Archer implements CommandExecutor {
	
	private Main plugin;
	public Archer(Main plugin){
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
				if(!p.hasPermission("kit.archer")) {
					p.sendMessage(ChatColor.RED + "Purchase access to this kit at " + ChatColor.WHITE + "our store!");
			} else {
				if(p.hasPermission("kit.archer")) {
					plugin.used.add(p.getName());
		p.sendMessage(ChatColor.WHITE + "You have selected the " + ChatColor.AQUA + "archer" + ChatColor.WHITE + " kit!");
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 0));
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2147483647, 0));
		PlayerInventory inv = p.getInventory();
		Utils.clearInv(p);
		ItemStack pvp = new ItemStack(Material.STONE_SWORD);
		pvp.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		inv.addItem(pvp);
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
		bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
		bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		inv.addItem(bow);
		inv.setHelmet(new ItemStack(Material.LEATHER_HELMET));
		inv.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		inv.setBoots(new ItemStack(Material.LEATHER_BOOTS));
		Utils.giveSoup(p);
		inv.addItem(new ItemStack(Material.ARROW));
		p.setMaxHealth(20);
		p.setHealth(20);
				}
			}
			}
			return false;
	}
}
		
