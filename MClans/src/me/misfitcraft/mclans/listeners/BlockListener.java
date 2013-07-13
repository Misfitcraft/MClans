package me.misfitcraft.mclans.listeners;

import me.misfitcraft.mclans.MClan;
import me.misfitcraft.mclans.MClans;
import me.misfitcraft.mclans.land.MChunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {
	MClans instance;
	public BlockListener(MClans instance){
		this.instance = instance;
	}
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e){
		for(MClan m : instance.clans){
			for(MChunk c : m.getChunks()){
				if(e.getBlock().getChunk().getX() == c.getX() && e.getBlock().getChunk().getZ() == c.getZ()){
					if(!c.getClan().canBreakBlock(e.getPlayer().getName())){
						e.setCancelled(true);
					}
				}
			}
		}
	}
}
