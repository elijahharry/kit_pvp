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

public class Poseidon implements CommandExecutor {
	
	private Main plugin;
	public Poseidon(Main plugin){
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
				if(!p.hasPermission("kit.poseidon")) {
					p.sendMessage(ChatColor.RED + "Purchase access to this kit at " + ChatColor.WHITE + "our store!");
			} else {
				if(p.hasPermission("kit.poseidon")) {
					plugin.used.add(p.getName());
					plugin.poseidon.add(p.getName());
		p.sendMessage(ChatColor.WHITE + "You have selected the " + ChatColor.AQUA + "poseidon" + ChatColor.WHITE + " kit!");
		PlayerInventory inv = p.getInventory();
		Utils.clearInv(p);
		ItemStack pvp = new ItemStack(Material.IRON_SWORD);
		pvp.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		inv.addItem(pvp);
		inv.setHelmet(new ItemStack(Material.LEATHER_HELMET));
		inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
		Utils.giveSoup(p);
		p.setMaxHealth(20);
		p.setHealth(20);
				}
			}
			}
			return false;
	}
}
		
