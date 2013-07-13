package me.misfitcraft.mclans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import me.misfitcraft.mclans.commands.MainCommand;
import me.misfitcraft.mclans.land.MChunk;
import me.misfitcraft.mclans.land.Type;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MClans extends JavaPlugin{
	public File clansfile;
	public MClan[] clans;
	private File chunkfile;
	
	@Override
	public void onEnable(){
		try {
			checkFiles();
			loadClans();
			loadChunks();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getCommand("MClans").setExecutor(new MainCommand());
	}

	private void loadChunks() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(chunkfile));
		String currline;
		while((currline = br.readLine()) != null){
			String[] splitdata = currline.split(",");
			for(MClan c : clans){
				if(splitdata[0].equals(c.getName())){
					c.addChunk(new MChunk(Integer.parseInt(splitdata[1]), Integer.parseInt(splitdata[2]), Type.valueOf(splitdata[3]), getServer().getWorld(splitdata[4])));
				}
			}
		}
		br.close();
	}

	/**
	 * loads all the clans from files in the file folder for clans
	 * @author tommycake50
	 * @throws IOException
	 */
	private void loadClans() throws IOException{
		//TODO either have the files with no extension or add functionality to .remove() the extensions
		int i = 0;
		for(File f : clansfile.listFiles()){
			HashMap<String, String> membersandranks = new HashMap<String, String>();
			BufferedReader br = new BufferedReader(new FileReader(f));
			String currline;
			while((currline = br.readLine()) != null){
				String[] values = currline.split(",");
				membersandranks.put(values[0], values[1]);
			}
			br.close();
			clans[i] = new MClan(f.getName(), membersandranks);
			i++;
		}
		//TODO add functionality to load clans from probably a text file in the clans folder
	}

	private void checkFiles() throws IOException{
		//we are gonna have a config at some point
		saveDefaultConfig();
		clansfile = new File(getDataFolder(), "Clans");
		if(!clansfile.exists()){
			clansfile.mkdir();
		}
		chunkfile = new File(getDataFolder(), "chunks.txt");
		if(!chunkfile.exists()){
			chunkfile.createNewFile();
		}
	}
}
