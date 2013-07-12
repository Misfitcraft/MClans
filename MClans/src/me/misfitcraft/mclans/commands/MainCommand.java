package me.misfitcraft.mclans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(label.equalsIgnoreCase("mclans")){
			if(args.length == 0){
				displayHelp(sender);
			}else{
				
			}
		}
		return false;
	}

	private void displayHelp(CommandSender sender){
		//todo write out all of the possible arguments ther will be and format them in some fancy colors
	}
	
}
