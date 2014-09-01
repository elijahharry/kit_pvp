package me.elijah;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.elijah.commands.Commands;
import me.elijah.commands.Kit;
import me.elijah.commands.Kits;
import me.elijah.commands.Refill;
import me.elijah.commands.Soup;
import me.elijah.kits.Archer;
import me.elijah.kits.Assassin;
import me.elijah.kits.Berserker;
import me.elijah.kits.Blizzard;
import me.elijah.kits.Blur;
import me.elijah.kits.Gunner;
import me.elijah.kits.Heavy;
import me.elijah.kits.Juggernaut;
import me.elijah.kits.Kangaroo;
import me.elijah.kits.Ninja;
import me.elijah.kits.Phantom;
import me.elijah.kits.Poseidon;
import me.elijah.kits.PvP;
import me.elijah.kits.Reaper;
import me.elijah.kits.Snail;
import me.elijah.kits.Souper;
import me.elijah.kits.Specialist;
import me.elijah.kits.Viper;
import me.elijah.kits.Wizard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fish;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

public class Main extends JavaPlugin implements Listener {
	
	public List<String> used = new ArrayList<String>();	
	public List<String> poseidon = new ArrayList<String>();	
	public List<String> cooldown = new ArrayList<String>();	
	public List<String> freezed = new ArrayList<String>();
	public List<String> blizzard = new ArrayList<String>();	
	public List<String> specialist = new ArrayList<String>();
	public List<String> nofall = new ArrayList<String>();
	public List<String> assassin = new ArrayList<String>();
	public List<String> kangaroo = new ArrayList<String>();
	public List<String> kanga = new ArrayList<String>();
	public List<String> phantom = new ArrayList<String>();
	public List<String> berserker = new ArrayList<String>();
	public List<String> wizard = new ArrayList<String>();
	public List<String> viper = new ArrayList<String>();
	public List<String> souper = new ArrayList<String>();
	public List<String> wither = new ArrayList<String>();
	public List<String> dwarf = new ArrayList<String>();
	public List<String> snail = new ArrayList<String>();
	public List<String> gunner = new ArrayList<String>();
	public List<String> blur = new ArrayList<String>();
	
