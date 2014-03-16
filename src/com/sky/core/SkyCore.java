package com.sky.core;

import org.bukkit.plugin.java.JavaPlugin;

import com.sky.core.commands.CommandCoins;


public class SkyCore extends JavaPlugin {
	
	private static SkyCore instance;
	
	public void onEnable() {
		
		setInstance(this);
		
		getCommand("coins").setExecutor(new CommandCoins());
		
	}
	
	public void onDisable() {
		
	}
	
	
	public static SkyCore get() {
		return instance;
	}

	private void setInstance(SkyCore inst) {
		instance = inst;
	}
	
	

}
