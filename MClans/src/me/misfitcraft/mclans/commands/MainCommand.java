package me.misfitcraft.mclans.commands;

import java.io.IOException;

import me.misfitcraft.mclans.utils.ClanCreation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.*;

public class MainCommand implements CommandExecutor{
	
	ClanCreation ccinst;
	
	public MainCommand(ClanCreation ccinst){
		this.ccinst = ccinst;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(label.equalsIgnoreCase("mclans") || label.equalsIgnoreCase("c")){
			if(args.length == 0){
				displayHelp(sender);
			}else if(args.length == 2){
				if(args[0].equalsIgnoreCase("create")){
					if(sender instanceof Player){
						try {
							ccinst.createClan((Player)sender, args[1]);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						sender.sendMessage(DARK_RED + "Only players can create clans!");
					}
				}
			}
		}
		return false;
	}

	private void displayHelp(CommandSender sender){
		ChatColor green = GREEN;
		ChatColor aqua = AQUA;
		ChatColor red = RED;
		//TODO write out all of the possible arguments ther will be and format them in some fancy colors
		sender.sendMessage(green + "Acceptable arguments are:");
		sender.sendMessage(aqua + "Create" + red + ":" + green + "Creates a new clan");
	}
	
}
