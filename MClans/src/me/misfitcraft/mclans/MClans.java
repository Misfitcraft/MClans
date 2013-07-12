package me.misfitcraft.mclans;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class MClans extends JavaPlugin {
	public File clansfile;
	public String[] clans;
	
	@Override
	public void onEnable() {
		checkFiles();
		loadClans();
	}

	private void loadClans() {
		//TODO either have the files with no extension or add functionality to .remove() the extensions
		clans = clansfile.list();
		//TODO add functionality to load clans from probably a text file in the clans folder
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
