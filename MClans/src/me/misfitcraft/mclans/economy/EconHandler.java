package me.misfitcraft.mclans.economy;

import org.bukkit.plugin.RegisteredServiceProvider;

import me.misfitcraft.mclans.MClans;
import net.milkbowl.vault.economy.Economy;

public class EconHandler{
	Economy econ;
	MClans MClansInstance;
	public EconHandler(MClans instance){
		MClansInstance = instance;
		setupEconomy();
	}
	//taken off the Vault bukkitdev page.
	 private boolean setupEconomy(){
	        RegisteredServiceProvider<Economy> economyProvider = MClansInstance.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null){
	            econ = economyProvider.getProvider();
	        }
	        return (econ != null);
	    }
}
