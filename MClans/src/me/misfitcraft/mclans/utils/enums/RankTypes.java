package me.misfitcraft.mclans.utils.enums;

public enum RankTypes{
	owner("disband,kick,invite,claim,unclaim"),
	moderator("kick,invite"),
	member(""),
	admin("kick,invite,claim,unclaim"),
	knight("invite");
	
	private String permissions;
	
	private RankTypes(String permissions){
		this.permissions = permissions;
	}
	
	public String getPermissions(){
		return permissions;
	}
}
