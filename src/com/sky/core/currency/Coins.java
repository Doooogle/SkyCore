package com.sky.core.currency;

import java.util.HashMap;

import org.bukkit.Bukkit;

public class Coins {
	
	private static HashMap<String, Integer> coins = new HashMap<String, Integer>();

	
	public static HashMap<String, Integer> getCoinsHashmap() {
		return coins;
	}

	
	public static int getCoins(String player) {
		return (coins.containsKey(player) ? coins.get(player) : -1);
	}

	
	public static void setCoins(String player, int amount) {
		coins.put(player, amount);
		Bukkit.getLogger().info(player + " had their coins set to " + Integer.valueOf(amount));

	}

	public static void addCoins(String player, int amount) {
		if (coins.containsKey(player)){
			coins.put(player, coins.get(player) + amount);
			Bukkit.getLogger().info(player + " had " + Integer.valueOf(amount) + " coins added to their account.");
		}		
	}

	
	public static boolean minusCoins(String player, int amount) {
		  int has = coins.get(player);
		  
		  if((has - amount) < 0) return false;			 
		  coins.put(player, has - amount);
		  Bukkit.getLogger().info(player + " had " + Integer.valueOf(amount) + " coins minused from their account.");
		  return true;  
		} 
}
