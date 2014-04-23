package me.shawshark.moneyAPI;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class API {
	
	public static Boolean hasAccount(Player player) {
		FileConfiguration c = MoneyAPI.config;
		
		String UUID = player.getUniqueId().toString().replace("-", "");
		
		if(c.getString("server.money." + UUID) != null) {
			return true;
		}
		
		return false;
	}
	
	public static int getMoney(Player player) {
		FileConfiguration c = MoneyAPI.config;
		
		String UUID = player.getUniqueId().toString().replace("-", "");
		
		if(hasAccount(player)) {
			return c.getInt("server.money." + UUID);
		} else {
			createAccount(player);
			return 0;
		}
	}
	
	public static void setMoney(Player player, int set) {
        
		FileConfiguration c = MoneyAPI.config;
		
		String UUID = player.getUniqueId().toString().replace("-", "");
		
		int add = 0;
		
		if(hasAccount(player)) {
			int currentMoney = getMoney(player);
			
			int prepare = currentMoney + set;
			
			if(prepare >= 0) {
				add = currentMoney + set;
			}
			c.set("server.money." + UUID, add);
		}
	}
	
	public static void takeMoney(Player player, int take) {
		FileConfiguration c = MoneyAPI.config;
		
		String UUID = player.getUniqueId().toString().replace("-", "");
		
		int add = 0;
		
		
		
		if(hasAccount(player)) {
			int currentMoney = getMoney(player);
			
			if(currentMoney - take > 0) {
				add = currentMoney - take;
			}
			
			c.set("server.money." + UUID, add);
		}
	}
	
	public static void createAccount(Player player) {
		
		if(!hasAccount(player)) {
			setMoney(player, 0);
		}
	}
}
