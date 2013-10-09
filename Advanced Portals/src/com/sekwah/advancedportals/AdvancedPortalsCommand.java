package com.sekwah.advancedportals;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class AdvancedPortalsCommand implements CommandExecutor {
	
	private AdvancedPortalsPlugin plugin;

	public AdvancedPortalsCommand(AdvancedPortalsPlugin plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("advancedportals").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		Player player = (Player)sender;
		ConfigAccessor config = new ConfigAccessor(plugin, "Config.yml");
		if(args.length > 0){
			if(args[0].toLowerCase().equals("wand") || args[0].toLowerCase().equals("selector")){
				if(sender.hasPermission("AdvancedPortals.create")){
					PlayerInventory inventory = player.getInventory();
					
					ItemStack regionselector = new ItemStack(Material.IRON_AXE);
					ItemMeta selectorname = regionselector.getItemMeta();
					selectorname.setDisplayName("�ePortal Region Selector");
					selectorname.setLore(Arrays.asList("�rThis iron axe with has the power to help"
							, "�r create portals bistowed upon it!"));
					regionselector.setItemMeta(selectorname);
					
					inventory.addItem(regionselector);
					sender.sendMessage("�a[�7AdvancedPortals�a] You have been given a �ePortal Region Selector�a!");
				}
				else{
					sender.sendMessage("�c[�7AdvancedPortals�c] You do not have permission to create portals so you cannot give yourself a �ePortal Region Selector�c!");
				}
			}
		}
		else{
			sender.sendMessage("�c[�7AdvancedPortals�c] You need to type something after /" + command + "\n"
					+ "if you do not know what you can put or would like some help with the commands please type /" + command + " help");
		}
		
		return true;
	}

}
