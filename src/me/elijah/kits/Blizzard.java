package me.elijah.kits;

import java.util.ArrayList;
import java.util.List;

import me.elijah.Main;
import me.elijah.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Blizzard implements CommandExecutor {
	
	private Main plugin;
	public Blizzard(Main plugin){
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
				if(!p.hasPermission("kit.blizzard")) {
					p.sendMessage(ChatColor.RED + "Purchase access to this kit at " + ChatColor.WHITE + "our store!");
			} else {
				if(p.hasPermission("kit.blizzard")) {
					plugin.used.add(p.getName());
					plugin.blizzard.add(p.getName());
		p.sendMessage(ChatColor.WHITE + "You have selected the " + ChatColor.AQUA + "blizzard" + ChatColor.WHITE + " kit!");
		Utils.clearInv(p);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 1));
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta he = (LeatherArmorMeta) helmet.getItemMeta();
		he.setColor(Color.WHITE);
		helmet.setItemMeta(he);
		ItemStack l = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta lc = (LeatherArmorMeta) l.getItemMeta();
		lc.setColor(Color.WHITE);
		l.setItemMeta(lc);
		ItemStack b = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bc = (LeatherArmorMeta) b.getItemMeta();
		bc.setColor(Color.WHITE);
		b.setItemMeta(bc);
		ItemStack c = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta cc = (LeatherArmorMeta) c.getItemMeta();
		cc.setColor(Color.WHITE);
		c.setItemMeta(cc);
		p.getInventory().setHelmet(helmet);
		p.getInventory().setChestplate(c);
		p.getInventory().setLeggings(l);
		p.getInventory().setBoots(b);
		
		ItemStack pvp = new ItemStack(Material.IRON_SWORD);
		pvp.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		p.getInventory().addItem(pvp);
		ItemStack item = new ItemStack(Material.SNOW_BALL, 16);
		ItemMeta im1 = item.getItemMeta();
		im1.setDisplayName(ChatColor.WHITE + "Snow Spheres");
		List<String> loreList = new ArrayList<String>();
		loreList.add(ChatColor.WHITE + "Throw at your enemies to");
		loreList.add(ChatColor.WHITE + "freeze them in place!");
		im1.setLore(loreList);
		item.setItemMeta(im1);
		p.getInventory().addItem(item);
		Utils.giveSoup(p);
		p.setMaxHealth(20);
		p.setHealth(20);
				}
			}
			}
			return false;
	}
}
		