package me.elijah;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Utils {
	
	private Main plugin;
	public Utils(Main plugin){
		this.plugin = plugin;
	}
	
	public static void clearInv(Player p){
		p.getInventory().clear();
	}
	
	public static void giveSoup(Player p){
		for(int i = 0; i < 33; i++){
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		}
	}

}
