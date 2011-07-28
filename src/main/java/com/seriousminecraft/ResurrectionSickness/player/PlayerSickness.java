package com.seriousminecraft.ResurrectionSickness.player;

import org.bukkit.entity.Player;

import com.seriousminecraft.ResurrectionSickness.util.RSConfig;

/**
 * Hack to get player health set on respawn 
 * (currently not supported by bukkit)
 * @author jam
 */

public class PlayerSickness implements Runnable{
	
	private Player player;
	public PlayerSickness(Player player){
		this.player = player;
	}
	
	public void run(){
		player.setHealth(RSConfig.healthOnSick);
	}
}