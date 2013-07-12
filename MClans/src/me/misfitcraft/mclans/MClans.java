package me.misfitcraft.mclans;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class MClans extends JavaPlugin {
	public File clansfile;
	
	@Override
	public void onEnable() {
		checkFiles();
	}

	private void checkFiles() {
		//we are gonna have a config at some point
		saveDefaultConfig();
		clansfile = new File(getDataFolder(), "Clans");
		if(!clansfile.exists()){
			clansfile.mkdir();
		}
	}
}
