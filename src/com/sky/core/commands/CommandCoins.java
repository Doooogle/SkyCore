package com.sky.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sky.core.currency.Coins;
import com.sky.core.utils.Strings;

public class CommandCoins implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd,
			String CommandLabel, String[] args) {
		Player p = (Player) sender;

		
		if(args.length == 0){
			p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "You currently have " + ChatColor.GOLD + Coins.getCoins(p.getName()) + ChatColor.DARK_AQUA + " coins.");
		}
		
		else if(args.length == 1){
			if(args[0].equalsIgnoreCase("set")){
				p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Incorrect arguments. " + ChatColor.AQUA + "/coins set <player> <amount>");
			}
			if(args[0].equalsIgnoreCase("add")){
				p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Incorrect arguments. " + ChatColor.AQUA + "/coins add <player> <amount>");
			}
			if(args[0].equalsIgnoreCase("take")){
				p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Incorrect arguments. " + ChatColor.AQUA + "/coins take <player> <amount>");
			}
		}
		
		else if(args.length == 2){
			if(Bukkit.getPlayer(args[1]) !=null){
				Player target = Bukkit.getPlayer(args[1]);
				if(args[0].equalsIgnoreCase("set")){
					p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Incorrect arguments. " + ChatColor.AQUA + "/coins set " + ChatColor.RED + target.getName() + ChatColor.AQUA + " <amount>");
				}
				if(args[0].equalsIgnoreCase("add")){
					p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Incorrect arguments. " + ChatColor.AQUA + "/coins add " + ChatColor.RED + target.getName() + ChatColor.AQUA + " <amount>");
				}
				if(args[0].equalsIgnoreCase("take")){
					p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Incorrect arguments. " + ChatColor.AQUA + "/coins take " + ChatColor.RED + target.getName() + ChatColor.AQUA + " <amount>");
				}
			}
			else if(Bukkit.getPlayer(args[1]) == null){
				p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Player is " + ChatColor.AQUA + "offline.");
			}
		}
		
		else if(args.length == 3){
			if(Bukkit.getPlayer(args[1]) !=null){
				Player target = Bukkit.getPlayer(args[1]);
				if(args[0].equalsIgnoreCase("set")){
					Coins.setCoins(target.getName(), Integer.valueOf(args[2]));
					p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "You have set " + ChatColor.AQUA + target.getName() + "'s" + ChatColor.DARK_AQUA + " coins to " + ChatColor.GOLD + Integer.valueOf(args[2]) + ChatColor.DARK_AQUA + ".");
					return false;
				}
				if(args[0].equalsIgnoreCase("add")){
					Coins.addCoins(target.getName(), Integer.valueOf(args[2]));
					p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "You have added " + ChatColor.GOLD + Integer.valueOf(args[2]) + ChatColor.DARK_AQUA + " coins to " + ChatColor.AQUA + target.getName() + "'s" + ChatColor.DARK_AQUA + " account.");
					return false;
				}
				if(args[0].equalsIgnoreCase("take")){
					if(Coins.minusCoins(p.getName(), Integer.valueOf(args[2])) == false) {
						p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Error: A players coin amount cannot go below 0.");		
						return false;
					}
					Coins.minusCoins(p.getName(), Integer.valueOf(args[2]));
					p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "You have taken " + ChatColor.GOLD + Integer.valueOf(args[2]) + ChatColor.DARK_AQUA + " coins from " + ChatColor.AQUA + target.getName() + "'s" + ChatColor.DARK_AQUA + " account.");
					return false;
				}
				
				else{
					p.sendMessage(Strings.getPrefix() + ChatColor.DARK_AQUA + "Player is " + ChatColor.AQUA + "offline.");
				}
			}
		}
		
		else if(args.length >= 4){
			p.sendMessage(Strings.getArgs());
		}
		
		return false;
	}

}
