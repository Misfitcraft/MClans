package me.misfitcraft.mclans.land;

import me.misfitcraft.mclans.MClan;
import me.misfitcraft.mclans.utils.enums.ChunkType;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

public class MChunk implements Chunk{
	private int x;
	private int z;
	private ChunkType ChunkType;
	private World world;
	private MClan ownedbyclan;
	public MChunk(int x, int z, ChunkType ChunkType, World world){
		this.x = x;
		this.z = z;
		this.ChunkType = ChunkType;
		this.world = world;
		if(ChunkType.equals(me.misfitcraft.mclans.utils.enums.ChunkType.FARMLAND)){
			
		}
	}
	@Override
	public int getX(){
		return x;
	}
	@Override
	public int getZ(){
		return z;
	}
	@Override
	public World getWorld(){
		return world;
	}
	@Override
	public Block getBlock(int x, int y, int z){
		return world.getChunkAt(x, z).getBlock(x, y, z);
	}
	@Override
	public ChunkSnapshot getChunkSnapshot(){
		return world.getChunkAt(x, z).getChunkSnapshot();
	}
	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain){
		return world.getChunkAt(x, z).getChunkSnapshot(includeMaxblocky, includeBiome, includeBiomeTempRain);
	}
	@Override
	public Entity[] getEntities(){
		return world.getChunkAt(x, z).getEntities();
	}
	@Override
	public BlockState[] getTileEntities(){
		return world.getChunkAt(x, z).getTileEntities();
	}
	@Override
	public boolean isLoaded(){
		return world.getChunkAt(x, z).isLoaded();
	}
	@Override
	public boolean load(boolean generate){
		return world.getChunkAt(x, z).load(generate);
	}
	@Override
	public boolean load(){
		return world.getChunkAt(x, z).load();
	}
	@Override
	public boolean unload(boolean save, boolean safe){
		return world.getChunkAt(x, z).unload(save, safe);
	}
	@Override
	public boolean unload(boolean save){
		return world.getChunkAt(x, z).unload(save);
	}
	@Override
	public boolean unload(){
		return world.getChunkAt(x, z).unload();
	}
	/**
	 * @return the ownedbyclan
	 */
	public MClan getClan() {
		return ownedbyclan;
	}
	/**
	 * @param ownedbyclan the ownedbyclan to set
	 */
	public void setClan(MClan ownedbyclan) {
		this.ownedbyclan = ownedbyclan;
	}
	public ChunkType getChunkType(){
		return ChunkType;
	}
}
