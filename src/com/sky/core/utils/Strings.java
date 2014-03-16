package com.sky.core.utils;

import org.bukkit.ChatColor;

public class Strings {
	
	private static String prefix = ChatColor.WHITE + "[" + ChatColor.BLUE + "Test" + ChatColor.WHITE + "] ";
	private static String Coins_Error = prefix+  ChatColor.DARK_AQUA + " You do not have enough coins to do this.";
	private static String Args = prefix + ChatColor.DARK_AQUA + "Error: " + ChatColor.AQUA + "Too many arguments.";

	
	public static String getPrefix() {
		return prefix;
	}

	public void setPrefix(String string) {
		string = prefix;
	}

	public static String getCoinsError() {
		return Coins_Error;
	}

	public static void setCoinsError(String coins_Error) {
		Coins_Error = coins_Error;
	}

	public static String getArgs() {
		return Args;
	}

	public static void setArgs(String args) {
		Args = args;
	} 

}
