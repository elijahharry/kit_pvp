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
import org.bukkit.inventory.meta.ItemMeta;

public class Specialist implements CommandExecutor {
	
	private Main plugin;
	public Specialist(Main plugin){
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
				if(!p.hasPermission("kit.specialist")) {
					p.sendMessage(ChatColor.RED + "Purchase access to this kit at " + ChatColor.WHITE + "our store!");
			} else {
				if(p.hasPermission("kit.specialist")) {
					plugin.used.add(p.getName());
					plugin.specialist.add(p.getName());
		p.sendMessage(ChatColor.WHITE + "You have selected the " + ChatColor.AQUA + "specialist" + ChatColor.WHITE + " kit!");
		PlayerInventory inv = p.getInventory();
		Utils.clearInv(p);
		ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
		inv.addItem(pvp);
		ItemStack book = new ItemStack(Material.BOOK);
		ItemMeta im = book.getItemMeta();
		im.setDisplayName(ChatColor.WHITE + "Portable Enchantment Table");
		book.setItemMeta(im);
		inv.addItem(book);
		inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		inv.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
		inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		inv.setBoots(new ItemStack(Material.GOLD_BOOTS));
		Utils.giveSoup(p);
		p.setMaxHealth(20);
		p.setHealth(20);
				}
			}
			}
			return false;
	}
}
		