	public void onEnable(){
		registerCommands();
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	
	public void registerCommands(){
		getCommand("me").setExecutor(new Commands(this));
		getCommand("soup").setExecutor(new Soup(this));
		getCommand("kit").setExecutor(new Kit(this));	
		getCommand("kits").setExecutor(new Kits(this));			
		getCommand("refill").setExecutor(new Refill(this));
		getCommand("pvp").setExecutor(new PvP(this)); //free
		getCommand("archer").setExecutor(new Archer(this)); //free
		getCommand("heavy").setExecutor(new Heavy(this)); //free
		getCommand("poseidon").setExecutor(new Poseidon(this)); //mvp
		getCommand("blizzard").setExecutor(new Blizzard(this)); //pro
		getCommand("specialist").setExecutor(new Specialist(this)); //vip
		getCommand("ninja").setExecutor(new Ninja(this)); //vip
		getCommand("assassin").setExecutor(new Assassin(this)); //mvp
		getCommand("kangaroo").setExecutor(new Kangaroo(this)); //pro
		getCommand("phantom").setExecutor(new Phantom(this)); //mvp
		getCommand("berserker").setExecutor(new Berserker(this)); //vip
		getCommand("viper").setExecutor(new Viper(this)); //mvp
		getCommand("wizard").setExecutor(new Wizard(this)); //pro
		getCommand("souper").setExecutor(new Souper(this)); //mvp
		getCommand("snail").setExecutor(new Snail(this)); //mvp
		getCommand("reaper").setExecutor(new Reaper(this)); //vip
		getCommand("gunner").setExecutor(new Gunner(this)); //pro
		getCommand("blur").setExecutor(new Blur(this)); //pro
		getCommand("juggernaut").setExecutor(new Juggernaut(this)); //pro		
	}
//Soup Drink
	@EventHandler
    public void SoupAbility (PlayerInteractEvent e) {
        Player p = e.getPlayer();
		if(souper.contains(p.getName())) {
	        if (p.getHealth() == p.getMaxHealth()) return;
	        if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
	            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
	                p.setHealth(p.getHealth() + 9 > p.getMaxHealth() ? p.getMaxHealth() : p.getHealth() + 9);
	                p.getItemInHand().setType(Material.BOWL);
	                return;
	            }
	        }
		} else {
            if (p.getHealth() == p.getMaxHealth()) return;
            if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    p.setHealth(p.getHealth() + 7 > p.getMaxHealth() ? p.getMaxHealth() : p.getHealth() + 7);
                    p.getItemInHand().setType(Material.BOWL);
                    return;
                }
            }
		}
	}
	
	@EventHandler
	public void onDeathRemoveKit(PlayerDeathEvent e) {
		Player p = (Player)e.getEntity();
		if(used.contains(p.getName())){
			used.remove(p.getName());
			poseidon.remove(p.getName());
			cooldown.remove(p.getName());
			blizzard.remove(p.getName());
			freezed.remove(p.getName());
			assassin.remove(p.getName());
			specialist.remove(p.getName());
			wizard.remove(p.getName());
			berserker.remove(p.getName());
			viper.remove(p.getName());
			kangaroo.remove(p.getName());
			kanga.remove(p.getName());
			souper.remove(p.getName());
			phantom.remove(p.getName());
			dwarf.remove(p.getName());
			snail.remove(p.getName());
			wither.remove(p.getName());
			gunner.remove(p.getName());
			blur.remove(p.getName());
		if(used.contains(p.getName())) {
				if(e.getEntity() instanceof Player) {
			e.getDrops().clear();
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
			e.getDrops().add(new ItemStack(Material.MUSHROOM_SOUP));
				}
		}
		}
	}
	   
	@EventHandler
	public void onPoseidonKitAbility(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getLocation().getBlock().isLiquid()) {
			
			if(poseidon.contains(p.getName())) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 0));
			} else {
				if(!p.getLocation().getBlock().isLiquid()) {
					p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.removePotionEffect(PotionEffectType.SPEED);
					p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
					}
				}
		}
		
	}
	
    @EventHandler
    public void onBlockClick22(PlayerInteractEvent event) {
      Player p = event.getPlayer();
      if ((specialist.contains(p.getName())) && 
        ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) && 
        (p.getItemInHand().getType() == Material.BOOK))
        p.openEnchanting(null, true);
    }
    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
    	Player p = event.getEntity().getKiller();
        if (specialist.contains(p.getName())){
          Player killer = event.getEntity().getKiller();
          Player victim = event.getEntity().getPlayer();
          killer.setLevel(killer.getLevel() +2 );
          killer.sendMessage(ChatColor.AQUA + "As a specialist, you have absorbed xp from " + ChatColor.WHITE + victim.getDisplayName() + ChatColor.AQUA +"!");
    } else {
            if (!specialist.contains(p.getName()));
            Player killer = event.getEntity().getKiller();
            killer.setLevel(killer.getLevel() +0 );
        }
    }
	public void onAssassin(PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		
		if(player.getItemInHand().getType() == Material.NETHER_STAR && event.getAction() == Action.RIGHT_CLICK_AIR || player.getItemInHand().getType() == Material.NETHER_STAR && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(cooldown.contains(player.getName())){
				if(assassin.contains(player.getName())) {
				player.sendMessage(ChatColor.RED + "You are on a cooldown!");
				}
			} else {
				if(assassin.contains(player.getName())){
				cooldown.add(player.getName());
				player.getInventory().setArmorContents(null);
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 0));
				player.updateInventory();
				player.sendMessage(ChatColor.GREEN + "You are now in assassin mode!");
				
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

				@Override
				public void run() {
					cooldown.remove(player.getName());
					player.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
					player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					
				}
			
			}, 600);
		  }
		}
	 }
	}
	@EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if(kangaroo.contains(p.getName())) {
        if (p.getItemInHand().getType() == Material.FIREWORK) {
            if (event.getAction() == Action.LEFT_CLICK_AIR
                    || event.getAction() == Action.LEFT_CLICK_BLOCK
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK
                    || event.getAction() == Action.RIGHT_CLICK_AIR)
                event.setCancelled(true);
            if (!kanga.contains(p.getName())) {
                if (!(p.isSneaking())) {
                    p.setFallDistance(-(4F + 1));
                    Vector vector = p.getEyeLocation().getDirection();
                    vector.multiply(0.6F);
                    vector.setY(1.2F);
                    p.setVelocity(vector);
                } else {
                    p.setFallDistance(-(4F + 1));
                    Vector vector = p.getEyeLocation().getDirection();
                    vector.multiply(1.2F);
                    vector.setY(0.8);
                    p.setVelocity(vector);
                }
                kanga.add(p.getName());
            }
        }
       }
    }
	
	@EventHandler
    public void onInteract1(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (dwarf.contains(p.getName())) {
            if (p.isSneaking()) {
    			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20, 1));
            }
        }
	}
 
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (kanga.contains(p.getName())) {
            Block b = p.getLocation().getBlock();
            if (b.getType() != Material.AIR
                    || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                kanga.remove(p.getName());
            }
 
        }
    }
 
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
    	Player p = event.getPlayer();
        if (event.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
        	if(kangaroo.contains(p.getName())){
        		event.setCancelled(true);
        }
    }
  }
 
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity e = event.getEntity();
        if (e instanceof Player) {
            Player player = (Player) e;
            if(kangaroo.contains(player.getName())){
            if (event.getEntity() instanceof Player
                    && event.getCause() == DamageCause.FALL
                    && player.getInventory().contains(Material.FIREWORK)) {
                if (event.getDamage() >= 7) {
                    event.setDamage(7);
                }
              }
            }
        }
    }
	@EventHandler
	public void onPhantom(PlayerInteractEvent e) {
		
		final Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() == Material.FEATHER && e.getAction() == Action.RIGHT_CLICK_BLOCK || p.getItemInHand().getType() == Material.FEATHER && e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(phantom.contains(p.getName())) {
			    if(cooldown.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "You can't fly again yet!");
			} else {
				if(phantom.contains(p.getName())) {
					
					cooldown.add(p.getName());
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							cooldown.remove(p.getName());
							
						}
						
					}, 400);
					
					p.setAllowFlight(true);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@Override
						public void run() {
							p.sendMessage(ChatColor.WHITE + "Flight off in: " + ChatColor.RED + "5");
						}
					}, 20);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@Override
						public void run() {
							p.sendMessage(ChatColor.WHITE + "Flight off in: " + ChatColor.RED + "4");
						}
					}, 40);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@Override
					public void run() {
						p.sendMessage(ChatColor.WHITE + "Flight off in: " + ChatColor.RED + "3");
						}
					}, 60);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@Override
						public void run() {
							p.sendMessage(ChatColor.WHITE + "Flight off in: " + ChatColor.RED + "2");
						}
					}, 80);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@Override
						public void run() {
							p.sendMessage(ChatColor.WHITE + "Flight off in: " + ChatColor.RED + "1");
						}
					}, 100);
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

						@Override
						public void run() {
							p.setAllowFlight(false);
							
						}
						
					}, 120);
				}
			}
			}
		}
	}
	@EventHandler
    public void onInteract21(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if(kangaroo.contains(p.getName())) {
        if (p.getItemInHand().getType() == Material.FIREWORK) {
            if (event.getAction() == Action.LEFT_CLICK_AIR
                    || event.getAction() == Action.LEFT_CLICK_BLOCK
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK
                    || event.getAction() == Action.RIGHT_CLICK_AIR)
                event.setCancelled(true);
            if (!kanga.contains(p.getName())) {
                if (!(p.isSneaking())) {
                    p.setFallDistance(-(4F + 1));
                    Vector vector = p.getEyeLocation().getDirection();
                    vector.multiply(0.6F);
                    vector.setY(1.2F);
                    p.setVelocity(vector);
                } else {
                    p.setFallDistance(-(4F + 1));
                    Vector vector = p.getEyeLocation().getDirection();
                    vector.multiply(1.2F);
                    vector.setY(0.8);
                    p.setVelocity(vector);
                }
                kanga.add(p.getName());
            }
        }
       }
    }
 
    @EventHandler
    public void onMove1(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (kanga.contains(p.getName())) {
            Block b = p.getLocation().getBlock();
            if (b.getType() != Material.AIR
                    || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                kanga.remove(p.getName());
            }
 
        }
    }
 
    @EventHandler
    public void onDrop1(PlayerDropItemEvent event) {
    	Player p = event.getPlayer();
        if (event.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
        	if(kangaroo.contains(p.getName())){
        		event.setCancelled(true);
        }
    }
  }
 
    @EventHandler
    public void onDamage1(EntityDamageEvent event) {
        Entity e = event.getEntity();
        if (e instanceof Player) {
            Player player = (Player) e;
            if(kangaroo.contains(player.getName())){
            if (event.getEntity() instanceof Player
                    && event.getCause() == DamageCause.FALL
                    && player.getInventory().contains(Material.FIREWORK)) {
                if (event.getDamage() >= 7) {
                    event.setDamage(7);
                }
              }
            }
        }
    }
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		int chance = 3;
		int length = 5;
		int multiplier = 0;
		LivingEntity entity = (LivingEntity) event.getEntity();
        Player player = (Player) event.getDamager();
		if(viper.contains(player.getName())){
			if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity){
			if(new Random().nextInt(chance) == 1){
				entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, length * 20, multiplier), true);
			}
		} else {
			
		}
		}
	}
	@EventHandler
	public void onHit1(EntityDamageByEntityEvent event) {
		int chance = 3;
		int length = 2;
		int multiplier = 1;
		LivingEntity entity = (LivingEntity) event.getEntity();
        Player player = (Player) event.getDamager();
		if(snail.contains(player.getName())){
			if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity){
			if(new Random().nextInt(chance) == 1){
				entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, length * 20, multiplier), true);
			}
		} else {
			
		}
		}
		
	}
	@EventHandler
	public void onHit2(EntityDamageByEntityEvent event) {
		int chance = 3;
		int length = 4;
		int multiplier = 0;
		LivingEntity entity = (LivingEntity) event.getEntity();
        Player player = (Player) event.getDamager();
		if(wither.contains(player.getName())){
			if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity){
			if(new Random().nextInt(chance) == 1){
				entity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, length * 20, multiplier), true);
			}
		} else {
			
		}
		}
		
	}
	
	@EventHandler
	public void onKill(EntityDeathEvent event) {
		Player player = (Player) event.getEntity().getKiller();
		if(berserker.contains(player.getName())){
			player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 400, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 1));
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onStick(PlayerInteractEvent e) {
		
		final Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() == Material.STICK && e.getAction() == Action.RIGHT_CLICK_BLOCK || p.getItemInHand().getType() == Material.STICK && e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(cooldown.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "You have to wait for your wand to charge!");
			} else {
				if(wizard.contains(p.getName())) {
				    p.throwEgg();
				    cooldown.add(p.getName());
				    
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							cooldown.remove(p.getName());
							
						}
						
					}, 200);
			}
		}
		}
	}
	@EventHandler
	public void onEgg(ProjectileHitEvent event){
		Entity e = event.getEntity();
		if(e instanceof Egg){
			Player g = (Player) ((Egg) e).getShooter();
			if(wizard.contains(g.getName())){
				Location loc = e.getLocation();
				loc.getWorld().strikeLightning(loc);
				loc.getWorld().strikeLightning(loc);
				loc.getWorld().strikeLightning(loc);
				loc.getWorld().strikeLightning(loc);
				loc.getWorld().strikeLightning(loc);
			}
		}
	} 
	@EventHandler
	public void onArrow(PlayerInteractEvent e) {
		
		final Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() == Material.DISPENSER && e.getAction() == Action.RIGHT_CLICK_BLOCK || p.getItemInHand().getType() == Material.DISPENSER && e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(cooldown.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "You have to wait for your gun to cool off!");
			} else {
				if(gunner.contains(p.getName())) {
					
					cooldown.add(p.getName());
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							cooldown.remove(p.getName());
							
						}
						
					}, 100);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 1);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 3);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@SuppressWarnings("deprecation")
						@Override
					public void run() {
							p.shootArrow();
						}
					}, 5);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 7);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 9);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 11);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 13);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 15);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 17);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 19);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 21);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 23);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 25);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 27);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@SuppressWarnings("deprecation")
						@Override
						public void run() {
							p.shootArrow();
						}
					}, 29);
			  }
			}
		}
	}
	@EventHandler
	public void onBlur(PlayerInteractEvent e) {
		
		final Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() == Material.FEATHER && e.getAction() == Action.RIGHT_CLICK_BLOCK || p.getItemInHand().getType() == Material.FEATHER && e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(cooldown.contains(p.getName())) {
				
			} else {
				if(blur.contains(p.getName())) {
					
					cooldown.add(p.getName());
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							cooldown.remove(p.getName());
							
						}
						
					}, 700);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@Override
						public void run() {
							p.sendMessage(ChatColor.AQUA + "Achieving super speed!");
							p.removePotionEffect(PotionEffectType.SPEED);
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 2));
						}
					}, 0);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						
						@Override
						public void run() {
							p.sendMessage(ChatColor.AQUA + "Gaining energy...");
							p.removePotionEffect(PotionEffectType.SPEED);
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 3));
						}
					}, 100);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@Override
					public void run() {
						p.sendMessage(ChatColor.AQUA + "Almost there...");
						p.removePotionEffect(PotionEffectType.SPEED);
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 10));
						}
					}, 200);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	
						@Override
						public void run() {
							p.sendMessage(ChatColor.AQUA + "You are now running at super speed!");
							p.removePotionEffect(PotionEffectType.SPEED);
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 50));
							Location loc = p.getLocation();
							loc.getWorld().strikeLightning(loc);
						}
						
						
					}, 300);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

						@Override
						public void run() {
							p.sendMessage(ChatColor.AQUA + "Slowing down!");
							p.removePotionEffect(PotionEffectType.SPEED);
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 1));
							}
					}, 500);
				}
			}
		}
	}
}


					
