package me.misfitcraft.mclans;

import java.util.HashMap;

import me.misfitcraft.mclans.land.MChunk;

public class MClan{
	private String name;
	private HashMap<String, String> membersandranks;
	private MChunk[] chunks;
	public MClan(String name, HashMap<String, String> membersandranks){
		this.setMembersandranks(membersandranks);
		this.name = name;
	}
	/**
	 * @return the membersandranks
	 */
	public HashMap<String, String> getMembersandranks() {
		return membersandranks;
	}
	/**
	 * @param membersandranks the membersandranks to set
	 */
	public void setMembersandranks(HashMap<String, String> membersandranks) {
		this.membersandranks = membersandranks;
	}
	/**
	 * @return the chunks
	 */
	public MChunk[] getChunks() {
		return chunks;
	}
	/**
	 * @param chunks the chunks to set
	 */
	public void setChunks(MChunk[] chunks) {
		this.chunks = chunks;
	}
	public boolean canBreakBlock(String name) {
		if(membersandranks.containsKey(name)){
			return true;
		}else{
			return false;
		}
	}
}
