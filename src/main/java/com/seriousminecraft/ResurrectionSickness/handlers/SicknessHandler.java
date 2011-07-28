package com.seriousminecraft.ResurrectionSickness.handlers;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.seriousminecraft.ResurrectionSickness.player.RSPlayer;

public class SicknessHandler {

	private HashMap<Player, RSPlayer> sicknessPlayers;
	
	public SicknessHandler(){
		sicknessPlayers = new HashMap<Player,RSPlayer>();
	}
	
	/**
	 * Add a player to the handler
	 * @param player
	 */
	public void addPlayer(Player p){
		sicknessPlayers.put(p, new RSPlayer());
	}
	
	/**
	 * Get a RSickness player from the list
	 */
	
	public RSPlayer getPlayer(Player p){
		if (sicknessPlayers.containsKey(p))
			return sicknessPlayers.get(p);
		addPlayer(p);
		return sicknessPlayers.get(p);
	}
	
}
