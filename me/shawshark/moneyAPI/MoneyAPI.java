package me.shawshark.moneyAPI;

import java.io.PrintStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MoneyAPI extends JavaPlugin {
	
	public static FileConfiguration config = null;
	public static Plugin plugin = null;
	public static PrintStream s;
	
	
	public void onEnable() {
		try {
			config = getConfig();
			plugin = this;
			s = System.out;
			
			s.println("MoneyAPI Has been enabled!");
			
		} catch(Exception e) {
			/* Failed. */
			e.printStackTrace();
		}
	}
	
	public void onDisable() {
		try {
			saveConfig();
			config = null;
			plugin = null;
			
			s.println("MoneyAPI Has been Disabled!");
			s = null;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
