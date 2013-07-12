package me.misfitcraft.mclans;

import java.util.HashMap;

public class MClan{
	private String name;
	private HashMap<String, String> membersandranks;
	public MClan(String name, HashMap<String, String> membersandranks){
		this.membersandranks = membersandranks;
		this.name = name;
	}
}
