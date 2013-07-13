package me.misfitcraft.mclans.economy;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import me.misfitcraft.mclans.MClans;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

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
	 /**
	  * Takes an amount of money from a defined player
	  * @author tommycake50
	  * @param player
	  * @param amount
	  * @return boolean whether the withdrawl was successful 
	  */
	 public boolean takeMoneyPlayer(Player p, double amount){
		 if(econ.hasAccount(p.getName())){
			 EconomyResponse balance = econ.bankBalance(p.getName());
		 	if(balance.balance > amount){
		 		econ.withdrawPlayer(p.getName(), amount);
		 		return true;
		 	}else{
		 		return false;
		 	}
	 	}else{
	 		return false;
	 	}
	 }
}
