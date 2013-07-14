package me.misfitcraft.mclans.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import me.misfitcraft.mclans.MClan;
import me.misfitcraft.mclans.MClans;
import me.misfitcraft.mclans.economy.EconHandler;

import org.bukkit.entity.Player;

public class ClanCreation{
	
	MClans instance;
	EconHandler econInstance;
	
	public ClanCreation(MClans instance, EconHandler econInstance){
		this.instance = instance;
		this.econInstance = econInstance;
	}
	/**
	 * creates a new clan
	 * @author tommycake50
	 * @param owner
	 * @param clanName
	 * @throws IOException 
	 */
	public void createClan(Player owner, String clanName) throws IOException{
		if(econInstance.takeMoneyPlayer(owner, instance.config.getDouble("clancost"))){
			File file = new File(instance.clansfile, "clanName");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.append(owner.getName()+",owner");
			bw.close();
			HashMap<String, String> hash = new HashMap<String, String>();
			hash.put(owner.getName(), "owner");
			instance.clans.add(new MClan(clanName, hash));
		}
	}
}
