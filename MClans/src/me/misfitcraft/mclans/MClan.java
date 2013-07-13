package me.misfitcraft.mclans;

import java.util.ArrayList;
import java.util.HashMap;

import me.misfitcraft.mclans.land.MChunk;

public class MClan{
	private String name;
	private HashMap<String, String> membersandranks;
	private ArrayList<MChunk> chunks;
	public MClan(String name, HashMap<String, String> membersandranks){
		this.setMembersandranks(membersandranks);
		this.setName(name);
		chunks = new ArrayList<MChunk>();
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
	public ArrayList<MChunk> getChunks() {
		return chunks;
	}
	/**
	 * @param chunks the chunks to set
	 */
	public void setChunks(ArrayList<MChunk> chunks) {
		this.chunks = chunks;
	}
	public boolean canBreakBlock(String name) {
		if(membersandranks.containsKey(name)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void addChunk(MChunk c){
		chunks.add(c);
	}
}
